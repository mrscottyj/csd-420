import java.util.ArrayList;
import java.util.Random;

public class UniqueListTest {

    // generic method so it works with any type of ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // this new list will only hold one copy of each value
        ArrayList<E> uniqueList = new ArrayList<>();

        // go through every item in the original list one at a time
        for (int i = 0; i < list.size(); i++) {
            E current = list.get(i);

            // if the new list does not have this value yet, add it
            if (!uniqueList.contains(current)) {
                uniqueList.add(current);
            }
        }

        // send back the list with no duplicates
        return uniqueList;
    }

    public static void main(String[] args) {
        // create the original list and a random number generator
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // add 50 random numbers between 1 and 20
        // nextInt(20) gives 0 to 19 so I add 1 to get 1 to 20
        for (int i = 0; i < 50; i++) {
            numbers.add(random.nextInt(20) + 1);
        }

        // print the original list so we can see the duplicates
        System.out.println("Original list: " + numbers);

        // call the method to get a new list without duplicates
        ArrayList<Integer> uniqueNumbers = removeDuplicates(numbers);

        // print the new list to show the duplicates are gone
        System.out.println("No duplicates: " + uniqueNumbers);
    }
}