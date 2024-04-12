/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoomanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */


abstract class Animal{ //abstract class whose methods are overridden
    
    public String name;
    public int age;
    public double weight;
        
    public void makeSound(){
        System.out.println("is making a sound...");
    }
        
    public void sleep(){
        System.out.println("is sleeping...");
        
    }
        
    public void eat(){
        System.out.println("is eating....");
        
    }
  
}
    
interface Flyable{
    
    public void fly();
    
}
    
interface Swimmable{
    
    public void swim();
    
}
    
interface Climber{
    
    public void climb();    
    
}
    
class Mammal extends Animal{   
    
    public Mammal (String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
        
        
    }
    
    
    public void climb(){
        System.out.println("This animal is climbing!");
    }
    
}
    
class Primate extends Mammal {
       
    public Primate (String name, int age, double weight){
        super(name,age,weight);
    }
    
    @Override
    public void climb(){
        System.out.println("This primate is climbing!");
    }

}
    
class Ape extends Primate implements Climber{
    
    public Ape (String name, int age, double weight){
        super(name,age,weight);
    }
    
    @Override
    public void climb(){
        System.out.println("This Ape is climbing!");
    }
    
    @Override
    public void eat(){
            System.out.println("is eating fruits....");
        }
    
}
    
class Monkey extends Primate{
    
    public Monkey (String name, int age, double weight){
        super(name,age,weight);
    }
    
    @Override
    public void climb(){
        System.out.println("This Monkey is climbing!");
    }
    
    @Override
    public void eat(){
            System.out.println("is eating bananas....");
        }
    
}

class Bird extends Animal implements Flyable{
        
    public Bird (String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
       
    }
    
    @Override
    public void fly(){
        System.out.println("is flying...");
    }
    
    @Override
    public void eat(){
            System.out.println("is eating worms....");
        }
    
    @Override
    public void makeSound(){
        System.out.println("goes 'tweet tweet kkaawww...'");
    }
}
    
class Reptile extends Animal{
        
    public Reptile (String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
     
    }
    
    public void scaling(){
        System.out.println("is cleaning its scales...");
        
    }
    
    @Override
    public void eat(){
            System.out.println("is eating its prey....");
        }
    
    @Override
    public void makeSound(){
        System.out.println("goes 'sksksksksk...'");
    }
}
    
class Fish extends Animal implements Swimmable{
        
    public Fish (String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;

    }
    
    @Override
    public void sleep(){
        System.out.println("is not swimming, it must be sleeping...");
    }
    
    @Override
    public void eat(){
            System.out.println("is eating fish feeds....");
        }
    
    @Override
    public void makeSound(){
        System.out.println("goes 'blob blob blob...'");
    }
    
    @Override
    public void swim(){
        System.out.println("is swimming...");
        
    }
    
    
}

public class ZooManagementSystem {

    //ArrayLists based on habitats
    static ArrayList<String> animalList = new ArrayList<>();// all
    static ArrayList<String> savannahAnimals = new ArrayList<>(); //savannah 
    static ArrayList<String> jungleAnimals = new ArrayList<>(); //jungle
    static ArrayList<String> aquaAnimals= new ArrayList<>(); //aquarium tank
    static ArrayList<String> aviaryAnimals = new ArrayList<>(); //aviary
    
    //ArrayLists based on type
    static ArrayList<String> mammals = new ArrayList<>();  //mammals
    static ArrayList<String> birds = new ArrayList<>();  //birds
    static ArrayList<String> reptiles = new ArrayList<>();  //reptiles
    static ArrayList<String> fish = new ArrayList<>();  //fishes
    
    //main class
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String answer, answer1, simulateAgain;
        
