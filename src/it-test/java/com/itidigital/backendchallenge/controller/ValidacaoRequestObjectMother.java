package com.itidigital.backendchallenge.controller;

public class ValidacaoRequestObjectMother {

    public static ValidacaoRequest criarSenhaValida() {
        return new ValidacaoRequest("AbTp9!fok");
    }

    public static ValidacaoRequest criarSenhaComEspacoEmBranco() {
        return new ValidacaoRequest("AbTp9!fok ");
    }

    public static ValidacaoRequest criarSenhaComCaracterRepetido() {
        return new ValidacaoRequest("AbTp9!fokk");
    }

    public static ValidacaoRequest criarSenhaFaltandoCaracterMaiusculo() {
        return new ValidacaoRequest("abtp9!fok");
    }

    public static ValidacaoRequest criarSenhaFaltandoCaracterMinusculo() {
        return new ValidacaoRequest("ABTP9!FOK");
    }

    public static ValidacaoRequest criarSenhaMenosCaracteresQueOMinimo() {
        return new ValidacaoRequest("AbTp9!fo");
    }

    public static ValidacaoRequest criarSenhaFaltandoCaracterEspecial() {
        return new ValidacaoRequest("AbTp98fok");
    }

    public static ValidacaoRequest criarSenhaFaltandoDigito() {
        return new ValidacaoRequest("AbTpu!fok");
    }

    public static ValidacaoRequest criarSenhaVazia() {
        return new ValidacaoRequest();
    }
}
