package com.itidigital.backendchallenge.domain.caractermaiusculo;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.springframework.stereotype.Service;

@Service
public final class RegraLetraMaiuscula implements IRegra<CredencialCandidata> {
    private final String MASCARA_LETRA_MAIUSCULA = ".*[A-Z]+.*";

    @Override
    public ResultadoAplicacaoRegra aplicar(CredencialCandidata credencialCandidata) {
        boolean valido = credencialCandidata.getSenha().matches(MASCARA_LETRA_MAIUSCULA);
        return (valido ? new ResultadoAplicacaoRegra()
                : new ResultadoAplicacaoRegra(new FaltandoLetraMaiuscula()));
    }
}
