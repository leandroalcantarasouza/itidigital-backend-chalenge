package com.itidigital.backendchallenge.domain.caractervazio;

import com.itidigital.backendchallenge.domain.IMensagemErro;

final class CaracterVazioNaoPermitido implements IMensagemErro {

    private final String MENSAGEM_ERRO = "com.validacao.erro.caractervazionaopermitido";
    private final String mensagem;

    public CaracterVazioNaoPermitido() {
        this.mensagem = MENSAGEM_ERRO;
    }

    public String getMensagem() {
        return mensagem;
    }
}
