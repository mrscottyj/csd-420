import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GameShowBuzzers extends Application {

    // builds a row of four buzzer circles and returns it
    public static HBox createBuzzers() {
        Circle buzzer1 = new Circle(40);
        Circle buzzer2 = new Circle(40);
        Circle buzzer3 = new Circle(40);
        Circle buzzer4 = new Circle(40);

        // buzzers 1 and 4 use the class (white fill, black stroke)
        buzzer1.getStyleClass().add("buzzer");
        buzzer4.getStyleClass().add("buzzer");

        // buzzer 2 uses the id for red
        buzzer2.setId("wrong");

        // buzzer 3 uses the id for green
        buzzer3.setId("correct");

        // put the circles side by side
        HBox row = new HBox(20, buzzer1, buzzer2, buzzer3, buzzer4);
        row.setPadding(new Insets(20));
        row.setAlignment(Pos.CENTER);
        return row;
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createBuzzers());

        // load the style sheet
        scene.getStylesheets().add("mystyle.css");

        stage.setTitle("Game Show Buzzers");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}