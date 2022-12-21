package com.example.magic_wand_catalogue_micro.database;

import com.example.magic_wand_catalogue_micro.model.MagicWandCatalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicWandCatalogueRepository extends JpaRepository<MagicWandCatalogue, String> {
}
