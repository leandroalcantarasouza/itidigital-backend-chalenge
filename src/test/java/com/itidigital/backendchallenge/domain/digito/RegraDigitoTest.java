package com.itidigital.backendchallenge.domain.digito;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RegraDigitoTest {

    @Test
    public void deveExigirCaracterComDigito() {
        IRegra<CredencialCandidata> regraDigito = new RegraDigito();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComDigito());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        Assertions.assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveRejeitarSemCaracterComDigito() {
        IRegra<CredencialCandidata> regraDigito = new RegraDigito();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaSemDigito());
        assertThat(resultadoAplicacao.passou()).isEqualTo(false);
        assertThat(resultadoAplicacao.recuperaMensagensErro().isPresent()).isEqualTo(true);
    }

    private CredencialCandidata criarSenhaComDigito() {
        return new CredencialCandidata("123abc");
    }

    private CredencialCandidata criarSenhaSemDigito() {
        return new CredencialCandidata("abc");
    }
}
