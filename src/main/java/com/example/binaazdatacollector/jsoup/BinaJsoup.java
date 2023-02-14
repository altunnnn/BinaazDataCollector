package com.example.binaazdatacollector.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BinaJsoup {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://bina.az/baki/alqi-satqi/menziller").get();
        Document document2 = Jsoup.connect("https://bina.az/items/3270074").get();
        // Elements page = document.getElementsByClass("page");

        String text = document2.getElementsByClass("azn").text();
        String text1 = document2.getElementsByClass("services-container").text();

        Elements parameters = document2.getElementsByClass("parameters");

       // String element = text.split(" ").toString();

        System.out.println(text);
        System.out.println(text1);
        for (Element element1: parameters) {
            System.out.println(element1);
        }


//        System.out.println(parameters);
    }
}
