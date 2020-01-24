/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rule;

import com.jfoenix.controls.JFXTextArea;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JTextArea;

/**
 *
 * @author Hassaine
 */
public class Rule {
    BooleanRuleBase rb;
    String name;
    Clause [] antecedents;
    Clause concequent;
    Boolean truth;
    boolean fired=false;

    public Rule(BooleanRuleBase rb, String name, Clause lhs, Clause rhs) {
        this.rb = rb;
        this.name = name;
        this.antecedents= new Clause[1];
        this.antecedents[0] = lhs;
        lhs.addRuleRef(this);
        this.concequent = rhs;
        rhs.addRuleRef(this);
        rhs.setConcequent();
        rb.ruleList.add(this);
        this.truth = null;
    }
    public Rule(BooleanRuleBase rb, String name, Clause[] lhs, Clause rhs) {
        this.rb = rb;
        this.name = name;
        this.antecedents= new Clause[lhs.length];
        for (int i = 0; i < lhs.length; i++) {
             this.antecedents[i] = lhs[i];
              lhs[i].addRuleRef(this);
             
        }
       
       
        this.concequent = rhs;
        rhs.addRuleRef(this);
        rhs.setConcequent();
        rb.ruleList.addElement(this);
        this.truth = null;
    }

    public Boolean check() {
        for (int i = 0; i <antecedents.length; i++) {
            if(antecedents[i].truth==null){
                return truth=null;
               
            }
            if(antecedents[i].truth.booleanValue()==false){
               return truth= new Boolean(false);
            }
            
        }
        return truth= new Boolean(true);
    }

    public long numAntecedents() {
        return antecedents.length;
    }
    public void fire(){
        rb.trace("\nFiring Rule"+name);
        truth= new Boolean(true);
        fired=true;
        if(concequent.lhs==null){
         //   ((EffectorClause) concequent).perform(rb);
        }else{
            concequent.lhs.setValue(concequent.rhs);
            checkRules(concequent.lhs.clauseRefs);
        }
    }

    public static void checkRules(Vector clauseRefs) {
        Enumeration elements = clauseRefs.elements();
        while(elements.hasMoreElements()){
            Clause temp = (Clause) elements.nextElement();
            Enumeration elements_2 = temp.ruleRefs.elements();
            while(elements_2.hasMoreElements()){
                ((Rule) elements_2.nextElement()).check();
            }
        }
       
    }
    public void display(JFXTextArea JFXtextArea){
        System.out.println(name+": IF");
            JFXtextArea.appendText(name+": IF ");
            for (int i = 0; i < antecedents.length; i++) {
                Clause nextClause = antecedents[i];
                System.out.println(nextClause.toString());
                JFXtextArea.appendText(nextClause.toString());
                if(i+1<antecedents.length){
                    System.out.println("\n     AND ");
                     JFXtextArea.appendText("\n     AND ");         
                }
                                 
        }
            System.out.println("\n     THEN ");
            System.out.println(concequent.toString());
            JFXtextArea.appendText("\n     THEN ");
             JFXtextArea.appendText(concequent.toString());
            
    }
    
    
    
}
