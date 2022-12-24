package com.example.magic_wand_catalogue_micro.controller;

import com.example.magic_wand_catalogue_micro.model.MagicWandCatalogue;
import com.example.magic_wand_catalogue_micro.service.MagicWandCatalogueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/magic-wand-catalogue")
public class MagicWandCatalogueControllerImpl implements MagicWandCatalogueController {

    @Autowired
    private MagicWandCatalogueServiceImpl magicWandCatalogueServiceImpl;

    @Override
    @PostMapping("add")
    public MagicWandCatalogue addMagicWandCatalogue(@RequestBody @Valid MagicWandCatalogue magicWandCatalogue) {
        return magicWandCatalogueServiceImpl.saveMagicWandCatalogue(magicWandCatalogue);
    }

    @Override
    @GetMapping("find-all")
    public List<MagicWandCatalogue> findAllMagicWandCatalogue() {
        return magicWandCatalogueServiceImpl.getAllMagicWandCatalogue();
    }

    @Override
    @GetMapping("find-id/{id}")
    public MagicWandCatalogue findMagicWandCatalogueById(@PathVariable String id) {
        return magicWandCatalogueServiceImpl.getMagicWandCatalogueById(id);
    }

    @Override
    @PutMapping("update-id/{id}")
    public MagicWandCatalogue changeMagicWandCatalogueById(@PathVariable String id, @RequestBody @Valid MagicWandCatalogue magicWandCatalogue) {
        return magicWandCatalogueServiceImpl.updateMagicWandCatalogueById(id, magicWandCatalogue);
    }

    @Override
    @DeleteMapping("delete-id/{id}")
    public String removeMagicWandCatalogueById(@PathVariable String id) {
        return magicWandCatalogueServiceImpl.deleteMagicWandCatalogueById(id);
    }
}
