package util;

public class Utils {

  static public boolean doubleEquals(double a, double b) {
    return Math.abs(a - b) < 1e-6;
  }

  static public boolean doubleGreater(double a, double b) {
    return a - b > -1e-6;
  }

}
