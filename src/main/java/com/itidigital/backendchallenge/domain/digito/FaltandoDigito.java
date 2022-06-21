package com.itidigital.backendchallenge.domain.digito;

import com.itidigital.backendchallenge.domain.IMensagemErro;

final class FaltandoDigito implements IMensagemErro {

    private final String MENSAGEM_ERRO = "com.validacao.erro.faltandodigito";
    private final String mensagem;

    public FaltandoDigito() {
        this.mensagem = MENSAGEM_ERRO;
    }

    public String getMensagem() {
        return mensagem;
    }
}
