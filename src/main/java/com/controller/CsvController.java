package com.controller;

import com.service.CsvFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class CsvController {

    private final CsvFileService csvFileService;

    public CsvController(CsvFileService csvFileService) {
        this.csvFileService = csvFileService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestParam("file") MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        if (!csvFileService.exists(originalFilename)) {
            try {
                csvFileService.save(originalFilename, file.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(originalFilename, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("info")
    public ResponseEntity<?> getInfo() {
        return new ResponseEntity<>(csvFileService.findAll(), HttpStatus.OK);
    }
}
