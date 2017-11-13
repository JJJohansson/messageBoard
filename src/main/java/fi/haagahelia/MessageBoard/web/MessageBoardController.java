package fi.haagahelia.MessageBoard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.MessageBoard.domain.CommentRepository;
import fi.haagahelia.MessageBoard.domain.CategoryRepository;
import fi.haagahelia.MessageBoard.domain.ThreadRepository;

@Controller
public class MessageBoardController {
	
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private ThreadRepository threadRepo;
	@Autowired
	private CommentRepository commentRepo;
	
	@RequestMapping(value="/home")
	public String homePage(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "home";
	}
	
	@RequestMapping(value="/category/{id}", method = RequestMethod.GET)
	public String category(@PathVariable("id") Long categoryId, Model model) {
		model.addAttribute("category", categoryRepo.findById(categoryId));
		model.addAttribute("threads", threadRepo.findByCategoryId(categoryId));
		return "category";
	}
	
	@RequestMapping(value="/thread/{id}", method = RequestMethod.GET)
	public String thread(@PathVariable("id") Long threadId, Model model) {
		model.addAttribute("thread", threadRepo.findById(threadId));
		model.addAttribute("comments", commentRepo.findByThreadId(threadId));
		return "thread";
	}
}
