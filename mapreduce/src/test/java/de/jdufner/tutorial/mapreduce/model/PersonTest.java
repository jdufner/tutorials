package de.jdufner.tutorial.mapreduce.model;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

public class PersonTest {

  @Test
  public void whenEquals_expectNotSameButHashCodeEquals() {
    // arrange
    Person p1 = PersonBuilder.HANS_HAUSER.build();
    Person p2 = PersonBuilder.HANS_HAUSER.build();

    // act

    // assert
    assertEquals(p1, p2);
    assertNotSame(p1, p2);
    assertEquals(p1.hashCode(), p2.hashCode());
  }

  @Test
  public void whenNotEquals_expectNotSameAndNoEqualsHashCodes() {
    // arrange
    Person p1 = PersonBuilder.HANS_HAUSER.build();
    Person p2 = PersonBuilder.HANS_HAUSER.but().withNachname("Hofmann").build();

    // act

    // assert
    assertNotEquals(p1, p2);
    assertNotSame(p1, p2);
    assertNotEquals(p1.hashCode(), p2.hashCode());
  }

  public static class PersonBuilder {

    public static PersonBuilder HANS_HAUSER = new PersonBuilder().withVorname("Hans")
        .withNachname("Hauser")
        .withGeburtsdatum(1987, 11, 15);
    public static PersonBuilder MARTINA_MUELLER = new PersonBuilder().withVorname("Martina")
        .withNachname("Müller")
        .withGeburtsdatum(1992, 4, 25);

    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;

    public PersonBuilder withVorname(final String vorname) {
      this.vorname = vorname;
      return this;
    }

    public PersonBuilder withNachname(final String nachname) {
      this.nachname = nachname;
      return this;
    }

    public PersonBuilder withGeburtsdatum(final int year, final int month, final int dayOfMonth) {
      this.geburtsdatum = LocalDate.of(year, month, dayOfMonth);
      return this;
    }

    private PersonBuilder withGeburtsdatum(final LocalDate geburtsdatum) {
      this.geburtsdatum = geburtsdatum;
      return this;
    }

    public Person build() {
      return new Person(vorname, nachname, geburtsdatum);
    }

    public PersonBuilder but() {
      return new PersonBuilder().withVorname(vorname)
          .withNachname(nachname)
          .withGeburtsdatum(geburtsdatum);
    }
  }

}