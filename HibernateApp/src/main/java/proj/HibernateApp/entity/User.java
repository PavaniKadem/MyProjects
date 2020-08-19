package proj.HibernateApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS_DATA")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
	@SequenceGenerator(name="author_generator", sequenceName = "author_seq")
	private int userId;
	private String userName;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	/*@JoinTable(name="USERS_INTERESTS",joinColumns={@JoinColumn(referencedColumnName="userId")},
	inverseJoinColumns={@JoinColumn(referencedColumnName="interestId")})*/
	private List<Interest> interest;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Interest> getInterest() {
		return interest;
	}
	public void setInterest(List<Interest> interest) {
		this.interest = interest;
	}
	

}
