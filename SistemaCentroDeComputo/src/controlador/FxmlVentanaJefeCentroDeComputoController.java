/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author galil
 */
public class FxmlVentanaJefeCentroDeComputoController implements Initializable {

    @FXML
    private ImageView imageViewLogo;

    @FXML
    private Text textNombreJefe;

    @FXML
    private Text textAdministrador;

    @FXML
    private Button buttonSalir;

    @FXML
    private Button buttonAdministrarSoftware;

    @FXML
    private Button buttonAdministrarHardware;

    @FXML
    private Button buttonAdministrarUsuarios;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonSalir.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) buttonSalir.getScene().getWindow();
            stage.close();
        });
        
        buttonAdministrarSoftware.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FxmlAdministrarSoftware.fxml"));
                Parent root = (Parent)loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene (root));
                stage.show();
                } catch(IOException ex) {
                Logger.getLogger(FxmlVentanaJefeCentroDeComputoController.class.getName()).log(Level.SEVERE, null, ex);
                }          
            }          
        });

        buttonAdministrarHardware.setOnMouseClicked((event) -> {
            Stage primaryStage = (Stage) buttonAdministrarHardware.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource(
                        "/FxmlSistemaCentroDeComputo.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(FxmlVentanaJefeCentroDeComputoController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            Image icono = new Image("/iconos/logo cc.png");
            primaryStage.getIcons().add(icono);
            primaryStage.setResizable(false);
            primaryStage.show();
        });
    }      
}
    
    
    
    
    
    

