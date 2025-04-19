package com.acme.spam.normalization;

public class TextNormalizer {
    /**
     * Quita absolutamente todos los caracteres que no sean letras ni espacios,
     * luego convierte todo a minusculas y recorta espacios.
     */
    public String normalize(String input) {
        if (input == null) {
            return "";
        }
        String cleaned = input.replaceAll("[^\\p{L}\\s]", "");
        return cleaned.toLowerCase().trim();
    }
}
