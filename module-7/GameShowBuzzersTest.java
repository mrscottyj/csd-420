import java.io.File;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

public class GameShowBuzzersTest {

    public static void main(String[] args) {
        HBox row = GameShowBuzzers.createBuzzers();

        // test 1: there should be four circles
        if (row.getChildren().size() == 4) {
            System.out.println("Test 1 passed: four circles");
        } else {
            System.out.println("Test 1 failed");
        }

        // test 2: the first circle should use the buzzer class
        Circle first = (Circle) row.getChildren().get(0);
        if (first.getStyleClass().contains("buzzer")) {
            System.out.println("Test 2 passed: first circle has buzzer class");
        } else {
            System.out.println("Test 2 failed");
        }

        // test 3: the second circle should have the id wrong
        Circle second = (Circle) row.getChildren().get(1);
        if ("wrong".equals(second.getId())) {
            System.out.println("Test 3 passed: second circle has id wrong");
        } else {
            System.out.println("Test 3 failed");
        }

        // test 4: the third circle should have the id correct
        Circle third = (Circle) row.getChildren().get(2);
        if ("correct".equals(third.getId())) {
            System.out.println("Test 4 passed: third circle has id correct");
        } else {
            System.out.println("Test 4 failed");
        }

        // test 5: the fourth circle should use the buzzer class
        Circle fourth = (Circle) row.getChildren().get(3);
        if (fourth.getStyleClass().contains("buzzer")) {
            System.out.println("Test 5 passed: fourth circle has buzzer class");
        } else {
            System.out.println("Test 5 failed");
        }

        // test 6: the css file should be in the folder
        if (new File("mystyle.css").exists()) {
            System.out.println("Test 6 passed: mystyle.css found");
        } else {
            System.out.println("Test 6 failed: mystyle.css missing");
        }
    }
}