package info.danielcarl;

public class MergeSort extends Sort {
  public static void main(String[] args) {
    int[] numbers = { 5, 2, 4, 7, 1, 3, 2, 6 };

    System.out.println("Unsorted Array: " + formatArray(numbers));

    mergeSort(numbers, 0, numbers.length - 1);
    System.out.println("Sorted Array: " + formatArray(numbers));
  }

  private static void merge(int[] array, int startPos, int midPos, int endPos) {
    int[] leftArray = new int[midPos - startPos + 1];
    int[] rightArray = new int[endPos - midPos];

    // Copy array data across. (Oh no, this algorithm isn't in-place!)
    for (int x = 0; x < leftArray.length; x++) {
      leftArray[x] = array[startPos + x];
    }
    for (int x = 0; x < rightArray.length; x++) {
      rightArray[x] = array[midPos + x + 1];
    }

    // Begin merge!
    int lPointer = 0, rPointer = 0;
    for (int k = startPos; k <= endPos; k++) {
      if (lPointer >= leftArray.length) {
        // If we've exhausted the left array...
        array[k] = rightArray[rPointer++];
      } else if (rPointer >= rightArray.length) {
        // If we've exhausted the right array...
        array[k] = leftArray[lPointer++];
      } else {
        // Still some elements left in leftArray and rightArray!
        if (leftArray[lPointer] <= rightArray[rPointer]) {
          array[k] = leftArray[lPointer++];
        } else {
          array[k] = rightArray[rPointer++];
        }
      }
    }
  }

  public static void mergeSort(int[] array, int startPos, int endPos) {
    if (startPos < endPos) {
      int midPos = (startPos + endPos) / 2;
      mergeSort(array, startPos, midPos);
      mergeSort(array, midPos + 1, endPos);
      merge(array, startPos, midPos, endPos);
    }
  }
}