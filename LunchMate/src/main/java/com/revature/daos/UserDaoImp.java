package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.Util.HibernateUtil;
import com.revature.models.User;

public class UserDaoImp implements UserDao {

	@Override
	public User getUser(int id) {
		Session s = HibernateUtil.getSession();
		Query q = s.getNamedQuery("User.getByIdQuery");
		q.setParameter("idVar", id);
		User u = (User) q.getSingleResult();
		s.close();
		return u;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		List<User> users = s.createQuery("from USER_INFO", User.class).list();
		s.close();
		return users;
	}

	@Override
	public void createUser(User u) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int pk = (int) s.save(u);
		u.setId(pk);
		tx.commit();
		s.close();
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		s.update(u);
		tx.commit();
		s.close();
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		User u = s.get(User.class, id);
		if (u != null) {
			s.delete(u);
			tx.commit();
			s.close();
			return true;
		}
		s.close();
		return false;
	}

	@Override
	public boolean getUserLogin(String username, String password) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Query q = s.getNamedQuery("User.getLoginInfo");
		q.setParameter("username", username);
		q.setParameter("password", password);
		User u = (User) q.getSingleResult();
		if (u == null)
			return false;
		return true;
	}
}
