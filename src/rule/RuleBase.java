/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rule;

import com.jfoenix.controls.JFXTextArea;
import java.util.Vector;
import javax.swing.JTextArea;

/**
 *
 * @author Hassaine
 */
public interface RuleBase {
    public void setDisplay(JFXTextArea JFXtextArea);
    public void trace(String text);
    public void DisplayVariables(JFXTextArea JFXtextArea);
    public void DisplayRules(JFXTextArea JFXtextArea);
    public void reset();
    public void backWardChain(String goalVarName);
    public void forWardChain();
    public Vector getGoalVariables();
    
}
