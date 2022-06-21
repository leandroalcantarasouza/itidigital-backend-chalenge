package com.itidigital.backendchallenge.domain.caracterminusculo;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.springframework.stereotype.Service;

@Service
public final class RegraLetraMinuscula implements IRegra<CredencialCandidata> {
    private final String MASCARA_LETRA_MINUSCULA = ".*[a-z]+.*";

    @Override
    public ResultadoAplicacaoRegra aplicar(CredencialCandidata credencialCandidata) {
        boolean valido = credencialCandidata.getSenha().matches(MASCARA_LETRA_MINUSCULA);
        return (valido ? new ResultadoAplicacaoRegra()
                : new ResultadoAplicacaoRegra(new FaltandoLetraMinuscula()));
    }
}
