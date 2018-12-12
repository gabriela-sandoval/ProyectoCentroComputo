/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import CentroComputo.Software;
import Daos.SoftwareDao;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author galil
 */
public class FxmlAgregarSoftwareController implements Initializable {
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldOrigen;
    @FXML
    private TextField textFieldObservaciones;
    @FXML
    private DatePicker datePickerFecha;
    @FXML
    private TextField textFieldTipo;
    @FXML
    private TextField textFieldMarca;
    @FXML
    private TextField textFieldActualizacion;
    @FXML
    private TextField textFieldVersion;
    @FXML
    private TextField textFieldSO;
    @FXML
    private TextField textFieldIdioma;  
    @FXML
    private Button buttonGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonGuardar.setOnAction (new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {  
        SoftwareDao softwareDao = new SoftwareDao();
        String idSoftware= "";
        String nombreSoftware = textFieldNombre.getText();
        String origen= textFieldOrigen.getText();
        String observaciones= textFieldObservaciones.getText();
        Date fechaAdquisicion = Date.valueOf(datePickerFecha.getValue());
        String tipoSoftware = textFieldTipo.getText();
        String marca = textFieldMarca.getText();
        Boolean requiereActualizacion = Boolean.parseBoolean(textFieldActualizacion.getText());
        Double version = Double.parseDouble(textFieldVersion.getText());
        Boolean disponible= true;
        String sistemaOperativo = textFieldSO.getText();
        String idioma = textFieldIdioma.getText();
               
        Software software = new Software(idSoftware, nombreSoftware, origen, 
                observaciones, fechaAdquisicion, tipoSoftware, marca, 
                requiereActualizacion, version, disponible, sistemaOperativo, idioma);        
        softwareDao.agregarSoftware(software);
        
            }
        });
    }    
    
   /** @FXML
    private void guardarSoftware(ActionEvent evento) {
        if(evento.getSource()== buttonGuardar) {
        SoftwareDao softwareDao = new SoftwareDao();
        String idSoftware= "S001";
        String nombreSoftware = textFieldNombre.getText();
        String origen= textFieldOrigen.getText();
        String observaciones= textFieldObservaciones.getText();
        Date fechaAdquisicion = Date.valueOf(datePickerFecha.getValue());
        String tipoSoftware = textFieldTipo.getText();
        String marca = textFieldMarca.getText();
        Boolean requiereActualizacion = Boolean.parseBoolean(textFieldActualizacion.getText());
        Double version = Double.parseDouble(textFieldVersion.getText());
        Boolean disponible= true;
        String sistemaOperativo = textFieldSO.getText();
        String idioma = textFieldIdioma.getText();
               
        Software software = new Software(idSoftware, nombreSoftware, origen, 
                observaciones, fechaAdquisicion, tipoSoftware, marca, 
                requiereActualizacion, version, disponible, sistemaOperativo, idioma);        
        softwareDao.agregarSoftware(software);
        }
    }
   **/
}
