package controlador;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javax.print.DocFlavor.URL;

public class FxmlAdministrarSoftwareController {

  @FXML
  private ImageView imageViewLogo;

  @FXML
  private Text textAdministrarSoftware;

  @FXML
  private Text textJefeDelCentroDeComputo;

  @FXML
  private TextField textFieldNombreDeUsuario;

  @FXML
  private Text textRegresar;

  @FXML
  private TableColumn<?, ?> tableColumnNoInventario;

  @FXML
  private TableColumn<?, ?> tableColumnNombreDeSoftware;

  @FXML
  private TableColumn<?, ?> tableColumnNoLicencias;

  @FXML
  private TableColumn<?, ?> tableColumnVersion;

  @FXML
  private TableColumn<?, ?> tableColumnObservaciones;

  @FXML
  private Button buttonBuscar;

  @FXML
  private Button buttonAgregar;

  @FXML
  private Button buttonVer;

  @FXML
  private Button buttonEditar;

  @FXML
  private Button buttonDeshabilitar;

  @FXML
  private Button buttonRegresar;

  public void inicialize(URL url, ResourceBundle rb) {
    colocarIconoBotones();
  }

  private FxmlAdministrarSoftwareController() {

  }

  private void colocarIconoBotones() {
    java.net.URL linkBuscar = getClass().getResource("/iconos/buscar.png");
    java.net.URL linkRegresar = getClass().getResource("/iconos/regresar.png");
    java.net.URL linkAgregar = getClass().getResource("/iconos/agregar.png");
    java.net.URL linkEditar = getClass().getResource("/iconos/editar.png");
    java.net.URL linkVer = getClass().getResource("/iconos/ver.png");
    java.net.URL linkDeshabilitar = getClass().getResource("/iconos/drshsbilitar.png");

    Image imagenBuscar = new Image(linkBuscar.toString(), 24, 24, false, true);
    Image imagenRegresar = new Image(linkRegresar.toString(), 24, 24, false, true);
    Image imagenAgregar = new Image(linkAgregar.toString(), 24, 24, false, true);
    Image imagenEditar = new Image(linkEditar.toString(), 24, 24, false, true);
    Image imagenVer = new Image(linkVer.toString(), 24, 24, false, true);
    Image imagenDeshabilitar = new Image(linkDeshabilitar.toString(), 24, 24, false, true);

    buttonBuscar.setGraphic(new ImageView(imagenBuscar));
    buttonRegresar.setGraphic(new ImageView(imagenRegresar));
    buttonAgregar.setGraphic(new ImageView(imagenAgregar));
    buttonEditar.setGraphic(new ImageView(imagenEditar));
    buttonVer.setGraphic(new ImageView(imagenVer));
    buttonDeshabilitar.setGraphic(new ImageView(imagenDeshabilitar));

  }
}
