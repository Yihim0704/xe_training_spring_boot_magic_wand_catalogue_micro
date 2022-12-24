package com.example.magic_wand_catalogue_micro.exception;

public class MagicWandCatalogueExistException extends RuntimeException {
    public MagicWandCatalogueExistException() {
    }

    public MagicWandCatalogueExistException(String message) {
        super(message);
    }
}
