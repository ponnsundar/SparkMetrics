package com.cloudera.SparkMetricsDAO;

import com.cloudera.SparkMetricsAccumulatorDTO.AppConfig;
import com.cloudera.SparkMetricsAccumulatorDTO.Job;
import com.cloudera.SparkMetricsSink.HDFSSink;
import com.cloudera.SparkMetricsSink.KafkaSink;
import com.cloudera.SparkMetricsSink.LocalFSSink;

import java.util.ArrayList;

public class JobsDAO {

	public static boolean saveJobs(ArrayList<Job> jobList, AppConfig appConfig)
			throws Exception {

		String ColumnSeperator = appConfig.getDelimiter();
		String jobContent = "JobMetrics" + ColumnSeperator;
		int i = 0;

		for (Job job : jobList) {
			if (i > 0) {

				jobContent = jobContent + "JobMetrics" + ColumnSeperator;
			}
			i++;
			jobContent = jobContent + job.getApplicationID() + ColumnSeperator
					+ job.getJobId() + ColumnSeperator + job.getName()
					+ ColumnSeperator + job.getSubmissionTime()
					+ ColumnSeperator + job.getCompletionTime()
					+ ColumnSeperator + job.getStatus() + ColumnSeperator
					+ job.getNumTasks() + ColumnSeperator
					+ job.getNumActiveTasks() + ColumnSeperator
					+ job.getNumCompletedTasks() + ColumnSeperator
					+ job.getNumSkippedTasks() + ColumnSeperator
					+ job.getNumFailedTasks() + ColumnSeperator
					+ job.getNumActiveStages() + ColumnSeperator
					+ job.getNumCompletedStages() + ColumnSeperator
					+ job.getNumSkippedStages() + ColumnSeperator
					+ job.getNumFailedStages()+ System.lineSeparator();

		}

		if (appConfig.isWriteToHDFS()) {
			HDFSSink writeToHDFS = new HDFSSink(appConfig);
			appConfig.setOutputPath(appConfig.getBasePath()
					+ "/applications/jobs");
			writeToHDFS.saveData(appConfig, jobContent);
		}
		if (appConfig.isWriteToLocalFS()) {
			LocalFSSink writeToLocalFS = new LocalFSSink();
			appConfig.setOutputPath(appConfig.getBasePath()
					+ "/applications/jobs");
			writeToLocalFS.saveData(appConfig, jobContent);
		}
		if (appConfig.isWriteToKafka()) {
			KafkaSink kafkaSink = new KafkaSink();
			kafkaSink.saveData(appConfig, jobContent);
		}

		return true;
	}

}
