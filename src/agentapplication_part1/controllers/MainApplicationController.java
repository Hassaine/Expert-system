/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentapplication_part1.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXTextArea;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import rule.*;

/**
 *
 * @author Hassaine
 */
public class MainApplicationController implements Initializable {

    BooleanRuleBase rb;
    boolean default_F, clear_F;
    char rbSelected = 'V';

    @FXML
    private CheckMenuItem vehiculeMCheck;

    @FXML
    private CheckMenuItem medcinMCheck;

    @FXML
    private JFXButton rbDisplayButton;

    @FXML
    private JFXButton varValuesButton;

    @FXML
    private JFXButton defTestSetButton;

    @FXML
    private JFXButton performFCButton;

    @FXML
    private JFXTextArea rules;

    @FXML
    void about(ActionEvent event) {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("about");
        alert.setContentText("this application was devloped as a part of a project  in agents technlogie couse");
        alert.showAndWait();

    }

    @FXML
    void defaultTestSet(ActionEvent event) {
        default_F = true;
        clear_F = false;

    }

    @FXML
    void displayRB(ActionEvent event) {
        rules.clear();
        rb.DisplayRules(rules);

    }

    @FXML
    void displayVar(ActionEvent event) {
        rules.clear();
        if (!clear_F) {
            initRuleBase.kBLoader(rb, default_F);
        }

        rb.DisplayVariables(rules);
    }

    @FXML
    void newInstance(ActionEvent event) {

        default_F = false;

        Parent root;
        String fileName = "";
        String title = "";

        if (rbSelected == 'V') {  //if the selected ruleBase is vehicule
            fileName = "views/vehicule.fxml";
            title = "vehicule application controler";

        } else if (rbSelected == 'M') {  //if the selected ruleBase is medcine
            fileName = "views/medcinInput.fxml";
            title = "medcine rule base";

        }
        try {

            root = FXMLLoader.load(agentapplication_part1.AgentApplication_part1.class.getResource(fileName));
            
            Stage stage = new Stage();
            stage.setTitle(title);
                    JFXDecorator decorator = new JFXDecorator(stage,root);
                   
            stage.setScene(new Scene(decorator));
            stage.setResizable(false);
            stage.show();
            clear_F = false;

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    @FXML
    void performFC(ActionEvent event) {
        rules.clear();
        initRuleBase.kBLoader(rb, default_F);
        rb.forWardChain();

    }

    @FXML
    void quit(ActionEvent event) {
        System.exit(1);

    }

    @FXML
    void rest(ActionEvent event) {
        clear_F = true;
        rb.reset();
    }

    @FXML
    void vehiculeRBSelected(ActionEvent event) {

        if (medcinMCheck.isSelected()) {
            rbSelected = 'V';
            medcinMCheck.setSelected(false);
        }
        rb = new BooleanRuleBase("vehicule");
        rb.setDisplay(rules);
        initRuleBase.initVehiculeRuleBase(rb);

    }

    @FXML
    void medcinRBSelected(ActionEvent event) {
        if (vehiculeMCheck.isSelected()) {
            vehiculeMCheck.setSelected(false);

        }
        rbSelected = 'M';
        rb = new BooleanRuleBase("medcine");
        rb.setDisplay(rules);
        initRuleBase.initMedcinRuleBase(rb);

    }

    @Override
    public void initialize(URL url, ResourceBundle rbe) {
        rules.setEditable(false);
        rb = new BooleanRuleBase("vehicule");
        rb.setDisplay(rules);
        initRuleBase.initVehiculeRuleBase(rb);
        default_F = true;
        clear_F = false;
    }

}
