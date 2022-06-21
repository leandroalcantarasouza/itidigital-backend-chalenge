package com.itidigital.backendchallenge.domain.digito;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.springframework.stereotype.Service;

@Service
public final class RegraDigito implements IRegra<CredencialCandidata> {

    private final String MASCARA_DIGITOS = ".*\\d+.*";

    @Override
    public ResultadoAplicacaoRegra aplicar(CredencialCandidata credencialCandidata) {
        boolean valido = credencialCandidata.getSenha().matches(MASCARA_DIGITOS);
        return (valido ? new ResultadoAplicacaoRegra()
                : new ResultadoAplicacaoRegra(new FaltandoDigito()));
    }
}
