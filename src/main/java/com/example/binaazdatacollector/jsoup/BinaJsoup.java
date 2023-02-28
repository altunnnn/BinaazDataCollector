package com.example.binaazdatacollector.jsoup;

import com.example.binaazdatacollector.dto.BinaDto;
import lombok.Builder;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.beans.BeanProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BinaJsoup {

    public static void main(String[] args) throws IOException {
        jsoupData();
    }
    public static void jsoupData() throws IOException {

        BinaDto dto = null;

        Document document = Jsoup.connect("https://bina.az/baki/alqi-satqi/menziller").get();

        Elements pages = document.select("div.items_list div.items-i").not(".vipped");
//        System.out.println(pages);
        Document document2;
        Elements elements;





        for (Element e:pages) {
            String attr = e.attr("data-item-id");
          //  System.out.println(attr);
            document2 = Jsoup.connect("https://bina.az/items/" + attr).get();

            elements = document2.getElementsByClass("services-container");
            String text = elements.get(0).getElementsByTag("h1").text();


           // System.out.println(text);

                Elements parameters = document2.getElementsByClass("parameters");

                //Menzil
                String text1 = parameters.get(0).getElementsByTag("td").get(0).text();
                Optional<String> menzil = Optional.ofNullable(text1);
              //  menzil.ifPresent(System.out::println);
            assert text1 != null;
            if (text1.equals("Kateqoriya")) {
                    String menzilValue = parameters.get(0).getElementsByTag("td").get(1).text();
                    System.out.println(menzilValue);
                    assert false;
                    dto.setMenzil(menzilValue);
                }

            //Mertebe
            String text2 = parameters.get(0).getElementsByTag("td").get(2).text();
            Optional<String> mertebe = Optional.ofNullable(text2);
            //  menzil.ifPresent(System.out::println);
            assert text2 != null;
            if (text2.equals("Mərtəbə")) {
                String menzilValue = parameters.get(0).getElementsByTag("td").get(3).text();
                System.out.println(menzilValue);
               // assert false;
                //dto.setMenzil(menzilValue);
            }



            //sahe
            String text3 = parameters.get(0).getElementsByTag("td").get(4).text();
            Optional<String> sahe = Optional.ofNullable(text3);
            //  menzil.ifPresent(System.out::println);
            assert text3 != null;
            if (text3.equals("Sahə")) {
                String saheValue = parameters.get(0).getElementsByTag("td").get(5).text();
                System.out.println(saheValue);
                // assert false;
                //dto.setMenzil(menzilValue);
            }




            //otaqSayi
            String text4 = parameters.get(0).getElementsByTag("td").get(6).text();
            Optional<String> otaqSayi = Optional.ofNullable(text4);
            //  menzil.ifPresent(System.out::println);
            assert text4 != null;
            if (text4.equalsIgnoreCase("Otaq sayı")) {
                String otaqSayiValue = parameters.get(0).getElementsByTag("td").get(7).text();
                System.out.println(otaqSayiValue);
                // assert false;
                //dto.setMenzil(menzilValue);
            }



            //cixaris
            try{
                String text5 = parameters.get(0).getElementsByTag("td").get(8).text();
                Optional<String> cixaris = Optional.ofNullable(text5);
                boolean present2 = cixaris.isPresent();

                //  menzil.ifPresent(System.out::println);
                if (present2 && text5.equalsIgnoreCase("Çıxarış")) {
                    String cixarisValue = parameters.get(0).getElementsByTag("td").get(9).text();
                    System.out.println(cixarisValue);
                    // assert false;
                    //dto.setMenzil(menzilValue);
                }
            }catch (IndexOutOfBoundsException exception){
                System.out.println("Not found");
            }



            //ipoteka
            try{
                String text6 = parameters.get(0).getElementsByTag("td").get(10).text();
                Optional<String> ipoteka = Optional.ofNullable(text6);
                boolean present = ipoteka.isPresent();

                if (present && text6.equalsIgnoreCase("İpoteka")) {
                    String ipotekaValue = parameters.get(0).getElementsByTag("td").get(11).text();

                    System.out.println(ipotekaValue);
                    // assert false;
                    //dto.setMenzil(menzilValue);
                }
            }catch (IndexOutOfBoundsException exception){
                System.out.println("Not found");
            }




            //
            try{
                String text7 = parameters.get(0).getElementsByTag("td").get(12).text();
                Optional<String> temir = Optional.ofNullable(text7);
                // ipoteka.ifPresentOrElse(System.out::println,);


                if (text7.equalsIgnoreCase("Təmir")) {
                    String temirValue = parameters.get(0).getElementsByTag("td").get(13).text();

                    System.out.println("temir   " + temirValue);
                    // assert false;
                    //dto.setMenzil(menzilValue);
                }
            }
            catch (IndexOutOfBoundsException exception){
                System.out.println("Not found");
            }






//            Elements price_compound = document2.getElementsByClass("price compound");
//            String price = price_compound.get(0).getElementsByTag("span").text();
//
//        //    dto.setQiymet(price);
//
//            Elements parameters = document2.getElementsByClass("parameters");
//            String menzil = parameters.get(0).getElementsByTag("td").get(1).text();
//          //  dto.setMenzil(menzil);
//
//            Elements parameters2 = document2.getElementsByClass("parameters");
//            String mertebe = parameters2.get(0).getElementsByTag("td").get(3).text();
//         //   dto.setMertebe(Integer.valueOf(mertebe));
//
//            Elements parameters3 = document2.getElementsByClass("parameters");
//            String sahe = parameters3.get(0).getElementsByTag("td").get(5).text();
//         //   dto.setSahe(Integer.valueOf(sahe));
//
//            Elements parameters4 = document2.getElementsByClass("parameters");
//            String otaqSayi = parameters4.get(0).getElementsByTag("td").get(7).text();
//          //  dto.setOtaqSayi(Integer.valueOf(otaqSayi));
//
//            Elements parameters5 = document2.getElementsByClass("parameters");
//            String cixaris = parameters5.get(0).getElementsByTag("td").get(9).text();
//          //  dto.setCixaris(Boolean.valueOf(cixaris));
//
//            //burda problem var temirli olub olmamasini goture bilmirem -- indexofbound xetasi
////            Elements parameters6 = document2.getElementsByClass("parameters");
////            String temir = parameters6.get(0).getElementsByTag("td").get(11).text();
//
//            Elements locationsMetro = document2.getElementsByClass("locations");
//            String yaxinMetro = locationsMetro.get(0).getElementsByTag("a").text();
//           // dto.setRayon(yaxinMetro);
//
//            Elements map_address = document2.getElementsByClass("map_address");
//            String unvan = map_address.get(0).text();
//          //  dto.setUnvan(unvan);
//
//            System.out.println(price + "\t" + text + "\n" + menzil
//                    + " " + mertebe + " " + sahe + " " + otaqSayi
//                    + " " + cixaris + " " + yaxinMetro + "***" + unvan);
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

