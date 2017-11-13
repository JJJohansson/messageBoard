package fi.haagahelia.MessageBoard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.MessageBoard.domain.CommentRepository;
import fi.haagahelia.MessageBoard.domain.ForumRepository;
import fi.haagahelia.MessageBoard.domain.ThreadRepository;

@Controller
public class MessageBoardController {
	
	@Autowired
	private ForumRepository forumRepo;
	@Autowired
	private ThreadRepository threadRepo;
	@Autowired
	private CommentRepository commentRepo;
	
	@RequestMapping(value="/home")
	public String homePage(Model model) {
		model.addAttribute("forums", forumRepo.findAll());
		return "home";
	}
	
	@RequestMapping(value="/forum/{id}", method = RequestMethod.GET)
	public String forum(@PathVariable("id") Long forumId, Model model) {
		model.addAttribute("forumId", forumRepo.findById(forumId));
		model.addAttribute("threads", threadRepo.findByForumId(forumId));
		return "forum";
	}
	
	@RequestMapping(value="/thread/{id}", method = RequestMethod.GET)
	public String thread(@PathVariable("id") Long threadId, Model model) {
		model.addAttribute("thread", threadRepo.findById(threadId));
		model.addAttribute("comments", commentRepo.findByThreadId(threadId));
		return "thread";
	}
}
