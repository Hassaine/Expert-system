/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentapplication_part1;

import com.jfoenix.controls.JFXDecorator;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.stage.Stage;

/**
 *
 * @author Hassaine abdellah ,slougui djaber
 */
public class AgentApplication_part1 extends Application {

    Stage stageApp;

    @Override
    public void start(Stage stage) throws Exception {
        this.stageApp = stage;
        Parent root = FXMLLoader.load(getClass().getResource("views/agentApplication.fxml"));

        
        Scene scene = new Scene(root, 570, 400);
        
        stageApp.setScene(scene);
        stageApp.setResizable(false);
        stageApp.show();

    }

    @Override
    public void init() throws Exception {

        Thread.sleep(6500);
//
        LauncherImpl.notifyPreloader(this, new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));
    }

 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LauncherImpl.launchApplication(AgentApplication_part1.class, Mypreloader.class, args);
       
    }

}
