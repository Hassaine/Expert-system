/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rule;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author Hassaine
 */
public abstract class Variable {
    protected String name;
    protected String value;
    protected Vector labels;
    protected int   column;

    public Variable() {
    }
    public Variable(String name){
        this.name  =  name;
        value = null;
        
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setLabels(String newLabels) {
        labels=new Vector();
        StringTokenizer token = new StringTokenizer(newLabels);
        while(token.hasMoreTokens()){
            labels.addElement(new String(token.nextToken()));
        }
    }
    public String getLabel(int index){
        return (String) labels.elementAt(index);
    }
    public Vector getLabels() {
        return (Vector) labels.clone();
    }
    public String getLabelsAsString(){
        String LabelList = new String();
        Enumeration enums = labels.elements();
        while(enums.hasMoreElements()){
            LabelList+=enums.nextElement()+ " ";
        }
        return LabelList;
    }
    public int getIndex(String label){
        int index=-1;
        if(labels==null) return index;
        for (int i = 0; i < labels.size(); i++) {
            if(labels.elementAt(i).equals(label)){
                index=i;
                break;
            }
            
        }
        return index;
    }
    public boolean categorical(){
        return (labels!=null);
    }
    @Override
    public String toString(){
        return name;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    
    public abstract void computeStatistics(String intValue);
    public abstract int normalize(String intValue,float[] outArray,int inx);
    
    public int normalizedSize(){
        return 1;
    }
    public String getDecodedValue(float[] act,int index){
        return String.valueOf(act[index]);
    }
    
    
    
    
    
    
}
