package com.cloudera.SparkMetricsDAO;

import com.cloudera.SparkMetricsAccumulatorDTO.AppConfig;
import com.cloudera.SparkMetricsAccumulatorDTO.Stage;
import com.cloudera.SparkMetricsSink.HDFSSink;
import com.cloudera.SparkMetricsSink.KafkaSink;
import com.cloudera.SparkMetricsSink.LocalFSSink;

import java.util.ArrayList;

public class StageDAO {

	public static boolean saveStages(ArrayList<Stage> stageList,
			AppConfig appConfig) throws Exception {

		String ColumnSeperator = appConfig.getDelimiter();
		String stageContent = "StageMetrics" + ColumnSeperator;
		int i = 0;

		for (Stage stage : stageList) {
			if (i > 0) {
				stageContent = stageContent + "StageMetrics" + ColumnSeperator;
			}
			i++;
			stageContent = stageContent + stage.getApplicationID()
					+ ColumnSeperator + stage.getStatus() + ColumnSeperator
					+ stage.getStageId() + ColumnSeperator
					+ stage.getAttemptId() + ColumnSeperator
					+ stage.getNumTasks() + ColumnSeperator
					+ stage.getNumActiveTasks() + ColumnSeperator
					+ stage.getNumCompleteTasks() + ColumnSeperator
					+ stage.getNumFailedTasks() + ColumnSeperator
					+ stage.getExecutorRunTime() + ColumnSeperator
					+ stage.getSubmissionTime() + ColumnSeperator
					+ stage.getFirstTaskLaunchedTime() + ColumnSeperator
					+ stage.getCompletionTime() + ColumnSeperator
					+ stage.getInputBytes() + ColumnSeperator
					+ stage.getInputRecords() + ColumnSeperator
					+ stage.getOutputBytes() + ColumnSeperator
					+ stage.getOutputRecords() + ColumnSeperator
					+ stage.getShuffleReadBytes() + ColumnSeperator
					+ stage.getShuffleReadRecords() + ColumnSeperator
					+ stage.getShuffleWriteBytes() + ColumnSeperator
					+ stage.getShuffleWriteRecords() + ColumnSeperator
					+ stage.getMemoryBytesSpilled() + ColumnSeperator
					+ stage.getDiskBytesSpilled() + ColumnSeperator
					+ stage.getName() + ColumnSeperator
					+ stage.getSchedulingPool()+ System.lineSeparator();

		}

		if (appConfig.isWriteToHDFS()) {
			HDFSSink writeToHDFS = new HDFSSink(appConfig);
			appConfig.setOutputPath(appConfig.getBasePath()
					+ "/applications/stage");
			writeToHDFS.saveData(appConfig, stageContent);
		}
		if (appConfig.isWriteToLocalFS()) {
			LocalFSSink writeToLocalFS = new LocalFSSink();
			appConfig.setOutputPath(appConfig.getBasePath()
					+ "/applications/stage");
			writeToLocalFS.saveData(appConfig, stageContent);
		}
		if (appConfig.isWriteToKafka()) {
			KafkaSink kafkaSink = new KafkaSink();
			kafkaSink.saveData(appConfig, stageContent);
		}
		return true;
	}

}
