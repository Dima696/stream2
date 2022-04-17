import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main ( String[] args ) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long minor = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println(minor);

        List<String> militaryService = persons.stream()
                .filter(a -> a.getAge() >= 18 && a.getAge() < 27)
                .map(a -> a.getFamily())
                .collect(Collectors.toList());
        System.out.println(militaryService.toString());

        List<Person> peopleHowCanWork = persons.stream()
                .filter(( p ) -> p.getAge() >= 18)
                .filter(( p ) -> (p.getSex() == Sex.WOMAN &&
                        p.getEducation() == Education.HIGHER &&
                        p.getAge() < 60) || (p.getSex() == Sex.MAN &&
                        p.getEducation() == Education.HIGHER && p.getAge() < 65))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(peopleHowCanWork);
    }
}
