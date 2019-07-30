package com.cloudera.SparkMetricsAccumulatorDTO;

import java.util.ArrayList;

public class Application {

	String name;
	String id;
	String attemptId;
	String startTime;
	String endTime;
	String lastUpdated;
	String duration;
	String sparkUser;
	String completed;
	String startTimeEpoch;
	String endTimeEpoch;
	String lastUpdatedEpoch;

	public String getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(String attemptId) {
		this.attemptId = attemptId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSparkUser() {
		return sparkUser;
	}

	public void setSparkUser(String sparkUser) {
		this.sparkUser = sparkUser;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public String getStartTimeEpoch() {
		return startTimeEpoch;
	}

	public void setStartTimeEpoch(String startTimeEpoch) {
		this.startTimeEpoch = startTimeEpoch;
	}

	public String getEndTimeEpoch() {
		return endTimeEpoch;
	}

	public void setEndTimeEpoch(String endTimeEpoch) {
		this.endTimeEpoch = endTimeEpoch;
	}

	public String getLastUpdatedEpoch() {
		return lastUpdatedEpoch;
	}

	public void setLastUpdatedEpoch(String lastUpdatedEpoch) {
		this.lastUpdatedEpoch = lastUpdatedEpoch;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
