package org.example.Tuan1.Phan1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Bai3 {
    // declare url variable with type String
    String url;
    // constructor with url parameter
    public Bai3(String url) {
        this.url = url;
    }
    // open connection to url
    URLConnection urlConnection;
    public void openConnection() throws MalformedURLException, IOException {
        URL url = new URL(this.url);
        urlConnection = url.openConnection();
    }

    // getHeaderFieldKey: get header field key, getHeaderField: get header field and return result
    public String getHeader() {
        String result = "";
        int i = 1;
        while (urlConnection.getHeaderFieldKey(i) != null) {
            result += "Header "+i+" :"+urlConnection.getHeaderFieldKey(i) + ": " + urlConnection.getHeaderField(i) + "\n";
            i++;
        }
        return result;
    }
}
