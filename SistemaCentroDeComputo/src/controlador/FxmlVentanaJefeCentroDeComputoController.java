/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author galil
 */
public class FxmlVentanaJefeCentroDeComputoController implements Initializable {

  @FXML
  private ImageView imageViewLogo;

  @FXML
  private Text textNombreJefe;

  @FXML
  private Text textAdministrador;

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
    // TODO
  }

}
