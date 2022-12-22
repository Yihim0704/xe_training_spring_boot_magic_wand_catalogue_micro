package com.example.magic_wand_catalogue_micro.controller;

import com.example.magic_wand_catalogue_micro.model.MagicWandCatalogue;

import java.util.List;

public interface MagicWandCatalogueController {

    MagicWandCatalogue addMagicWandCatalogue(MagicWandCatalogue magicWandCatalogue);

    List<MagicWandCatalogue> findAllMagicWandCatalogue();

    MagicWandCatalogue findMagicWandCatalogueById(String id);

    MagicWandCatalogue changeMagicWandCatalogueById(String id, MagicWandCatalogue magicWandCatalogue);

    String removeMagicWandCatalogueById(String id);
}
