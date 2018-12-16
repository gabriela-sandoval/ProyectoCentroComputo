package controlador;

import CentroComputo.Software;
import Daos.SoftwareDao;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * 
 * @author Irasema
 */
public class FxmlAdministrarSoftwareController implements Initializable {
  
  @FXML
  private ImageView imageViewLogo;
  
  @FXML
  private Text textAdministrarSoftware;
  @FXML
  private Text textJefeDelCentroDeComputo;
  @FXML
  private Text textRegresar;
  
  @FXML
  private TextField textFieldBuscar;
   
  //Tabla
  @FXML
  private TableView<Software> tabladeSoftware;
  @FXML
  private TableColumn tableColumnIdSoftware;
  @FXML
  private TableColumn tableColumnNombreDeSoftware;
  @FXML
  private TableColumn tableColumnOrigen;
  @FXML
  private TableColumn tableColumnObservaciones;
  @FXML
  private TableColumn tableColumnFecha;
  @FXML
  private TableColumn tableColumnTipo;
  @FXML
  private TableColumn tableColumnMarca;
  @FXML
  private TableColumn tableColumnActualizacion;
  @FXML
  private TableColumn tableColumnVersion;
  @FXML
  private TableColumn tableColumnDisponibilidad;
  @FXML
  private TableColumn tableColumnSO;
  @FXML
  private TableColumn tableColumnIdioma;
  ObservableList <Software> softwars;
  private int posicionSoftware;
  
  //Botones
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

    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        //llenarTabladeSoftware();
        buttonActualizar.setOnAction((ActionEvent event) -> {
            this.inicializarTabla();
        });
               
        buttonEditar.setDisable(true);
        buttonDeshabilitar.setDisable(true);
        //seleccion de las tuplas
        final ObservableList<Software> tablaSoftware = tabladeSoftware.getSelectionModel().getSelectedItems();
        tablaSoftware.addListener(selector);
        
        buttonRegresar.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) buttonRegresar.getScene().getWindow();
            stage.close();
        });
        
        buttonAgregar.setOnAction((event)-> {
        Stage primaryStage = (Stage) buttonAgregar.getScene().getWindow();
        Parent root = null;
        try {
              root = FXMLLoader.load(getClass().getResource(
                      "/interfazGrafica/FxmlAgregarSoftware.fxml"));       
        } catch (IOException ex) {
              ex.printStackTrace();
          }
          Scene scene = new Scene(root);
          
          Stage appStage = new Stage();
          appStage.setScene(scene);
          appStage.toFront();
          appStage.show();                   
        });
        
        buttonEditar.setOnAction((event) -> {
            
        });
        
    }
    
    private final ListChangeListener<Software> selector = new ListChangeListener<Software>() {
      @Override
      public void onChanged(ListChangeListener.Change<? extends Software> c) {
          ponerSoftwareSeleccionado();
      }
  };
    
    public Software getSoftwareSeleccionado() {
        if (tabladeSoftware != null) {
            List<Software> tabla = tabladeSoftware.getSelectionModel().getSelectedItems();
            if(tabla.size()==1) {
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
        
        tableColumnIdSoftware.setCellValueFactory(new PropertyValueFactory<>("idSoftware"));
        tableColumnNombreDeSoftware.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumnOrigen.setCellValueFactory(new PropertyValueFactory<>("origen"));
        tableColumnObservaciones.setCellValueFactory(new PropertyValueFactory<>("observaciones"));
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fechaAdquisicion"));
        tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipoSoftware"));
        tableColumnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tableColumnActualizacion.setCellValueFactory(new PropertyValueFactory<>("requiereActualizacion"));
        tableColumnVersion.setCellValueFactory(new PropertyValueFactory<>("version"));
        tableColumnDisponibilidad.setCellValueFactory(new PropertyValueFactory<>("disponible"));
        tableColumnSO.setCellValueFactory(new PropertyValueFactory<>("sistemaOperativo"));
        tableColumnIdioma.setCellValueFactory(new PropertyValueFactory<>("idioma"));
        
        softwars = FXCollections.observableArrayList(softwares);
        
        tabladeSoftware.setItems(softwars);
    }
    
    
    
    /**
    public void llenarTabladeSoftware() {
        //muestra la tabla
        tabladeSoftware.refresh();
        List inventarioSoftware;
        SoftwareDao softwareDao = new SoftwareDao();
        inventarioSoftware = softwareDao.obtenerListaSoftware();
        ObservableList<Software> softwares = FXCollections.observableArrayList(
                inventarioSoftware);
        tableColumnIdSoftware.setCellFactory(new PropertyValueFactory<>("idSoftware"));
        tableColumnNombreDeSoftware.setCellFactory(new PropertyValueFactory<>("nombre"));
        tableColumnOrigen.setCellFactory(new PropertyValueFactory<>("origen"));
        tableColumnObservaciones.setCellFactory(new PropertyValueFactory<>("observaciones"));
        tableColumnFecha.setCellFactory(new PropertyValueFactory<>("fechaAdquisicion"));
        tableColumnTipo.setCellFactory(new PropertyValueFactory<>("tipoSoftware"));
        tableColumnMarca.setCellFactory(new PropertyValueFactory<>("marca"));
        tableColumnActualizacion.setCellFactory(new PropertyValueFactory<>("requiereActualizacion"));
        tableColumnVersion.setCellFactory(new PropertyValueFactory<>("version"));
        tableColumnDisponibilidad.setCellFactory(new PropertyValueFactory<>("disponible"));
        tableColumnSO.setCellFactory(new PropertyValueFactory<>("sistemaOperativo"));
        tableColumnIdioma.setCellFactory(new PropertyValueFactory<>("idioma"));
        
        tabladeSoftware.setVisible(true);
        
        tabladeSoftware.getColumns().addAll(tableColumnIdSoftware, tableColumnNombreDeSoftware, 
                tableColumnOrigen, tableColumnObservaciones, tableColumnFecha, tableColumnTipo,
                tableColumnMarca, tableColumnActualizacion, tableColumnVersion, tableColumnDisponibilidad,
                tableColumnSO, tableColumnIdioma);
        tabladeSoftware.setItems(softwares);                   
    }
*/

    
}

/**
 * SimpleIntegerProperty edad = new SimpleIntegerProperty(persona.getEdad());
 */