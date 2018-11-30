package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.Util.HibernateUtil;
import com.revature.models.Posting;

public class PostingDaoImp implements PostingDao {

	@Override
	public List<Posting> getAllPosting() {
		Session s = HibernateUtil.getSession();
		List<Posting> postings = s.createQuery("from Posting", Posting.class).list();
		s.close();
		return postings;
	}

	@Override
	public Posting getPosting(int id) {
		Session s = HibernateUtil.getSession();
		Query q = s.getNamedQuery("Posting.getByIdQuery");
		q.setParameter("idVar", id);
		Posting p = (Posting) q.getSingleResult();
		s.close();
		return p;
	}

	@Override
	public void createPosting(Posting p) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int pk = (int) s.save(p);
		p.setId(pk);
		tx.commit();
		s.close();
	}

	@Override
	public void updatePosting(Posting p) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(p);
		tx.commit();
		s.close();
	}

	@Override
	public boolean deletePosting(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx =s.beginTransaction();
		Posting p = s.get(Posting.class, id);
		if(p!=null) {
			s.delete(p);
			tx.commit();
			s.close();
			return true;
		}
		s.close();
		return false;
	}

}
