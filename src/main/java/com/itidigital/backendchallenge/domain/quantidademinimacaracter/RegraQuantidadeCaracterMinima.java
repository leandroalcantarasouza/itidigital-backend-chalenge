package com.itidigital.backendchallenge.domain.quantidademinimacaracter;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.springframework.stereotype.Service;

@Service
public final class RegraQuantidadeCaracterMinima implements IRegra<CredencialCandidata> {

    private final int QUANTIDADE_MINIMA_CARACTERES = 9;

    @Override
    public ResultadoAplicacaoRegra aplicar(CredencialCandidata credencialCandidata) {
        boolean valido = credencialCandidata.getSenha().chars().count() >= QUANTIDADE_MINIMA_CARACTERES;
        return (valido ?
                new ResultadoAplicacaoRegra()
                : new ResultadoAplicacaoRegra(new QuantidadeCaracteresMenorQuePermitida()));
    }
}
