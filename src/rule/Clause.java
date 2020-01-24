/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rule;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Hassaine
 */
public class Clause {
   Vector ruleRefs;
    RuleVariable lhs;
    Condition cond;
    String rhs;
    Boolean truth;  
    
    boolean concequent;
    

    public Clause(RuleVariable lhs , Condition cond,String rhs) {
    ruleRefs = new Vector();
    this.lhs=lhs;
    lhs.addClauseRef(this);
    this.cond = cond;
    this.rhs=rhs;
    this.truth=null;
    this.concequent=false;
    
    
    
    }
    
    
    public void addRuleRef(Rule ruleName){
        this.ruleRefs.add(ruleName);
        
    }

    void setConcequent() {
        this.concequent=true;
    }
      Boolean check() {
        if (concequent== true) return null ;
        if (lhs.value == null) {
            return truth = null ;  // can't check if variable value is undefined
        } else {

        switch(cond.index) {
       case 1: truth = new Boolean(lhs.value.equals(rhs)) ;
//        RuleBase.appendText("\nTesting Clause " + lhs.name + " = " + rhs + " " + truth);
        break ;
       case 2: truth = new Boolean(lhs.value.compareTo(rhs) > 0) ;
//        RuleBase.appendText("\nTesting Clause " + lhs.name + " > " + rhs + " " + truth);
        break ;
       case 3: truth = new Boolean(lhs.value.compareTo(rhs) < 0) ;
//        RuleBase.appendText("\nTesting Clause " + lhs.name + " < " + rhs + " " + truth);
        break ;
       case 4: truth = new Boolean(lhs.value.compareTo(rhs) != 0) ;
//        RuleBase.appendText("\nTesting Clause " + lhs.name + " != " + rhs + " " + truth);
        break ;
       }

       return truth ;
        }
    }
//    public Boolean check(){
//        if(this.concequent){
//            return (this.truth=null);
//        }
//        if(this.lhs.value==null){
//             return (this.truth=null);
//             
//        }
//        else{
//            Double lhsNumericValue=null;
//            Double rhsNumericValue=null;
//            boolean bothNumeric=true;
//            try {
//                lhsNumericValue = Double.valueOf(lhs.value);
//                lhsNumericValue = Double.valueOf(rhs);
//            } catch (Exception e) {
//                bothNumeric=false;
//            }
//            switch(this.cond.index){
//                case 1:
//                    if(bothNumeric){
//                        this.truth = new Boolean(lhsNumericValue.compareTo(rhsNumericValue) == 0);
//                    }
//                    else{
//                        this.truth = new Boolean(lhs.value.equalsIgnoreCase(rhs));
//                        
//                    }
//                    break;
//                case 2:
//                    if(bothNumeric){
//                        this.truth = new Boolean(lhsNumericValue.compareTo(rhsNumericValue)>0);
//                    }
//                    else{
//                        this.truth = new Boolean(lhs.value.compareTo(rhs)>0);
//                        
//                    }
//                    break;
//                case 3:
//                    if(bothNumeric){
//                        this.truth = new Boolean(lhsNumericValue.compareTo(rhsNumericValue)<0);
//                    }
//                    else{
//                        this.truth = new Boolean(lhs.value.compareTo(rhs)<0);
//                        
//                    }
//                    break;
//                case 4:
//                    if(bothNumeric){
//                        this.truth = new Boolean(lhsNumericValue.compareTo(rhsNumericValue)!=0);
//                    }
//                    else{
//                        this.truth = new Boolean(lhs.value.compareTo(rhs)!=0);
//                        
//                    }
//                    break;
//                
//                    
//            }
//            return this.truth;
//            
//                
//            
//            
//            
//        }
//    }
    public Rule getRule(){
        if(this.concequent==true){
            return (Rule) this.ruleRefs.elementAt(0);
        }else{
            return null;
        }
    }
    
   @Override
    public String toString(){
        return lhs.name+cond.toString()+rhs+" ";
        
    }

  
    
}
