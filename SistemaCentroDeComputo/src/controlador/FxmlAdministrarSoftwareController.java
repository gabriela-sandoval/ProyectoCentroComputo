package controlador;

import CentroComputo.Software;
import Daos.SoftwareDao;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Clase controladora de la interfaz de administrar software
 * 
 * @author Irasema Caicero
 * @since 18/12/18
 * @version 1.0
 */
public class FxmlAdministrarSoftwareController implements Initializable {
  // Tabla
  @FXML
  private TableView<Software> tabladeSoftware;
  @FXML
  private TableColumn<Software, String> tableColumnIdSoftware;
  @FXML
  private TableColumn<Software, String> tableColumnNombreDeSoftware;
  @FXML
  private TableColumn<Software, String> tableColumnOrigen;
  @FXML
  private TableColumn<Software, String> tableColumnObservaciones;
  @FXML
  private TableColumn<Software, Date> tableColumnFecha;
  @FXML
  private TableColumn<Software, String> tableColumnTipo;
  @FXML
  private TableColumn<Software, String> tableColumnMarca;
  @FXML
  private TableColumn<Software, String> tableColumnActualizacion;
  @FXML
  private TableColumn<Software, Double> tableColumnVersion;
  @FXML
  private TableColumn<Software, String> tableColumnDisponibilidad;
  @FXML
  private TableColumn<Software, String> tableColumnSO;
  @FXML
  private TableColumn<Software, String> tableColumnIdioma;

  ObservableList<Software> softwars;
  private int posicionSoftware;
  // Botones
  @FXML
  private Button buttonActualizar;
  @FXML
  private Button buttonAgregar;
  @FXML
  private Button buttonEditar;
  @FXML
  private Button buttonDeshabilitar;
  @FXML
  private Button buttonRegresar;

  FxmlAdministrarSoftwareController controlAdminSoftware;

  @Override
  public void initialize(java.net.URL location, ResourceBundle resources) {
    controlAdminSoftware = this;

    buttonActualizar.setOnAction((ActionEvent event) -> {
      this.inicializarTabla();
    });

    buttonEditar.setDisable(true);
    buttonDeshabilitar.setDisable(true);

    // seleccion de las tuplas
    ObservableList<Software> seleccion = tabladeSoftware.getSelectionModel().getSelectedItems();
    seleccion.addListener(selector);

    buttonEditar.setOnAction((event) -> {
      try {
        Stage primaryStage = (Stage) buttonEditar.getScene().getWindow();
        Software auxiliar = new Software();
        auxiliar = seleccion.get(0);
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/interfazGrafica/FxmlModificarSoftware.fxml"));
        Parent root = loader.load();
        FxmlModificarSoftwareController controlModifSoftware =
            loader.<FxmlModificarSoftwareController>getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.toFront();
        stage.show();
        controlModifSoftware.traerSoftware(auxiliar);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    });

    buttonDeshabilitar.setOnAction(new EventHandler() {
      @Override
      public void handle(Event event) {
        Software software = new Software();
        software = seleccion.get(0);

        String idSoftware = software.getIdSoftware();
        String nombreSoftware = software.getNombre();

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Deshabilitacion de software");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText(
            "¿Deshabilitar Id: " + idSoftware + "\nNombre: " + nombreSoftware + "?");

        ButtonType btEliminar = new ButtonType("Deshabilitar");
        ButtonType btCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        confirmacion.getButtonTypes().setAll(btEliminar, btCancelar);

        Optional<ButtonType> eleccion = confirmacion.showAndWait();

        if (eleccion.get() == btEliminar) {
          SoftwareDao softwaredao = new SoftwareDao();
          softwaredao.eliminarSoftware(software);
          tabladeSoftware.refresh();
        }
      }
    });

    buttonAgregar.setOnAction((event) -> {
      Stage primaryStage = (Stage) buttonAgregar.getScene().getWindow();
      Parent root = null;
      try {
        root = FXMLLoader.load(getClass().getResource("/interfazGrafica/FxmlAgregarSoftware.fxml"));
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      Scene scene = new Scene(root);

      Stage appStage = new Stage();
      appStage.setScene(scene);
      appStage.toFront();
      appStage.show();
    });

    buttonRegresar.setOnAction((ActionEvent event) -> {
      Stage stage = (Stage) buttonRegresar.getScene().getWindow();
      stage.close();
    });

  }

  private final ListChangeListener<Software> selector = new ListChangeListener<Software>() {
    @Override
    public void onChanged(ListChangeListener.Change<? extends Software> c) {
      ponerSoftwareSeleccionado();
    }
  };

  /**
   * permite obtener el elemento seleccionado de la tabla
   * 
   * @return elemento seleccionado
   */
  public Software getSoftwareSeleccionado() {
    if (tabladeSoftware != null) {
      List<Software> tabla = tabladeSoftware.getSelectionModel().getSelectedItems();
      if (tabla.size() == 1) {
        final Software seleccionada = tabla.get(0);
        return seleccionada;
      }
    }
    return null;
  }

  private void ponerSoftwareSeleccionado() {
    final Software software = getSoftwareSeleccionado();
    posicionSoftware = softwars.indexOf(software);
    if (software != null) {
      buttonEditar.setDisable(false);
      buttonDeshabilitar.setDisable(false);
    }
  }

  private void inicializarTabla() {
    List softwares;
    SoftwareDao softwareDao = new SoftwareDao();
    softwares = softwareDao.obtenerListaSoftware();
    tableColumnIdSoftware
        .setCellValueFactory(new PropertyValueFactory<Software, String>("idSoftware"));
    tableColumnNombreDeSoftware
        .setCellValueFactory(new PropertyValueFactory<Software, String>("nombre"));
    tableColumnOrigen.setCellValueFactory(new PropertyValueFactory<Software, String>("origen"));
    tableColumnObservaciones
        .setCellValueFactory(new PropertyValueFactory<Software, String>("observaciones"));
    tableColumnFecha
        .setCellValueFactory(new PropertyValueFactory<Software, Date>("fechaAdquisicion"));
    tableColumnTipo.setCellValueFactory(new PropertyValueFactory<Software, String>("tipoSoftware"));
    tableColumnMarca.setCellValueFactory(new PropertyValueFactory<Software, String>("marca"));
    tableColumnActualizacion
        .setCellValueFactory(new PropertyValueFactory<Software, String>("requiereActualizacion"));
    tableColumnVersion.setCellValueFactory(new PropertyValueFactory<Software, Double>("version"));
    tableColumnDisponibilidad
        .setCellValueFactory(new PropertyValueFactory<Software, String>("disponible"));
    tableColumnSO
        .setCellValueFactory(new PropertyValueFactory<Software, String>("sistemaOperativo"));
    tableColumnIdioma.setCellValueFactory(new PropertyValueFactory<Software, String>("idioma"));

    softwars = FXCollections.observableArrayList(softwares);
    tabladeSoftware.setItems(softwars);
  }
}
