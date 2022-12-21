package com.example.magic_wand_catalogue_micro.controller;

import com.example.magic_wand_catalogue_micro.model.MagicWandCatalogue;
import com.example.magic_wand_catalogue_micro.service.MagicWandCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/magic-wand-catalogue")
public class MagicWandCatalogueController {

    @Autowired
    private MagicWandCatalogueService magicWandCatalogueService;

    @PostMapping("add")
    public MagicWandCatalogue addMagicWandCatalogue(@RequestBody MagicWandCatalogue magicWandCatalogue){
        return magicWandCatalogueService.saveMagicWandCatalogue(magicWandCatalogue);
    }

    @GetMapping("find-all")
    public List<MagicWandCatalogue> findAllMagicWandCatalogue() {
        return magicWandCatalogueService.getAllMagicWandCatalogue();
    }

    @GetMapping("find-id/{id}")
    public MagicWandCatalogue findMagicWandCatalogueById(@PathVariable String id){
        return magicWandCatalogueService.getMagicWandCatalogueById(id);
    }

    @PutMapping("update-id/{id}")
    public MagicWandCatalogue changeMagicWandCatalogueById(@PathVariable String id, @RequestBody MagicWandCatalogue magicWandCatalogue){
        return magicWandCatalogueService.updateMagicWandCatalogueById(id, magicWandCatalogue);
    }

    @DeleteMapping("delete-id/{id}")
    public String removeMagicWandCatalogueById(@PathVariable String id){
        return magicWandCatalogueService.deleteMagicWandCatalogueById(id);
    }
}
