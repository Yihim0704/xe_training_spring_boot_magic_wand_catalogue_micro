package com.example.magic_wand_catalogue_micro.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "magic_wand_catalogue")
public class MagicWandCatalogue {
    @Id
    private String id;

    @NotNull(message = "Magic wand name should not be null.")
    @NotBlank(message = "Magic wand name should not be blank.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Magic wand name should not be containing special characters and numbers.")
    private String name;

    @NotNull(message = "Magic wand description should not be null.")
    @NotBlank(message = "Magic wand description should not be blank.")
    @Pattern(regexp = "^[a-zA-Z0-9,. ]+$", message = "Magic wand name should not be containing special characters except comma and full stop.")
    private String description;

    @Range(min = 18, max = 70, message = "Age limit for magic magic should be between 18 to 70 years of age.")
    private int ageLimit;

    @Min(0)
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

    @Override
    public String toString() {
        return "MagicWandCatalogue{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ageLimit=" + ageLimit +
                ", stock=" + stock +
                '}';
    }
}
