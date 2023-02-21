package com.example.binaazdatacollector.dto;

import lombok.Builder;
import lombok.Data;
import org.aspectj.apache.bcel.util.Repository;
@Builder
@Data
public class BinaDto {
    String menzil;
    Long id;
    String seher;
    Integer sahe;
    Double qiymet;
    Integer unvan;
    String rayon;
    Integer otaqSayi;
    Integer mertebe;
    String temir;
}
