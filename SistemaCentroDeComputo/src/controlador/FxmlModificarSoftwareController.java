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
 * FXML Controller class
 *
 * @author Irasema Caicero Franco
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

  @Override
  public void initialize(URL url, ResourceBundle rb) {

    buttonGuardar.setOnAction(new EventHandler() {
      @Override
      public void handle(Event event) {

        Validador validador = new Validador();

        boolean idValidacion = validador.validaIdSoftware(textFieldIdSoftware.getText());
        if (idValidacion == true) {
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
          boolean resultado = softwareDao.actualizarSoftware(new Software(idSoftware,
              nombreSoftware, origen, observaciones, fechaAdquisicion, tipoSoftware, marca,
              requiereActualizacion, version, disponible, sistemaOperativo, idioma));

          // agregar ventana emergente---------------------------------------
          Alert alerta = new Alert(Alert.AlertType.INFORMATION);
          alerta.setTitle("Software Guardado");
          alerta.setHeaderText(null);
          alerta.setContentText("Los datos han sido guardados! :D");
          alerta.show();

        }
      }
    });

    buttonSalir.setOnAction((ActionEvent event) -> {
      Stage stage = (Stage) buttonSalir.getScene().getWindow();
      stage.close();
    });
  }

  public void traerSoftware(Software aux) {
    textFieldIdSoftware.setText(aux.getIdSoftware());
    textFieldNombre.setText(aux.getNombre());
    textFieldOrigen.setText(aux.getOrigen());
    textFieldObservaciones.setText(aux.getObservaciones());
    textFieldFecha.setText(String.valueOf(aux.getFechaAdquisicion()));
    textFieldTipo.setText(aux.getTipoSoftware());
    textFieldMarca.setText(aux.getMarca());
    textFieldActualizacion.setText(String.valueOf(aux.isRequiereActualizacion()));
    textFieldVersion.setText(String.valueOf(aux.getVersion()));
    textFieldDisponible.setText(String.valueOf(aux.isDisponible()));
    textFieldSO.setText(aux.getSistemaOperativo());
    textFieldIdioma.setText(aux.getIdioma());
    this.software = aux;
  }
}
