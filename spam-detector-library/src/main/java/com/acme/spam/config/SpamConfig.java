package com.acme.spam.config;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.yaml.snakeyaml.Yaml;

public class SpamConfig {
    private double threshold;
    private List<String> terms;

    public double getThreshold() { return threshold; }
    public List<String> getTerms() { return terms; }

    public void setThreshold(double threshold) { this.threshold = threshold; }
    public void setTerms(List<String> terms) { this.terms = terms; }

    public static SpamConfig load() {
        Yaml yaml = new Yaml();
        try (InputStream in = SpamConfig.class.getResourceAsStream("/spam-config.yaml")) {
            SpamConfig cfg = yaml.loadAs(in, SpamConfig.class);
            if (cfg.terms == null) cfg.terms = new ArrayList<>();
            return cfg;
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar spam-config.yaml", e);
        }
    }
}
