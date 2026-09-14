import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import java.util.Random;

public class CardApp extends Application {

    // array to hold the 4 image spots on screen
    private ImageView[] cardViews = new ImageView[4];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // create the 4 image views and set a starting size for them
        HBox cardRow = new HBox(10);
        for (int i = 0; i < 4; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(100);
            cardViews[i].setFitHeight(140);
            cardRow.getChildren().add(cardViews[i]);
        }

        // load the first set of random cards when the app opens
        loadRandomCards();

        // create the refresh button
        Button refreshButton = new Button("Refresh");

        // lambda expression - runs loadRandomCards() every time the button is clicked
        refreshButton.setOnAction(e -> loadRandomCards());

        // stack the card row and button vertically
        VBox root = new VBox(15);
        root.getChildren().addAll(cardRow, refreshButton);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // set up the window
        Scene scene = new Scene(root, 500, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Random Cards");
        primaryStage.show();
    }

    // picks 4 different random numbers between 1 and 52
    // and updates the 4 image views with those card images
    private void loadRandomCards() {
        Random rand = new Random();
        int[] usedNumbers = new int[4];
        int count = 0;

        while (count < 4) {
            int cardNumber = rand.nextInt(52) + 1;

            // check if this number was already picked
            boolean alreadyUsed = false;
            for (int i = 0; i < count; i++) {
                if (usedNumbers[i] == cardNumber) {
                    alreadyUsed = true;
                }
            }

            // only use it if it is a new number
            if (!alreadyUsed) {
                usedNumbers[count] = cardNumber;
                Image cardImage = new Image("file:cards/" + cardNumber + ".png");
                cardViews[count].setImage(cardImage);
                count++;
            }
        }
    }
}