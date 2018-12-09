package controlador;

import com.gluonhq.charm.glisten.control.Icon;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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

}
