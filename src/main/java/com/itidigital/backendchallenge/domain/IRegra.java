package com.itidigital.backendchallenge.domain;

public interface IRegra<T> {
    ResultadoAplicacaoRegra aplicar(T input);
}
