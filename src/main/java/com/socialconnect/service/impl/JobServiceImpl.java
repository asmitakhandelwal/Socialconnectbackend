package com.socialconnect.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialconnect.DAO.JobDAO;
import com.socialconnect.model.ApplyForJob;
import com.socialconnect.model.Job;
import com.socialconnect.service.JobService;

@Service(value="jobService")
public class JobServiceImpl implements JobService {
@Autowired
JobDAO jobDAO;
	@Override
	public void insertOrUpdateJob(Job job) {
		jobDAO.insertOrUpdateJob(job);
	}

	@Override
	public void deleteJob(Job job) {
		jobDAO.deleteJob(job);
	}

	@Override
	public List<Job> getJob() {
		List<Job> jobs=jobDAO.getJob();
		if(jobs!=null)
		{
			return jobs;
		}
		else {
		return null;
	}
	}

	@Override
	public Job getJobById(int id) {
		Job jobById=jobDAO.getJobById(id);
		if(jobById!=null)
		{
			return jobById;
		}
		else {
		return null;
	}
	}
	

	@Override
	public List<ApplyForJob> getAllAppliedUser(int jobId) {
	List<ApplyForJob> allAppliedUsers=jobDAO.getAllAppliedUser(jobId);
	if(allAppliedUsers!=null) {
		return allAppliedUsers;
	}
	else
	{
		return null;
	}
	}
	
	@Override
	public void applyForJob(ApplyForJob applyForJob) {
		jobDAO.applyForJob(applyForJob);
		
	}

	@Override
	public boolean checkIfApplied(int jobId, String username) {
		if(jobDAO.checkIfApplied(jobId, username))
		{
			return true;
		}
		else {
		return false;
	}
	}
	
}