package com.example.binaazdatacollector.service;

import com.example.binaazdatacollector.dto.BinaDto;
import com.example.binaazdatacollector.entity.BinaEntity;
import com.example.binaazdatacollector.repository.BinaRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BinaService {



    @Autowired
    BinaRepository repository;

    public BinaEntity addData(BinaDto dto){
        BinaEntity entity = BinaEntity.builder()
                .id(dto.getId())
                .menzil(dto.getMenzil())
                .mertebe(dto.getMertebe())
                .temir(dto.getTemir())
                .unvan(dto.getUnvan())
                .otaqSayi(dto.getOtaqSayi())
                .qiymet(dto.getQiymet())
                .rayon(dto.getRayon())
                .sahe(dto.getSahe())
                .seher(dto.getSeher())
                .cixaris(dto.getCixaris())
                .ipoteka(dto.getIpoteka())
                .build();


        BinaEntity save = repository.save(entity);
        return save;
    }


    public BinaService() throws IOException {
        Document document = Jsoup.connect("https://bina.az/").get();

        
    }
}
