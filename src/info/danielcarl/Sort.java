package info.danielcarl;

abstract class Sort {
  static String formatArray(int[] numArray) {
    String str = "";
    for (int number : numArray) {
      str += number + "; ";
    }
    return str;
  }
}