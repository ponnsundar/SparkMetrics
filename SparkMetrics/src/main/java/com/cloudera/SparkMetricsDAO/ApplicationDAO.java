package com.cloudera.SparkMetricsDAO;

import com.cloudera.SparkMetricsAccumulatorDTO.AppConfig;
import com.cloudera.SparkMetricsAccumulatorDTO.Application;
import com.cloudera.SparkMetricsSink.HDFSSink;
import com.cloudera.SparkMetricsSink.KafkaSink;
import com.cloudera.SparkMetricsSink.LocalFSSink;
import com.cloudera.SparkMetricsSink.Sink;

public class ApplicationDAO {

	public static boolean saveApplictionMetrics(Application application,
			AppConfig appConfig) throws Exception {

		String ColumnSeperator = appConfig.getDelimiter();
		String applicationContent = "ApplicationMetrics" + ColumnSeperator;
		applicationContent = applicationContent + application.getName()
				+ ColumnSeperator + application.getId() + ColumnSeperator
				+ application.getStartTime() + ColumnSeperator
				+ application.getEndTime() + ColumnSeperator
				+ application.getLastUpdated() + ColumnSeperator
				+ application.getDuration() + ColumnSeperator
				+ application.getSparkUser() + ColumnSeperator
				+ application.getCompleted() + ColumnSeperator
				+ application.getStartTimeEpoch() + ColumnSeperator
				+ application.getEndTimeEpoch() + ColumnSeperator
				+ application.getLastUpdatedEpoch() + System.lineSeparator();

		if (appConfig.isWriteToHDFS()) {
			Sink writeToHDFS = new HDFSSink(appConfig);
			appConfig.setOutputPath(appConfig.getBasePath()
					+ "/applications/app");
			writeToHDFS.saveData(appConfig, applicationContent);
		}
		if (appConfig.isWriteToLocalFS()) {
			Sink writeToLocalFS = new LocalFSSink();
			appConfig.setOutputPath(appConfig.getBasePath()
					+ "/applications/app");
			writeToLocalFS.saveData(appConfig, applicationContent);
		}

		if (appConfig.isWriteToKafka()) {
			Sink kafkaSink = new KafkaSink();
			kafkaSink.saveData(appConfig, applicationContent);
		}

		return true;
	}

}
