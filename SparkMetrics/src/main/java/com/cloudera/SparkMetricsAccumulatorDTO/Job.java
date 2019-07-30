package com.cloudera.SparkMetricsAccumulatorDTO;

import java.util.ArrayList;

public class Job {

	String applicationID;
	String jobId;
	String name;
	String submissionTime;
	String completionTime;
	ArrayList<String> stageIds;
	String status;
	String numTasks;
	String numActiveTasks;
	String numCompletedTasks;
	String numSkippedTasks;
	String numFailedTasks;
	String numActiveStages;
	String numCompletedStages;
	String numSkippedStages;
	String numFailedStages;

	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(String submissionTime) {
		this.submissionTime = submissionTime;
	}

	public String getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(String completionTime) {
		this.completionTime = completionTime;
	}

	public ArrayList<String> getStageIds() {
		return stageIds;
	}

	public void setStageIds(ArrayList<String> stageIds) {
		this.stageIds = stageIds;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNumTasks() {
		return numTasks;
	}

	public void setNumTasks(String numTasks) {
		this.numTasks = numTasks;
	}

	public String getNumActiveTasks() {
		return numActiveTasks;
	}

	public void setNumActiveTasks(String numActiveTasks) {
		this.numActiveTasks = numActiveTasks;
	}

	public String getNumCompletedTasks() {
		return numCompletedTasks;
	}

	public void setNumCompletedTasks(String numCompletedTasks) {
		this.numCompletedTasks = numCompletedTasks;
	}

	public String getNumSkippedTasks() {
		return numSkippedTasks;
	}

	public void setNumSkippedTasks(String numSkippedTasks) {
		this.numSkippedTasks = numSkippedTasks;
	}

	public String getNumFailedTasks() {
		return numFailedTasks;
	}

	public void setNumFailedTasks(String numFailedTasks) {
		this.numFailedTasks = numFailedTasks;
	}

	public String getNumActiveStages() {
		return numActiveStages;
	}

	public void setNumActiveStages(String numActiveStages) {
		this.numActiveStages = numActiveStages;
	}

	public String getNumCompletedStages() {
		return numCompletedStages;
	}

	public void setNumCompletedStages(String numCompletedStages) {
		this.numCompletedStages = numCompletedStages;
	}

	public String getNumSkippedStages() {
		return numSkippedStages;
	}

	public void setNumSkippedStages(String numSkippedStages) {
		this.numSkippedStages = numSkippedStages;
	}

	public String getNumFailedStages() {
		return numFailedStages;
	}

	public void setNumFailedStages(String numFailedStages) {
		this.numFailedStages = numFailedStages;
	}
}
