package com.cloudera.util;

import java.util.*;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TestProducer {
	public static void main(String[] args) {

		Properties props = new Properties();
		props.put(
				"bootstrap.servers",
				"mstestspark-3.vpc.cloudera.com:9092,mstestspark-4.vpc.cloudera.com:9092,mstestspark-5.vpc.cloudera.com:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<>(props);
		for (int i = 0; i < 100; i++) {
			String Rec = "t" + i;
			producer.send(new ProducerRecord<String, String>("test", Integer
					.toString(i), Rec));
		}

		producer.close();

	}

}