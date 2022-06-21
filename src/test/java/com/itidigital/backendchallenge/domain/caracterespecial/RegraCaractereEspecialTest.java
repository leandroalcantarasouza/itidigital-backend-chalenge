package com.itidigital.backendchallenge.domain.caracterespecial;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RegraCaractereEspecialTest {

    @Test
    public void deveAceitarCaracterEspecialVarianteExclamacao() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComExclamacao());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveAceitarCaracterEspecialVarianteArroba() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComArroba());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveAceitarCaracterEspecialVarianteTralha() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComTralha());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveAceitarCaracterEspecialVarianteCifrao() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComCifrao());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveAceitarCaracterEspecialVariantePercentual() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComPercentual());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveAceitarCaracterEspecialVarianteCircunflexo() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComCircunflexo());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveAceitarCaracterEspecialEComercial() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComEComercial());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveAceitarCaracterEspecialEstrela() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComEstrela());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveAceitarCaracterEspecialParenteseEsquerdo() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComParentesesEsquerdo());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveAceitarCaracterEspecialParenteseDireito() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComParentesesDireito());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveAceitarCaracterEspecialMenos() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComMenos());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveAceitarCaracterEspecialMais() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComMais());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveRejeitarSemCaracterEspecial() {
        IRegra<CredencialCandidata> regraDigito = new RegraCaractereEspecial();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaSemCaracterEspecial());
        assertThat(resultadoAplicacao.passou()).isEqualTo(false);
        assertThat(resultadoAplicacao.recuperaMensagensErro().isPresent()).isEqualTo(true);
    }

    private CredencialCandidata criarSenhaSemCaracterEspecial() {
        return new CredencialCandidata("abc");
    }

    private CredencialCandidata criarSenhaComExclamacao() {
        return new CredencialCandidata("123A!");
    }

    private CredencialCandidata criarSenhaComArroba() {
        return new CredencialCandidata("123A@");
    }

    private CredencialCandidata criarSenhaComTralha() {
        return new CredencialCandidata("123A#");
    }

    private CredencialCandidata criarSenhaComCifrao() {
        return new CredencialCandidata("123A$");
    }

    private CredencialCandidata criarSenhaComPercentual() {
        return new CredencialCandidata("123A%");
    }

    private CredencialCandidata criarSenhaComCircunflexo() {
        return new CredencialCandidata("123A^");
    }

    private CredencialCandidata criarSenhaComEComercial() {
        return new CredencialCandidata("123A&");
    }

    private CredencialCandidata criarSenhaComEstrela() {
        return new CredencialCandidata("123A*");
    }

    private CredencialCandidata criarSenhaComParentesesEsquerdo() {
        return new CredencialCandidata("123A(");
    }

    private CredencialCandidata criarSenhaComParentesesDireito() {
        return new CredencialCandidata("123A)");
    }

    private CredencialCandidata criarSenhaComMenos() {
        return new CredencialCandidata("123A-");
    }

    private CredencialCandidata criarSenhaComMais() {
        return new CredencialCandidata("123A+");
    }
}
