/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentapplication_part1.controllers;

import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Hassaine
 */
public class MedcinController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField nezboucher;

    @FXML
    private JFXTextField douleurArticulaire;

    @FXML
    private JFXTextField chaleurDEDC;

    @FXML
    private JFXTextField toux;

    @FXML
    private JFXTextField vomisement;

    @FXML
    private JFXTextField fatigue;

    @FXML
    private JFXTextField diarhee;

    @FXML
    private JFXTextField coliquesDegistifs;

    @FXML
    private JFXTextField pert_dappitit;

    @FXML
    private JFXTextField mictionDouleureusse;

    @FXML
    void aboutUs(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("about");
        alert.setContentText("this application was devloped as a part of a project  in agents technlogie couse");
        alert.showAndWait();
    }

    @FXML
    void contact(ActionEvent event) throws URISyntaxException, IOException {

        Desktop desktop;
        if (Desktop.isDesktopSupported()
                && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
            URI mailto = new URI("mailto:doctor@example.com?subject=patient%20consulting");
            desktop.mail(mailto);
        } else {

            throw new RuntimeException("desktop doesn't support mailto; mail is dead anyway ;)");
        }

    }

    @FXML
    void submit(ActionEvent event) {
        ArrayList<String> posibleValues = new ArrayList<>();
        posibleValues.add("no");
        posibleValues.add("yes");
        posibleValues.add("");
        posibleValues.add("eleve");
        posibleValues.add("normal");
        try {
            FileWriter fr = new FileWriter("intialKnowledgeBase/medcineKB.json");
            fr.write("{");
            if (posibleValues.contains(chaleurDEDC.getText())) {
                fr.write("\"chaleur_dans_les_extrimites_du_corps\":\"" + (chaleurDEDC.getText().equals("") ? "null" : chaleurDEDC.getText()) + "\",");

            }
            if (posibleValues.contains(coliquesDegistifs.getText())) {

                fr.write("\"coliques_degistifs\":\"" + (coliquesDegistifs.getText().equals("") ? "null" : coliquesDegistifs.getText()) + "\",");
            }
            if (posibleValues.contains(diarhee.getText())) {

                fr.write("\"diarrhee\":\"" + (diarhee.getText().equals("") ? "null" : diarhee.getText()) + "\",");
            }
            if (posibleValues.contains(douleurArticulaire.getText())) {

                fr.write("\"douleur_articulaire\":\"" + (douleurArticulaire.getText().equals("") ? "null" : douleurArticulaire.getText()) + "\",");
            }
            if (posibleValues.contains(fatigue.getText())) {

                fr.write("\"fatigue\":\"" + (fatigue.getText().equals("") ? "null" : fatigue.getText()) + "\",");
            }
            if (posibleValues.contains(mictionDouleureusse.getText())) {

                fr.write("\"miction_douleureusse\":\"" + (mictionDouleureusse.getText().equals("") ? "null" : mictionDouleureusse.getText()) + "\",");
            }

            if (posibleValues.contains(nezboucher.getText())) {
                fr.write("\"nez_bouchee\":\"" + (nezboucher.getText().equals("") ? "null" : nezboucher.getText()) + "\",");
            }
            if (posibleValues.contains(pert_dappitit.getText())) {
                fr.write("\"pert_dappetit\":\"" + (pert_dappitit.getText().equals("") ? "null" : pert_dappitit.getText()) + "\",");
            }
            if (posibleValues.contains(toux.getText())) {
                fr.write("\"toux\":\"" + (toux.getText().equals("") ? "null" : toux.getText()) + "\",");
            }
            if (posibleValues.contains(vomisement.getText())) {
                fr.write("\"vomisement\":\"" + (vomisement.getText().equals("") ? "null" : vomisement.getText()) + "\"");
            }
            fr.write("}");
            fr.close();

        } catch (IOException ex) {
            Logger.getLogger(VehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
