package com.itidigital.backendchallenge.domain.caracterespecial;

import com.itidigital.backendchallenge.domain.IMensagemErro;

final class FaltandoCaractereEspecial implements IMensagemErro {

    private final String MENSAGEM_ERRO = "com.validacao.erro.faltandocaractereespecial";
    private final String mensagem;

    public FaltandoCaractereEspecial() {
        this.mensagem = MENSAGEM_ERRO;
    }

    public String getMensagem() {
        return mensagem;
    }
}
