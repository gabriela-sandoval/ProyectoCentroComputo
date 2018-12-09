/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import CentroComputo.Software;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author Irasema Caicero
 */
public class SoftwareDao implements InterfaceSoftwareDao {
    private String consulta;
    private List<Software> listaSoftware;
    

    @Override
    public boolean agregarSoftware(Software software) {
        
        consulta= "insert into software values (?, ?, ?, ?, ?)";
        try(PreparedStatement consultaparametrizada = AccesoDataBase){
            
            
            
        }
    }

    @Override
    public boolean actualizarSoftware(Software software) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Software> obtenerListaSoftware() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Software buscarSoftware(String idSoftware) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarSoftware(String idSoftware) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
