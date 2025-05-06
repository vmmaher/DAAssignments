import java.util.Scanner;

public class Assignment1 {
    // add suppress to ignore yellow warning ↓
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // check with user how many days they want to enter the temp
        System.out.print("Enter the number of days ");
        int numberDays = scanner.nextInt();
        // create the array
        double[] temps = new double[numberDays];

        // create the array and add the temperatures ferom user
        for (int i = 0; i < numberDays; i++) {
            System.out.print("Enter the temperature for day #" + (i + 1) + " ");
            temps[i] = scanner.nextDouble();
        }

        // get the avg temp
        double total = 0;
        for (int i = 0; i < numberDays; i++) {
            total += temps[i];
        }
        double average = total / numberDays;

        System.out.println("The average temperature is " + average);

        // check the temps that are more than avg
        int numberOfDaysAboveAvg = 0;
        for (int i = 0; i < numberDays; i++) {
            if (temps[i] > average) {
                numberOfDaysAboveAvg++;
            }
        }

        // show user the results
        System.out.println("The number of days more than the average is " + numberOfDaysAboveAvg);
    }
}
