package fr.kevinya.todolist.service;


import java.util.List;

import fr.kevinya.todolist.model.Person;

public interface PersonService {
    
    public void addPerson(Person person);
    public List<Person> listPeople();
    public void removePerson(Integer id);
}