        do{ //iterates when user still wants to do a transaction
            System.out.println("Welcome to the Zoo!\nWhat would you like to do?");
            System.out.println("[1]View all animals");
            System.out.println("[2]Add an animal");
            System.out.println("[3]View all animals in a habitat");
            System.out.println("[4]Simulate animal behavior");
            int choice = in.nextInt();

            switch (choice){

                case 1:
                    System.out.println("View all animals");
                    viewAllAnimals(); //displays all animals
                    
                    break;
                    
                case 2: 
                    System.out.println("Add an animal!");
                    
                        do{
                            addAnimal(in); //adds animal of user's choice
                            System.out.println("Add another animal?y/n");
                            answer1 = in.next();
                                
                        }while(answer1.equalsIgnoreCase("y"));
                        
                    break;
                        
                case 3: //Shows animals in specific habitats
                    System.out.println("Which habitat would you like to view?");
                    System.out.println("[1]Savannah\n[2]Aquarium Tank\n[3]Aviary\n[4]Jungle");
                    int choice2 = in.nextInt();
                    
                        switch (choice2) {
                            
                            case 1:
                                viewSavannahAnimals(); //shows all animals in Savannah habitat
                                break;

                            case 2:
                                viewAquaAnimals(); //shows all animals in Aquarium habitat
                                break;

                            case 3:
                                viewAviaryAnimals(); //shows all animals in Aviary habitat
                                break;

                            case 4:
                                viewJungleAnimals(); //shows all animals in Jungle habitat
                                break;
                                
                            default:
                                System.out.println("Invalid choice");
                                return;
                                
                        }
                        
                    break;

                case 4:
                    do{
                        simulateBehavior(); //Lets user choose an animal and shows what it can do
                        System.out.println("Simulate again? y/n");
                        simulateAgain = in.next();
                        
                    } while (simulateAgain.equalsIgnoreCase("y"));
                    
                    break;
                    
                default:
                    System.out.println("Invalid choice");
                    return; //terminates program
                    
            }
            
            //asks user if he would like to do another round of steps
            System.out.println("Try another transaction?y/n");
            answer = in.next(); 
            
        } while (answer.equalsIgnoreCase("y"));
        
