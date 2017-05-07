/**
 * 
 */
package com.orion.orionlauncher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author sauravsharma
 *
 */
public class CommunicationController {

	String SUCCESS = "success";
	String serverlink = "http://oriondigi.in/";

	/**
	 * does converting map items into post query string
	 * 
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getQuery(Map<String, String> params) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		try {
			boolean first = true;
			Iterator<Entry<String, String>> it = params.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, String> pair = (Entry<String, String>) it.next();
				if (first) {
					first = false;
				} else {
					result.append("&");
				}
				result.append(URLEncoder.encode(pair.getKey(), "UTF-8"));
				result.append("=");
				result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
			}
		} catch (Exception exception) {
			System.err.println(exception.getMessage());
		}
		return result.toString();
	}

	/**
	 * does the actual communication with orion server
	 *
	 * @param parameters
	 * @param path
	 * @param method
	 * @return
	 */
	public String Communicate(Map<String, String> parameters, String path, String method) {
		String response = "";
		try {
			URL url = new URL(serverlink + path);
			HttpURLConnection connection = null;
			String querystring = this.getQuery(parameters);
			System.out.println("QUERY STRING:\n" + querystring);
			if (method.compareTo("POST") == 0) {
				connection = (HttpURLConnection) url.openConnection();
				System.out.println(method);
				connection.setRequestMethod(method);
				connection.setDoInput(true);
				connection.setDoOutput(true);
				OutputStream opstream = connection.getOutputStream();
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(opstream, "UTF-8"));
				writer.write(querystring);
				writer.flush();
				writer.close();
				opstream.close();
			} else {
				url = new URL(url + "?" + querystring);
				System.out.println(url.toString());
				connection = (HttpURLConnection) url.openConnection();
				System.out.println(method);
				connection.setRequestMethod(method);
			}
			connection.connect();
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				String line;
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = br.readLine()) != null) {
					response += line;
				}
				System.out.println("HTTP_OK\n" + response);
			} else if (connection.getResponseCode() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
				InputStream inputStream = connection.getErrorStream();
				System.out.println("HTTP 500\n" + getStringFromInputStream(inputStream));
			} else {

				Map<String, List<String>> headers = connection.getHeaderFields();
				Set<Entry<String, List<String>>> entrySet = headers.entrySet();
				for (Entry<String, List<String>> entry : entrySet) {
					String headerName = entry.getKey();
					System.out.println("Header Name:" + headerName);
					List<String> headerValues = entry.getValue();
					for (String value : headerValues) {
						System.out.print("Header value:" + value);
					}
					System.out.println();
				}
				int responsecode = connection.getResponseCode();
				System.out.println(responsecode);
			}
			// connection.disconnect();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return response;
	}

	private String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

}
