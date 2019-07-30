package com.cloudera.SparkMetricsAccumulatorDTO;

public class Task {

	String applicationID;
	String stageID;
	String taskId;
	String index;
	String attempt;
	String launchTime;
	String executorId;
	String host;
	String taskLocality;
	String speculative;

	String executorDeserializeTime;
	String executorDeserializeCpuTime;
	String executorRunTime;
	String executorCpuTime;
	String resultSize;
	String jvmGcTime;
	String resultSerializationTime;
	String memoryBytesSpilled;
	String diskBytesSpilled;
	String peakExecutionMemory;
	// taskMetrics
	String input_bytesRead;
	String input_recordsRead;
	// outputMetrics
	String output_bytesWritten;
	String output_recordsWritten;
	// shuffleReadMetrics
	String shuffle_remoteBlocksFetched;
	String shuffle_localBlocksFetched;
	String shuffle_fetchWaitTime;
	String shuffle_remoteBytesRead;
	String shuffle_localBytesRead;
	String shuffle_remoteBytesReadToDisk;
	String shuffle_recordsRead;
	// shuffleWriteMetrics
	String shuffle_bytesWritten;
	String shuffle_writeTime;
	String shuffle_recordsWritten;

	public String getPeakExecutionMemory() {
		return peakExecutionMemory;
	}

	public void setPeakExecutionMemory(String peakExecutionMemory) {
		this.peakExecutionMemory = peakExecutionMemory;
	}

	public String getShuffle_RemoteBytesReadToDisk() {
		return shuffle_remoteBytesReadToDisk;
	}

	public void setShuffle_RemoteBytesReadToDisk(String remoteBytesReadToDisk) {
		this.shuffle_remoteBytesReadToDisk = remoteBytesReadToDisk;
	}

	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public String getStageID() {
		return stageID;
	}

	public void setStageID(String stageID) {
		this.stageID = stageID;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getAttempt() {
		return attempt;
	}

	public void setAttempt(String attempt) {
		this.attempt = attempt;
	}

	public String getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(String launchTime) {
		this.launchTime = launchTime;
	}

	public String getExecutorId() {
		return executorId;
	}

	public void setExecutorId(String executorId) {
		this.executorId = executorId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getTaskLocality() {
		return taskLocality;
	}

	public void setTaskLocality(String taskLocality) {
		this.taskLocality = taskLocality;
	}

	public String getSpeculative() {
		return speculative;
	}

	public void setSpeculative(String speculative) {
		this.speculative = speculative;
	}

	public String getExecutorDeserializeTime() {
		return executorDeserializeTime;
	}

	public void setExecutorDeserializeTime(String executorDeserializeTime) {
		this.executorDeserializeTime = executorDeserializeTime;
	}

	public String getExecutorDeserializeCpuTime() {
		return executorDeserializeCpuTime;
	}

	public void setExecutorDeserializeCpuTime(String executorDeserializeCpuTime) {
		this.executorDeserializeCpuTime = executorDeserializeCpuTime;
	}

	public String getExecutorRunTime() {
		return executorRunTime;
	}

	public void setExecutorRunTime(String executorRunTime) {
		this.executorRunTime = executorRunTime;
	}

	public String getExecutorCpuTime() {
		return executorCpuTime;
	}

	public void setExecutorCpuTime(String executorCpuTime) {
		this.executorCpuTime = executorCpuTime;
	}

	public String getResultSize() {
		return resultSize;
	}

	public void setResultSize(String resultSize) {
		this.resultSize = resultSize;
	}

	public String getJvmGcTime() {
		return jvmGcTime;
	}

	public void setJvmGcTime(String jvmGcTime) {
		this.jvmGcTime = jvmGcTime;
	}

	public String getResultSerializationTime() {
		return resultSerializationTime;
	}

	public void setResultSerializationTime(String resultSerializationTime) {
		this.resultSerializationTime = resultSerializationTime;
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

	public String getInput_bytesRead() {
		return input_bytesRead;
	}

	public void setInput_bytesRead(String input_bytesRead) {
		this.input_bytesRead = input_bytesRead;
	}

	public String getInput_recordsRead() {
		return input_recordsRead;
	}

	public void setInput_recordsRead(String input_recordsRead) {
		this.input_recordsRead = input_recordsRead;
	}

	public String getOutput_bytesWritten() {
		return output_bytesWritten;
	}

	public void setOutput_bytesWritten(String output_bytesWritten) {
		this.output_bytesWritten = output_bytesWritten;
	}

	public String getOutput_recordsWritten() {
		return output_recordsWritten;
	}

	public void setOutput_recordsWritten(String output_recordsWritten) {
		this.output_recordsWritten = output_recordsWritten;
	}

	public String getShuffle_remoteBlocksFetched() {
		return shuffle_remoteBlocksFetched;
	}

	public void setShuffle_remoteBlocksFetched(
			String shuffle_remoteBlocksFetched) {
		this.shuffle_remoteBlocksFetched = shuffle_remoteBlocksFetched;
	}

	public String getShuffle_localBlocksFetched() {
		return shuffle_localBlocksFetched;
	}

	public void setShuffle_localBlocksFetched(String shuffle_localBlocksFetched) {
		this.shuffle_localBlocksFetched = shuffle_localBlocksFetched;
	}

	public String getShuffle_fetchWaitTime() {
		return shuffle_fetchWaitTime;
	}

	public void setShuffle_fetchWaitTime(String shuffle_fetchWaitTime) {
		this.shuffle_fetchWaitTime = shuffle_fetchWaitTime;
	}

	public String getShuffle_remoteBytesRead() {
		return shuffle_remoteBytesRead;
	}

	public void setShuffle_remoteBytesRead(String shuffle_remoteBytesRead) {
		this.shuffle_remoteBytesRead = shuffle_remoteBytesRead;
	}

	public String getShuffle_localBytesRead() {
		return shuffle_localBytesRead;
	}

	public void setShuffle_localBytesRead(String shuffle_localBytesRead) {
		this.shuffle_localBytesRead = shuffle_localBytesRead;
	}

	public String getShuffle_recordsRead() {
		return shuffle_recordsRead;
	}

	public void setShuffle_recordsRead(String shuffle_recordsRead) {
		this.shuffle_recordsRead = shuffle_recordsRead;
	}

	public String getShuffle_bytesWritten() {
		return shuffle_bytesWritten;
	}

	public void setShuffle_bytesWritten(String shuffle_bytesWritten) {
		this.shuffle_bytesWritten = shuffle_bytesWritten;
	}

	public String getShuffle_writeTime() {
		return shuffle_writeTime;
	}

	public void setShuffle_writeTime(String shuffle_writeTime) {
		this.shuffle_writeTime = shuffle_writeTime;
	}

	public String getShuffle_recordsWritten() {
		return shuffle_recordsWritten;
	}

	public void setShuffle_recordsWritten(String shuffle_recordsWritten) {
		this.shuffle_recordsWritten = shuffle_recordsWritten;
	}
}
