package de.jdufner.tutorial.mapreduce.model;

import java.time.LocalDate;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * I DO NOT USE Lombok, because I want to show how to implement equals() and hashCode().
 *
 * @author Jürgen Dufner
 * @since 1.0
 */
public class Person {

  private final String vorname; // part of natural key
  private final String nachname; // part of natural key
  private final LocalDate geburtsdatum; // part of natural key

  public Person(final String vorname, final String nachname, final LocalDate geburtsdatum) {
    this.vorname = vorname;
    this.nachname = nachname;
    this.geburtsdatum = geburtsdatum;
  }

  public String getVorname() {
    return vorname;
  }

  public String getNachname() {
    return nachname;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(vorname).append(nachname).append(geburtsdatum).build();
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }
    Person rhs = (Person) obj;
    return new EqualsBuilder()
        .append(vorname, rhs.vorname)
        .append(nachname, rhs.nachname)
        .append(geburtsdatum, rhs.geburtsdatum)
        .isEquals();
  }

  public static class ToNameTransformer implements Transformer<Person, String> {
    @Override
    public String transform(final Person person) {
      return person.vorname + " " + person.nachname;
    }
  }

  public static class NotNullPersonPredicate implements Predicate<Person> {
    @Override
    public boolean evaluate(final Person person) {
      return person != null;
    }
  }

}
