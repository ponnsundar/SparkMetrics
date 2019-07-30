package com.cloudera.SparkMetricsDAO;

import com.cloudera.SparkMetricsAccumulatorDTO.AppConfig;
import com.cloudera.SparkMetricsAccumulatorDTO.Task;
import com.cloudera.SparkMetricsSink.HDFSSink;
import com.cloudera.SparkMetricsSink.KafkaSink;
import com.cloudera.SparkMetricsSink.LocalFSSink;

import java.util.ArrayList;

public class TaskDAO {

	public static boolean saveTasks(ArrayList<ArrayList<Task>> taskList,
			AppConfig appConfig) throws Exception {

		String ColumnSeperator = appConfig.getDelimiter();
		String taskContent = "TaskMetrics" + ColumnSeperator;
		int i = 0;

		for (ArrayList<Task> taskArrayList : taskList) {
			for (Task task : taskArrayList) {
				if (i > 0) {
				
					taskContent = taskContent + "TaskMetrics" + ColumnSeperator;
				}
				i++;
				taskContent = taskContent + task.getApplicationID()
						+ ColumnSeperator + task.getStageID() + ColumnSeperator
						+ task.getTaskId() + ColumnSeperator + task.getIndex()
						+ ColumnSeperator + task.getAttempt() + ColumnSeperator
						+ task.getLaunchTime() + ColumnSeperator
						+ task.getExecutorId() + ColumnSeperator
						+ task.getHost() + ColumnSeperator
						+ task.getTaskLocality() + ColumnSeperator
						+ task.getSpeculative() + ColumnSeperator
						+ task.getExecutorDeserializeTime() + ColumnSeperator
						+ task.getExecutorDeserializeCpuTime()
						+ ColumnSeperator + task.getExecutorRunTime()
						+ ColumnSeperator + task.getExecutorCpuTime()
						+ ColumnSeperator + task.getResultSize()
						+ ColumnSeperator + task.getJvmGcTime()
						+ ColumnSeperator + task.getResultSerializationTime()
						+ ColumnSeperator + task.getMemoryBytesSpilled()
						+ ColumnSeperator + task.getDiskBytesSpilled()
						+ ColumnSeperator + task.getPeakExecutionMemory()
						+ ColumnSeperator + task.getInput_bytesRead()
						+ ColumnSeperator + task.getInput_recordsRead()
						+ ColumnSeperator + task.getOutput_bytesWritten()
						+ ColumnSeperator + task.getOutput_recordsWritten()
						+ ColumnSeperator
						+ task.getShuffle_remoteBlocksFetched()
						+ ColumnSeperator
						+ task.getShuffle_localBlocksFetched()
						+ ColumnSeperator + task.getShuffle_fetchWaitTime()
						+ ColumnSeperator + task.getShuffle_remoteBytesRead()
						+ ColumnSeperator
						+ task.getShuffle_RemoteBytesReadToDisk()
						+ ColumnSeperator + task.getShuffle_localBytesRead()
						+ ColumnSeperator + task.getShuffle_recordsRead()
						+ ColumnSeperator + task.getShuffle_bytesWritten()
						+ ColumnSeperator + task.getShuffle_writeTime()
						+ ColumnSeperator + task.getShuffle_recordsWritten()+ System.lineSeparator();

			}
		}

		if (appConfig.isWriteToHDFS()) {
			HDFSSink writeToHDFS = new HDFSSink(appConfig);
			appConfig.setOutputPath(appConfig.getBasePath()
					+ "/applications/task");
			writeToHDFS.saveData(appConfig, taskContent);
		}
		if (appConfig.isWriteToLocalFS()) {
			LocalFSSink writeToLocalFS = new LocalFSSink();
			appConfig.setOutputPath(appConfig.getBasePath()
					+ "/applications/task");
			writeToLocalFS.saveData(appConfig, taskContent);
		}
		if (appConfig.isWriteToKafka()) {
			KafkaSink kafkaSink = new KafkaSink();
			kafkaSink.saveData(appConfig, taskContent);
		}
		return true;
	}

}
