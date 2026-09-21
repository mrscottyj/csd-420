import java.io.*;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {

        Random rand = new Random();

        // arrays to hold the random numbers
        int[] numbers = new int[5];
        double[] decimals = new double[5];

        // fill the arrays with random values
        for (int i = 0; i < 5; i++) {
            numbers[i] = rand.nextInt(100) + 1;     // random int from 1 to 100
            decimals[i] = rand.nextDouble() * 100;  // random double from 0 to 100
        }

        try {
            // the true makes it append if the file already exists
            FileOutputStream fileOut = new FileOutputStream("Scott datafile.dat", true);
            DataOutputStream out = new DataOutputStream(fileOut);

            // write the five ints first
            for (int i = 0; i < 5; i++) {
                out.writeInt(numbers[i]);
            }

            // then write the five doubles
            for (int i = 0; i < 5; i++) {
                out.writeDouble(decimals[i]);
            }

            out.close();
            System.out.println("Data was written to Scott datafile.dat");

        } catch (IOException e) {
            System.out.println("Something went wrong writing the file.");
        }
    }
}