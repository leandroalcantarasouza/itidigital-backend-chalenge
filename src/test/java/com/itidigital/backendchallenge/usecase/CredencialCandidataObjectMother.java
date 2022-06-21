package com.itidigital.backendchallenge.usecase;

import com.itidigital.backendchallenge.domain.CredencialCandidata;

public class CredencialCandidataObjectMother {

    public static CredencialCandidata criarSenhaVazia() {
        return new CredencialCandidata();
    }

    public static CredencialCandidata criarSenhaaa() {
        return new CredencialCandidata("aa");
    }

    public static CredencialCandidata criarSenhaab() {
        return new CredencialCandidata("ab");
    }

    public static CredencialCandidata criarSenhaMaisculasRepetidasEMinusculasRepetidas() {
        return new CredencialCandidata("ab");
    }

    public static CredencialCandidata criarSenhaMinusculaRepetida() {
        return new CredencialCandidata("AbTp9!foo");
    }

    public static CredencialCandidata criarSenhaMaiusculaRepetida() {
        return new CredencialCandidata("AbTp9!foA");
    }

    public static CredencialCandidata criarSenhaComEspacoNoMeio() {
        return new CredencialCandidata("AbTp9! fok");
    }

    public static CredencialCandidata criarSenhaComEspacoNoFim() {
        return new CredencialCandidata("AbTp9!fok ");
    }

    public static CredencialCandidata criarSenhaComEspacoNoInicio() {
        return new CredencialCandidata(" AbTp9!fok");
    }

    public static CredencialCandidata criarSenhaCaracterRepetido() {
        return new CredencialCandidata("AbTp9!fokk");
    }

    public static CredencialCandidata criarSenhaSemCaracterMaiusculo() {
        return new CredencialCandidata("abtp9!fok");
    }

    public static CredencialCandidata criarSenhaSemCaracterMinusculo() {
        return new CredencialCandidata("ABTP9!FOK");
    }

    public static CredencialCandidata criarSenhaComMenosCaracteresQueOMinimo() {
        return new CredencialCandidata("AbTp9!fo");
    }

    public static CredencialCandidata criarSenhaSemCaracterEspecial() {
        return new CredencialCandidata("AbTp98fok");
    }

    public static CredencialCandidata criarSenhaSemDigito() {
        return new CredencialCandidata("AbTpu!fok");
    }

    public static CredencialCandidata criarSenhaSemDigitoESemCaractereEspecial() {
        return new CredencialCandidata("AbTpuifok");
    }

    public static CredencialCandidata criarSenhaValida() {
        return new CredencialCandidata("AbTp9!fok");
    }

    public static CredencialCandidata criarSenhaConteudoNula() {
        return new CredencialCandidata(null);
    }

}
