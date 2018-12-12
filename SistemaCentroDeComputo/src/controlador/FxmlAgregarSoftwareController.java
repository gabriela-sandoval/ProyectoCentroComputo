/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import CentroComputo.Software;
import Daos.SoftwareDao;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        Stage stage = (Stage) buttonGuardar.getScene().getWindow();
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(""));
        } catch (IOException ex) {
            Logger.getLogger(FxmlAgregarSoftwareController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scence = new Scene(root);
        stage.setScene(scence);
        buttonGuardar.setOnAction((EventHandler<ActionEvent>), this));
        stage.show();
        
        
        
           
        
    }    
    
    @FXML
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
   
}
