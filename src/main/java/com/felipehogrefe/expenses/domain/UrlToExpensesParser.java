package com.felipehogrefe.expenses.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.svenson.JSONParser;

public class UrlToExpensesParser {
	private String url;

	public UrlToExpensesParser(String _url) {
		this.url = _url;
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Expense> getExpenses() throws JSONException, IOException {
		JSONObject json = new JSONObject(readJsonFromUrl(url).get("result").toString());
		JSONParser parser = new JSONParser();
		parser.addTypeHint(".records[]", Expense.class);
		Map<String, List<Expense>> result1 = parser.parse(Map.class, json.toString());
		List<Expense> list = result1.get("records");

		return list;
	}
}