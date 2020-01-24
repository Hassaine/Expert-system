/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rule;

/**
 *
 * @author Hassaine
 */
public class Condition {
    int index;
    String symbol;

    public Condition( String symbol) {
        this.symbol = symbol;
        this.index=-1;
        if(this.symbol.equals("=")){
            this.index=1;
            
        }
        if(this.symbol.equals(">")){
             this.index=2;
            
        }
        if(this.symbol.equals("<")){
             this.index=3;
            
        }
        if(this.symbol.equals("!=")){
             this.index=4;
            
        }
   
    }
    @Override
     public String toString(){
        return this.symbol;
    }
    
    
            
    
}
