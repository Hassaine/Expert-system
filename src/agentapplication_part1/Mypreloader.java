/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentapplication_part1;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Hassaine
 */
public class Mypreloader extends Preloader {
     Stage preloadStage;
    Scene scene;

    @Override
    public void init() throws Exception {
        
        Parent root1 = FXMLLoader.load(this.getClass().getResource("views/splashScreen.fxml"));
        scene = new Scene(root1);
    }
    

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        this.preloadStage = primaryStage;
        preloadStage.setScene(scene);
        preloadStage.initStyle(StageStyle.UNDECORATED);
        preloadStage.show();
//        
      
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
       if(info.getType() ==StateChangeNotification.Type.BEFORE_START){
           this.preloadStage.hide();
       }
    }
    
    
}
