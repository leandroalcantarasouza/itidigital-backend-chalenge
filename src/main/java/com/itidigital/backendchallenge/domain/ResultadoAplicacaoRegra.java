package com.itidigital.backendchallenge.domain;

import java.util.Optional;

public final class ResultadoAplicacaoRegra {
    private final StatusResultadoRegra statusValidacao;
    private final Optional<IMensagemErro> mensagemErro;

    public ResultadoAplicacaoRegra() {
        this.statusValidacao = StatusResultadoRegra.VALIDA;
        this.mensagemErro = Optional.empty();
    }

    public ResultadoAplicacaoRegra(IMensagemErro mensagemErro) {
        this.statusValidacao = StatusResultadoRegra.INVALIDA;
        this.mensagemErro = Optional.of(mensagemErro);
    }

    public boolean naoPassou() {
        return !StatusResultadoRegra.VALIDA.equals(statusValidacao);
    }

    public boolean passou() {
        return StatusResultadoRegra.VALIDA.equals(statusValidacao);
    }

    public Optional<IMensagemErro> recuperaMensagensErro() {
        return this.mensagemErro;
    }
}
