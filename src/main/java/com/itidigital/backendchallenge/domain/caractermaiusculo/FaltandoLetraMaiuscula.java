package com.itidigital.backendchallenge.domain.caractermaiusculo;

import com.itidigital.backendchallenge.domain.IMensagemErro;

final class FaltandoLetraMaiuscula implements IMensagemErro {

    private final String MENSAGEM_ERRO = "com.validacao.erro.faltandoletramaiuscula";
    private final String mensagem;

    public FaltandoLetraMaiuscula() {
        this.mensagem = MENSAGEM_ERRO;
    }

    public String getMensagem() {
        return mensagem;
    }
}
