package com.socialconnect.service;
import java.util.List;
import com.socialconnect.model.ApplyForJob;
import com.socialconnect.model.Job;

public interface JobService 
{
	public void insertOrUpdateJob(Job job);
	public void deleteJob(Job job);
	public List<Job> getJob();
	public Job getJobById(int id);
	public List<ApplyForJob> getAllAppliedUser(int jobId);
	public void applyForJob(ApplyForJob applyForJob);
	public boolean checkIfApplied(int jobId,String username);
}
