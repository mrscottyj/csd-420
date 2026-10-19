// CSD-420
// Scott Johnson
// JohnsonModule6.2.java
 
import java.util.Arrays;
import java.util.Comparator;
 
class JohnsonModule6_2 {
 
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int pass = 0; pass < list.length - 1; pass++) {
            for (int i = 0; i < list.length - 1 - pass; i++) {
                // If the item on the left is bigger, swap the two items
                if (list[i].compareTo(list[i + 1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
    }
 
    public static <E> void bubbleSort(E[] list, Comparator<E> comparator) {
        for (int pass = 0; pass < list.length - 1; pass++) {
            for (int i = 0; i < list.length - 1 - pass; i++) {
                if (comparator.compare(list[i], list[i + 1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
    }
 
    public static void main(String[] args) {
 
        // Test 1: Integers
        Integer[] numbers = {5, 2, 9, 1, 7};
        Integer[] expectedNumbers = {1, 2, 5, 7, 9};
        System.out.println("Numbers before: " + Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println("Numbers after:  " + Arrays.toString(numbers));
        System.out.println(Arrays.equals(numbers, expectedNumbers) ? "PASS" : "FAIL");
 
        // Test 2: Strings
        String[] words = {"pear", "apple", "mango", "banana"};
        String[] expectedWords = {"apple", "banana", "mango", "pear"};
        System.out.println("\nWords before: " + Arrays.toString(words));
        bubbleSort(words);
        System.out.println("Words after:  " + Arrays.toString(words));
        System.out.println(Arrays.equals(words, expectedWords) ? "PASS" : "FAIL");
 
        // Test 3: Oscar winning movies
        Movie m1 = new Movie("Titanic", 1997);
        Movie m2 = new Movie("The Godfather", 1972);
        Movie m3 = new Movie("Parasite", 2019);
        Movie m4 = new Movie("Rocky", 1976);
 
        Movie[] movies = {m1, m2, m3, m4};
        Movie[] expectedByYear = {m2, m4, m1, m3};
        System.out.println("\nMovies before: " + Arrays.toString(movies));
        bubbleSort(movies);
        System.out.println("Movies by year: " + Arrays.toString(movies));
        System.out.println(Arrays.equals(movies, expectedByYear) ? "PASS" : "FAIL");
 
        // Test 4: Movies
        Movie[] moviesByTitle = {m1, m2, m3, m4};
        Movie[] expectedByTitle = {m3, m4, m2, m1};
        System.out.println("\nMovies before: " + Arrays.toString(moviesByTitle));
        bubbleSort(moviesByTitle, (a, b) -> a.getTitle().compareTo(b.getTitle()));
        System.out.println("Movies by title: " + Arrays.toString(moviesByTitle));
        System.out.println(Arrays.equals(moviesByTitle, expectedByTitle) ? "PASS" : "FAIL");
    }
}
 
// Movie class for Best Picture winners
class Movie implements Comparable<Movie> {
    private String title;
    private int year;
 
    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }
 
    public String getTitle() {
        return title;
    }
 
    // Default order for movies is oldest release year first
    public int compareTo(Movie other) {
        return Integer.compare(this.year, other.year);
    }
 
    public String toString() {
        return title + " (" + year + ")";
    }
}
 