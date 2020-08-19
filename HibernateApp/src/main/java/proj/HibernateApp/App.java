package proj.HibernateApp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import proj.HibernateApp.entity.Interest;
import proj.HibernateApp.entity.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Interest i1 = new Interest();
		i1.setiName("Crafts");
		i1.setDescription("Share your crafting ideas here!");
		Interest i2 = new Interest();
		i2.setiName("photography");
		i2.setDescription("Share your amazing photography techniques!");
		List<Interest> interests1=new ArrayList<Interest>();
		interests1.add(i1);
		interests1.add(i2);
		List<Interest> interests2=new ArrayList<Interest>();
		interests2.add(i1);
		User u1 = new User();
		u1.setUserId(100);
		u1.setUserName("PAVANI");
		u1.setInterest(interests1);
		User u2 = new User();
		u2.setUserId(101);
		u2.setUserName("RAMYA");
        u2.setInterest(interests2);
		// save() ex:
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Integer id2 = (Integer) session.save(u1);
		Integer id1 = (Integer) session.save(u2);
		//Integer id3 = (Integer) session.save(i1);
		System.out.println("saved entities with ids:" + id1 + "," + id2);
		//System.out.println("Interest created with id:" + id3);
		session.getTransaction().commit();

		// Load() ex:
		session.beginTransaction();
		User user = session.load(User.class, id1);
		System.out.println("Load method worked!\n User id:" + user.getUserId() + "\nUser Name:" + user.getUserName());
		session.getTransaction().commit();

	}
}
