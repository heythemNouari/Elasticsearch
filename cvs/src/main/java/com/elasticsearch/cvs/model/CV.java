package com.elasticsearch.cvs.model;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;


@Entity
@Document(indexName = "cv")
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;

    private String prenom;

    private String contenue;


    public CV(){

    }
    public CV(String nom, String prenom, String contenue) {
        this.nom = nom;
        this.prenom=prenom;
        this.contenue = contenue;
    }

    public int getId(){
        return this.id;
    }

    public String getContenue(){
        return this.contenue;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom ;
    }

    public void setNom(String nom){
        this.nom = nom ;
    }
    public void setId(int id){
        this.id = id ;
    }

    public void setContenue(String contenue){
        this.contenue = contenue ;
    }


}
