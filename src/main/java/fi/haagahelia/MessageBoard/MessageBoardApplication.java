package fi.haagahelia.MessageBoard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.MessageBoard.domain.Comment;
import fi.haagahelia.MessageBoard.domain.Thread;
import fi.haagahelia.MessageBoard.domain.Category;
import fi.haagahelia.MessageBoard.domain.CommentRepository;
import fi.haagahelia.MessageBoard.domain.CategoryRepository;
import fi.haagahelia.MessageBoard.domain.ThreadRepository;

@SpringBootApplication
public class MessageBoardApplication {
	private static final Logger log = LoggerFactory.getLogger(MessageBoardApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MessageBoardApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CategoryRepository forumRepo, ThreadRepository threadRepo,  CommentRepository commentRepo) {
		return (args) -> {	

			log.info("-- SAVING CATEGORIES --");
			forumRepo.save(new Category("Studies"));
			forumRepo.save(new Category("Video games"));
			forumRepo.save(new Category("Off topic"));

			log.info("-- SAVING THREADS --");
			threadRepo.save(new Thread(1, "Server programming", "a1603200", "02:10 12/11/2017"));
			threadRepo.save(new Thread(1, "What is HTML? HELP PLS!", "a1603200", "02:10 12/11/2017"));
			threadRepo.save(new Thread(2, "PUBG", "a1603200", "02:10 12/11/2017"));
			threadRepo.save(new Thread(3, "Kuviokellunta", "a1603200", "02:10 12/11/2017"));
			
			log.info(" -- SAVING COMMENTS --");
			commentRepo.save(new Comment(1, "a1603200", "Server programming bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla. BLA BLA I AM SO STRESSED!", "02:10 12/11/2017"));
			commentRepo.save(new Comment(1, "a1601337", "I AM SO STRESSED AS WELL HOLY SHIT", "02:10 12/11/2017"));
			commentRepo.save(new Comment(2, "a1603200", "What is HTML? Does anyone know? I want to build a site for my prize horse and I want it to have a lot of animations and glitter. Can someone help me, please?", "02:10 12/11/2017"));
			commentRepo.save(new Comment(3, "a1603200", "Who likes pans?", "02:10 12/11/2017"));
			commentRepo.save(new Comment(3, "a1603200", "FUCK THE PANS FOR FUCKING UP MY SHOTS! /rant", "02:10 12/11/2017"));
			commentRepo.save(new Comment(3, "a1603200", "I guess it's kind of silly that they block bullets..? :D", "02:10 12/11/2017"));
			commentRepo.save(new Comment(4, "a1603200", "Mistä te tykkäätte eniten kuvokellunnassa?", "02:10 12/11/2017"));
			commentRepo.save(new Comment(4, "a1603200", "Kellumisesta. /thread", "02:10 12/11/2017"));
			commentRepo.save(new Comment(4, "a1603200", "Vedestä ja kavereista ja ryhmäaktiviteeteista ja ja ja..!", "02:10 12/11/2017"));
		};
	}
}
