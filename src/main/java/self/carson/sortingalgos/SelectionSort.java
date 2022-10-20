package self.carson.sortingalgos;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import self.carson.CanvasController;
import java.util.ArrayList;

public class SelectionSort extends AbstractSort {

    private final CanvasController cControl;
    private final Button randomizeButton;
    private long startTime = 0;
    private final int animSpeed = 250;
    private int animFrame = 0;
    private final ArrayList<ArrayList<Integer>> animSortFrames = new ArrayList<>();

    public SelectionSort(CanvasController cControl, Button randomizeButton) {
        this.cControl = cControl;
        this.randomizeButton = randomizeButton;
    }

    @Override
    public void sort(ArrayList<Integer> nodes) {
        selectionSort(nodes);

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


    private void selectionSort(ArrayList<Integer> arr) {
        for (int i = arr.size() - 1; i > 0; i--) {
            int j = 0;
            for (int k = 1; k <= i; k++) {
                if (arr.get(k) > arr.get(j)) {
                    j = k;
                }
            }
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);

            animSortFrames.add(new ArrayList<>(arr));
        }
    }
}




