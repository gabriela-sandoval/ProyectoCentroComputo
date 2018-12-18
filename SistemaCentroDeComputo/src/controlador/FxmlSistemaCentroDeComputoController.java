package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * controlador de la interfaz sistema centro de computo; loguin
 * @author gabriela sandoval
 */
public class FxmlSistemaCentroDeComputoController implements Initializable {
    
  @FXML
  private Button buttonIngresar;

  @FXML
  private Label label;

  @FXML
  private TextField textFieldNombreDeUsuario;

  @FXML
  private Text textNombreDeUsuario;

  @FXML
  private Text textContrasenia;

  @FXML
  private TextField textFieldContrasenia;

  @FXML
  private ImageView imageViewLogoCC;

  public void initialize(URL url, ResourceBundle rb) {

  }
}
