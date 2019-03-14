package com.socialconnect.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialconnect.DAO.BlogPostDAO;
import com.socialconnect.model.BlogComment;
import com.socialconnect.model.BlogPost;
import com.socialconnect.model.UserDetails;
import com.socialconnect.service.BlogPostService;

@Service(value="blogPostService")
public class BlogPostServiceImpl implements BlogPostService 
{
	@Autowired
	BlogPostDAO blogPostDAO;

	@Override
	public void insertOrUpdateBlogPost(BlogPost blogPost){
		try {
			blogPostDAO.insertOrUpdateBlogPost(blogPost);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
@Override
	public List<BlogPost> getBlogPosts(String approved){
		List<BlogPost>blogPosts=blogPostDAO.getBlogPosts(approved);
		if(blogPosts!=null)
		{
			return blogPosts;
		}
		else
		{
			return null;
		}
	}
@Override
	public BlogPost getBlogPostById(int id) {
		BlogPost blogPostById=blogPostDAO.getBlogPostById(id);
		if(blogPostById!=null)
		{
			return blogPostById;
		}
		else {
			return null;
		}
		}
	@Override
	public List<BlogPost> getBlogPostsByUser(UserDetails user){
		List<BlogPost> blogPostByUser=blogPostDAO.getBlogPostsByUser(user);
		if(blogPostByUser!=null)
		{
			return blogPostByUser;
		}
		else {
			return null;
		}
	}
	
	@Override
	public void deleteBlogPost(BlogPost blogPost) {
		blogPostDAO.deleteBlogPost(blogPost);
	}
	
	public void addBlogComment(BlogComment blogComment) {
		blogPostDAO.addBlogComment(blogComment);
	}
	public List<BlogComment> getAllBlogComment(int blog_id){
		List<BlogComment> allBlogComment=blogPostDAO.getAllBlogComment(blog_id);
		if(allBlogComment!=null)
		{
			return allBlogComment;
		}
		else {
			return null;
		}
	}
}