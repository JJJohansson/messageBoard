package fi.haagahelia.MessageBoard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.MessageBoard.domain.CommentRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageBoardApplicationTests {
	
	@Autowired
	private CommentRepository commentRepo;
	
	

	@Test
	public void contextLoads() {
		assertThat(commentRepo.findAll()).isNotNull();
	}
	
	@Test
	public void FindByIdShouldReturnAComment() {
		assertThat(commentRepo.findById(1)).isNotNull();
	}

}


