package com.example.binaazdatacollector.controller;

import com.example.binaazdatacollector.dto.BinaDto;
import com.example.binaazdatacollector.service.BinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bina")
public class BinaController {

    @Autowired
    BinaService binaService;
    @PostMapping("/add")
    public void addData( BinaDto dto){
        binaService.addData(dto);
    }
}
