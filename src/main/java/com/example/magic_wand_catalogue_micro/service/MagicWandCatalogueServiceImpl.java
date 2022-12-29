package com.example.magic_wand_catalogue_micro.service;

import com.example.magic_wand_catalogue_micro.database.MagicWandCatalogueRepository;
import com.example.magic_wand_catalogue_micro.exception.server.MagicWandCatalogueDescriptionExceededLimitException;
import com.example.magic_wand_catalogue_micro.exception.server.MagicWandCatalogueExistException;
import com.example.magic_wand_catalogue_micro.exception.server.MagicWandCatalogueIdNotFoundException;
import com.example.magic_wand_catalogue_micro.exception.server.NoMagicWandCatalogueFoundException;
import com.example.magic_wand_catalogue_micro.model.MagicWandCatalogue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MagicWandCatalogueServiceImpl implements MagicWandCatalogueService {

    @Autowired
    private MagicWandCatalogueRepository magicWandCatalogueRepository;

    private static final Logger logger = LoggerFactory.getLogger(MagicWandCatalogueServiceImpl.class);

    @Override
    public MagicWandCatalogue saveMagicWandCatalogue(MagicWandCatalogue magicWandCatalogue) {
        MagicWandCatalogue existMagicWandCatalogue = magicWandCatalogueRepository.findByName(magicWandCatalogue.getName().trim());
        if (existMagicWandCatalogue != null) {
            throw new MagicWandCatalogueExistException("Magic wand catalogue exists, consider update it with magic wand catalogue Id: " + existMagicWandCatalogue.getId());
        }
        if (magicWandCatalogue.getDescription().trim().length() > 100) {
            throw new MagicWandCatalogueDescriptionExceededLimitException("Magic wand catalogue description has exceed the characters' limit -- 100");
        }
        String id = UUID.randomUUID().toString();
        magicWandCatalogue.setId(id);
        magicWandCatalogue.setName(magicWandCatalogue.getName().trim());
        magicWandCatalogue.setDescription(magicWandCatalogue.getDescription().trim());
        return magicWandCatalogueRepository.save(magicWandCatalogue);
    }

    @Override
    public List<MagicWandCatalogue> getAllMagicWandCatalogue() {
        if (magicWandCatalogueRepository.findAll().isEmpty()) {
            throw new NoMagicWandCatalogueFoundException("There is no magic wand catalogue in the database.");
        }
        return magicWandCatalogueRepository.findAll();
    }

    @Override
    public MagicWandCatalogue getMagicWandCatalogueById(String id) {
        if (!magicWandCatalogueRepository.findById(id).isPresent()) {
            throw new MagicWandCatalogueIdNotFoundException("Magic wand catalogue Id does not exist.");
        }
        return magicWandCatalogueRepository.findById(id).orElse(null);
    }

    @Override
    public MagicWandCatalogue updateMagicWandCatalogueById(String id, MagicWandCatalogue magicWandCatalogue) {
        if (!magicWandCatalogueRepository.findById(id).isPresent()) {
            throw new MagicWandCatalogueIdNotFoundException("Magic wand catalogue does not exist.");
        }
        MagicWandCatalogue existMagicWandCatalogueName = magicWandCatalogueRepository.findByName(magicWandCatalogue.getName().trim());
        MagicWandCatalogue existingMagicWandCatalogue = magicWandCatalogueRepository.findById(id).orElse(null);
        if (existMagicWandCatalogueName == null || existMagicWandCatalogueName != null && existingMagicWandCatalogue.getName().equalsIgnoreCase(magicWandCatalogue.getName().trim())) {
            if (magicWandCatalogue.getDescription().trim().length() > 100) {
                throw new MagicWandCatalogueDescriptionExceededLimitException("Magic wand catalogue description has exceed the characters' limit -- 100");
            }
            existingMagicWandCatalogue.setName(magicWandCatalogue.getName().trim());
            existingMagicWandCatalogue.setDescription(magicWandCatalogue.getDescription().trim());
            existingMagicWandCatalogue.setAgeLimit(magicWandCatalogue.getAgeLimit());
            existingMagicWandCatalogue.setStock(magicWandCatalogue.getStock());
            return magicWandCatalogueRepository.save(existingMagicWandCatalogue);
        } else {
            throw new MagicWandCatalogueExistException("Magic wand name exists, consider change to another name");
        }
    }

    @Override
    public String deleteMagicWandCatalogueById(String id) {
        if (!magicWandCatalogueRepository.findById(id).isPresent()) {
            throw new MagicWandCatalogueIdNotFoundException("Magic wand catalogue does not exist.");
        }
        magicWandCatalogueRepository.deleteById(id);
        return "Magic wand catalogue has been deleted successfully !\tID: " + id;
    }
}
