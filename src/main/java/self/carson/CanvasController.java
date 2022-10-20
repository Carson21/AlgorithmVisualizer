package self.carson;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class CanvasController {

    public static final int NO_OF_NODES = 40;
    public static final int MAX_VAL_NODE = Controller.C_HEIGHT / 10;
    public static final int SPACING_OF_NODES = 2;
    public static final int WIDTH_OF_NODE = (Controller.C_WIDTH - (NO_OF_NODES * 2)) / NO_OF_NODES;


    private final ArrayList<Integer> nodes = new ArrayList<>();
    private final GraphicsContext ctx;

    public CanvasController(GraphicsContext ctx) {
        this.ctx = ctx;
        shuffleNodes();
        renderNodes();
    }

    public ArrayList<Integer> getNodes() {
        return nodes;
    }

    public void shuffleNodes() {
        nodes.clear();
        Random rand = new Random();

        for (int i = 0; i < NO_OF_NODES; i++) {
            nodes.add(rand.nextInt(MAX_VAL_NODE - 1) + 1);
        }
    }

    public void renderNodes() {
        ctx.clearRect(0, 0, Controller.C_WIDTH, Controller.C_HEIGHT);
        ctx.setFill(Color.DARKGRAY);
        ctx.fillRect(0, 0, Controller.C_WIDTH, Controller.C_HEIGHT);

        for (int i = 0; i < NO_OF_NODES; i++) {
            ctx.setFill(Color.RED);
            ctx.fillRect((i * (WIDTH_OF_NODE + SPACING_OF_NODES)) + 1, 720 - nodes.get(i) * 10, WIDTH_OF_NODE, nodes.get(i) * 10);
        }
    }

    public void renderNodes(ArrayList<Integer> arr) {
        ctx.clearRect(0, 0, Controller.C_WIDTH, Controller.C_HEIGHT);
        ctx.setFill(Color.DARKGRAY);
        ctx.fillRect(0, 0, Controller.C_WIDTH, Controller.C_HEIGHT);

        for (int i = 0; i < NO_OF_NODES; i++) {
            ctx.setFill(Color.RED);
            ctx.fillRect((i * (WIDTH_OF_NODE + SPACING_OF_NODES)) + 1, 720 - arr.get(i) * 10, WIDTH_OF_NODE, arr.get(i) * 10);
        }
    }


}
