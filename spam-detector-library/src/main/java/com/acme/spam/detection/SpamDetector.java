package com.acme.spam.detection;

import com.acme.spam.config.SpamTermRepository;
import com.acme.spam.normalization.TextNormalizer;

public class SpamDetector {
    private final SpamTermRepository repo;
    private final double threshold;
    private final TextNormalizer normalizer = new TextNormalizer();

    public SpamDetector(SpamTermRepository repo, double threshold) {
        this.repo = repo;
        this.threshold = threshold;
    }

    public boolean isSpam(String text) {
        String norm = normalizer.normalize(text);
        String[] tokens = norm.trim().split("\\s+");
        if (tokens.length == 0) return false;
        long spamCount = java.util.Arrays.stream(tokens)
            .filter(repo::contains)
            .count();
        double ratio = (double) spamCount / tokens.length;
        return ratio > threshold;
    }
}
