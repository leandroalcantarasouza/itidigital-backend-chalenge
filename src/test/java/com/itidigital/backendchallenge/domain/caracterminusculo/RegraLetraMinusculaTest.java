package com.itidigital.backendchallenge.domain.caracterminusculo;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RegraLetraMinusculaTest {

    @Test
    public void deveAceitarSenhaComCaracterMinusculo() {
        IRegra<CredencialCandidata> regraDigito = new RegraLetraMinuscula();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComCaracterMinusculo());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveRejeitarSenhaSemCaracterMinusculo() {
        IRegra<CredencialCandidata> regraDigito = new RegraLetraMinuscula();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaSemmCaracterMinusculo());
        assertThat(resultadoAplicacao.passou()).isEqualTo(false);
        assertThat(resultadoAplicacao.recuperaMensagensErro().isPresent()).isEqualTo(true);
    }

    private CredencialCandidata criarSenhaComCaracterMinusculo() {
        return new CredencialCandidata("123a");
    }

    private CredencialCandidata criarSenhaSemmCaracterMinusculo() {
        return new CredencialCandidata("ABC");
    }
}
