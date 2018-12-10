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
 * Clase principal de.
 * 
 * @author Gabriela Sandoval Cruz
 * @version 1.0
 * @since 2018-12-08
 */
public class SistemaCentroDeComputo extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource(
        "/interfazGrafica/FxmlVentanaJefeCentroDeComputo.fxml"));

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    Image icono = new Image("/iconos/logo cc.png");
    primaryStage.getIcons().add(icono);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  /**
   * Clase main SistemaCentroDeComputo.
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
