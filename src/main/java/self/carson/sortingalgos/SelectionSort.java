package self.carson.sortingalgos;


import self.carson.CanvasController;
import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort extends AbstractSort {

    private final CanvasController cControl;

    public SelectionSort(CanvasController cControl) {

        this.cControl = cControl;
    }

    @Override
    public void sort(ArrayList<Integer> nodes) {
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        selectionSort(nodes, comparator);
    }

    private <T> void selectionSort(ArrayList<T> arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Array and comparator cannot be null");
        }

        for (int i = arr.size() - 1; i > 0; i--) {
            int j = 0;
            for (int k = 1; k <= i; k++) {
                if (comparator.compare(arr.get(k), arr.get(j)) > 0) {
                    j = k;
                }
            }
            T temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);

            cControl.renderNodes();
        }
    }
}




