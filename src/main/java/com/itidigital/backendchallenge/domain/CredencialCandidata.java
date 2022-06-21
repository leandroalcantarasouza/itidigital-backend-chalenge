package com.itidigital.backendchallenge.domain;

public final class CredencialCandidata {
    private final String senha;
    private final String DEFAULT_VALUE = "";

    public CredencialCandidata(String senha) {
        this.senha = (senha != null ? senha : DEFAULT_VALUE);
    }

    public CredencialCandidata() {
        this.senha = DEFAULT_VALUE;
    }

    public String getSenha() {
        return senha;
    }
}
