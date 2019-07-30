package com.cloudera.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RestAPIUtil {

	public static String makeRESTCall(String base_url_s) throws Exception {

		System.out.println(base_url_s);
		URL url = new URL(base_url_s);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		StringBuffer inline = new StringBuffer();
		if (responsecode != 200) {
			// throw new RuntimeException("HttpResponseCode: " + responsecode);
			System.out.println("Request failed for URL" + base_url_s);
			return "failed";
		} else {
			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNext()) {
				inline.append(sc.nextLine() + "\n");
			}
			sc.close();
		}
		return inline.toString();
	}

}
