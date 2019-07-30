package com.cloudera.SparkMetricsAccumulatorDTO;

public class Stage {

	String applicationID;
	String status;
	String stageId;
	String attemptId;
	String numTasks;

	String numActiveTasks;
	String numCompleteTasks;
	String numFailedTasks;
	String executorRunTime;
	String submissionTime;
	String firstTaskLaunchedTime;
	String completionTime;
	String inputBytes;
	String inputRecords;
	String outputBytes;
	String outputRecords;
	String shuffleReadBytes;
	String shuffleReadRecords;
	String shuffleWriteBytes;
	String shuffleWriteRecords;
	String memoryBytesSpilled;
	String diskBytesSpilled;
	String name;
	String schedulingPool;

	public String getNumTasks() {
		return numTasks;
	}

	public void setNumTasks(String numTasks) {
		this.numTasks = numTasks;
	}

	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStageId() {
		return stageId;
	}

	public void setStageId(String stageId) {
		this.stageId = stageId;
	}

	public String getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(String attemptId) {
		this.attemptId = attemptId;
	}

	public String getNumActiveTasks() {
		return numActiveTasks;
	}

	public void setNumActiveTasks(String numActiveTasks) {
		this.numActiveTasks = numActiveTasks;
	}

	public String getNumCompleteTasks() {
		return numCompleteTasks;
	}

	public void setNumCompleteTasks(String numCompleteTasks) {
		this.numCompleteTasks = numCompleteTasks;
	}

	public String getNumFailedTasks() {
		return numFailedTasks;
	}

	public void setNumFailedTasks(String numFailedTasks) {
		this.numFailedTasks = numFailedTasks;
	}

	public String getExecutorRunTime() {
		return executorRunTime;
	}

	public void setExecutorRunTime(String executorRunTime) {
		this.executorRunTime = executorRunTime;
	}

	public String getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(String submissionTime) {
		this.submissionTime = submissionTime;
	}

	public String getFirstTaskLaunchedTime() {
		return firstTaskLaunchedTime;
	}

	public void setFirstTaskLaunchedTime(String firstTaskLaunchedTime) {
		this.firstTaskLaunchedTime = firstTaskLaunchedTime;
	}

	public String getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(String completionTime) {
		this.completionTime = completionTime;
	}

	public String getInputBytes() {
		return inputBytes;
	}

	public void setInputBytes(String inputBytes) {
		this.inputBytes = inputBytes;
	}

	public String getInputRecords() {
		return inputRecords;
	}

	public void setInputRecords(String inputRecords) {
		this.inputRecords = inputRecords;
	}

	public String getOutputBytes() {
		return outputBytes;
	}

	public void setOutputBytes(String outputBytes) {
		this.outputBytes = outputBytes;
	}

	public String getOutputRecords() {
		return outputRecords;
	}

	public void setOutputRecords(String outputRecords) {
		this.outputRecords = outputRecords;
	}

	public String getShuffleReadBytes() {
		return shuffleReadBytes;
	}

	public void setShuffleReadBytes(String shuffleReadBytes) {
		this.shuffleReadBytes = shuffleReadBytes;
	}

	public String getShuffleReadRecords() {
		return shuffleReadRecords;
	}

	public void setShuffleReadRecords(String shuffleReadRecords) {
		this.shuffleReadRecords = shuffleReadRecords;
	}

	public String getShuffleWriteBytes() {
		return shuffleWriteBytes;
	}

	public void setShuffleWriteBytes(String shuffleWriteBytes) {
		this.shuffleWriteBytes = shuffleWriteBytes;
	}

	public String getShuffleWriteRecords() {
		return shuffleWriteRecords;
	}

	public void setShuffleWriteRecords(String shuffleWriteRecords) {
		this.shuffleWriteRecords = shuffleWriteRecords;
	}

	public String getMemoryBytesSpilled() {
		return memoryBytesSpilled;
	}

	public void setMemoryBytesSpilled(String memoryBytesSpilled) {
		this.memoryBytesSpilled = memoryBytesSpilled;
	}

	public String getDiskBytesSpilled() {
		return diskBytesSpilled;
	}

	public void setDiskBytesSpilled(String diskBytesSpilled) {
		this.diskBytesSpilled = diskBytesSpilled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchedulingPool() {
		return schedulingPool;
	}

	public void setSchedulingPool(String schedulingPool) {
		this.schedulingPool = schedulingPool;
	}
}
