package com.example.binaazdatacollector.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BinaJsoup {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://bina.az/baki/alqi-satqi/menziller").get();

        Elements pages = document.getElementsByAttribute("data-item-id");
        String attr = pages.attr("data-item-id");
        //System.out.println(attr);

        Document document2 = Jsoup.connect("https://bina.az/items/" + attr).get();
        Elements elements = document2.getElementsByClass("services-container");
        String text = elements.get(0).getElementsByTag("h1").text();

        System.out.println(text);
//        for (int i = 0; i < 10; i++) {
//            int i1 = Integer.parseInt(attr);
//           // i1 = i1 + i;
//            String s = Integer.toString(i1+i);
//            Document document3 = Jsoup.connect("https://bina.az/items/" + s).get();
//            Elements elements2 = document2.getElementsByClass("services-container");
//            String text2 = elements.get(0).getElementsByTag("h1").text();
//            System.out.println(text2);}
        }











        // Elements page = document.getElementsByClass("page");

//        String text = document2.getElementsByClass("azn").text();
//        String text1 = document2.getElementsByClass("services-container").text();
//
//        Elements parameters = document2.getElementsByClass("parameters");
//
//       // String element = text.split(" ").toString();
//
//        System.out.println(text);
//        System.out.println(text1);
//        for (Element element1: parameters) {
//            System.out.println(element1);
//        }


//        System.out.println(parameters);
    }

