import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exo algo tri rapide d'un tableau");
        System.out.println("================================");

        int[] numbers = {3, 9, 7, 1, 6, 2, 8, 4, 5};

        System.out.println("Tableau de départ non trié :");
        System.out.println("numbers = " + Arrays.toString(numbers));
        System.out.println("================================");

        quickSort(numbers, 0, numbers.length-1);

        System.out.println("Résultat du tri sur le tableau :");
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    private static void quickSort(int[] numbersToSort, int lowIndex, int highIndex) {
        // in case the array contain only one element meaning is already sorted
        if (lowIndex >= highIndex) {
            return;
        }

        // STEP 1 - choose the pivot (last array element)
        int pivot = numbersToSort[highIndex];

        // STEP 2 - (Partitioning) MOVE all numbers < than the pivot to the left of the pivot AND MOVE all numbers > than the pivot to the right of the pivot
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (numbersToSort[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (numbersToSort[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(numbersToSort, leftPointer, rightPointer);
        }
        swap(numbersToSort, leftPointer, highIndex);

        quickSort(numbersToSort, lowIndex, leftPointer - 1); // sorting array on the left side of the pivot
        quickSort(numbersToSort, leftPointer + 1, highIndex); // sorting array on the right side of the pivot
    }

    private static void swap(int[] numbersToSort, int index1, int index2) { //
        int tempValueToSwap = numbersToSort[index1];
        numbersToSort[index1] = numbersToSort[index2];
        numbersToSort[index2] = tempValueToSwap;
    }
}
