package com.itidigital.backendchallenge.domain.quantidademinimacaracter;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RegraQuantidadeCaracterMinimaTest {

    @Test
    public void deveAceitarSenhaComMaisCaracteresQueMinimo() {
        IRegra<CredencialCandidata> regraDigito = new RegraQuantidadeCaracterMinima();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComMaisCaracteresQueQuantidadeMinima());
        assertThat(resultadoAplicacao.passou()).isEqualTo(true);
        assertThat(resultadoAplicacao.recuperaMensagensErro()).isEqualTo(Optional.empty());
    }

    @Test
    public void deveRejeitarSenhaComMenosCaracteresQueMinimo() {
        IRegra<CredencialCandidata> regraDigito = new RegraQuantidadeCaracterMinima();
        ResultadoAplicacaoRegra resultadoAplicacao = regraDigito.aplicar(criarSenhaComMenosCaracteresQueQuantidadeMinima());
        assertThat(resultadoAplicacao.passou()).isEqualTo(false);
        assertThat(resultadoAplicacao.recuperaMensagensErro().isPresent()).isEqualTo(true);
    }

    private CredencialCandidata criarSenhaComMaisCaracteresQueQuantidadeMinima() {
        return new CredencialCandidata("123456789");
    }

    private CredencialCandidata criarSenhaComMenosCaracteresQueQuantidadeMinima() {
        return new CredencialCandidata("12345678");
    }
}
