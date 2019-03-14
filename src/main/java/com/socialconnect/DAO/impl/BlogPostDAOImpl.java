package com.socialconnect.DAO.impl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.socialconnect.DAO.BlogPostDAO;
import com.socialconnect.model.BlogComment;
import com.socialconnect.model.BlogPost;
import com.socialconnect.model.UserDetails;

@Transactional
@Repository(value="blogPostDAO")
public class BlogPostDAOImpl implements BlogPostDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void insertOrUpdateBlogPost(BlogPost blogPost) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blogPost);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public List<BlogPost> getBlogPosts(String approved) {
		List<BlogPost> blogPostsList;
		try {
			blogPostsList=sessionFactory.getCurrentSession().createQuery("from BlogPost").list();
			return blogPostsList;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	public BlogPost getBlogPostById(int id) {
		BlogPost blogPost;
		try {
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(BlogPost.class);
			cr.add(Restrictions.eq("blogId",id));
			blogPost=(BlogPost) cr.uniqueResult();
			return blogPost;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	public List<BlogPost> getBlogPostsByUser(UserDetails user) {
		List<BlogPost> blogPostsByUser;
		try
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(BlogPost.class);
			cr.add(Restrictions.eq("postedBy", user));
			blogPostsByUser=cr.list();
			return blogPostsByUser;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	public void deleteBlogPost(BlogPost blogPost) {
		try {
			sessionFactory.getCurrentSession().delete(blogPost);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void addBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().save(blogComment);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	public List<BlogComment> getAllBlogComment(int blog_id) {
		List<BlogComment> blogComments;
		try {
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(BlogComment.class);
			cr.add(Restrictions.eq("blogId", blog_id));
			blogComments=cr.list();
			return blogComments;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		}
	}

