package com.itidigital.backendchallenge.domain.caracterrepetido;

import com.itidigital.backendchallenge.domain.IMensagemErro;

final class ContemCaractereRepetido implements IMensagemErro {

    private final String MENSAGEM_ERRO = "com.validacao.erro.comcaractererepetido";
    private final String mensagem;

    public ContemCaractereRepetido() {
        this.mensagem = MENSAGEM_ERRO;
    }

    public String getMensagem() {
        return mensagem;
    }
}
