package com.itidigital.backendchallenge.domain.caractervazio;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RegraCaractereVazioTest {

    @Test
    public void deveAceitarSenhaSemCaractereVazio() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereVazio();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaSemCaracterVazio());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveRejeitarSenhaComCaractereVazioNoMeio() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereVazio();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComCaracterVazioNoMeio());
        assertThat(resultadoAplicacao.passou()).isEqualTo(false);
        assertThat(resultadoAplicacao.recuperaMensagensErro().isPresent()).isEqualTo(true);
    }

    @Test
    public void deveRejeitarSenhaComCaractereVazioNoInicio() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereVazio();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComCaracterVazioNoInicio());
        assertThat(resultadoAplicacao.passou()).isEqualTo(false);
        assertThat(resultadoAplicacao.recuperaMensagensErro().isPresent()).isEqualTo(true);
    }

    @Test
    public void deveRejeitarSenhaComCaractereVazioNoFim() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereVazio();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComCaracterVazioNoFim());
        assertThat(resultadoAplicacao.passou()).isEqualTo(false);
        assertThat(resultadoAplicacao.recuperaMensagensErro().isPresent()).isEqualTo(true);
    }

    @Test
    public void deveRejeitarSenhaComSomenteCaractereVazio() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereVazio();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComSomenteCaracterVazio());
        assertThat(resultadoAplicacao.passou()).isEqualTo(false);
        assertThat(resultadoAplicacao.recuperaMensagensErro().isPresent()).isEqualTo(true);
    }

    private CredencialCandidata criarSenhaSemCaracterVazio() {
        return new CredencialCandidata("123456789");
    }

    private CredencialCandidata criarSenhaComCaracterVazioNoMeio() {
        return new CredencialCandidata("abc teste");
    }

    private CredencialCandidata criarSenhaComCaracterVazioNoInicio() {
        return new CredencialCandidata(" abcteste");
    }

    private CredencialCandidata criarSenhaComCaracterVazioNoFim() {
        return new CredencialCandidata("abcteste ");
    }

    private CredencialCandidata criarSenhaComSomenteCaracterVazio() {
        return new CredencialCandidata("");
    }
}
