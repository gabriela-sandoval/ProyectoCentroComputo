package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javax.swing.Icon;

public class FxmlAdministrarHardwareController {

    @FXML
    private ImageView imageViewLogo;

    @FXML
    private Text textAdministrarHardware;

    @FXML
    private TableView<?> tableViewAdministrarHardware;

    @FXML
    private TableColumn<?, ?> tableColumnNoInventario;

    @FXML
    private TableColumn<?, ?> tableColumnMarca;

    @FXML
    private TableColumn<?, ?> tableColumnModelo;

    @FXML
    private TableColumn<?, ?> tableColumnNoSerie;

    @FXML
    private TableColumn<?, ?> tableColumnResponsable;

    @FXML
    private TableColumn<?, ?> tableColumnUbicacion;

    @FXML
    private TableColumn<?, ?> tableColumnTipo;

    @FXML
    private TableColumn<?, ?> tableColumnGarantia;

    @FXML
    private TableColumn<?, ?> tableColumnEstado;

    @FXML
    private TableColumn<?, ?> tableColumnFecha;

    @FXML
    private TableColumn<?, ?> tableColumnPartes;

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
  
}
