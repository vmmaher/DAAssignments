public class AnimalShelterArray {
    private String[] dogQueue;
    private String[] catQueue;
    private int[] dogOrder;
    private int[] catOrder;

    private int dogFront, dogBack, dogCount;
    private int catFront, catBack, catCount;
    private int orderCounter;

    public AnimalShelterArray(int size) {
        dogQueue = new String[size];
        catQueue = new String[size];
        dogOrder = new int[size];
        catOrder = new int[size];
        dogFront = catFront = 0;
        dogBack = catBack = -1;
        dogCount = catCount = 0;
        orderCounter = 0;

        System.out.println("Created an animal shelter with " + size + " size");
    }

    public boolean isDogFull() {
        return dogBack == dogQueue.length - 1;
    }

    public boolean isCatFull() {
        return catBack == catQueue.length - 1;
    }

    public boolean isDogEmpty() {
        return dogCount == 0;
    }

    public boolean isCatEmpty() {
        return catCount == 0;
    }

    public void enQueue(String type, String name) {
        if (type.equalsIgnoreCase("dog")) {
            if (isDogFull()) {
                System.out.println("The dog queue is full");
                return;
            }
            dogBack++;
            dogQueue[dogBack] = name;
            dogOrder[dogBack] = orderCounter++;
            dogCount++;
        } else if (type.equalsIgnoreCase("cat")) {
            if (isCatFull()) {
                System.out.println("The cat que is full");
                return;
            }
            catBack++;
            catQueue[catBack] = name;
            catOrder[catBack] = orderCounter++;
            catCount++;
        } else {
            System.out.println("Only dogs and cats are allowed");
        }
    }

    public String deQueueAny() {
        if (isDogEmpty() && isCatEmpty()) {
            return "The shelter is empty";
        } else if (isDogEmpty()) {
            return deQueueCat();
        } else if (isCatEmpty()) {
            return deQueueDog();
        }

        if (dogOrder[dogFront] < catOrder[catFront]) {
            return deQueueDog();
        } else {
            return deQueueCat();
        }
    }

    public String deQueueDog() {
        if (isDogEmpty()) {
            return "No dogs are available";
        }
        String result = dogQueue[dogFront];
        dogFront++;
        dogCount--;
        return result;
    }

    public String deQueueCat() {
        if (isCatEmpty()) {
            return "No cats available";
        }
        String result = catQueue[catFront];
        catFront++;
        catCount--;
        return result;
    }

    public void deleteShelter() {
        dogQueue = null;
        catQueue = null;
        dogOrder = null;
        catOrder = null;
        System.out.println("shelter was deleted");
    }
}
