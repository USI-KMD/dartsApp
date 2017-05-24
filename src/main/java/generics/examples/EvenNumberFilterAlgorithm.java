package generics.examples;

import java.util.Arrays;
import java.util.Collection;

public class EvenNumberFilterAlgorithm {
	
	
	
	public static void main(String[] args) {
        Collection<Integer> ci = Arrays.asList(7, 8, 20, 21, 23 );
        int count = CountingEvenNumbersAlgorithm.countIf(ci, new EvenPredicate());
        System.out.println("Our counted even numbers = " + count);
    }

}

final class CountingEvenNumbersAlgorithm {
	
	
//	TODO: Fix that declaration - make it generic
    public static int countIf(Collection xx, UnaryPredicate xxyy) {

        int count = 0;
//        TODO: fix this for each - implement a logic
//        for (elem : xx)
//            if (something)
//			  then something
        	return count;
    }
}


class EvenPredicate implements UnaryPredicate<Integer> {
    public boolean test(Integer i) { return i % 2 == 0; }
}

interface UnaryPredicate<T> {
    public boolean test(T obj);
}