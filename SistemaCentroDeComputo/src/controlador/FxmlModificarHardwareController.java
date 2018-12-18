package interfazGrafica;

import CentroComputo.Hardware;
import CentroComputo.Validador;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author irasema caicero
 */
public class FxmlModificarHardwareController implements Initializable {

    //cajas de texto y combo box
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
    
    Hardware hardware;
    
    
    
  @Override
  public void initialize(URL url, ResourceBundle rb) {
      ObservableList<String> estados = FXCollections.observableArrayList();
      estados.addAll("Disponible", "Deshabilitado", "prestado", "En mantenimiento");
      comboBoxEstado.setItems(estados);
      
      
      
      buttonGuardar.setOnAction((ActionEvent event) -> {
          Validador validador = new Validador();
          boolean noInventarioValidado = validador.validarNoInventarioHardware(textFieldNoInventario.getText());
          if(noInventarioValidado == true) {
           
              comboBoxEstado.setOnAction(e -> System.out.println("selecciona un estado: " + comboBoxEstado.getValue()));
              
              
          }
          // agregar ventana emergente---------------------------------------
          Alert alerta = new Alert(Alert.AlertType.INFORMATION);
          alerta.setTitle("hardware no Guardado");
          alerta.setHeaderText(null);
          alerta.setContentText("revise que los datos sean correctos");
          alerta.show();
          
          
      });
   
  }

}
