package fi.haagahelia.MessageBoard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.MessageBoard.domain.Comment;
import fi.haagahelia.MessageBoard.domain.Thread;
import fi.haagahelia.MessageBoard.domain.Forum;
import fi.haagahelia.MessageBoard.domain.CommentRepository;
import fi.haagahelia.MessageBoard.domain.ForumRepository;
import fi.haagahelia.MessageBoard.domain.ThreadRepository;

@SpringBootApplication
public class MessageBoardApplication {
	private static final Logger log = LoggerFactory.getLogger(MessageBoardApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MessageBoardApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ForumRepository forumRepo, ThreadRepository threadRepo,  CommentRepository commentRepo) {
		return (args) -> {	

			log.info("-- SAVING FORUMS --");
			forumRepo.save(new Forum("Studies"));
			forumRepo.save(new Forum("Video games"));
			forumRepo.save(new Forum("Off topic"));

			log.info("-- SAVING THREADS --");
			threadRepo.save(new Thread(1, "Server programming", "a1603200", "02:10 12/11/2017"));
			threadRepo.save(new Thread(1, "What is HTML? HELP PLS!", "a1603200", "02:10 12/11/2017"));
			threadRepo.save(new Thread(2, "PUBG 1", "a1603200", "02:10 12/11/2017"));
			threadRepo.save(new Thread(2, "PUBG 2", "a1603200", "02:10 12/11/2017"));
			threadRepo.save(new Thread(3, "Kuviokellunta", "a1603200", "02:10 12/11/2017"));
			
			log.info(" -- SAVING COMMENTS --");
			commentRepo.save(new Comment(1, "a1603200", "Server programming1 eka kommentti", "02:10 12/11/2017"));
			commentRepo.save(new Comment(1, "a1603200", "Server programming1 toka kommentti.", "02:10 12/11/2017"));
			commentRepo.save(new Comment(2, "a1603200", "Server programming2 eka kommentti.", "02:10 12/11/2017"));
			commentRepo.save(new Comment(3, "a1603200", "PUBG1 eka kommentti..", "02:10 12/11/2017"));
			commentRepo.save(new Comment(4, "a1603200", "PUBG2 eka kommentti...", "02:10 12/11/2017"));
			commentRepo.save(new Comment(4, "a1603200", "PUBG2 toka kommentti...", "02:10 12/11/2017"));
			commentRepo.save(new Comment(5, "a1603200", "Kuviokellunta eka kommentti...", "02:10 12/11/2017"));
			commentRepo.save(new Comment(5, "a1603200", "Kuviokellunta toka kommentti...", "02:10 12/11/2017"));
			commentRepo.save(new Comment(5, "a1603200", "Kuviokellunta kolmas kommentti...", "02:10 12/11/2017"));
		};
	}
}
