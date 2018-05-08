package de.jdufner.tutorial.mapreduce.model;

import static de.jdufner.tutorial.mapreduce.model.PersonTest.PersonBuilder.HANS_HAUSER;
import static de.jdufner.tutorial.mapreduce.model.PersonTest.PersonBuilder.MARTINA_MUELLER;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

import de.jdufner.tutorials.functional.StabilityTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(StabilityTest.class)
public class GroupTest {

  @Test
  public void testNamenAsText_whenGroupContainsNoPerson_expectEmptyString() {
    // arrange
    Group group = new Group(emptyList());

    // act
    String namenAsText = group.namenAsText();

    // assert
    assertEquals("", namenAsText);
  }

  @Test
  public void testNamenAsText_whenGroupContainsOnePerson_expectOneName() {
    // arrange
    List<Person> people = new ArrayList<>();
    people.add(HANS_HAUSER.build());
    Group group = new Group(people);

    // act
    String namenAsText = group.namenAsText();

    // assert
    assertEquals("Hans Hauser", namenAsText);
  }

  @Test
  public void testNamenAsText_whenGroupContainsManyPeople_expectNamenAsString() {
    // arrange
    List<Person> people = new ArrayList<>();
    people.add(HANS_HAUSER.build());
    people.add(MARTINA_MUELLER.build());
    Group group = new Group(people);

    // act
    String namenAsText = group.namenAsText();

    // assert
    assertEquals("Hans Hauser, Martina Müller", namenAsText);
  }

  @Test
  public void testNamenAsText_whenGroupContainsNull_expectNamenAsStringWithoutNull() {
    // arrange
    List<Person> people = new ArrayList<>();
    people.add(HANS_HAUSER.build());
    people.add(null);
    people.add(MARTINA_MUELLER.build());
    Group group = new Group(people);

    // act
    String namenAsText = group.namenAsText();

    // assert
    assertEquals("Hans Hauser, Martina Müller", namenAsText);
  }

  @Test
  public void testNamenAsTextStreamApi_whenGroupContainsNoPerson_expectEmptyString() {
    // arrange
    Group group = new Group(emptyList());

    // act
    String namenAsText = group.namenAsTextStreamApi();

    // assert
    assertEquals("", namenAsText);
  }

  @Test
  public void testNamenAsTextStreamApi_whenGroupContainsOnePerson_expectOneName() {
    // arrange
    List<Person> people = new ArrayList<>();
    people.add(HANS_HAUSER.build());
    Group group = new Group(people);

    // act
    String namenAsText = group.namenAsTextStreamApi();

    // assert
    assertEquals("Hans Hauser", namenAsText);
  }

  @Test
  public void testNamenAsTextStreamApi_whenGroupContainsManyPeople_expectNamenAsString() {
    // arrange
    List<Person> people = new ArrayList<>();
    people.add(HANS_HAUSER.build());
    people.add(MARTINA_MUELLER.build());
    Group group = new Group(people);

    // act
    String namenAsText = group.namenAsTextStreamApi();

    // assert
    assertEquals("Hans Hauser, Martina Müller", namenAsText);
  }

  @Test
  public void testNamenAsTextStreamApi_whenGroupContainsNull_expectNamenAsStringWithoutNull() {
    // arrange
    List<Person> people = new ArrayList<>();
    people.add(HANS_HAUSER.build());
    people.add(null);
    people.add(MARTINA_MUELLER.build());
    Group group = new Group(people);

    // act
    String namenAsText = group.namenAsTextStreamApi();

    // assert
    assertEquals("Hans Hauser, Martina Müller", namenAsText);
  }

  @Test
  public void testNamenAsTextStreamApiEigenerCollector_whenGroupContainsManyPeople_expectNamenAsString() {
    // arrange
    List<Person> people = new ArrayList<>();
    people.add(HANS_HAUSER.build());
    people.add(MARTINA_MUELLER.build());
    Group group = new Group(people);

    // act
    String namenAsText = group.namenAsTextStreamApiEigenerCollector();

    // assert
    assertEquals("Hans Hauser, Martina Müller", namenAsText);
  }

}