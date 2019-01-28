package com.felipehogrefe.expenses;

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

import com.felipehogrefe.expenses.domain.Expense;

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
		String newJson = json.toString();
		Map<String, List<Expense>> result1 = parser.parse(Map.class, json.toString());
		
		List<Expense> list = result1.get("records");
		

		return list;
	}
	
	String reparse(String s) {
		String newString = s.replace("_a", "A")
				.replace("_b", "B")
				.replace("_c", "C")
				.replace("_d", "D")
				.replace("_e", "E")
				.replace("_f", "F")
				.replace("_g", "G")
				.replace("_h", "H")
				.replace("_i", "I")
				.replace("_j", "J")
				.replace("_k", "K")
				.replace("_l", "L")
				.replace("_m", "M")
				.replace("_n", "N")
				.replace("_o", "O")
				.replace("_p", "P")
				.replace("_q", "Q")
				.replace("_r", "R")
				.replace("_s", "S")
				.replace("_t", "T")
				.replace("_u", "U")
				.replace("_v", "V")
				.replace("_x", "X")
				.replace("_w", "W")
				.replace("_y", "Y")
				.replace("_z", "Z");
		return newString;
	}
}