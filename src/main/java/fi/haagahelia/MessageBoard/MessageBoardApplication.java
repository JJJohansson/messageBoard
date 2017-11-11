package fi.haagahelia.MessageBoard;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.MessageBoard.domain.Comment;
import fi.haagahelia.MessageBoard.domain.CommentRepository;

@SpringBootApplication
public class MessageBoardApplication {
	private static final Logger log = LoggerFactory.getLogger(MessageBoardApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MessageBoardApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CommentRepository commentRepo) {
		return (args) -> {
			
			Date date = new Date();
			date.getTime();

			log.info("-- SAVING COMMENTS --");
			commentRepo.save(new Comment("I AM ADMIN LOL", "admin", "13:32 11/11/2017"));
			commentRepo.save(new Comment("13:32 TESTI 1", "admin", "13:32 11/11/2017"));
			commentRepo.save(new Comment("TESTI 2", "JEBUS", "13:32 11/11/2017"));
			commentRepo.save(new Comment("TESTI 3", "JEBUS", "13:32 11/11/2017"));
			commentRepo.save(new Comment("TESTI 4", "user777", "13:32 11/11/2017"));
			commentRepo.save(new Comment("TESTI 5", "user77", "13:32 11/11/2017"));
			
			
			log.info("--- FETCHING COMMENTS ---");
			for (Comment comment : commentRepo.findAll()) {
				log.info(comment.toString());
			}

			log.info("-- FIRST COMMENT--");
			commentRepo.findById(0);
			
		};
	}
}
