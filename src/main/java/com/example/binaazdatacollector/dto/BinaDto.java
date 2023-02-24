package com.example.binaazdatacollector.dto;

import lombok.Builder;
import lombok.Data;
import org.aspectj.apache.bcel.util.Repository;
@Builder
@Data
public class BinaDto {
    public String menzil;
    public Long id;
    public String seher;
    public Integer sahe;
    public String qiymet;
    public String unvan;
    public String rayon;
    public Boolean cixaris;
    public Integer otaqSayi;
    public Integer mertebe;
    public String temir;
}
