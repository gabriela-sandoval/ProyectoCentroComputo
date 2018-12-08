/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacentrodecomputo;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Gabriela Sandoval Cruz
 */
public class SistemaCentroDeComputo extends Application {
  
  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource(
        "/interfazGrafica/FxmlSistemaCentroDeComputo.fxml"));

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    Image icono = new Image("/iconos/logo cc.png");
    primaryStage.getIcons().add(icono);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  /**
   * Clase main de AnalisisEstiloJava.
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}
