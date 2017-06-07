package generics.examples;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvenNumberFilterAlgorithm {
	

	public static void main(String[] args) {
        Collection<Integer> ci = Arrays
                .asList(7, 8, 20, 21, 23 );
        int count = Aggregator
                .countIf(ci, new EvenPredicate());

        Collection<String> stringElements = Stream.of(
                "one",
                "two",
                "three"
        ).collect(Collectors.toList());

        Aggregator.countIf(
                stringElements,
                (s -> s.startsWith("o")));

        System.out.println("Our counted even numbers = " + count);

        Aggregator aggregator = new Aggregator();

        aggregator.increaseInternal(Arrays.asList(3,4,5,6));
        aggregator.increaseInternal(Arrays.asList(3,4,5,6));

        List<Double> numbers = Arrays.asList(3.3, 4.2, 5.4, 6.2);
        aggregator.increaseInternal(numbers);

    }

}

final class Aggregator {

    private Double startValue;

    public Double
    increaseInternal(Collection<? extends Number> numbers) {

        double sum = numbers.stream()
                .mapToDouble(Number::doubleValue)
                .sum();

        startValue = startValue + sum;

        return startValue;
    }

//    public <T extends Number> Double
//        increaseInternal(Collection<T> numbers) {
//
//        double sum = numbers.stream()
//                .mapToDouble(Number::doubleValue)
//                .sum();
//
//        startValue = startValue + sum;
//
//        return startValue;
//    }

    public static <T,G> G print(Collection<T> elements,
                              UnaryPredicate<G> predicate) {


        return null;
    }

    public static <T> int countIf(Collection<T> numbers,
                                  UnaryPredicate<T> predicate) {
        return (int) numbers.stream().filter(e -> predicate.test(e)).count();
    }
}

class EvenPredicate implements UnaryPredicate<Integer> {
    public boolean test(Integer i) {
        return i % 2 == 0;
    }
}

interface UnaryPredicate<T> {
    public boolean test(T obj);
}
