package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author galil
 */
public class FxmlVentanaJefeCentroDeComputoController implements Initializable {
  // logos
  @FXML
  private ImageView imageViewLogo;
  // textos
  @FXML
  private Text textNombreJefe;
  @FXML
  private Text textAdministrador;
  // botones
  @FXML
  private Button buttonSalir;
  @FXML
  private Button buttonAdministrarSoftware;
  @FXML
  private Button buttonAdministrarHardware;
  @FXML
  private Button buttonAdministrarUsuarios;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    buttonSalir.setOnAction((ActionEvent event) -> {
      Stage stage = (Stage) buttonSalir.getScene().getWindow();
      stage.close();
    });


    buttonAdministrarSoftware.setOnAction((event) -> {
      Stage primaryStage = (Stage) buttonAdministrarSoftware.getScene().getWindow();
      Parent root = null;
      try {
        root = FXMLLoader
            .load(getClass().getResource("/interfazGrafica/FxmlAdministrarSoftware.fxml"));

      } catch (IOException e) {
        e.printStackTrace();
      }
      Scene scene = new Scene(root);
      Stage appStage = new Stage();
      appStage.setScene(scene);
      Image imagen = new Image("/iconos/logo cc.png");
      appStage.getIcons().add(imagen);
      appStage.toFront();
      appStage.show();
    });


    buttonAdministrarHardware.setOnAction((event) -> {
      Stage primaryStage = (Stage) buttonAdministrarHardware.getScene().getWindow();
      Parent root = null;
      try {
        root = FXMLLoader
            .load(getClass().getResource("/interfazGrafica/FxmlAdministrarHardware.fxml"));
      } catch (IOException ex) {
        ex.printStackTrace();
      }

      Scene scene = new Scene(root);

      primaryStage.setScene(scene);
      Image icono = new Image("/iconos/logo cc.png");
      primaryStage.getIcons().add(icono);
      primaryStage.setResizable(false);
      primaryStage.show();
    });



  }

}
    
    
    

