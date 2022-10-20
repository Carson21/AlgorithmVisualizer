package self.carson.sortingalgos;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import self.carson.CanvasController;
import java.util.ArrayList;

public class CocktailShakerSort extends AbstractSort {

    private final CanvasController cControl;
    private final Button randomizeButton;
    private long startTime = 0;
    private final int animSpeed = 400;
    private int animFrame = 0;
    private final ArrayList<ArrayList<Integer>> animSortFrames = new ArrayList<>();

    public CocktailShakerSort(CanvasController cControl, Button randomizeButton) {
        this.cControl = cControl;
        this.randomizeButton = randomizeButton;
    }

    @Override
    public void sort(ArrayList<Integer> nodes) {
        cocktailSort(nodes);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int delta = (int) ((now - startTime) / 1000000);
                if (delta > animSpeed) {
                    try {
                        showCurFrame(animFrame);
                        animFrame++;
                        startTime = now;
                    } catch (IndexOutOfBoundsException e) {
                        randomizeButton.setDisable(false);
                        this.stop();
                    }
                }
            }
        };
        timer.start();
    }

    @Override
    protected void showCurFrame(int i) throws IndexOutOfBoundsException {
        cControl.renderNodes(animSortFrames.get(i));
    }

    private void cocktailSort(ArrayList<Integer> arr) {
        boolean swapsMade = true;
        int startInd;
        int endInd = arr.size() - 1;
        int lastInd = 0;

        while (swapsMade) {
            swapsMade = false;
            startInd = lastInd;
            for (int i = startInd; i < endInd; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, temp);
                    swapsMade = true;
                    lastInd = i;
                }
            }

            if (swapsMade) {
                swapsMade = false;
                endInd = lastInd;
                for (int i = endInd; i > startInd; i--) {
                    if (arr.get(i - 1) > arr.get(i)) {
                        int temp = arr.get(i);
                        arr.set(i, arr.get(i - 1));
                        arr.set(i - 1, temp);
                        swapsMade = true;
                        lastInd = i;
                    }
                }
            }

            animSortFrames.add(new ArrayList<>(arr));

        }
    }
}
