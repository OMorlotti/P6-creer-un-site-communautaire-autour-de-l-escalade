package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.morlotti.escalade.models.beans.Comment;
import xyz.morlotti.escalade.models.beans.Spot;
import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.CommentDAO;
import xyz.morlotti.escalade.models.daos.SpotDAO;
import xyz.morlotti.escalade.models.daos.UserDAO;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController
{
    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private SpotDAO spotDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(path = "/comments", method = RequestMethod.GET)
    public String showComments(
        @RequestParam(name = "spot") int parentSpotId,
        Model model) throws Exception
    {
        model.addAttribute("title", "Comments");

        model.addAttribute("comments", commentDAO.list(parentSpotId));

        model.addAttribute("spotId", parentSpotId);

        return "showComments";
    }

    @RequestMapping(path = "/comment/{id}", method = RequestMethod.GET)
    public String showComment(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        model.addAttribute("title", "comment");

        model.addAttribute("comment", commentDAO.get(id));

        return "showUpdateComment";
    }

    @RequestMapping(path = "/comment", method = RequestMethod.POST)
    public String addComment(
        @RequestParam("spotfk") int parentSpotId,
        @RequestParam("comment") String comment,
        HttpSession session,
        Model model) throws Exception
    {
        Spot spot = spotDAO.get(parentSpotId);

        User user = (User) session.getAttribute("currentUser");

        Comment comment1 = new Comment();

        comment1.setSpotFK(spot);
        comment1.setUserFK(user);
        comment1.setComment(comment);

        commentDAO.add(comment1);

        /**/

        model.addAttribute("message", "Commentaire ajouté avec succès !");

        model.addAttribute("message_type", "success");

        return showComments(parentSpotId, model);
    }

    @RequestMapping(path = "/comment/update/{id}", method = RequestMethod.POST)
    public String updateComment(
        @PathVariable(value = "id") final int id,
        @RequestParam("comment") String comment,
        Model model) throws Exception
    {
        Comment comment1 = commentDAO.get(id);

        int parentSpotId = comment1.getSpotFK().getId();

        comment1.setComment(comment);

        commentDAO.update(comment1);

        /**/

        model.addAttribute("message", "Commentaire " + id + " supprimé avec succès !");

        model.addAttribute("message_type", "success");

        return showComments(parentSpotId, model);
    }

    @RequestMapping(path = "/comment/delete/{id}", method = RequestMethod.GET)
    public String deleteComment(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        Comment comment = commentDAO.get(id);

        int parentSpotId = comment.getSpotFK().getId();

        commentDAO.delete(id);

        /**/

        model.addAttribute("message", "Commentaire " + id + " supprimé avec succès !");

        model.addAttribute("message_type", "success");

        return showComments(parentSpotId, model);
    }
}