package com.cloudera.SparkMetricsAccumulator;

import java.util.ArrayList;

import com.cloudera.SparkMetricsAccumulatorDTO.*;
import com.cloudera.util.RestAPIUtil;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MetricsExtractor {

	public ArrayList<Application> getAllApplications(String url)
			throws Exception {
		ArrayList<Application> jobsList = new ArrayList<Application>();
		JSONParser parse = new JSONParser();
		String inline = RestAPIUtil.makeRESTCall(url);
		org.json.simple.JSONArray jArray = (org.json.simple.JSONArray) parse
				.parse(inline);
		for (int i = 0; i < jArray.size(); i++) {
			Application app = this
					.extractApplication((org.json.simple.JSONObject) jArray
							.get(i));
			jobsList.add(app);
		}
		return jobsList;
	}

	public Application getApplication(String url) throws Exception {
		JSONParser parse = new JSONParser();
		String inline = RestAPIUtil.makeRESTCall(url);
		if(inline.equalsIgnoreCase("failed") || inline == null)
		{
			System.out.println("Rest Api call produced no results");
			System.exit(1);
		}
		org.json.simple.JSONObject result = (org.json.simple.JSONObject) parse
				.parse(inline);
		Application app = this
				.extractApplication((org.json.simple.JSONObject) result);
		return app;
	}

	public Application extractApplication(
			org.json.simple.JSONObject applicationJSON) {

		String applicationID = (String) applicationJSON.get("id");
		System.out.println("Application ID: " + applicationID);
		Application app = new Application();
		app.setName((String) applicationJSON.get("name"));
		app.setId((String) applicationJSON.get("id"));
		org.json.simple.JSONArray attemptsArray = (org.json.simple.JSONArray) applicationJSON
				.get("attempts");
		org.json.simple.JSONObject attemptsJSON = (org.json.simple.JSONObject) attemptsArray
				.get(0);
		app.setAttemptId("" + attemptsJSON.get("attemptId"));
		app.setStartTime("" + attemptsJSON.get("startTime"));
		app.setEndTime("" + attemptsJSON.get("endTime"));
		app.setLastUpdated("" + attemptsJSON.get("lastUpdated"));
		app.setDuration("" + attemptsJSON.get("duration"));
		app.setSparkUser("" + attemptsJSON.get("sparkUser"));
		app.setCompleted("" + attemptsJSON.get("completed"));
		app.setStartTimeEpoch("" + attemptsJSON.get("startTimeEpoch"));
		app.setEndTimeEpoch("" + attemptsJSON.get("endTimeEpoch"));
		app.setLastUpdatedEpoch("" + attemptsJSON.get("lastUpdatedEpoch"));
		return app;
	}

	public ArrayList<Job> getJobs(String base_URL, Application application)
			throws Exception {
		ArrayList<Job> jobsList = new ArrayList<Job>();
		String applicationID = application.getId();
		String restOutput = null;
		if (application.getAttemptId() == null
				|| application.getAttemptId().equals("null")) {
			restOutput = RestAPIUtil.makeRESTCall(base_URL + "/"
					+ applicationID + "/jobs");
		} else {
			restOutput = RestAPIUtil.makeRESTCall(base_URL + "/"
					+ applicationID + "/" + application.getAttemptId()
					+ "/jobs");
		}
		if (restOutput.equals("failed")) {
			return jobsList;
		}
		JSONParser parse = new JSONParser();
		org.json.simple.JSONArray jArray = (org.json.simple.JSONArray) parse
				.parse(restOutput);
		for (int i = 0; i < jArray.size(); i++) {
			// System.out.println(jArray.get(i));
			org.json.simple.JSONObject jAppArray = (org.json.simple.JSONObject) jArray
					.get(i);
			// Long jobId = (Long) jAppArray.get("jobId");
			// System.out.println("job ID: "+jobId);
			Job job = new Job();
			job.setApplicationID(applicationID);
			job.setJobId("" + jAppArray.get("jobId"));
			job.setName((String) jAppArray.get("name"));
			job.setSubmissionTime((String) jAppArray.get("submissionTime"));
			job.setCompletionTime((String) jAppArray.get("completionTime"));
			job.setStatus((String) jAppArray.get("status"));
			job.setNumTasks("" + jAppArray.get("numTasks"));
			job.setNumActiveTasks("" + jAppArray.get("numActiveTasks"));
			job.setNumCompletedTasks("" + jAppArray.get("numCompletedTasks"));
			job.setNumSkippedTasks("" + jAppArray.get("numSkippedTasks"));
			job.setNumFailedTasks("" + jAppArray.get("numFailedTasks"));
			job.setNumActiveStages("" + jAppArray.get("numActiveStages"));
			job.setNumCompletedStages("" + jAppArray.get("numCompletedStages"));
			job.setNumSkippedStages("" + jAppArray.get("numSkippedStages"));
			job.setNumFailedStages("" + jAppArray.get("numFailedStages"));
			org.json.simple.JSONArray jStageArray = (org.json.simple.JSONArray) jAppArray
					.get("stageIds");
			ArrayList<String> stageIDs = new ArrayList<String>();
			for (int j = 0; j < jStageArray.size(); j++) {
				stageIDs.add("" + jStageArray.get(j));
			}
			job.setStageIds(stageIDs);
			// job.setStageIds((String)jAppArray.get("stageIds"));
			jobsList.add(job);
		}
		// System.out.println("jobs output is"+restOutput);
		return jobsList;
	}

	public ArrayList<Stage> getStagesinfo(String base_URL,
			Application application) throws Exception {
		ArrayList<Stage> stagesList = new ArrayList<Stage>();
		String restOutput = null;
		if (application.getAttemptId() == null
				|| application.getAttemptId().equals("null")) {
			restOutput = RestAPIUtil.makeRESTCall(base_URL + "/"
					+ application.getId() + "/stages");
		} else {
			restOutput = RestAPIUtil.makeRESTCall(base_URL + "/"
					+ application.getId() + "/" + application.getAttemptId()
					+ "/stages");
		}
		if (restOutput.equals("failed")) {
			return stagesList;
		}
		JSONParser parse = new JSONParser();
		org.json.simple.JSONArray stagesArray = (org.json.simple.JSONArray) parse
				.parse(restOutput);
		for (int i = 0; i < stagesArray.size(); i++) {
			org.json.simple.JSONObject stageJSON = (org.json.simple.JSONObject) stagesArray
					.get(i);
			// System.out.println("Stage details are: "+stagesArray.get(i));
			Stage stage = new Stage();
			stage.setApplicationID(application.getId());
			stage.setStatus("" + stageJSON.get("status"));
			stage.setStageId("" + stageJSON.get("stageId"));
			stage.setAttemptId("" + stageJSON.get("attemptId"));
			stage.setNumActiveTasks("" + stageJSON.get("numActiveTasks"));
			stage.setNumCompleteTasks("" + stageJSON.get("numCompleteTasks"));
			stage.setNumFailedTasks("" + stageJSON.get("numFailedTasks"));
			stage.setExecutorRunTime("" + stageJSON.get("executorRunTime"));
			stage.setSubmissionTime("" + stageJSON.get("submissionTime"));
			stage.setFirstTaskLaunchedTime(""
					+ stageJSON.get("firstTaskLaunchedTime"));
			stage.setCompletionTime("" + stageJSON.get("completionTime"));
			stage.setInputBytes("" + stageJSON.get("inputBytes"));
			stage.setInputRecords("" + stageJSON.get("inputRecords"));
			stage.setOutputBytes("" + stageJSON.get("outputBytes"));
			stage.setOutputRecords("" + stageJSON.get("outputRecords"));
			stage.setShuffleReadBytes("" + stageJSON.get("shuffleReadBytes"));
			stage.setShuffleReadRecords(""
					+ stageJSON.get("shuffleReadRecords"));
			stage.setShuffleWriteBytes("" + stageJSON.get("shuffleWriteBytes"));
			stage.setShuffleWriteRecords(""
					+ stageJSON.get("shuffleWriteRecords"));
			stage.setMemoryBytesSpilled(""
					+ stageJSON.get("memoryBytesSpilled"));
			stage.setDiskBytesSpilled("" + stageJSON.get("diskBytesSpilled"));
			stage.setName("" + stageJSON.get("name"));
			stage.setSchedulingPool("" + stageJSON.get("schedulingPool"));
			stage.setNumTasks("" + stageJSON.get("numTasks"));
			stagesList.add(stage);
		}
		return stagesList;
	}

	public ArrayList<Executor> getExecutorsInfo(String base_URL,
			Application application) throws Exception {
		ArrayList<Executor> executorsList = new ArrayList<Executor>();
		String restOutput = null;
		if (application.getAttemptId() == null
				|| application.getAttemptId().equals("null")) {
			restOutput = RestAPIUtil.makeRESTCall(base_URL + "/"
					+ application.getId() + "/allexecutors");
		} else {
			restOutput = RestAPIUtil.makeRESTCall(base_URL + "/"
					+ application.getId() + "/" + application.getAttemptId()
					+ "/allexecutors");
		}
		if (restOutput.equals("failed")) {
			return executorsList;
		}
		JSONParser parse = new JSONParser();
		org.json.simple.JSONArray executorArray = (org.json.simple.JSONArray) parse
				.parse(restOutput);
		for (int i = 0; i < executorArray.size(); i++) {
			org.json.simple.JSONObject executorJSON = (org.json.simple.JSONObject) executorArray
					.get(i);
			// String jobId=(String)executorJSON.get("id");
			Executor executor = new Executor();
			executor.setApplicationID(application.getId());
			executor.setId("" + executorJSON.get("id"));
			executor.setHostPort("" + executorJSON.get("hostPort"));
			executor.setIsActive("" + executorJSON.get("isActive"));
			executor.setRddBlocks("" + executorJSON.get("rddBlocks"));
			executor.setMemoryUsed("" + executorJSON.get("memoryUsed"));
			executor.setDiskUsed("" + executorJSON.get("diskUsed"));
			executor.setTotalCores("" + executorJSON.get("totalCores"));
			executor.setMaxTasks("" + executorJSON.get("maxTasks"));
			executor.setActiveTasks("" + executorJSON.get("activeTasks"));
			executor.setFailedTasks("" + executorJSON.get("failedTasks"));
			executor.setCompletedTasks("" + executorJSON.get("completedTasks"));
			executor.setTotalTasks("" + executorJSON.get("totalTasks"));
			executor.setTotalDuration("" + executorJSON.get("totalDuration"));
			executor.setTotalGCTime("" + executorJSON.get("totalGCTime"));
			executor.setTotalInputBytes(""
					+ executorJSON.get("totalInputBytes"));
			executor.setTotalShuffleRead(""
					+ executorJSON.get("totalShuffleRead"));
			executor.setTotalShuffleWrite(""
					+ executorJSON.get("totalShuffleWrite"));
			executor.setIsBlacklisted("" + executorJSON.get("isBlacklisted"));
			executor.setMaxMemory("" + executorJSON.get("maxMemory"));
			executor.setAddTime("" + executorJSON.get("addTime"));
			JSONObject memoryMetricsJSON = (org.json.simple.JSONObject) executorJSON
					.get("memoryMetrics");
			executor.setTotalOnHeapStorageMemory(memoryMetricsJSON.get(
					"totalOnHeapStorageMemory").toString());
			executor.setTotalOffHeapStorageMemory(memoryMetricsJSON.get(
					"totalOffHeapStorageMemory").toString());
			executor.setUsedOffHeapStorageMemory(memoryMetricsJSON.get(
					"usedOffHeapStorageMemory").toString());
			executor.setUsedOnHeapStorageMemory(memoryMetricsJSON.get(
					"usedOnHeapStorageMemory").toString());
			executorsList.add(executor);
		}
		return executorsList;
	}

	public ArrayList<Task> getTasksInfo(String base_URL,
			Application application, String stageID, String attemptID)
			throws Exception {
		ArrayList<Task> taskList = new ArrayList<Task>();
		String restOutput = null;

		// http://mstestspark-2.vpc.cloudera.com:18088/api/v1/applications/application_1563295259089_0019/stages/0/0/taskList?length=1000000000
		if (application.getAttemptId() == null
				|| application.getAttemptId().equals("null")) {
			restOutput = RestAPIUtil.makeRESTCall(base_URL + "/"
					+ application.getId() + "/stages/" + stageID + "/"
					+ attemptID + "/taskList?length=1000000000");
		} else {
			restOutput = RestAPIUtil.makeRESTCall(base_URL + "/"
					+ application.getId() + "/" + application.getAttemptId()
					+ "/stages/" + stageID + "/" + attemptID
					+ "/taskList?length=1000000000");
		}
		if (restOutput.equals("failed")) {
			return taskList;
		}
		JSONParser parse = new JSONParser();
		org.json.simple.JSONArray taskArray = (org.json.simple.JSONArray) parse
				.parse(restOutput);
		for (int i = 0; i < taskArray.size(); i++) {
			org.json.simple.JSONObject taskJSON = (org.json.simple.JSONObject) taskArray
					.get(i);
			Task taskObj = new Task();
			taskObj.setApplicationID(application.getId());
			taskObj.setStageID(stageID);
			taskObj.setTaskId("" + taskJSON.get("taskId"));
			taskObj.setIndex("" + taskJSON.get("index"));
			taskObj.setAttempt("" + taskJSON.get("attempt"));
			taskObj.setLaunchTime("" + taskJSON.get("launchTime"));
			taskObj.setExecutorId("" + taskJSON.get("executorId"));
			taskObj.setHost("" + taskJSON.get("host"));
			taskObj.setTaskLocality("" + taskJSON.get("taskLocality"));
			taskObj.setSpeculative("" + taskJSON.get("speculative"));
			JSONObject taskMetricsJSON = (org.json.simple.JSONObject) taskJSON
					.get("taskMetrics");
			taskObj.setExecutorDeserializeTime(""
					+ taskMetricsJSON.get("executorDeserializeTime"));
			taskObj.setExecutorDeserializeCpuTime(""
					+ taskMetricsJSON.get("executorDeserializeCpuTime"));
			taskObj.setExecutorRunTime(""
					+ taskMetricsJSON.get("executorRunTime"));
			taskObj.setExecutorCpuTime(""
					+ taskMetricsJSON.get("executorCpuTime"));
			taskObj.setResultSize("" + taskMetricsJSON.get("resultSize"));
			taskObj.setJvmGcTime("" + taskMetricsJSON.get("jvmGcTime"));
			taskObj.setResultSerializationTime(""
					+ taskMetricsJSON.get("resultSerializationTime"));
			taskObj.setMemoryBytesSpilled(""
					+ taskMetricsJSON.get("memoryBytesSpilled"));
			taskObj.setDiskBytesSpilled(""
					+ taskMetricsJSON.get("diskBytesSpilled"));
			taskObj.setPeakExecutionMemory(""
					+ taskMetricsJSON.get("peakExecutionMemory"));

			JSONObject inputMetricsJSON = (org.json.simple.JSONObject) taskMetricsJSON
					.get("inputMetrics");
			JSONObject outputMetricsJSON = (org.json.simple.JSONObject) taskMetricsJSON
					.get("outputMetrics");
			JSONObject shuffleReadMetricsJSON = (org.json.simple.JSONObject) taskMetricsJSON
					.get("shuffleReadMetrics");
			JSONObject shuffleWriteMetricsJSON = (org.json.simple.JSONObject) taskMetricsJSON
					.get("shuffleWriteMetrics");
			taskObj.setInput_bytesRead("" + inputMetricsJSON.get("bytesRead"));
			taskObj.setInput_recordsRead(""
					+ inputMetricsJSON.get("recordsRead"));
			taskObj.setOutput_bytesWritten(""
					+ outputMetricsJSON.get("bytesWritten"));
			taskObj.setOutput_recordsWritten(""
					+ outputMetricsJSON.get("recordsWritten"));
			taskObj.setShuffle_remoteBlocksFetched(""
					+ shuffleReadMetricsJSON.get("remoteBlocksFetched"));
			taskObj.setShuffle_localBlocksFetched(""
					+ shuffleReadMetricsJSON.get("localBlocksFetched"));
			taskObj.setShuffle_fetchWaitTime(""
					+ shuffleReadMetricsJSON.get("fetchWaitTime"));
			taskObj.setShuffle_remoteBytesRead(""
					+ shuffleReadMetricsJSON.get("remoteBytesRead"));
			taskObj.setShuffle_RemoteBytesReadToDisk(""
					+ shuffleReadMetricsJSON.get("remoteBytesReadToDisk"));
			taskObj.setShuffle_localBytesRead(""
					+ shuffleReadMetricsJSON.get("localBytesRead"));
			taskObj.setShuffle_recordsRead(""
					+ shuffleReadMetricsJSON.get("recordsRead"));
			taskObj.setShuffle_bytesWritten(""
					+ shuffleWriteMetricsJSON.get("bytesWritten"));
			taskObj.setShuffle_writeTime(""
					+ shuffleWriteMetricsJSON.get("writeTime"));
			taskObj.setShuffle_recordsWritten(""
					+ shuffleWriteMetricsJSON.get("recordsWritten"));
			taskList.add(taskObj);
		}
		return taskList;
		// return null;
	}

}
