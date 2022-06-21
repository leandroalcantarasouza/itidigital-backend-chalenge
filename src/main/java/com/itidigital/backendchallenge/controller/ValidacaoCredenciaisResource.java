package com.itidigital.backendchallenge.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "credenciais",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class ValidacaoCredenciaisResource {

    private final AplicaMotorRegrasCredenciais aplicaMotorRegrasCredenciais;

    public ValidacaoCredenciaisResource(AplicaMotorRegrasCredenciais aplicaMotorRegrasCredenciais) {
        this.aplicaMotorRegrasCredenciais = aplicaMotorRegrasCredenciais;
    }

    @PostMapping(value = "validacao")
    public ResponseEntity<ValidacaoResponse> validarCredenciais(@RequestBody ValidacaoRequest dadosCredenciais) {
        return aplicaMotorRegrasCredenciais.aplicaRegras(dadosCredenciais);
    }
}
