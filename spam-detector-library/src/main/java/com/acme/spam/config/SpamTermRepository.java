package com.acme.spam.config;

import java.util.Set;
import java.util.stream.Collectors;

public class SpamTermRepository {
    private final Set<String> terms;

    public SpamTermRepository(SpamConfig cfg) {
        this.terms = cfg.getTerms().stream()
            .map(String::toLowerCase)
            .collect(Collectors.toSet());
    }

    public boolean contains(String token) {
        return terms.contains(token);
    }
}
