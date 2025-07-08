public class Main {
    public static void main(String[] args) {
        AnimalShelterArray shelter = new AnimalShelterArray(10);

        shelter.enQueue("dog", "Dog #1");
        shelter.enQueue("cat", "Cat #1");
        shelter.enQueue("dog", "Dog #2");
        shelter.enQueue("cat", "Cat #2");

        System.out.println("Adopt any animal - " + shelter.deQueueAny()); 
        System.out.println("Adopt a dog - " + shelter.deQueueDog());
        System.out.println("Adopt a cat - " + shelter.deQueueCat());
    }
}
