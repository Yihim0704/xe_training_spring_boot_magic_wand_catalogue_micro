package com.example.magic_wand_catalogue_micro.service;

import com.example.magic_wand_catalogue_micro.model.MagicWandCatalogue;

import java.util.List;

public interface MagicWandCatalogueService {

    MagicWandCatalogue saveMagicWandCatalogue(MagicWandCatalogue magicWandCatalogue);

    List<MagicWandCatalogue> getAllMagicWandCatalogue();

    MagicWandCatalogue getMagicWandCatalogueById(String id);

    MagicWandCatalogue updateMagicWandCatalogueById(String id, MagicWandCatalogue magicWandCatalogue);

    String deleteMagicWandCatalogueById(String id);
}
