package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

public class ClosingFiles {
  public static void getMoneyFromCreditCard() throws SocketException {

  }
  // Failure (however it might be represented!)
  // is part of your public API!!! -- it should be
  // represented at the SAME LEVEL OF ABSTRACTION
  // if you change your public API you probably break your client
  public static void useAFile(String fn)/* throws IOException */ {
    try {
      FileInputStream fis = new FileInputStream(fn);
      FileOutputStream fos = new FileOutputStream(fn);

//      fis.close(); // no good, might not happen
//      fos.close();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // attempt to close resources here
//      fis.   ... but scoping and definite initializtion rules
      // mean this does NOT work well.
    }
  }

  public static void main(String[] args) throws IOException {
    useAFile("Bad.txt");
  }
}
