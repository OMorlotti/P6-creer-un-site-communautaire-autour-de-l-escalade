package xyz.morlotti.escalade;

import xyz.morlotti.escalade.models.beans.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GuestFilter implements Filter
{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		// Nothing to do
	}

	@Override
	public void destroy()
	{
		// Nothing to do
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		HttpSession session = request.getSession(true); // Le paramètre True indique qu'il faut créer la session si elle n'existe pas. La session est comme un dictionnaire (map).

		if(session.getAttribute("currentUser") == null) // S'il n'y a pas d'entrée currentUser dans la session, elle est créee.
		{
			User user = new User();

			user.initGuest();

			session.setAttribute("currentUser", user);
		}

		// Passez à l'élément suivant (filtre ou cible) en chaîne.
		filterChain.doFilter(servletRequest, servletResponse);
	}
}
