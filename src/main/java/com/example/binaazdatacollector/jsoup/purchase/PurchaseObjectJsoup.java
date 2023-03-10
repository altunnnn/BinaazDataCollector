package com.example.binaazdatacollector.jsoup.purchase;

import com.example.binaazdatacollector.dto.BinaDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Optional;

public class PurchaseObjectJsoup {
    public static void main(String[] args) throws IOException {
        jsoupData();
    }

    public static void jsoupData() throws IOException {

        BinaDto dto = new BinaDto();

        Document document = Jsoup.connect("https://bina.az/baki/alqi-satqi/menziller").get();

        Elements pages = document.select("div.items_list div.items-i").not(".vipped");
//        System.out.println(pages);
        Document document2;
        Elements elements;

        boolean haveCixaris = false;
        boolean haveIpoteka = false;
        boolean haveTemir = false;


        for (Element e : pages) {
            String attr = e.attr("data-item-id");
            //  System.out.println(attr);
            document2 = Jsoup.connect("https://bina.az/items/" + attr).get();

            elements = document2.getElementsByClass("services-container");
            String text = elements.get(0).getElementsByTag("h1").text();


            // System.out.println(text);

            Elements parameters = document2.getElementsByClass("parameters");


            try {
                for (int i = 0; i < 12; i = i + 2) {
                    String text1 = parameters.get(0).getElementsByTag("td").get(i).text();

                    Optional<String> nullcheck = Optional.ofNullable(text1);
                    boolean presentt = nullcheck.isPresent();

                    if (text1.equals("Kateqoriya")) {
                        String menzilValue = parameters.get(0).getElementsByTag("td").get(1).text();
                        System.out.println(menzilValue);
                        dto.setMenzil(menzilValue);
                    } else if (text1.equals("Mərtəbə")) {
                        String mertebeValue = parameters.get(0).getElementsByTag("td").get(3).text();
                        System.out.println(mertebeValue);
                        // assert false;
                        dto.setMertebe(mertebeValue);
                    } else if (text1.equals("Sahə")) {
                        String saheValue = parameters.get(0).getElementsByTag("td").get(5).text();
                        System.out.println(saheValue);
                        // assert false;
                        //  dto.setSahe(Integer.valueOf(saheValue));
                    } else if (text1.equalsIgnoreCase("Otaq sayı")) {
                        String otaqSayiValue = parameters.get(0).getElementsByTag("td").get(7).text();
                        System.out.println(otaqSayiValue);
                        // assert false;

                        dto.setOtaqSayi(otaqSayiValue);
                    } else if (presentt && text1.equalsIgnoreCase("Çıxarış")) {
                        String cixarisValue = parameters.get(0).getElementsByTag("td").get(9).text();
                        System.out.println(cixarisValue);
                        // assert false;
                        if (cixarisValue.equalsIgnoreCase("var") || cixarisValue.equalsIgnoreCase("vardır") || cixarisValue.equalsIgnoreCase("vardir")) {
                            haveCixaris = true;
                        }

                        dto.setCixaris(haveCixaris);
                    } else if (presentt && text1.equalsIgnoreCase("İpoteka")) {
                        String ipotekaValue = parameters.get(0).getElementsByTag("td").get(11).text();

                        System.out.println(ipotekaValue);
                        if (ipotekaValue.equalsIgnoreCase("var") || ipotekaValue.equalsIgnoreCase("vardır") || ipotekaValue.equalsIgnoreCase("vardir")) {
                            haveIpoteka = true;
                        }
                        dto.setIpoteka(haveIpoteka);
                    } else if (presentt && text1.equalsIgnoreCase("Təmir")) {
                        String temirValue = parameters.get(0).getElementsByTag("td").get(13).text();

                        if (temirValue.equalsIgnoreCase("var") || temirValue.equalsIgnoreCase("vardır") || temirValue.equalsIgnoreCase("vardir")) {
                            haveTemir = true;
                        }
                        dto.setIpoteka(haveTemir);
                        // assert false;
                        //dto.setMenzil(menzilValue);
                    }
                }
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Not found");
            }


            Elements price_compound = document2.getElementsByClass("price compound");
            String price = price_compound.get(0).getElementsByTag("span").text();

            dto.setQiymet(price);

        }


//        for (int i = 2; i < 6; i++) {
//            String pageNum = "?page=" + i;
//            Document documentLoop = Jsoup.connect("https://bina.az/baki/alqi-satqi/menziller").get();
//
//            Elements pagesLoop = documentLoop.select("div.items_list div.items-i").not(".vipped");
////        System.out.println(pages);
//            Document document2Loop;
//            Elements elementsLoop;
//
//
//
//
//            for (Element e:pagesLoop) {
//                String attr = e.attr("data-item-id");
//                //  System.out.println(attr);
//                document2Loop = Jsoup.connect("https://bina.az/items/" + attr).get();
//
//                elementsLoop = document2Loop.getElementsByClass("services-container");
//                String text = elementsLoop.get(0).getElementsByTag("h1").text();
//
//                Elements price_compound = document2Loop.getElementsByClass("price compound");
//                String price = price_compound.get(0).getElementsByTag("span").text();
//
//                Elements parameters = document2Loop.getElementsByClass("parameters");
//                String menzil = parameters.get(0).getElementsByTag("td").get(1).text();
//
//
//                Elements parameters2 = document2Loop.getElementsByClass("parameters");
//                String mertebe = parameters2.get(0).getElementsByTag("td").get(3).text();
//
//                Elements parameters3 = document2Loop.getElementsByClass("parameters");
//                String sahe = parameters3.get(0).getElementsByTag("td").get(5).text();
//
//                Elements parameters4 = document2Loop.getElementsByClass("parameters");
//                String otaqSayi = parameters4.get(0).getElementsByTag("td").get(7).text();
//
//                Elements parameters5 = document2Loop.getElementsByClass("parameters");
//                String cixaris = parameters5.get(0).getElementsByTag("td").get(9).text();
//
//                //burda problem var temirli olub olmamasini goture bilmirem -- indexofbound xetasi
////            Elements parameters6 = document2.getElementsByClass("parameters");
////            String temir = parameters6.get(0).getElementsByTag("td").get(10).text();
//
//                Elements locationsMetro = document2Loop.getElementsByClass("locations");
//                String yaxinMetro = locationsMetro.get(0).getElementsByTag("a").text();
//
//                Elements map_address = document2Loop.getElementsByClass("map_address");
//                String unvan = map_address.get(0).text();
//
//
//                System.out.println(price + "\t" + text + "\n" + menzil
//                        + " " + mertebe + " " + sahe + " " + otaqSayi
//                        + " " + cixaris + " " + yaxinMetro + "***" + unvan);
//            }
//        }
    }
}
