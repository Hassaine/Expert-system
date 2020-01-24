/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rule;

import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JFrame;

/**
 *
 * @author Hassaine
 */
public class RuleVariable extends Variable {
    protected BooleanRuleBase rb;
    protected Vector clauseRefs;
    protected String promptText;
    protected String ruleName;

    public RuleVariable(BooleanRuleBase rb,String Name) {
        super(Name);
        this.rb = rb;
       rb.addVariable(this);
       clauseRefs = new Vector();
    }
    public void setValue(String value){
        this.value=value;
        updateClouses();
    }
    
    

    public void addClauseRef(Clause ref){
        
        this.clauseRefs.addElement(ref);
    }
    

    private void updateClouses() {
        Enumeration element = this.clauseRefs.elements();
        
        while(element.hasMoreElements()){
           ((Clause) element.nextElement()).check();
        }
    }
    //setters
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }
    //getters

    public String getPromptText() {
        return promptText;
    }
    
    
    
    
    
    @Override
    public void computeStatistics(String intValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int normalize(String intValue, float[] outArray, int inx) {
       return inx;
    }
    

   
    
}
