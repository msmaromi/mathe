/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mathe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;
import sun.reflect.generics.tree.Tree;

/**
 *
 * @author msmaromi
 */
public class PDA {
  public static final String OPERAN = "operan";
  public static final String OPERATOR = "operator";
  public static final String OPEN_BRACKET = "(";
  public static final String CLOSE_BRACKET = ")";
    
  private ArrayList<Character> listOperator;
  private ArrayList<Character> listOperan;  
  
  private final String CURRENT_STATE = "current state";
  private final String INPUT = "input";
  private final String TOP_STACK = "top stack";
  private final String NEXT_STATE = "next state";
  private final String RESULT_STACK = "result stack";
  private final String START_STATE = "start state";
  private final String FINAL_STATE = "final state";
  
  private Vector<Rule> rules;
  
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
  
  public PDA(String filename) {   
    listOperator = new ArrayList<>(Arrays.asList(new Character[] {'+', '-', '*', '/'}));
    listOperan = new ArrayList<>(Arrays.asList(new Character[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}));
    rules = extractRules(filename);
  }
  
  public Vector<Rule> extractRules(String filename) {
    return null;
  }
  
  public Integer analyzeExpression(char[] listChar) {
    String state = START_STATE;
    outerloop:
    for(int i = 0; i < listChar.length; i++) {
      String typeInput = examineExpresseion(listChar[i]);      
      if(typeInput == null)
        return null;
      else {
        for(int j = 0; j < rules.size(); j++) {
          Rule rule = rules.get(j);
          if(rule.lefthand.get(CURRENT_STATE) == state && rule.lefthand.get(INPUT) == typeInput) {
            state = rule.lefthand.get(CURRENT_STATE);
            break outerloop;
          }          
        }
      }
    }
    
//    if(state == FINAL_STATE)
      
      
    return null;
  }
  
  public String examineExpresseion(char c) {    
    if(listOperator.contains(c))
      return OPERATOR;
    else if(listOperan.contains(c))
      return OPERAN;
    else if(c == '(')
      return OPEN_BRACKET;
    else if(c == ')')
      return CLOSE_BRACKET;
    
    return null;
  }    
}
