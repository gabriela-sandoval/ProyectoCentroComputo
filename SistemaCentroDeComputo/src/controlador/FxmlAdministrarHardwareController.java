package controlador;

import CentroComputo.Hardware;
import Daos.HardwareDao;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * Controlador de la interfaz Administrar Hardware
 * 
 * @author Irasema Caicero
 * @since 18/12/2018
 * @version 1.0
 */
public class FxmlAdministrarHardwareController implements Initializable {
  // Tabla
  @FXML
  private TableView<Hardware> tablaHardware;
  @FXML
  private TableColumn columnaNoInventario;
  @FXML
  private TableColumn columnaMarca;
  @FXML
  private TableColumn columnaModelo;
  @FXML
  private TableColumn columnaNumeroSerie;
  @FXML
  private TableColumn columnaEstado;
  @FXML
  private TableColumn columnaTipo;
  @FXML
  private TableColumn columnaFecha;
  @FXML
  private TableColumn columnaUbicacion;
  @FXML
  private TableColumn columnaResponsable;

  ObservableList<Hardware> equipos;
  private int posicion;
  // Botones
  @FXML
  private Button buttonAgregar;
  @FXML
  private Button buttonEditar;
  @FXML
  private Button buttonDeshabilitar;
  @FXML
  private Button buttonActualizar;
  @FXML
  private Button buttonRegresar;

  FxmlAdministrarHardwareController controlAdminHardware;

  public void initialize(URL url, ResourceBundle rb) {
    controlAdminHardware = this;

    buttonActualizar.setOnAction((ActionEvent event) -> {
      this.inicializarTabla();
    });

    buttonEditar.setDisable(true);
    buttonDeshabilitar.setDisable(true);
    ObservableList<Hardware> seleccion = tablaHardware.getSelectionModel().getSelectedItems();
    seleccion.addListener(selector);

    buttonRegresar.setOnAction((ActionEvent event) -> {
      Stage stage = (Stage) buttonRegresar.getScene().getWindow();
      stage.close();
    });

    buttonAgregar.setOnAction((event) -> {
      Stage stage = (Stage) buttonAgregar.getScene().getWindow();
      Parent ruta = null;
      try {
        ruta = FXMLLoader.load(getClass().getResource("/interfazGrafica/FxmlAgregarHardware.fxml"));
      } catch (IOException ex) {
        Logger.getLogger(FxmlAdministrarHardwareController.class.getName()).log(Level.SEVERE, null,
            ex);
      }
      Scene scene = new Scene(ruta);
      Stage nuevo = new Stage();
      nuevo.setScene(scene);
      nuevo.toFront();
      nuevo.show();
    });

    buttonEditar.setOnAction((ActionEvent event) -> {
      try {
        Stage stagePrimaria = (Stage) buttonEditar.getScene().getWindow();
        Hardware auxiliar = new Hardware();
        auxiliar = seleccion.get(0);
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/interfazGrafica/FxmlModificarHardware.fxml"));
        Parent ruta = loader.load();
        FxmlModificarHardwareController controlModificar =
            (FxmlModificarHardwareController) loader.getController();

        Scene escena = new Scene(ruta);
        stage.setScene(escena);
        stage.toFront();
        stage.show();
        controlModificar.traerHardware(auxiliar);
      } catch (IOException ex) {
        Logger.getLogger(FxmlAdministrarHardwareController.class.getName()).log(Level.SEVERE, null,
            ex);
      }

    });

    buttonDeshabilitar.setOnAction(new EventHandler() {
      @Override
      public void handle(Event event) {
        Hardware hardware = new Hardware();
        hardware = seleccion.get(0);

        String noInventarioUv = hardware.getNoInventarioUv();
        String nombreHardware = hardware.getTipoDispositivo();
        String marca = hardware.getMarca();
        String modelo = hardware.getModelo();

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Deshabilitacion del equipo");
        confirmacion.setHeaderText(null);
        confirmacion
            .setContentText("¿Eliminar el equipo " + nombreHardware + " de la marca " + marca
                + " modelo: " + modelo + " con el numero de inventario: " + noInventarioUv + "?");

        ButtonType btDeshabilitar = new ButtonType("Deshabilitar");
        ButtonType btCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        confirmacion.getButtonTypes().setAll(btDeshabilitar, btCancelar);

        Optional<ButtonType> eleccion = confirmacion.showAndWait();

        if (eleccion.get() == btDeshabilitar) {
          HardwareDao hardwareDao = new HardwareDao();
          hardwareDao.eliminarHardware(hardware);
          tablaHardware.refresh();
        }
      }
    });
  }


  private final ListChangeListener<Hardware> selector = new ListChangeListener<Hardware>() {
    @Override
    public void onChanged(ListChangeListener.Change<? extends Hardware> c) {
      ponerHardwareSeleccionado();
    }
  };

  /**
   * método que permite obtener el elemento seleccionado
   * 
   * @return Hardware seleccionado
   */
  public Hardware getHardwareSeleccionado() {
    if (tablaHardware != null) {
      List<Hardware> tabla = tablaHardware.getSelectionModel().getSelectedItems();
      if (tabla.size() == 1) {
        final Hardware seleccionada = tabla.get(0);
        return seleccionada;
      }
    }
    return null;
  }

  private void ponerHardwareSeleccionado() {
    final Hardware hardware = getHardwareSeleccionado();
    posicion = equipos.indexOf(hardware);
    if (hardware != null) {
      buttonEditar.setDisable(false);
      buttonDeshabilitar.setDisable(false);
    }
  }

  private void inicializarTabla() {
    List hardwars;
    HardwareDao hardwareDao = new HardwareDao();
    hardwars = hardwareDao.obtenerListaHardware();

    columnaNoInventario
        .setCellValueFactory(new PropertyValueFactory<Hardware, String>("noInventarioUv"));
    columnaMarca.setCellValueFactory(new PropertyValueFactory<Hardware, String>("marca"));
    columnaModelo.setCellValueFactory(new PropertyValueFactory<Hardware, String>("modelo"));
    columnaNumeroSerie
        .setCellValueFactory(new PropertyValueFactory<Hardware, Integer>("numeroSerie"));
    columnaEstado.setCellValueFactory(new PropertyValueFactory<Hardware, String>("estado"));
    columnaTipo.setCellValueFactory(new PropertyValueFactory<Hardware, String>("tipoDispositivo"));
    columnaFecha.setCellValueFactory(new PropertyValueFactory<Hardware, Date>("fechaAdquisicion"));
    columnaUbicacion.setCellValueFactory(new PropertyValueFactory<Hardware, String>("ubicacion"));
    columnaResponsable
        .setCellValueFactory(new PropertyValueFactory<Hardware, String>("responsable"));

    equipos = FXCollections.observableArrayList(hardwars);
    tablaHardware.setItems(equipos);
  }
}
