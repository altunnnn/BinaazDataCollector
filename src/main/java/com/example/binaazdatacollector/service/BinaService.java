package com.example.binaazdatacollector.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class BinaService {






    public BinaService() throws IOException {
        Document document = Jsoup.connect("https://bina.az/").get();

        
    }
}
