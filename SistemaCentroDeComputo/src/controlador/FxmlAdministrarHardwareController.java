package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javax.swing.Icon;

public class FxmlAdministrarHardwareController implements Initializable {

  @FXML
  private ImageView imageViewLogo;

  @FXML
  private Text textAdministrarHardware;


  @FXML
  private Text textJefeDelCentroDeComputo;

  @FXML
  private TextField textFieldNombreDeUsuario;

  @FXML
  private Icon iconRegresar;

  @FXML
  private Text textRegresar;

  @FXML
  private Icon iconAgregar;

  @FXML
  private Icon iconDeshabilitar;

  @FXML
  private Icon iconEditar;

  @FXML
  private Icon iconVerMas;

  /**
   * Initializes the controller class.
   */
  public void initialize(URL url, ResourceBundle rb) {

  }


}
