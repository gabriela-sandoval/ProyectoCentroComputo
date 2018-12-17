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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Irasema Caicero Franco
 */
public class FxmlModificarSoftwareController implements Initializable {
    //cajas de texto
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
    private TextField textFieldSo;
    @FXML
    private TextField textFieldIdioma;
    //Botones
    @FXML
    private Button buttonGuardar;
    @FXML
    private Button buttonSalir;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Software softwareAuxiliar = new Software();
        //softwareAuxiliar= extraerSoftwareSeleccionado();
       
        FXMLLoader loader = new FXMLLoader();
        FxmlAdministrarSoftwareController controlAdminSoftware = (FxmlAdministrarSoftwareController) loader.getController();
        
         
        Software softwareAuxiliar = new Software();
        softwareAuxiliar = controlAdminSoftware.softwars.get(0);
        
        textFieldIdSoftware.setText(softwareAuxiliar.getIdSoftware());
        textFieldNombre.setText(softwareAuxiliar.getNombre());
        textFieldOrigen.setText(softwareAuxiliar.getOrigen());
        textFieldObservaciones.setText(softwareAuxiliar.getObservaciones());
        //textFieldFecha.setText(softwareAuxiliar.getFechaAdquisicion());
        textFieldTipo.setText(softwareAuxiliar.getTipoSoftware());
        textFieldMarca.setText(softwareAuxiliar.getTipoSoftware());
        textFieldActualizacion.setText(softwareAuxiliar.getTipoSoftware());
        textFieldVersion.setText(softwareAuxiliar.getTipoSoftware());
        textFieldDisponible.setText(softwareAuxiliar.getTipoSoftware());
        textFieldSo.setText(softwareAuxiliar.getTipoSoftware());
        textFieldIdioma.setText(softwareAuxiliar.getTipoSoftware()); 
        
        buttonGuardar.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                SoftwareDao softwareDao = new SoftwareDao();
                
                String idSoftware= textFieldIdSoftware.getText();
                String nombreSoftware = textFieldNombre.getText();
                String origen= textFieldOrigen.getText();
                String observaciones= textFieldObservaciones.getText();
                Date fechaAdquisicion = Date.valueOf(textFieldFecha.getText());
                String tipoSoftware = textFieldTipo.getText();
                String marca = textFieldMarca.getText();
                Boolean requiereActualizacion = Boolean.parseBoolean(textFieldActualizacion.getText());
                Double version = Double.parseDouble(textFieldVersion.getText());
                Boolean disponible= Boolean.parseBoolean(textFieldDisponible.getText());
                String sistemaOperativo = textFieldSo.getText();
                String idioma = textFieldIdioma.getText();
                
                Software software = new Software(idSoftware, nombreSoftware, origen, 
                observaciones, fechaAdquisicion, tipoSoftware, marca, 
                requiereActualizacion, version, disponible, sistemaOperativo, idioma);
                
                softwareDao.actualizarSoftware(software);
                //agregar ventana emergente---------------------------------------
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Software Guardado");
                alerta.setHeaderText(null);
                alerta.setContentText("Los datos han sido guardados! :D");
                alerta.show();     
            }   
        });
        
        buttonSalir.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) buttonSalir.getScene().getWindow();
            stage.close();
        });
    }
    
   /*
    private Software extraerSoftwareSeleccionado() {
        
        FXMLLoader loader = new FXMLLoader();
        FxmlAdministrarSoftwareController controlAdminSoftware = (FxmlAdministrarSoftwareController) loader.getController();
        
        Software softwareAuxiliar = new Software();
        softwareAuxiliar = controlAdminSoftware.getSoftwareSeleccionado();
        controlAdminSoftware.softwars.get(0);
        /*
        textFieldIdSoftware.setText(softwareAuxiliar.getIdSoftware());
        textFieldNombre.setText(softwareAuxiliar.getNombre());
        textFieldOrigen.setText(softwareAuxiliar.getOrigen());
        textFieldObservaciones.setText(softwareAuxiliar.getObservaciones());
        //textFieldFecha.setText(softwareAuxiliar.getFechaAdquisicion());
        textFieldTipo.setText(softwareAuxiliar.getTipoSoftware());
        textFieldMarca.setText(softwareAuxiliar.getTipoSoftware());
        textFieldActualizacion.setText(softwareAuxiliar.getTipoSoftware());
        textFieldVersion.setText(softwareAuxiliar.getTipoSoftware());
        textFieldDisponible.setText(softwareAuxiliar.getTipoSoftware());
        textFieldSo.setText(softwareAuxiliar.getTipoSoftware());
        textFieldIdioma.setText(softwareAuxiliar.getTipoSoftware());   
        return null;
    }
  */  

    
    
}
