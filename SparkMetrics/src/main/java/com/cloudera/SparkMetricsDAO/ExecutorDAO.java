package com.cloudera.SparkMetricsDAO;

import com.cloudera.SparkMetricsAccumulatorDTO.AppConfig;
import com.cloudera.SparkMetricsAccumulatorDTO.Executor;
import com.cloudera.SparkMetricsSink.HDFSSink;
import com.cloudera.SparkMetricsSink.KafkaSink;
import com.cloudera.SparkMetricsSink.LocalFSSink;

import java.util.ArrayList;

public class ExecutorDAO {

	public static boolean saveExecutors(ArrayList<Executor> executorList,
			AppConfig appConfig) throws Exception {

		String ColumnSeperator = appConfig.getDelimiter();
		String executorContent = "ExectorMetrics" + ColumnSeperator;

		int i = 0;

		for (Executor executor : executorList) {
			if (i > 0) {
				executorContent = executorContent + "ExectorMetrics"
						+ ColumnSeperator;
			}
			i++;
			executorContent = executorContent + executor.getApplicationID()
					+ ColumnSeperator + executor.getId() + ColumnSeperator
					+ executor.getHostPort() + ColumnSeperator
					+ executor.getIsActive() + ColumnSeperator
					+ executor.getRddBlocks() + ColumnSeperator
					+ executor.getMemoryUsed() + ColumnSeperator
					+ executor.getDiskUsed() + ColumnSeperator
					+ executor.getTotalCores() + ColumnSeperator
					+ executor.getMaxTasks() + ColumnSeperator
					+ executor.getActiveTasks() + ColumnSeperator
					+ executor.getFailedTasks() + ColumnSeperator
					+ executor.getCompletedTasks() + ColumnSeperator
					+ executor.getTotalTasks() + ColumnSeperator
					+ executor.getTotalDuration() + ColumnSeperator
					+ executor.getTotalGCTime() + ColumnSeperator
					+ executor.getTotalInputBytes() + ColumnSeperator
					+ executor.getTotalShuffleRead() + ColumnSeperator
					+ executor.getTotalShuffleWrite() + ColumnSeperator
					+ executor.getIsBlacklisted() + ColumnSeperator
					+ executor.getMaxMemory() + ColumnSeperator
					+ executor.getAddTime() + ColumnSeperator
					+ executor.getTotalOffHeapStorageMemory() + ColumnSeperator
					+ executor.getTotalOnHeapStorageMemory() + ColumnSeperator
					+ executor.getUsedOffHeapStorageMemory() + ColumnSeperator
					+ executor.getUsedOnHeapStorageMemory()+ System.lineSeparator();

		}

		if (appConfig.isWriteToHDFS()) {
			HDFSSink writeToHDFS = new HDFSSink(appConfig);
			appConfig.setOutputPath(appConfig.getBasePath()
					+ "/applications/executor");
			writeToHDFS.saveData(appConfig, executorContent);
		}
		if (appConfig.isWriteToLocalFS()) {
			LocalFSSink writeToLocalFS = new LocalFSSink();
			appConfig.setOutputPath(appConfig.getBasePath()
					+ "/applications/executor");
			writeToLocalFS.saveData(appConfig, executorContent);
		}
		if (appConfig.isWriteToKafka()) {
			KafkaSink kafkaSink = new KafkaSink();
			kafkaSink.saveData(appConfig, executorContent);
		}
		return true;
	}

}
