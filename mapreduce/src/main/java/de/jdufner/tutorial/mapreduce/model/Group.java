package de.jdufner.tutorial.mapreduce.model;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;
import static org.apache.commons.collections4.CollectionUtils.collect;
import static org.apache.commons.collections4.CollectionUtils.select;
import static org.apache.commons.lang3.StringUtils.join;

import de.jdufner.tutorial.mapreduce.model.Person.NotNullPersonPredicate;
import de.jdufner.tutorial.mapreduce.model.Person.ToNameTransformer;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Group {

  private static final Logger LOG = LoggerFactory.getLogger(Group.class);

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

  public String namenAsTextStreamApiEigenerCollector() {
    Stream<Person> filteredPeople = people.stream().filter(person -> person != null);
    Stream<String> namen =
        filteredPeople.map(person -> person.getVorname() + " " + person.getNachname());
    String collectedNamen = namen.collect(Collector.of(
        // Supplier (liefert den Initialwert)
        new Supplier<StringBuilder>() {
          int i = 0;

          @Override
          public StringBuilder get() {
            LOG.info(format("(supplier) i=%d", i++));
            return new StringBuilder();
          }
        },
        // Accumulator (führt das eigentliche "Reduce" aus)
        new BiConsumer<StringBuilder, String>() {
          int j = 0;

          @Override
          public void accept(final StringBuilder s1, final String s2) {
            LOG.info(format("(accumulator) j=%d, s1=%s, s2=%s", j++, s1, s2));
            if (j > 1) {
              s1.append(", ");
            }
            s1.append(s2);
          }
        },
        // Combiner (wird nur bei paraller Verarbeitung genutzt)
        new BinaryOperator<StringBuilder>() {
          int k = 0;

          @Override
          public StringBuilder apply(final StringBuilder s1, final StringBuilder s2) {
            LOG.info(format("(combiner) k=%d, s1=%s, s2=%s", k++, s1, s2));
            return s1.append(s2);
          }
        },
        // Finisher
        new Function<StringBuilder, String>() {
          int l = 0;

          @Override
          public String apply(final StringBuilder s) {
            LOG.info(format("(finisher) l=%d, s=%s", l++, s));
            return s.toString();
          }
        }));
    return collectedNamen;
  }

}
