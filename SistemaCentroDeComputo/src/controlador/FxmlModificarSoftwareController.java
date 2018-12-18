package controlador;

import CentroComputo.Software;
import Daos.SoftwareDao;
import CentroComputo.Validador;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controlador de la interfaz de modificar software
 *
 * @author Irasema Caicero Franco
 * @since 12/12/18
 * @version 1.0
 */
public class FxmlModificarSoftwareController implements Initializable {
  // cajas de texto
  @FXML
  private TextField textFieldIdSoftware;
  @FXML
  private TextField textFieldNombre;
  @FXML
  private TextField textFieldOrigen;
  @FXML
  private TextField textFieldObservaciones;
  @FXML
  private TextField textFieldFecha;
  @FXML
  private TextField textFieldTipo;
  @FXML
  private TextField textFieldMarca;
  @FXML
  private TextField textFieldActualizacion;
  @FXML
  private TextField textFieldVersion;
  @FXML
  private TextField textFieldDisponible;
  @FXML
  private TextField textFieldSO;
  @FXML
  private TextField textFieldIdioma;
  // Botones
  @FXML
  private Button buttonGuardar;
  @FXML
  private Button buttonSalir;

  FxmlAdministrarSoftwareController controlAdmSoftware;
  Software software;

  /**
   * inicializa los botones agregando sus eventos
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {

    buttonGuardar.setOnAction(new EventHandler() {
      @Override
      public void handle(Event event) {
        Validador validador = new Validador();

        boolean idValidacion = validador.validaIdSoftware(textFieldIdSoftware.getText());
        boolean fechaValida = validador.validarEstructuraFecha(textFieldFecha.getText()) && validador.validarFechaMaxima(textFieldFecha.getText());
        if (idValidacion == true && fechaValida == true) {
          String idSoftware = textFieldIdSoftware.getText();
          String nombreSoftware = textFieldNombre.getText();
          String origen = textFieldOrigen.getText();
          String observaciones = textFieldObservaciones.getText();
          Date fechaAdquisicion = Date.valueOf(textFieldFecha.getText());
          String tipoSoftware = textFieldTipo.getText();
          String marca = textFieldMarca.getText();
          Boolean requiereActualizacion = Boolean.parseBoolean(textFieldActualizacion.getText());
          Double version = Double.parseDouble(textFieldVersion.getText());
          Boolean disponible = Boolean.parseBoolean(textFieldDisponible.getText());
          String sistemaOperativo = textFieldSO.getText();
          String idioma = textFieldIdioma.getText();

          SoftwareDao softwareDao = new SoftwareDao();
          boolean resultadoActualizacion = softwareDao.actualizarSoftware(new Software(idSoftware,
              nombreSoftware, origen, observaciones, fechaAdquisicion, tipoSoftware, marca,
              requiereActualizacion, version, disponible, sistemaOperativo, idioma));

          if(resultadoActualizacion == true) {
          Alert alerta = new Alert(Alert.AlertType.INFORMATION);
          alerta.setTitle("Software Guardado");
          alerta.setHeaderText(null);
          alerta.setContentText("Los datos han sido guardados! :D Recuerda Actualizar la tabla!");
          alerta.show();
          } else {
          Alert alerta = new Alert(Alert.AlertType.ERROR);
          alerta.setTitle("Software NO Guardado");
          alerta.setHeaderText(null);
          alerta.setContentText("No se guardaron los cambios...");
          alerta.show();
          }
        } else {
          Alert alerta = new Alert(Alert.AlertType.WARNING);
          alerta.setTitle("Datos Inválidos");
          alerta.setHeaderText(null);
          alerta.setContentText("Revise que los datos sean correctos.");
          alerta.show();
        }
      }
    });

    buttonSalir.setOnAction((ActionEvent event) -> {
      Stage stage = (Stage) buttonSalir.getScene().getWindow();
      stage.close();
    });
  }

  /**
   * obtiene el software que se selecciono a editar y los muestra en la ventana
   * @param auxiliar software que fue seleccionado a editar 
   */
  public void traerSoftware(Software auxiliar) {
    textFieldIdSoftware.setText(auxiliar.getIdSoftware());
    textFieldNombre.setText(auxiliar.getNombre());
    textFieldOrigen.setText(auxiliar.getOrigen());
    textFieldObservaciones.setText(auxiliar.getObservaciones());
    textFieldFecha.setText(String.valueOf(auxiliar.getFechaAdquisicion()));
    textFieldTipo.setText(auxiliar.getTipoSoftware());
    textFieldMarca.setText(auxiliar.getMarca());
    textFieldActualizacion.setText(String.valueOf(auxiliar.isRequiereActualizacion()));
    textFieldVersion.setText(String.valueOf(auxiliar.getVersion()));
    textFieldDisponible.setText(String.valueOf(auxiliar.isDisponible()));
    textFieldSO.setText(auxiliar.getSistemaOperativo());
    textFieldIdioma.setText(auxiliar.getIdioma());
    this.software = auxiliar;
  }
}
