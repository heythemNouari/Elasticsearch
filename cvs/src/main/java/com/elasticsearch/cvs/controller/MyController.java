package com.elasticsearch.cvs.controller;

import com.elasticsearch.cvs.model.CV;
import com.elasticsearch.cvs.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RestController
@RequestMapping(value= "v1/api/cv")
public class MyController {

    @Autowired
    CVService eserv;

    @PostMapping
    public ResponseEntity<CV> save(@RequestBody CV cv) {

        return ResponseEntity.created(URI.create("v1/api/cv")).body( eserv.save(cv));
    }

}
