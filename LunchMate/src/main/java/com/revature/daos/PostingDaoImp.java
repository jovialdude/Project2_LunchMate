package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.Util.HibernateUtil;
import com.revature.models.PostingServiceLayer;

public class PostingDaoImp implements PostingDao {

	@Override
	public List<PostingServiceLayer> getAllPosting() {
		Session s = HibernateUtil.getSession();
		List<PostingServiceLayer> postings = s.createQuery("from POSTING_INFO", PostingServiceLayer.class).list();
		s.close();
		return postings;
	}

	@Override
	public PostingServiceLayer getPosting(int id) {
		Session s = HibernateUtil.getSession();
		Query q = s.getNamedQuery("Posting.getByIdQuery");
		q.setParameter("idVar", id);
		PostingServiceLayer p = (PostingServiceLayer) q.getSingleResult();
		s.close();
		return p;
	}

	@Override
	public void createPosting(PostingServiceLayer p) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int pk = (int) s.save(p);
		p.setPostingId(pk);
		tx.commit();
		s.close();
	}

	@Override
	public void updatePosting(PostingServiceLayer p) {
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
		PostingServiceLayer p = s.get(PostingServiceLayer.class, id);
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
