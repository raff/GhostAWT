package ghostawt.sun;

class Logger {
  private static boolean verbose;

  static {
    String value = System.getProperty("ghostawt.verbose");
    verbose = ((value != null) && (value.equalsIgnoreCase("true")));
  }

  public static void log(Object... values) {
    if (verbose) {
      System.err.print("[ghostawt]");

      for (Object v: values) {
        System.err.print(' ');
        System.err.print(v);
      }

      System.err.println();
    }
  }

  public static void logf(String fmt, Object... values) {
    if (verbose) {
      System.err.print("[ghostawt] ");
      System.err.format(fmt, values);
    }
  }
}
