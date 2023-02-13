package org.example.Tuan1.Phan1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // bài 1
        // nhập từ bàn phims vào url
        System.out.println("Bai 1: Nhập url: ");
        String url = new java.util.Scanner(System.in).nextLine();
        Bai1 bai1 = new Bai1(url);
        try {
            System.out.println(bai1.getLocalHost());
            System.out.println(bai1.getNullHost());
            System.out.println(bai1.getInternetHost());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        // bài 2
        // nhập từ bàn phims vào url
        System.out.println("Bai 2: Nhập url: ");
        String url2 = new java.util.Scanner(System.in).nextLine();
        Bai2 bai2 = new Bai2(url2);
        try {
            System.out.println(bai2.getInternetHost());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        // bài 3
        // nhập từ bàn phims vào url
        System.out.println("Bai 3: Nhập url: ");
        String url3 = new java.util.Scanner(System.in).nextLine();
        Bai3 bai3 = new Bai3(url3);
        try {
            bai3.openConnection();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        try {
            System.out.println(bai3.getHeader());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        // bài 4
        // nhập từ bàn phims vào url
        System.out.println("Bai 4: Nhập url: ");
        String url4 = new java.util.Scanner(System.in).nextLine();
        Bai4 bai4 = new Bai4(url4);
        try {
            bai4.openConnection();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        try {
            System.out.println(bai4.getContent());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}