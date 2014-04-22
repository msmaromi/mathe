/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mathe;

import java.util.HashMap;

/**
 *
 * @author msmaromi
 */
public class PDA {
  public static final String OPERAN = "operan";
  public static final String OPERATOR = "operator";
  public static final String OPEN_BRACKET = "(";
  public static final String CLOSE_BRACKET = ")";
  
  private final String CURRENT_STATE = "current state";
  private final String INPUT = "input";
  private final String TOP_STACK = "top stack";
  private final String NEXT_STATE = "next state";
  private final String RESULT_STACK = "result stack";
  
  private class Rule {
    public HashMap<String, String> lefthand;
    public HashMap<String, String> righthand;
    
    public Rule(String currentState, String input, String topStack, String nextState, String resultStack) {
      lefthand.put(CURRENT_STATE, currentState);
      lefthand.put(INPUT, input);
      lefthand.put(TOP_STACK, topStack);
      righthand.put(NEXT_STATE, nextState);
      righthand.put(RESULT_STACK, resultStack);
    }
  } 
  
  public PDA(String currentState, String input, String topStack, String nextState, String resultStack) {
    
  }
  
  public Integer analyzeExpression(char[] listChar) {
    
    return null;
  }
  
  public String examineExpresseion(char c) {
    
    return null;
  }
}
