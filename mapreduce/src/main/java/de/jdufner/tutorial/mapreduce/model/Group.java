package de.jdufner.tutorial.mapreduce.model;

import de.jdufner.tutorial.mapreduce.model.Person.NotNullPersonPredicate;
import de.jdufner.tutorial.mapreduce.model.Person.ToNameTransformer;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.apache.commons.collections4.CollectionUtils.collect;
import static org.apache.commons.collections4.CollectionUtils.select;
import static org.apache.commons.lang3.StringUtils.join;

public class Group {

  private List<Person> people;

  public Group(final List<Person> people) {
    this.people = people;
  }

  /**
   * Implementation using Apache Commons API.
   *
   * @return Namen der Personen in kommaseparierter Liste.
   */
  public String namenAsText() {
    return join(collect(select(people, new NotNullPersonPredicate()), new ToNameTransformer()),
        ", ");
  }

  /**
   * Implementation using Java 8 Stream API.
   *
   * @return Namen der Personen in kommaseparierter Liste.
   */
  public String namenAsTextStreamApi() {
    return people.stream()
        .filter(person -> person != null)
        .map(person -> person.getVorname() + " " + person.getNachname())
        .collect(joining(", "));
  }


}
