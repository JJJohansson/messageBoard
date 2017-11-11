package fi.haagahelia.MessageBoard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.MessageBoard.domain.CommentRepository;

@Controller
public class MessageBoardController {
	
	@Autowired
	private CommentRepository commentRepo;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="home")
	public String homePage(Model model) {
		model.addAttribute("comments", commentRepo.findAll());
		return "home";
	}
}
