package org.example.Tuan1.Phan1;

import java.net.InetAddress;

public class Bai2 {
    /*Viết chương trình hiển thị tên và địa chỉ của website
    Phương thức sử dụng:
            ▪ getAllByName(String hostname): trả về tên website và tất cả các địa chỉ IP*/

    // constructor
    String url;
    public Bai2(String url) {
        this.url = url;
    }
    public String getInternetHost() throws Exception {
        InetAddress[] inetAddresses = InetAddress.getAllByName(url);
        String result = "";
        for (InetAddress inetAddress : inetAddresses) {
            result += inetAddress + "\n";
        }
        return result;
    }
}
