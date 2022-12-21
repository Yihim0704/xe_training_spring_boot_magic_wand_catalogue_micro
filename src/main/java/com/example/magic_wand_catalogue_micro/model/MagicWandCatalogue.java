package com.example.magic_wand_catalogue_micro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "magic_wand_catalogue")
public class MagicWandCatalogue {
    @Id
    private String id;
    private String name;
    private String description;
    private int ageLimit;
    private int stock;

    public MagicWandCatalogue() {
    }

    public MagicWandCatalogue(String id, String name, String description, int ageLimit, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ageLimit = ageLimit;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
