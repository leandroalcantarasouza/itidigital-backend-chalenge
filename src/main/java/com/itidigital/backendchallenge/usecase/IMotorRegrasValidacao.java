package com.itidigital.backendchallenge.usecase;

public interface IMotorRegrasValidacao<T> {

    ResultadoFinal validar(T credencialCandidata);
}
