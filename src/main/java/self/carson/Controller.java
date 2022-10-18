package self.carson;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import self.carson.sortingalgos.*;

import java.util.ArrayList;
import java.util.List;

public class Controller extends BorderPane {

    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;
    public static final int C_WIDTH = 1000;
    public static final int C_HEIGHT = 720;

    private final Canvas canvas;
    private final VBox buttons;
    private final Button sortButton;
    private final Button randomizeButton;
    private final ChoiceBox<AbstractSort> cBox;

    private final GraphicsContext ctx;
    private final CanvasController cControl;

    public Controller() {
        this.canvas = new Canvas(C_WIDTH, C_HEIGHT);
        this.ctx = this.canvas.getGraphicsContext2D();
        this.buttons = new VBox();

        buttons.setPrefWidth(280);
        buttons.setPadding(new Insets(20, 20, 20, 20));
        buttons.setSpacing(20);
        buttons.setAlignment(Pos.TOP_CENTER);

        setCenter(this.canvas);
        setLeft(this.buttons);

        ctx.setFill(Color.LIGHTBLUE);
        ctx.fillRect(0, 0, 1000, 720);

        this.sortButton = new Button("Sort");
        this.randomizeButton = new Button("Randomize");
        this.cBox = new ChoiceBox<>();

        List<AbstractSort> sortList = new ArrayList<>();
        sortList.add(new SelectionSort());
        sortList.add(new BubbleSort());
        sortList.add(new CocktailShakerSort());
        sortList.add(new MergeSort());
        sortList.add(new QuickSort());

        cBox.setItems(FXCollections.observableArrayList(sortList));

        buttons.getChildren().add(sortButton);
        buttons.getChildren().add(randomizeButton);
        buttons.getChildren().add(cBox);

        cBox.getSelectionModel().select(0);

        this.cControl = new CanvasController(ctx);

        randomizeButton.setOnAction(event -> {
            cControl.shuffleNodes();
            cControl.renderNodes();
        });

        cBox.setConverter(new StringConverter<>() {
            public String toString(AbstractSort abstractSort) {
                if (abstractSort == null) {
                    return "";
                } else {
                    return abstractSort.getClass().getSimpleName();
                }
            }

            public AbstractSort fromString(String s) {
                return null;
            }
        });
    }
}