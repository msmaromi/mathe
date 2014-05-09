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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static mathe.PDA.CLOSE_BRACKET;
import static mathe.PDA.OPEN_BRACKET;
import static mathe.PDA.OPERAN;
import static mathe.PDA.OPERATOR;

/**
 *
 * @author msmaromi
 */
public class FA {
  private final String ZERO = "zero";
  private final String NUMBER = "N";  //1..9
  private final String EMPTY = "e";
  private final String NEGATIVE_SIGN = "-";
  private final String DOT_SIGN = ".";
  
  private ArrayList<Character> listNumber;  // 1..9
  private ArrayList<String> listType;
  
  private final String CURRENT_STATE = "current state";
  private final String INPUT = "input";  
  private final String NEXT_STATE = "next state";  
  private final String START_STATE = "Q0";
  private final String FINAL_STATE = "Q5";
  
  private ArrayList<Rule> rules;
  
  private class Rule {
    public HashMap<String, String> lefthand;
    public HashMap<String, String> righthand;
    
    public Rule(String currentState, String input, String nextState) {
      lefthand = new HashMap<>();
      righthand = new HashMap<>();
      
      lefthand.put(CURRENT_STATE, currentState);
      lefthand.put(INPUT, input);      
      righthand.put(NEXT_STATE, nextState);      
    }           
  }
  
  public FA(String filename) {
    listNumber = new ArrayList<>(Arrays.asList(new Character[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'}));
    listType = new ArrayList<>(Arrays.asList(new String[] {EMPTY, NEGATIVE_SIGN, ZERO, NUMBER, DOT_SIGN}));
    rules = extractRules(filename);
  }
  
  public Double analyzeExpression(char[] listChar) {
//    Double result = 0.0;   
//    
//    int i = 0;
//    while(i < listType.size()) {
//      String typeInput = listType.get(i);
//      
//      i++;
//    }
//    
//    if(currentState.equals(FINAL_STATE)) {
//      if(listChar.length == 0) {        
//        return true;
//      }
//    } else {
//      char currentChar = listChar[0];
//      char newListChar[] = new char[listChar.length - 1];
//      for(int j = 1; j < listChar.length; j++) {
//        newListChar[j-1] = listChar[j];
//      }
//      int i = 0;
//      while(i < listType.size()) {
//        String typeInput = listType.get(i);
//        if(analyzeExpression(currentState, typeInput, newListChar)) {
//          return true;
//        }
//        i++;
//      }
//      return false;
//    }        
      
    StringBuilder sb =  new StringBuilder();
    for(char c: listChar) {
      sb.append(c);
    }

    Double result = null;
    try {
      System.out.println("format valid");
      result = Double.parseDouble(sb.toString());
    } catch (NumberFormatException e) {
      System.out.println("format tidak valid");      
    }

    return result;    
  }
  
  public String examineExpression(char c) {    
    if(listNumber.contains(c))
      return NUMBER;
    else if(c == '0')
      return ZERO;
    else if(c == '-')
      return NEGATIVE_SIGN;
    else if(c == '.')
      return DOT_SIGN;
    else if(c == 'e')
      return EMPTY;
    
    return null;
  }
  
  public ArrayList<Rule> extractRules(String filename) {
    ArrayList<Rule> rules = new ArrayList<>();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(filename));
      String str = br.readLine();
      while(str != null) {        
        String delims = "[,:]";
        String tokens[] = str.split(delims);                
        str = br.readLine();
        Rule r = new Rule(tokens[0], tokens[1], tokens[2]);        
        rules.add(r);
      }     
    } catch (FileNotFoundException ex) {
      Logger.getLogger(FA.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(FA.class.getName()).log(Level.SEVERE, null, ex);
    }   
    return rules;
  }
}
