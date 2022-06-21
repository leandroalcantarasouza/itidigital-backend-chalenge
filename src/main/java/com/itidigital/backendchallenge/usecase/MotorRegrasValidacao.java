package com.itidigital.backendchallenge.usecase;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
class MotorRegrasValidacao implements IMotorRegrasValidacao<CredencialCandidata> {

    private final List<IRegra<CredencialCandidata>> regrasValidacao;

    public MotorRegrasValidacao(List<IRegra<CredencialCandidata>> regrasValidacao) {
        this.regrasValidacao = new ArrayList<>(regrasValidacao);
    }

    @Override
    public ResultadoFinal validar(final CredencialCandidata credencialCandidata) {
        ResultadoFinal resultadoFinal = new ResultadoFinal();
        CredencialCandidata credencialCandidataASerAplicada = (Objects.isNull(credencialCandidata)
                || StringUtils.isEmpty(credencialCandidata.getSenha())
                ? new CredencialCandidata()
                : credencialCandidata);

        this.regrasValidacao.stream().flatMap(regra -> {
            ResultadoAplicacaoRegra resultadoRegra = regra.aplicar(credencialCandidataASerAplicada);
            if (resultadoRegra.naoPassou() && resultadoRegra.recuperaMensagensErro().isPresent()) {
                return Stream.of(resultadoRegra.recuperaMensagensErro().get());
            }
            return Stream.empty();
        }).forEach(resultadoFinal::adicionaErro);
        return resultadoFinal;
    }
}
