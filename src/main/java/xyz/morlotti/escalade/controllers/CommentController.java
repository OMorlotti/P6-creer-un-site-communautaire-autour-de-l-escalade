package xyz.morlotti.escalade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.morlotti.escalade.models.beans.Address;
import xyz.morlotti.escalade.models.beans.Comment;
import xyz.morlotti.escalade.models.beans.Spot;
import xyz.morlotti.escalade.models.beans.User;
import xyz.morlotti.escalade.models.daos.CommentDAO;
import xyz.morlotti.escalade.models.daos.SpotDAO;
import xyz.morlotti.escalade.models.daos.UserDAO;

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
        @RequestParam(name = "spot", required = false) Integer parentSpot,
        Model model) throws Exception
    {
        model.addAttribute("title", "Comments");

        if(parentSpot != null) {
            model.addAttribute("comments", commentDAO.list(parentSpot));
        }
        else {
            model.addAttribute("comments", commentDAO.list());
        }

        model.addAttribute("spots", spotDAO.list());

        return "showComments";
    }

    @RequestMapping(path = "/comment/{id}", method = RequestMethod.GET)
    public String showComment(@PathVariable(value = "id") final int id, Model model) throws Exception
    {
        model.addAttribute("title", "comment");

        model.addAttribute("comment", commentDAO.get(id));

        model.addAttribute("users", userDAO.list());

        return "showUpdateAddress";
    }

    @RequestMapping(path = "/comments", method = RequestMethod.POST)
    public String addComment(
        @RequestParam("spotfk") int spotFK,
        @RequestParam("userfk") int userFK,
        @RequestParam("comment") String comment,

               Model model)
    {
        Spot spot = spotDAO.get(spotFK);
        User user = userDAO.get(userFK);

        Comment comment1 = new Comment();

        comment1.setSpotFK(spot);
        comment1.setUserFK(user);
        comment1.setComment(comment);

        commentDAO.add(comment);

        model.addAttribute("title", "Commentaire ajouté");

        return "addComment";
    }

    @RequestMapping(path = "/comment/update/{id}", method = RequestMethod.POST)
    public String updateComment(
        @PathVariable(value = "id") final int id,
        @RequestParam("spotfk") int spotFK,
        @RequestParam("userfk") int userFK,
        @RequestParam("comment") String comment,
        Model model) throws Exception
    {
        Spot spot = spotDAO.get(spotFK);
        User user = userDAO.get(userFK);

        Comment comment1 = commentDAO.get(id);

        comment1.setSpotFK(spot);
        comment1.setUserFK(user);
        comment1.setComment(comment);


        commentDAO.update(comment1);

        model.addAttribute("title", "Commentaire modifié");

        model.addAttribute("message", "Commentaire modifié avec succès !");

        model.addAttribute("message_type", "success");

        model.addAttribute("comment", comment);

        model.addAttribute("spots", spotDAO.list());

        model.addAttribute("users", userDAO.list());

        return "showUpdateComment";
    }

    @RequestMapping(path = "/comment/delete/{id}", method = RequestMethod.GET)
    public String deleteComment(@PathVariable(value = "id") final int id, Model model)
    {
        commentDAO.delete(id);

        model.addAttribute("title", "Commentaire supprimé");

        model.addAttribute("id", id);

        return "deleteComment";
    }
}