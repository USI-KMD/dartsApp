package generics.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lukasz on 5/24/17.
 */
public class GenericExample1 {

    public static void main(String[] args) {

        List<Animal> animalList = new ArrayList<>();

        List<Dog> dogList = new ArrayList<>();

        Animal animal1 = new Dog();

        animalList.add(new Dog());

        Pair<String, Integer> pair1 = new Pair<>();
        pair1.setLeft("left1");
        pair1.setRight(123);



//        dogList.add(new Animal());

//        animalList = dogList;

        Animal[] animalsArray = new Animal[3];
        Dog[] dogArray = new Dog[3];

        animalsArray = dogArray;

//        animalsArray[1] = new Animal();
    }

}

class SimpleCalculator<T extends Number> {

    private List<T> elements;

    public void addElement(T element) {
        elements.add(element);
    }

//    public T getSum() {
//
//
//    }
}


class Pair<T, G> {

    private T left;
    private G right;

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
