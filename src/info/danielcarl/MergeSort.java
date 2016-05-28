package info.danielcarl;

public class MergeSort extends Sort {
  public static void main(String[] args) {
    int[] numbers = { 5, 2, 4, 6, 1, 3 };

    System.out.println("Unsorted Array: " + formatArray(numbers));

//    sort(numbers);
//    System.out.println("Sorted Array: " + formatArray(numbers));
  }

  public static void merge(int[] array, int startPos, int midPos, int endPos) {
    int leftLength = midPos - startPos + 1;
    int rightLength = endPos - startPos + 1;
    int[] leftArray = new int[leftLength], rightArray = new int[rightLength];

    // Copy array data across. (Oh no, this algorithm isn't in-place!)
    for (int x = 0; x < leftLength; x++) {
      leftArray[x] = array[startPos + x];
    }
    for (int x = 0; x < rightLength; x++) {
      rightArray[x] = array[midPos + x + 1];
    }

    // Begin merge!
    int i = 0, j = 0;
    for (int k = startPos; k <= endPos; k++) {
      if (leftArray[i] <= rightArray[j]) {
        array[k] = leftArray[i++];
      } else {
        array[k] = rightArray[j++];
      }
    }
  }
}