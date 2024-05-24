package br.com.erudio.service;

import br.com.erudio.model.Person;

public interface IPersonService {
    public Person createPerson(Person person) throws IllegalArgumentException;
}
