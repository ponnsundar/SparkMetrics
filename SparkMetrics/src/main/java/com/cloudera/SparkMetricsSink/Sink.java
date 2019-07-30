package com.cloudera.SparkMetricsSink;

import com.cloudera.SparkMetricsAccumulatorDTO.AppConfig;

public interface Sink {
	public boolean saveData(AppConfig config, String FileContent);
}
