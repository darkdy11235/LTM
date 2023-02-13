package org.example.Tuan1.Phan1;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

//Bài 1: Viết chương trình xuất ra các thông tin của máy trạm
//        - Localhots
//        - Null host
//        - Địa chỉ trên internet
public class Bai1 {
    // getLocalHost() : trả về địa chỉ của máy trạm
    // getHostName() : trả về tên của máy trạm
    // getHostAddress(String url) : trả về địa chỉ IP của máy trạm

    // constructor

    String url;
    public Bai1(String url) {
        this.url = url;
    }
    public String getLocalHost() throws UnknownHostException {
        return "The localhost is: " + java.net.InetAddress.getLocalHost();
    }

    public String getNullHost() throws UnknownHostException {
        return "The Null host is: " + java.net.InetAddress.getByName(null);
    }

    public String getInternetHost() throws UnknownHostException {
        return "The host address is: " + java.net.InetAddress.getByName(url);
    }
}
