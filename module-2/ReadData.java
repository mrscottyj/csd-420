import java.io.*;

public class ReadData {
    public static void main(String[] args) {

        try {
            FileInputStream fileIn = new FileInputStream("Scott datafile.dat");
            DataInputStream in = new DataInputStream(fileIn);

            int setNumber = 1;

            // keep reading until there is no data left in the file
            while (in.available() > 0) {
                System.out.println("Set " + setNumber);

                // read the five ints, in the same order they were written
                System.out.print("Integers: ");
                for (int i = 0; i < 5; i++) {
                    System.out.print(in.readInt() + " ");
                }
                System.out.println();

                // read the five doubles
                System.out.print("Doubles: ");
                for (int i = 0; i < 5; i++) {
                    System.out.printf("%.2f ", in.readDouble());
                }
                System.out.println();
                System.out.println();

                setNumber++;
            }

            in.close();

        } catch (FileNotFoundException e) {
            System.out.println("The file was not found. Run WriteData first.");
        } catch (IOException e) {
            System.out.println("Something went wrong reading the file.");
        }
    }
}