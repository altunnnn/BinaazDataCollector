package com.example.binaazdatacollector.repository;

import com.example.binaazdatacollector.entity.BinaEntity;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinaRepository extends JpaRepository<BinaEntity, Long> {
        BinaEntity findByMenzilAndMertebeAndSaheAAndAndIdAndSeherAndTemirAndTemirAndOtaqSayiAndQiymetAndRayonAndUnvan(String menzil, Integer mertebe, Integer sahe, Long id, String seher, String temir, Integer otaqSayi, Double qiymet, String rayon, Integer unvan);
}
