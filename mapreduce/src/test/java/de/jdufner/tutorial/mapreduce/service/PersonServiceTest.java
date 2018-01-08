package de.jdufner.tutorial.mapreduce.service;

import de.jdufner.tutorial.mapreduce.model.Person;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.time.LocalDate;

public class PersonServiceTest {

  @InjectMocks
  private PersonService personService;

  @Test
  public void whenPersonAelterAls18_expectIstErwachsen() {
    // arrange
    Person p = new Person("Hans", "Hauser", LocalDate.of(1987, 11, 5));

    // act


    // assert

  }

  @Test
  public void whenPersonJuengerAls18_expectIstNichtErwachsen() {
    // arrange
    Person p2 = new Person("Max", "Hüller", LocalDate.of(1995, 9, 14));

    // act


    // assert

  }

}