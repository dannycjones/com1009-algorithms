package info.danielcarl;

class InsertionSort {
  public static void main(String[] args) {
    int[] numbers = { 5, 2, 4, 6, 1, 3 };

    System.out.println("Unsorted Array: " + formatArray(numbers));

    sort(numbers);
    System.out.println("Sorted Array: " + formatArray(numbers));
  }

  public static void sort(int[] numArray) {
    int key, i;
    for (int j = 1; j < numArray.length; j++) {
      // Insert each key into correct position...
      key = numArray[j];
      i = j - 1;
      while (i >= 0 && numArray[i] > key) {
        // Until key is in correct position, move each number along.
        numArray[i + 1] = numArray[i];
        i--;
      }
      numArray[i + 1] = key; // Place in final position.
    }
  }

  private static String formatArray(int[] numArray) {
    String str = "";
    for (int number : numArray) {
      str += number + "; ";
    }
    return str;
  }
}