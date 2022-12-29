package com.example.magic_wand_catalogue_micro.exception.server;

public class MagicWandCatalogueDescriptionExceededLimitException extends RuntimeException {
    public MagicWandCatalogueDescriptionExceededLimitException() {
    }

    public MagicWandCatalogueDescriptionExceededLimitException(String message) {
        super(message);
    }
}
