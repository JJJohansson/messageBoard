package fi.haagahelia.MessageBoard.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "Comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String content;
	
	@CreatedBy
	private String username;
	
	@CreatedDate
	private String created;
	// 2017-10-31 14:09:47.623
	
	public Comment() { }
	
	public Comment (String content, String username, String created) {
		this.content = content;
		this.username = username;
		this.created = created;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "#" + getId() + ", username: " + getUsername() + ", date: " + getCreated() + ", message: " + getContent();
	}

}