        System.out.println("Thank you for coming!"); //this shows up as the program terminates
    
    }
    
    //recursive method called when user want to add an animal
    public static void addAnimal(Scanner in){
        
        System.out.println("Animal name:");
        String name = in.next();

        System.out.println("Enter age: ");
        int age = in.nextInt();

        System.out.println("Enter weight: ");
        double weight = in.nextDouble();
            
        System.out.println("Which type");
        System.out.println("[1]Mammal\n[2]Bird\n[3]Reptile\n[4]Fish");
        int type = in.nextInt();

        //combines all details into one string and adds it to the arrayList    
        String newAnimal = name.toLowerCase() + " " + age + " years old " + weight + " kilograms";
        animalList.add(newAnimal);
            
            switch(type){

                case 1:
                    mammals.add(newAnimal); //stores animal in the mammals list
                    break;
                
                case 2: 
                    birds.add(newAnimal); //stores animal in the birds list
                    break;
                    
                case 3:
                    reptiles.add(newAnimal); //stores animal in the reptiles list
                    break;
                    
                case 4:
                    fish.add(newAnimal); //stores animal in the fish list
                    break;
                   
                default:
                    System.out.println("Invalid choice"); //terminates prgram
                    return;
            }
            
        //lets user choose the appropriate habitat for the animal
        System.out.println("Habitat: \n[1]Savannah\n[2]Aquarium Tank\n[3]Aviary\n[4]Jungle");
        int choice = in.nextInt();
            
            switch (choice) {
                case 1:
                    savannahAnimals(newAnimal); //adds animal to the savannah
                    break;
                    
                case 2:
                    aquaAnimals(newAnimal); //adds animal to the aquarium
                    break;
                    
                case 3:
                    aviaryAnimals(newAnimal);//adds animal to the aviary
                    break;
                    
                case 4:
                    jungleAnimals(newAnimal);//adds animal to the jungle
                    break;
                    
                default:
                    System.out.println("invalid choice");
                    return; //terminates program
                    
            }
                
            System.out.println("Successfully added!"); 
            
    }
    
    public static void viewAllAnimals() { //shows all animals
        
        if (animalList.isEmpty()) {
            System.out.println("No animals to display.");
            
        } else {
            System.out.println("All animals in the Zoo:");
            int i = 0;
            
            for (String animal : animalList) {
                i++;
                System.out.println("[" + i + "}" + animal);
            }
            
        }
        
    }
    
    public static void savannahAnimals(String animal){
        
        savannahAnimals.add(animal); //shows all savannah animals
        
    }
    
    public static void viewSavannahAnimals(){
        
        if (savannahAnimals.isEmpty()){
            System.out.println("No animals to display");
            
        } else {
            System.out.println("Savannah Animals:");
            int i = 0;
            
            for (String animal: savannahAnimals){
                i++;
                System.out.println("[" + i + "}" + animal);
            }
            
        }
        
    }
    
    public static void aquaAnimals(String animal){
        
        aquaAnimals.add(animal); //shows all aquarium animals
        
    }
    
    public static void viewAquaAnimals(){
        
        if (aquaAnimals.isEmpty()){
            System.out.println("No animals to display");
            
        } else {
            System.out.println("Aquarium Animals:");
            int i = 0;
            
            for (String animal: aquaAnimals){
                i++;
                System.out.println("[" + i + "}" + animal);
            }
            
        }
        
    }
    
    public static void aviaryAnimals(String animal){
        aviaryAnimals.add(animal); //shows all aviary animals
        
    }
    
    public static void viewAviaryAnimals(){
        
        if (aviaryAnimals.isEmpty()){
            System.out.println("No animals to display");
            
        } else {
            System.out.println("Aviary Animals:");
            int i = 0;
            for (String animal: aviaryAnimals){
                i++;
                System.out.println("[" + i + "}" + animal);
            }
        }
        
    }
    
    public static void jungleAnimals(String animal){
        jungleAnimals.add(animal); //shows all jungle animals
        
    }
    
    public static void viewJungleAnimals(){
        
        if (jungleAnimals.isEmpty()){
            System.out.println("No animals to display");
            
        } else {
            System.out.println("Jungle Animals:");
            int i = 0;
            for (String animal: jungleAnimals){
                i++;
                System.out.println("[" + i + "}" + animal);
            }
        }
        
    }
    
    public static void simulateBehavior(){ //simulates animal behaviors upon user input
        
        Scanner in = new Scanner (System.in);
        
        System.out.println("Which one?"); //choose animal type
        System.out.println("[1]Mammal\n[2]Bird\n[3]Reptile\n[4]Fish");
        int choice = in.nextInt();
        
        int animalChoice;
        switch(choice){
            
            case 1 :
                System.out.println("Mammals");
                
                //shows all mammals
                if (mammals.isEmpty()){
                    System.out.println("No animals to display");
            
                } else { 
                    int i = 0;
                    
                        for (String animal: mammals){
                            i++;
                            System.out.println("[" + i + "}" + animal);

                        }    
                        
                    System.out.println("\nChoose a Mammal:");
                    animalChoice = in.nextInt();
                    
                            if (mammals.get(animalChoice-1).contains("ape")){ //apes can climb

                                Ape ape = new Ape("ape", 1, 1);
                                System.out.println(mammals.get(animalChoice-1)); //prints chosen animal
                                
                                ape.sleep();
                                ape.makeSound();
                                ape.eat();
                                ape.climb();

                            } else if (mammals.get(animalChoice-1).contains("monkey")){ //monkeys can climb
                                Monkey monkey = new Monkey("monkey", 1, 1);
                                System.out.println(mammals.get(animalChoice-1)); //prints chosen animal
                                monkey.sleep();
                                monkey.makeSound();
                                monkey.eat();
                                monkey.climb();

                            }else{ //other mammals do not have the climb attribute
                                Mammal mammal = new Mammal("mammal", 1, 1);
                                System.out.println(mammals.get(animalChoice-1)); //prints chosen animal
                                mammal.sleep();
                                mammal.makeSound();
                                mammal.eat();
                            } 
                            
                }
                break;
                
            case 2: 
                Bird bird = new Bird("bird", 1, 1);
                
                //shows all birds
                if (birds.isEmpty()){
                    System.out.println("No animals to display");
            
                } else {
                    
                    int i = 0;
                        for (String animal: birds){
                            i++;
                            System.out.println("[" + i + "}" + animal);

                        }    
                        
                System.out.println("Choose a Bird");
                animalChoice = in.nextInt();
                System.out.println(birds.get(animalChoice-1)); //prints chosen bird
                bird.sleep();
                bird.makeSound();
                bird.fly();
                bird.eat();
            }
            break;
            
            case 3: 
                Reptile reptile = new Reptile("reptile", 1, 1);
                
                //shows all reptiles
                if (reptiles.isEmpty()){
                    System.out.println("No animals to display");
            
                } else {
                    
                    int i = 0;
                        for (String animal: reptiles){
                            i++;
                            System.out.println("[" + i + "}" + animal);

                        }    
                        
                System.out.println("Choose a Reptile");
                animalChoice = in.nextInt(); 
                System.out.println(reptiles.get(animalChoice-1)); //prints chosen reptile
                reptile.sleep();
                reptile.makeSound();
                reptile.eat();
                reptile.scaling();
            }
            break;
            
            case 4: 
                Fish fishes = new Fish("fish", 1, 1);
                
                //shows all fish
                if (fish.isEmpty()){
                    System.out.println("No animals to display");
            
                } else {
                    
                    int i = 0;
                        for (String animal: fish){
                            i++;
                            System.out.println("[" + i + "}" + animal);

                        }    
                        
                System.out.println("Choose a Fish");
                animalChoice = in.nextInt();
                System.out.println(fish.get(animalChoice-1)); //prints chosen fish
                fishes.sleep();
                fishes.makeSound();
                fishes.eat();
                fishes.swim();
            }
            break;
            
            default:
                System.out.println("Invalid choice");
                return; //terminates program
   
        }
    }
}
