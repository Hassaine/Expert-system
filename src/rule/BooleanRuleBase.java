/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rule;

import com.jfoenix.controls.JFXTextArea;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.Stack;
import javax.swing.JTextArea;

/**
 *
 * @author Hassaine
 */
public class BooleanRuleBase implements RuleBase{
    String name;
    Hashtable variableList = new Hashtable();
    Clause clauseVarList[];
    Vector ruleList = new Vector();
    Vector ConclusionVarList ;
    Rule rulePtr;
    Clause clousePtr;
    Stack goalClauseStack;
    Hashtable sensors;
    Hashtable effectors;
    Vector factList;
    JFXTextArea textArea;

    public BooleanRuleBase(String name) {
        this.name= name;
    }
    
            
    
    
    
    
    void addVariable(RuleVariable var) {
       variableList.put(var.name,var);
    }
  public  void setVariableValue(String name,String value){
       RuleVariable temp= (RuleVariable) variableList.get(name);
       temp.setValue(value);
        
    }

    @Override
    public void setDisplay(JFXTextArea JFXtextArea) {
        
       this.textArea=JFXtextArea;
    }

    @Override
    public void trace(String text) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(text);
    }

    @Override
    public void DisplayVariables(JFXTextArea JFXtextArea) {
          //Hashtable variableList = new Hashtable();
          Set<String> key = variableList.keySet();
         Iterator<String> a=   key.iterator();
         
         while(a.hasNext()){
           RuleVariable test=((RuleVariable) variableList.get(a.next()));
             System.out.println(test.name+" "+test.value);
             if(JFXtextArea!=null)
             JFXtextArea.appendText(test.name+":"+test.value+"\n");
             //System.out.println(test.value);
         }
                 
       
    }

    @Override
    public void DisplayRules(JFXTextArea JFXtextArea) {
        
       Enumeration elements = ruleList.elements();
        System.out.println(ruleList.size());
       while(elements.hasMoreElements()){
           ((Rule)elements.nextElement()).display(JFXtextArea);
       }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reset() {
       textArea.appendText("\n --- Setting all " + name + " variables to null");
   Enumeration element = variableList.elements() ;
   while(element.hasMoreElements()) {
     RuleVariable temp = (RuleVariable) element.nextElement() ;
     temp.setValue(null);
     
     
     
   }
    element = ruleList.elements();
    
    while(element.hasMoreElements()){
         Rule temp = (Rule) element.nextElement() ;
     temp.fired=false;
             
        
    }
    }

    @Override
    public void backWardChain(String goalVarName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void forWardChain() {
        
         Vector conflictRuleSet = new Vector() ;

    // first test all rules, based on initial data
    conflictRuleSet = match(true); // see which rules can fire
        //System.out.println(conflictRuleSet.size());
      while(conflictRuleSet.size() > 0) {
      Rule selected = selectRule(conflictRuleSet); 
      selected.fire() ;  
      selected.display(this.textArea);
      conflictRuleSet = match(false); 
    }
    
       
    }

    @Override
    public Vector getGoalVariables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Vector match(boolean test){
        Vector matchList = new Vector();
        Enumeration elements = ruleList.elements();
        while(elements.hasMoreElements()){
            Rule ruleTest = (Rule) elements.nextElement();          
            if(test){
                ruleTest.check();
            }
            if(ruleTest.truth==null){
                continue;
            }
            if(ruleTest.truth.booleanValue()==true && ruleTest.fired==false){
                matchList.addElement(ruleTest);
            }
            
            
        }
        displayConflictSet(matchList);
        return matchList;
    }
    
    public Rule selectRule(Vector ruleSet){
        Enumeration elements = ruleSet.elements();
        long numClauses;
        Rule nextRule;
        Rule bestRule= (Rule) elements.nextElement();
        long max = bestRule.numAntecedents();
        while(elements.hasMoreElements()){
            nextRule= (Rule) elements.nextElement();
            if((numClauses=nextRule.numAntecedents())>max){
                bestRule=nextRule;
                max=numClauses;
            }
        }
        return bestRule;
    }

    private void displayConflictSet(Vector matchList) {
      
    }
    
}
