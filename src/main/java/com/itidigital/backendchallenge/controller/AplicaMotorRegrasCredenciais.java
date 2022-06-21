package com.itidigital.backendchallenge.controller;

import com.itidigital.backendchallenge.domain.CredencialCandidata;
import com.itidigital.backendchallenge.usecase.IMotorRegrasValidacao;
import com.itidigital.backendchallenge.usecase.ResultadoFinal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
public class AplicaMotorRegrasCredenciais {

    private final IMotorRegrasValidacao<CredencialCandidata> motorRegrasSenha;

    public AplicaMotorRegrasCredenciais(IMotorRegrasValidacao<CredencialCandidata> motorRegrasSenha) {
        this.motorRegrasSenha = motorRegrasSenha;
    }

    public ResponseEntity<ValidacaoResponse> aplicaRegras(ValidacaoRequest dadosCredenciais) {
        ResultadoFinal resultadoMotor = motorRegrasSenha.validar(new CredencialCandidata(dadosCredenciais.getSenha()));
        return resultadoMotor.isValido() ? new ResponseEntity<>(new ValidacaoResponse(TRUE), HttpStatus.OK)
                : new ResponseEntity<>(new ValidacaoResponse(FALSE), HttpStatus.PRECONDITION_FAILED);
    }
}
