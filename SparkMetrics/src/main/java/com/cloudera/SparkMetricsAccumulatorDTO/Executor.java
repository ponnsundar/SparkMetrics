package com.cloudera.SparkMetricsAccumulatorDTO;

public class Executor {

	String applicationID;
	String id;
	String hostPort;
	String isActive;
	String rddBlocks;
	String memoryUsed;
	String diskUsed;
	String totalCores;
	String maxTasks;
	String activeTasks;
	String failedTasks;
	String completedTasks;
	String totalTasks;
	String totalDuration;
	String totalGCTime;
	String totalInputBytes;
	String totalShuffleRead;
	String totalShuffleWrite;
	String isBlacklisted;
	String maxMemory;
	String addTime;
	String usedOnHeapStorageMemory;
	String usedOffHeapStorageMemory;
	String totalOnHeapStorageMemory;
	String totalOffHeapStorageMemory;

	public String getUsedOnHeapStorageMemory() {
		return usedOnHeapStorageMemory;
	}

	public void setUsedOnHeapStorageMemory(String usedOnHeapStorageMemory) {
		this.usedOnHeapStorageMemory = usedOnHeapStorageMemory;
	}

	public String getUsedOffHeapStorageMemory() {
		return usedOffHeapStorageMemory;
	}

	public void setUsedOffHeapStorageMemory(String usedOffHeapStorageMemory) {
		this.usedOffHeapStorageMemory = usedOffHeapStorageMemory;
	}

	public String getTotalOnHeapStorageMemory() {
		return totalOnHeapStorageMemory;
	}

	public void setTotalOnHeapStorageMemory(String totalOnHeapStorageMemory) {
		this.totalOnHeapStorageMemory = totalOnHeapStorageMemory;
	}

	public String getTotalOffHeapStorageMemory() {
		return totalOffHeapStorageMemory;
	}

	public void setTotalOffHeapStorageMemory(String totalOffHeapStorageMemory) {
		this.totalOffHeapStorageMemory = totalOffHeapStorageMemory;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHostPort() {
		return hostPort;
	}

	public void setHostPort(String hostPort) {
		this.hostPort = hostPort;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getRddBlocks() {
		return rddBlocks;
	}

	public void setRddBlocks(String rddBlocks) {
		this.rddBlocks = rddBlocks;
	}

	public String getMemoryUsed() {
		return memoryUsed;
	}

	public void setMemoryUsed(String memoryUsed) {
		this.memoryUsed = memoryUsed;
	}

	public String getDiskUsed() {
		return diskUsed;
	}

	public void setDiskUsed(String diskUsed) {
		this.diskUsed = diskUsed;
	}

	public String getTotalCores() {
		return totalCores;
	}

	public void setTotalCores(String totalCores) {
		this.totalCores = totalCores;
	}

	public String getMaxTasks() {
		return maxTasks;
	}

	public void setMaxTasks(String maxTasks) {
		this.maxTasks = maxTasks;
	}

	public String getActiveTasks() {
		return activeTasks;
	}

	public void setActiveTasks(String activeTasks) {
		this.activeTasks = activeTasks;
	}

	public String getFailedTasks() {
		return failedTasks;
	}

	public void setFailedTasks(String failedTasks) {
		this.failedTasks = failedTasks;
	}

	public String getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(String completedTasks) {
		this.completedTasks = completedTasks;
	}

	public String getTotalTasks() {
		return totalTasks;
	}

	public void setTotalTasks(String totalTasks) {
		this.totalTasks = totalTasks;
	}

	public String getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(String totalDuration) {
		this.totalDuration = totalDuration;
	}

	public String getTotalGCTime() {
		return totalGCTime;
	}

	public void setTotalGCTime(String totalGCTime) {
		this.totalGCTime = totalGCTime;
	}

	public String getTotalInputBytes() {
		return totalInputBytes;
	}

	public void setTotalInputBytes(String totalInputBytes) {
		this.totalInputBytes = totalInputBytes;
	}

	public String getTotalShuffleRead() {
		return totalShuffleRead;
	}

	public void setTotalShuffleRead(String totalShuffleRead) {
		this.totalShuffleRead = totalShuffleRead;
	}

	public String getTotalShuffleWrite() {
		return totalShuffleWrite;
	}

	public void setTotalShuffleWrite(String totalShuffleWrite) {
		this.totalShuffleWrite = totalShuffleWrite;
	}

	public String getIsBlacklisted() {
		return isBlacklisted;
	}

	public void setIsBlacklisted(String isBlacklisted) {
		this.isBlacklisted = isBlacklisted;
	}

	public String getMaxMemory() {
		return maxMemory;
	}

	public void setMaxMemory(String maxMemory) {
		this.maxMemory = maxMemory;
	}
}
