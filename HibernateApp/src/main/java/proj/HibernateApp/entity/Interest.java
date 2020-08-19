package proj.HibernateApp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="INTERESTS")
public class Interest {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer interestId;
	private String iName;
	private String description;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	public Integer getInterestId() {
		return interestId;
	}
	public void setInterestId(Integer interestId) {
		this.interestId = interestId;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	*/
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
