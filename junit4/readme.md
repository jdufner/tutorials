# Junit4 Beispiele

## Parametrisierte Tests

Die Klasse `FooTest` ist parametrisiert, d. h. die Daten werden von außen an den Test übergeben.
Dazu werden werden folgende Implementierungsschritte benötigt:

1. Die Klasse muss mit `@RunWith(Parameterized.class)` annotiert werden.
2. Die Klasse benötigt eine statische Methode, die mit `@Parameterized.Parameters` annotierte ist
und die Daten als `Collection<Object[]>` liefert.
3. Die Daten werden an den Konstruktor der Klasse übergeben, hier `public FooTest(final int input)`.

## Parallele Tests

Die Klasse `FooSuite` führt die Tests einer Suite parallel aus. Dabei können die Tests jeweils einer
Klasse oder jeweils einer Suite parallel ausgeführt werden.
