package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.sql.SQLException;

public class ClosingFiles {
  public static void getMoneyFromCreditCard() throws SocketException {

  }

  // Failure (however it might be represented!)
  // is part of your public API!!! -- it should be
  // represented at the SAME LEVEL OF ABSTRACTION
  // if you change your public API you probably break your client
  public static void useAFile(String fn)/* throws IOException */ {
//    try {
//      FileInputStream fis = new FileInputStream(fn);
//      FileOutputStream fos = new FileOutputStream(fn);
//
////      fis.close(); // no good, might not happen
////      fos.close();
//    } catch (IOException e) {
//      e.printStackTrace();
//    } finally {
//      // attempt to close resources here
////      fis.   ... but scoping and definite initializtion rules
//      // mean this does NOT work well.
//    }

    try (
        FileInputStream fis = new FileInputStream(fn);
        FileOutputStream fos = new FileOutputStream(fn);
    ) {

    } catch (IOException e) {

    } // finally is created automatically,
    // which will close the resources fis, fos for us
  }

  public void manyFailures() {
    try {
      if (Math.random() > 0.5) {
        throw new SQLException("DB busted");
      }
      if (Math.random() > 0.5) {
        throw new FileNotFoundException("File not found");
      }
      if (Math.random() > 0.5) {
        throw new IOException("File not found");
      }
//    } catch (IOException ioe) {
//      System.out.println("Uh oh, stuff broke");
//    }  catch (SQLException ioe) {
//      System.out.println("Uh oh, stuff broke");

//    } catch (Exception e) { // catches every exception except for errors!
//      System.out.println("Stuff broke");

    } catch (/*FileNotFoundException | */IOException | SQLException ex) {
      System.out.println("it's IO or SQL, only");
    }
  }

  public static void main(String[] args) throws IOException {
    useAFile("Bad.txt");
  }
}
