/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import CentroComputo.Hardware;
import java.util.List;

/**
 *
 * @author Irasema Caicero
 */
public interface InterfaceHardwareDao {
    public boolean agregarSoftware(Hardware hardware);
    public boolean actualizarSoftware(Hardware hardware);
    public List<Hardware> obtenerListaSoftware();
    public Hardware buscarSoftware(String idSoftware);
    public boolean eliminarSoftware(String noIventarioUv);   
    
}
