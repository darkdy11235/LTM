package org.example.Tuan1.Phan1;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Bai4 {
    // declare url variable with type String
    String url;
    // constructor with url parameter
    public Bai4(String url) {
        this.url = url;
    }
    // open connection to url
    URLConnection urlConnection;
    public void openConnection() throws MalformedURLException, IOException {
        URL url = new URL(this.url);
        urlConnection = url.openConnection();
    }

    // getContent method: get html content of url
    public String getContent() throws IOException {
        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        int data = inputStreamReader.read();
        String content = "";
        while (data != -1) {
            char current = (char) data;
            content += current;
            data = inputStreamReader.read();
        }
        return content;
    }
}
