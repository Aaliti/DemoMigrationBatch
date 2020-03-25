package com.migrationbatch.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@SequenceGenerator(name = "clientv3_seq", allocationSize = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientV3 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientv3_seq")
    private Long id;
    private String nom;
    private Long idV2;
    private String createdBy;
    private Date dateCreation = new Date();

   /* public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getIdV2() {
        return idV2;
    }

    public void setIdV2(Long idV2) {
        this.idV2 = idV2;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }*/
}
