package self.carson.sortingalgos;

import javafx.scene.control.Button;

import java.util.ArrayList;

public abstract class AbstractSort {
    public abstract void sort(ArrayList<Integer> nodes);

    protected abstract void showCurFrame(int i) throws IndexOutOfBoundsException;
}
