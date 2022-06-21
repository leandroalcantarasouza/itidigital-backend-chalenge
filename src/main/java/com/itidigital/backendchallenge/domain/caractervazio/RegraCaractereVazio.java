package com.itidigital.backendchallenge.domain.caractervazio;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public final class RegraCaractereVazio implements IRegra<CredencialCandidata> {

    @Override
    public ResultadoAplicacaoRegra aplicar(CredencialCandidata credencialCandidata) {
        boolean valido = !StringUtils.containsWhitespace(credencialCandidata.getSenha()) &&
                !StringUtils.isEmpty(credencialCandidata.getSenha());
        return (valido ? new ResultadoAplicacaoRegra()
                : new ResultadoAplicacaoRegra(new CaracterVazioNaoPermitido()));
    }
}
