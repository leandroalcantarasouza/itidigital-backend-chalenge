package com.itidigital.backendchallenge.usecase;

import com.itidigital.backendchallenge.domain.IMensagemErro;

import java.util.ArrayList;
import java.util.List;

public class ResultadoFinal {

    private StatusFinal statusFinal = StatusFinal.OK;
    private final List<IMensagemErro> mensagemErros = new ArrayList<>();

    public void adicionaErro(IMensagemErro mensagemAdicionar) {
        statusFinal = StatusFinal.ERRO;
        mensagemErros.add(mensagemAdicionar);
    }

    public List<IMensagemErro> getMensagemErros() {
        return new ArrayList<>(mensagemErros);
    }

    public boolean possuiErros() {
        return StatusFinal.ERRO.equals(statusFinal);
    }

    public boolean isValido() {
        return StatusFinal.OK.equals(statusFinal);
    }
}
