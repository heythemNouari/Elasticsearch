package com.elasticsearch.cvs.service;

import com.elasticsearch.cvs.dao.CVRepository;
import com.elasticsearch.cvs.model.CV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CVServiceImpl implements CVService {

    @Autowired
    private CVRepository cvRepository;


    public CV save(CV cv) {

        return cvRepository.save(cv);
    }

    public void delete(CV cv) {

        cvRepository.delete(cv);
    }


    public Iterable<CV> findAll() {

        return cvRepository.findAll();
    }

   public List<CV> findByTag(String tag) {

        return cvRepository.findByTag(tag);
    }

    public CV findByName(String nom) {

        return cvRepository.findByName(nom);
    }
}
