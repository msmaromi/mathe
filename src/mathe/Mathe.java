/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mathe;

import java.util.Vector;

/**
 *
 * @author msmaromi
 */
public class Mathe {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    char[] listChar = FileManager.extractExpression("files/exp.txt");
    for(char c: listChar) {
      System.out.println(c);
    }
  }
  
}
