package com.example.magic_wand_catalogue_micro.service;

import com.example.magic_wand_catalogue_micro.database.MagicWandCatalogueRepository;
import com.example.magic_wand_catalogue_micro.model.MagicWandCatalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MagicWandCatalogueService {
    @Autowired
    private MagicWandCatalogueRepository magicWandCatalogueRepository;

    public MagicWandCatalogue saveMagicWandCatalogue(MagicWandCatalogue magicWandCatalogue){
        String id = UUID.randomUUID().toString();
        magicWandCatalogue.setId(id);
        return magicWandCatalogueRepository.save(magicWandCatalogue);
    }

    public List<MagicWandCatalogue> getAllMagicWandCatalogue(){
        return magicWandCatalogueRepository.findAll();
    }

    public MagicWandCatalogue getMagicWandCatalogueById(String id){
        return magicWandCatalogueRepository.findById(id).orElse(null);
    }

    public MagicWandCatalogue updateMagicWandCatalogueById(String id, MagicWandCatalogue magicWandCatalogue){
        MagicWandCatalogue existingMagicWandCatalogue = magicWandCatalogueRepository.findById(id).orElse(null);
        existingMagicWandCatalogue.setName(magicWandCatalogue.getName());
        existingMagicWandCatalogue.setDescription(magicWandCatalogue.getDescription());
        existingMagicWandCatalogue.setAgeLimit(magicWandCatalogue.getAgeLimit());
        existingMagicWandCatalogue.setStock(magicWandCatalogue.getStock());
        return magicWandCatalogueRepository.save(existingMagicWandCatalogue);
    }

    public String deleteMagicWandCatalogueById(String id){
        magicWandCatalogueRepository.deleteById(id);
        return "Magic wand catalogue has been deleted successfully !\tID: " + id;
    }
}
