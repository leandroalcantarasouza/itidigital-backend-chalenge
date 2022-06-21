package com.itidigital.backendchallenge.domain.caracterminusculo;

import com.itidigital.backendchallenge.domain.IMensagemErro;

final class FaltandoLetraMinuscula implements IMensagemErro {

    private final String MENSAGEM_ERRO = "com.validacao.erro.faltandoletraminuscula";
    private final String mensagem;

    public FaltandoLetraMinuscula() {
        this.mensagem = MENSAGEM_ERRO;
    }

    public String getMensagem() {
        return mensagem;
    }
}
