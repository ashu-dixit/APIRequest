package get_request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class JSON_Placeholder {
	public static void main(String[] args) {
		BufferedReader reader;
		String line;
		StringBuffer response=new StringBuffer();
		
		try {
			URL url=new URL("https://jsonplaceholder.typicode.com/posts");
			HttpsURLConnection connections=(HttpsURLConnection) url.openConnection();
			connections.setRequestMethod("GET");
			connections.setRequestProperty("Content-Type", "application/jason; charset=UTF-8 ");
			connections.setConnectTimeout(500000);
			connections.setReadTimeout(500000);
			
			int status=connections.getResponseCode();
			System.out.println("Status: "+status);
			
			reader  = new BufferedReader(new InputStreamReader(connections.getInputStream()));
			while((reader.readLine())!=null) {
				line=reader.readLine();
				response.append(line);
			}
			String str=response.toString();
			System.out.println(str.substring(0, 9780));
			connections.disconnect();
			 
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
