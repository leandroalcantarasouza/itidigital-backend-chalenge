package com.itidigital.backendchallenge.domain.caracterrepetido;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.domain.IRegra;
import com.itidigital.backendchallenge.domain.ResultadoAplicacaoRegra;
import org.springframework.stereotype.Service;

@Service
public final class RegraCaractereRepetido implements IRegra<CredencialCandidata> {

    @Override
    public ResultadoAplicacaoRegra aplicar(CredencialCandidata credencialCandidata) {
        boolean valido = credencialCandidata.getSenha().length() == credencialCandidata.getSenha().chars().distinct().count();
        return (valido ? new ResultadoAplicacaoRegra()
                : new ResultadoAplicacaoRegra(new ContemCaractereRepetido()));
    }
}
