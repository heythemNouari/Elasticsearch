package com.elasticsearch.cvs.service;

import com.elasticsearch.cvs.model.CV;
import java.util.List;



public interface CVService {

    CV save(CV cv);

    void delete(CV cv);

    Iterable<CV> findAll();

    List<CV> findByTag(String tag);

    CV findByName(String nom);

}
