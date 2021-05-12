package bai7_AbstractClassInterface.thuc_hanh.LopAnimalVaInterfaceEdible.Animal;


import bai7_AbstractClassInterface.thuc_hanh.LopAnimalVaInterfaceEdible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}