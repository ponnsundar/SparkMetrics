package com.cloudera.SparkMetricsAccumulatorDTO;

public class AppConfig {

	String spark_history_server_url;
	String configPath;
	String basePath;
	String outputPath;
	String delimiter;
	boolean WriteToHDFS = false;
	boolean WriteToLocalFS = false;
	boolean writeToKafka = false;
	String kafkaBootstrapServers;
	String kafkaTopic;
	boolean isSecured = false;
	String principal;
	String keytabPath;

	public boolean isSecured() {
		return isSecured;
	}

	public void setSecured(boolean isSecured) {
		this.isSecured = isSecured;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getKeytabPath() {
		return keytabPath;
	}

	public void setKeytabPath(String keytabPath) {
		this.keytabPath = keytabPath;
	}

	public String getKafkaBootstrapServers() {
		return kafkaBootstrapServers;
	}

	public void setKafkaBootstrapServers(String kafkaBootstrapServers) {
		this.kafkaBootstrapServers = kafkaBootstrapServers;
	}

	public String getKafkaTopic() {
		return kafkaTopic;
	}

	public void setKafkaTopic(String kafkaTopic) {
		this.kafkaTopic = kafkaTopic;
	}

	public boolean isWriteToKafka() {
		return writeToKafka;
	}

	public void setWriteToKafka(boolean writeToKafka) {
		this.writeToKafka = writeToKafka;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	public boolean isWriteToHDFS() {
		return WriteToHDFS;
	}

	public void setWriteToHDFS(boolean writeToHDFS) {
		WriteToHDFS = writeToHDFS;
	}

	public boolean isWriteToLocalFS() {
		return WriteToLocalFS;
	}

	public void setWriteToLocalFS(boolean writeToLocalFS) {
		WriteToLocalFS = writeToLocalFS;
	}

	public String getSpark_history_server_url() {
		return spark_history_server_url;
	}

	public void setSpark_history_server_url(String spark_history_server_url) {
		this.spark_history_server_url = spark_history_server_url;
	}

	public String getConfigPath() {
		return configPath;
	}

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
}
