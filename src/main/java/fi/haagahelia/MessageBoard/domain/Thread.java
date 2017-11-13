package fi.haagahelia.MessageBoard.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Threadd")
public class Thread {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long forumId;
	private String title;
	@CreatedBy
	private String creator;
	@CreatedDate
	private String created;
	
	public Thread() { }
	
	public Thread(long forumId, String title, String creator, String created) {
		this.forumId = forumId;
		this.title = title;
		this.creator = creator;
		this.created = created;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getForumId() {
		return forumId;
	}

	public void setForumId(long forumId) {
		this.forumId = forumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "Thread #" + getId() + ", Forum #" + getForumId() + ", Title: " + getTitle() + ", Created by: " + getCreator() + ", Created: " + getCreated();
	}

}
