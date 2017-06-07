package generics.examples;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by lukasz on 5/24/17.
 */
public class GenericExample1 {

    public static void main(String[] args) {

//        List<Animal> animalList = new ArrayList<>();
//
//        List<Dog> dogList = new ArrayList<>();
//
//        Animal animal1 = new Dog();
//
//        animalList.add(new Dog());
//
//        Pair<String, Integer> pair1 = new Pair<>();
//        pair1.setLeft("left1");
//        pair1.setRight(123);



//        dogList.add(new Animal());

//        animalList = dogList;

        Animal[] animalsArray = new Animal[3];
        Dog[] dogArray = new Dog[3];

        animalsArray = dogArray;

//        animalsArray[1] = new Animal();

        Pair<String, Integer> wordCount = new Pair<>();
        wordCount.setLeft("one");
        wordCount.setRight(1);

        Pair<String, Integer> wordCountCopy = new Pair<>();
        wordCountCopy.setLeft("one");
        wordCountCopy.setRight(1);

        List<Pair<String, Integer>> pairs = new ArrayList<>();
        pairs.add(wordCount);

        List<Pair<String, Integer>> pairs2 = new ArrayList<>();
        pairs2.add(new Pair<>("one", 1));
        pairs2.add(new Pair<>("ssss", 3));
        pairs2.add(new Pair<>("dddd", 4));
        pairs2.add(new Pair<>("rrr", 5));

//        pairs.removeAll(new HashSet<>(pairs2));

        boolean contains = new HashSet<>(pairs2)
                .contains(wordCount);

        System.out.println(contains);

    }

}

class SimpleCalculator<T extends Number> {

    private List<T> elements;

    public void addElement(T element) {
        elements.add(element);
    }

//    public T getSum() {
//
//        return elements.get(0).doubleValue();
//    }
}


class Pair<T, G> {

    private T left;
    private G right;

    public Pair() {
    }

    public Pair(T left, G right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public void setLeft(T left) {
        this.left = left;
    }

    public G getRight() {
        return right;
    }

    public void setRight(G right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        return new EqualsBuilder()
                .append(left, pair.left)
                .append(right, pair.right)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(left)
                .append(right)
                .toHashCode();
    }
}


class Animal {

    public void doSound() {
        System.out.println("animal sound");
    }

}

class Dog extends Animal {
    @Override
    public void doSound() {
        System.out.println("bark");
    }
}
