/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacentrodecomputo;

import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Scene;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;
    import java.net.URL;
import javafx.scene.Parent;

/**
 *
 * @author Gabriela Sandoval Cruz
 */
public class SistemaCentroDeComputo extends Application {

  @Override
  public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FxmlSistemaCentroDeComputo.fxml"));        
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.show();
    }

  /**
   * Clase main de AnalisisEstiloJava.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
