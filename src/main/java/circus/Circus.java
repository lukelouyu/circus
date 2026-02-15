package circus;

import java.util.ArrayList;
import java.util.Arrays;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Elephant;
import circus.animal.Parrot;
import circus.animal.Tiger;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;


public class Circus {
    private static final Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static final Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
//        System.out.println("number of animals in the circus: " + animals.length);
//
//        printAllAnimals();

//        animals[3] = new Elephant("Strong one");

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        animalArrayList.add(new Elephant("strong one"));
//        printAllAnimals();
        printNumberOfAnimals(animalArrayList);

        animalArrayList.add(new Duck("Andy"));
        Tiger sherKhan = new Tiger("Sher Khan");
        animalArrayList.add(sherKhan);
        Parrot bobby = new Parrot("Bobby");
        animalArrayList.add(bobby);

        System.out.println("Position of Sher Khan in the arraylist is: " +
                animalArrayList.indexOf(sherKhan));

        System.out.println("Before sorting");
        printAllAnimals(animalArrayList);
//        Animal candidate = findAnimal(animalArrayList,"Polly");

        animalArrayList.sort(Animal.AnimalNameComparator);

        System.out.println("After sorting");
        printAllAnimals(animalArrayList);

//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    private static void printNumberOfAnimals(ArrayList<Animal> animalArrayList) {
        System.out.println("number of animals in the circus (AL): " + animalArrayList.size());
    }

    private static Animal findAnimal (ArrayList<Animal> animalArrayList, String name){
        for (Animal a: animalArrayList){
            if (a.name == name){
                return a;
            }
        }
        return null;
    }

    
}
