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
	private long threadId;
	@CreatedBy
	private String creator;
	private String content;
	@CreatedDate
	private String created;
	
	public Comment() { }
	
	public Comment (long threadId, String creator, String content, String created) {
		this.threadId = threadId;
		this.creator = creator;
		this.content = content;
		this.created = created;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getThreadId() {
		return threadId;
	}

	public void setThreadId(long threadId) {
		this.threadId = threadId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "comment #" + getId() + ", thread #" + getThreadId() + ", creator: " + getCreator() + ", date: " + getCreated() + ", message: " + getContent();
	}

}
