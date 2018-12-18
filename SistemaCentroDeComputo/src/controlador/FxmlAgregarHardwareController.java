package controlador;

import CentroComputo.Hardware;
import CentroComputo.Validador;
import Daos.HardwareDao;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class de la interfaz agregar hardware
 *
 * @author Irasema Caicero
 * @since 18/12/18
 * @version 1.0
 */
public class FxmlAgregarHardwareController implements Initializable {
    @FXML
    private TextField textFieldNoInventario;
    @FXML
    private TextField textFieldMarca;
    @FXML
    private TextField textFieldResponsable;
    @FXML
    private TextField textFieldTipo;
    @FXML
    private TextField textFieldFecha;
    @FXML
    private TextField textFieldModelo;
    @FXML
    private TextField textFieldNoSerie;
    @FXML
    private TextField textFieldUbicación;
    @FXML
    private ComboBox<String> comboBoxEstado;
    //botones
    @FXML
    private Button buttonGuardar;
    @FXML
    private Button buttonSalir;

  /**
   * Inicializa los botones de los eventos
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
      ObservableList<String> estados = FXCollections.observableArrayList();
      estados.addAll("Disponible", "Deshabilitado", "prestado", "En mantenimiento");
      comboBoxEstado.setItems(estados);
      
      comboBoxEstado.setOnAction(e -> System.out.println("selecciona un estado: " + comboBoxEstado.getValue()));

    
      buttonGuardar.setOnAction(new EventHandler() {
          @Override
          public void handle(Event event) {
              HardwareDao hardwareDao = new HardwareDao();
              Validador validador = new Validador();
              
              boolean noInventarioValidado = validador.validarNoInventarioHardware(textFieldNoInventario.getText());
              boolean fechaValidada = validador.validarEstructuraFecha(textFieldFecha.getText()) && validador.validarFechaMaxima(textFieldFecha.getText());
              boolean numSerie = validador.validarNumeroSerie(textFieldNoSerie.getText());
              if(noInventarioValidado == true && fechaValidada == true && numSerie == true) {
              
              String noInventarioUv = textFieldNoInventario.getText();
              String marca = textFieldMarca.getText();
              String modelo = textFieldModelo.getText();
              int numerodeSerie = Integer.parseInt(textFieldNoSerie.getText());
              String estado = comboBoxEstado.getValue();
              String tipoDispositivo = textFieldTipo.getText();
              Date fecha = Date.valueOf(textFieldFecha.getText());
              String responsable = textFieldResponsable.getText();
              String ubicacion = textFieldUbicación.getText();
              
              boolean resultadoGuardado =  hardwareDao.agregarHardware(new Hardware(noInventarioUv, marca, modelo, numerodeSerie,
              estado, tipoDispositivo, fecha, responsable, ubicacion));
              
              if (resultadoGuardado == true) {
                  Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                  alerta.setTitle("Hardware Guardado");
                  alerta.setHeaderText(null);
                  alerta.setContentText("Los datos han sido guardados! :D"
                          + " Recuerda actualizar la tabla!!");
                  alerta.show();   
              } else {
                  Alert alerta = new Alert(Alert.AlertType.ERROR);
                  alerta.setTitle("hardware NO Guardado");
                  alerta.setHeaderText(null);
                  alerta.setContentText("No se guardó el hardware");
                  alerta.show();
              }
              } else {
                  Alert alerta = new Alert(Alert.AlertType.WARNING);
                  alerta.setTitle("Datos Inválidos");
                  alerta.setHeaderText(null);
                  alerta.setContentText("Revise que los datos sean correctos");
                  alerta.show();
              }
          }     
  });
      
      buttonSalir.setOnAction(new EventHandler () {
          @Override
          public void handle(Event event) {
            Stage stage = (Stage) buttonSalir.getScene().getWindow();
            stage.close();
          }       
      });
  }

}
