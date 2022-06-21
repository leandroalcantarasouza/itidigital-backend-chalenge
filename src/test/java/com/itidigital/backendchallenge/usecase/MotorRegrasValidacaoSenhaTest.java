package com.itidigital.backendchallenge.usecase;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IMensagemErro;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.caracterespecial.RegraCaractereEspecial;
import com.itidigital.backendchallenge.domain.caractermaiusculo.RegraLetraMaiuscula;
import com.itidigital.backendchallenge.domain.caracterminusculo.RegraLetraMinuscula;
import com.itidigital.backendchallenge.domain.caracterrepetido.RegraCaractereRepetido;
import com.itidigital.backendchallenge.domain.caractervazio.RegraCaractereVazio;
import com.itidigital.backendchallenge.domain.digito.RegraDigito;
import com.itidigital.backendchallenge.domain.quantidademinimacaracter.RegraQuantidadeCaracterMinima;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class MotorRegrasValidacaoSenhaTest {

    private final MotorRegrasValidacao motorRegras;

    public MotorRegrasValidacaoSenhaTest() {
        IRegra<CredencialCandidata> regraCaracterEspecial = new RegraCaractereEspecial();
        IRegra<CredencialCandidata> regraCaractereRepetido = new RegraCaractereRepetido();
        IRegra<CredencialCandidata> regraCaracterVazio = new RegraCaractereVazio();
        IRegra<CredencialCandidata> regraDigito = new RegraDigito();
        IRegra<CredencialCandidata> regraLetraMaiuscula = new RegraLetraMaiuscula();
        IRegra<CredencialCandidata> regraLetraMinuscula = new RegraLetraMinuscula();
        IRegra<CredencialCandidata> regraQuantidadeCaractereMinima = new RegraQuantidadeCaracterMinima();

        List<IRegra<CredencialCandidata>> regrasValidacao = new ArrayList<>();
        regrasValidacao.add(regraCaracterEspecial);
        regrasValidacao.add(regraCaractereRepetido);
        regrasValidacao.add(regraCaracterVazio);
        regrasValidacao.add(regraDigito);
        regrasValidacao.add(regraLetraMaiuscula);
        regrasValidacao.add(regraLetraMinuscula);
        regrasValidacao.add(regraQuantidadeCaractereMinima);
        motorRegras = new MotorRegrasValidacao(regrasValidacao);
    }

    @Test
    public void devePermitirSenhaValida() {
        ResultadoFinal resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaValida());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(false);
    }

    @Test
    public void deveValidarRegrasInvalidas() {
        ResultadoFinal resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaVazia());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);

        resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaaa());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);

        resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaab());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);

        resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaMaisculasRepetidasEMinusculasRepetidas());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);

        resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaMinusculaRepetida());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);

        resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaMaiusculaRepetida());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);

        resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaComEspacoNoMeio());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);

    }

    @Test
    public void deveValidarSenhaComEspacoVazio() {
        ResultadoFinal resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaComEspacoNoFim());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);
        assertThat(retornaListaErros(resultadoValidacao.getMensagemErros()))
                .containsExactlyInAnyOrder("com.validacao.erro.caractervazionaopermitido");

        resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaComEspacoNoInicio());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);
        assertThat(retornaListaErros(resultadoValidacao.getMensagemErros()))
                .containsExactlyInAnyOrder("com.validacao.erro.caractervazionaopermitido");

        resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaComEspacoNoMeio());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);
        assertThat(retornaListaErros(resultadoValidacao.getMensagemErros()))
                .containsExactlyInAnyOrder("com.validacao.erro.caractervazionaopermitido");
    }

    @Test
    public void deveValidarCaractereRepetido() {
        ResultadoFinal resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaCaracterRepetido());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);
        assertThat(retornaListaErros(resultadoValidacao.getMensagemErros()))
                .containsExactlyInAnyOrder("com.validacao.erro.comcaractererepetido");
    }

    @Test
    public void deveValidarFaltaCaracterMaiusculo() {
        ResultadoFinal resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaSemCaracterMaiusculo());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);
        assertThat(retornaListaErros(resultadoValidacao.getMensagemErros()))
                .containsExactlyInAnyOrder("com.validacao.erro.faltandoletramaiuscula");
    }

    @Test
    public void deveValidarFaltaCaracterMinusculo() {
        ResultadoFinal resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaSemCaracterMinusculo());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);
        assertThat(retornaListaErros(resultadoValidacao.getMensagemErros()))
                .containsExactlyInAnyOrder("com.validacao.erro.faltandoletraminuscula");
    }

    @Test
    public void deveValidarQuantidadeMinimaCaracteres() {
        ResultadoFinal resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaComMenosCaracteresQueOMinimo());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);
        assertThat(retornaListaErros(resultadoValidacao.getMensagemErros()))
                .containsExactlyInAnyOrder("com.validacao.erro.quantidademinimacaracteres");
    }

    @Test
    public void deveValidarCaracterEspecial() {
        ResultadoFinal resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaSemCaracterEspecial());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);
        assertThat(retornaListaErros(resultadoValidacao.getMensagemErros()))
                .containsExactlyInAnyOrder("com.validacao.erro.faltandocaractereespecial");
    }

    @Test
    public void deveValidarFaltaDigito() {
        ResultadoFinal resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaSemDigito());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);
        assertThat(retornaListaErros(resultadoValidacao.getMensagemErros()))
                .containsExactlyInAnyOrder("com.validacao.erro.faltandodigito");
    }

    @Test
    public void deveValidarFaltandoMaisDeUmCriterio() {
        ResultadoFinal resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaSemDigitoESemCaractereEspecial());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);
        assertThat(retornaListaErros(resultadoValidacao.getMensagemErros()))
                .containsExactlyInAnyOrder("com.validacao.erro.faltandodigito",
                        "com.validacao.erro.faltandocaractereespecial");
    }

    @Test
    public void deveValidarSenhaNula() {
        ResultadoFinal resultadoValidacao = motorRegras.validar(null);
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);

        resultadoValidacao = motorRegras.validar(CredencialCandidataObjectMother.criarSenhaConteudoNula());
        assertThat(resultadoValidacao.possuiErros()).isEqualTo(true);
    }

    private List<String> retornaListaErros(List<IMensagemErro> mensagemErros) {
        return mensagemErros.stream().map(IMensagemErro::getMensagem).collect(Collectors.toList());
    }
}
