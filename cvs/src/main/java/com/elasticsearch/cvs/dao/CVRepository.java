package com.elasticsearch.cvs.dao;

import com.elasticsearch.cvs.model.CV;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface CVRepository extends CrudRepository<CV, String> {

    List<CV> findByTag(String tag);

    CV findByName(String nom);


}

