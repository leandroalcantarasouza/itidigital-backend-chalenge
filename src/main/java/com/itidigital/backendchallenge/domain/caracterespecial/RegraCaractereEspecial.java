package com.itidigital.backendchallenge.domain.caracterespecial;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.springframework.stereotype.Service;

@Service
public final class RegraCaractereEspecial implements IRegra<CredencialCandidata> {
    private final String MASCARA_CARACTERE_ESPECIAL = ".*[!@#$%^&*()\\-\\+]+.*";

    @Override
    public ResultadoAplicacaoRegra aplicar(CredencialCandidata credencialCandidata) {
        boolean valido = credencialCandidata.getSenha().matches(MASCARA_CARACTERE_ESPECIAL);
        return (valido ? new ResultadoAplicacaoRegra()
                : new ResultadoAplicacaoRegra(new FaltandoCaractereEspecial()));
    }
}
