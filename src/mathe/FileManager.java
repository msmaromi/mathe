/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mathe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msmaromi
 */
public class FileManager {
  public static char[] extractExpression(String fileName) {
    char[] chars;
    String str = null;
    try {
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      str = br.readLine();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
    }    
    
    chars = str.toCharArray();    
    return chars;
  }
  
}
