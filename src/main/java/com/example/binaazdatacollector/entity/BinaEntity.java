package com.example.binaazdatacollector.entity;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;

@Entity
@Data
@Table(name = "binaentity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BinaEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "menzil")
    private String menzil;
    @Column(name = "seher")
    private String seher;
    @Column(name = "sahe")
    private Integer sahe;
    @Column(name = "qiymet")
    private Double qiymet;
    @Column(name = "unvan")
    private Integer unvan;
    @Column(name = "rayon")
    private String rayon;
    @Column(name = "otaqSayi")
    private Integer otaqSayi;
    @Column(name = "mertebe")
    private Integer mertebe;
    @Column(name = "temir")
    private String temir;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
