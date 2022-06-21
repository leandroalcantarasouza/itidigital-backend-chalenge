package com.itidigital.backendchallenge.domain.caracterrepetido;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RegraCaractereRepetidoTest {

    @Test
    public void deveAceitarSenhaSemCaracterRepetido() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereRepetido();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaSemCaracterRepetido());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveRejeitarSenhaComCaracterRepetido() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereRepetido();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComCaracterRepetido());
        assertThat(resultadoAplicacao.passou()).isEqualTo(false);
        assertThat(resultadoAplicacao.recuperaMensagensErro().isPresent()).isEqualTo(true);
    }

    private CredencialCandidata criarSenhaSemCaracterRepetido() {
        return new CredencialCandidata("123A");
    }

    private CredencialCandidata criarSenhaComCaracterRepetido() {
        return new CredencialCandidata("abcc");
    }
}
