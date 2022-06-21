package com.itidigital.backendchallenge.domain.quantidademinimacaracter;

import com.itidigital.backendchallenge.domain.IMensagemErro;

final class QuantidadeCaracteresMenorQuePermitida implements IMensagemErro {

    private final String MENSAGEM_ERRO = "com.validacao.erro.quantidademinimacaracteres";
    private final String mensagem;

    public QuantidadeCaracteresMenorQuePermitida() {
        this.mensagem = MENSAGEM_ERRO;
    }

    public String getMensagem() {
        return mensagem;
    }
}
