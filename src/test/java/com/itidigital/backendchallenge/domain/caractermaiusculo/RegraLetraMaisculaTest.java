package com.itidigital.backendchallenge.domain.caractermaiusculo;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RegraLetraMaisculaTest {

    @Test
    public void deveAceitarSenhaComCaracterMaiusculo() {
        IRegra<CredencialCandidata> regraDigito = new RegraLetraMaiuscula();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComCaracterMaiusculo());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveRejeitarSenhaSemCaracterMaiusculo() {
        IRegra<CredencialCandidata> regraDigito = new RegraLetraMaiuscula();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaSemCaracterMaiusculo());
        assertThat(resultadoAplicacao.passou()).isEqualTo(false);
        assertThat(resultadoAplicacao.recuperaMensagensErro().isPresent()).isEqualTo(true);
    }

    private CredencialCandidata criarSenhaComCaracterMaiusculo() {
        return new CredencialCandidata("123A");
    }

    private CredencialCandidata criarSenhaSemCaracterMaiusculo() {
        return new CredencialCandidata("abc");
    }
}
