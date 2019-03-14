package com.socialconnect.service;
import java.util.List;
import com.socialconnect.model.BlogComment;
import com.socialconnect.model.BlogPost;
import com.socialconnect.model.UserDetails;

public interface BlogPostService 
{
	public void insertOrUpdateBlogPost(BlogPost blogPost);
	List<BlogPost> getBlogPosts(String approved);
	BlogPost getBlogPostById(int id);
	List<BlogPost> getBlogPostsByUser(UserDetails user);
	void deleteBlogPost(BlogPost blogPost);
	void addBlogComment(BlogComment blogComment);
	List<BlogComment> getAllBlogComment(int blog_id);
}
