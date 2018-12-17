package CentroComputo;

import java.sql.Date;

/**
 * clase de hardware a administrar
 * 
 * @author Irasema Caicero
 * @since 19/11/18
 * @version 1.0
 */
public class Hardware {
  private final String DISPONIBLE = "disponible";
  private final String DESHABILITADO = "deshabilitado";
  private final String PRESTADO = "prestado";
  private final String EN_MANTENIMIENTO = "en mantenimiento";
  private String noInventarioUv;
  private String marca;
  private String modelo;
  private int numeroSerie;
  private String estado;
  private String tipoDispositivo;
  private Date fechaAdquisicion;



  public Hardware(String noInventarioUv, String marca, String modelo, int numeroSerie,
      String estado, String tipoDispositivo, Date fechaAdquisicion) {
    this.noInventarioUv = noInventarioUv;
    this.marca = marca;
    this.modelo = modelo;
    this.numeroSerie = numeroSerie;
    this.estado = estado;
    this.tipoDispositivo = tipoDispositivo;
    this.fechaAdquisicion = fechaAdquisicion;

  }

  public Hardware() {

  }

  public String getNoInventarioUv() {
    return noInventarioUv;
  }

  public int getNumeroSerie() {
    return numeroSerie;
  }

  public String getModelo() {
    return modelo;
  }

  public String getMarca() {
    return marca;
  }

  public String getTipoDispositivo() {
    return tipoDispositivo;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Date getFechaAdquisicion() {
    return fechaAdquisicion;
  }

  public void setNoInventarioUv(String noInventarioUv) {
    this.noInventarioUv = noInventarioUv;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setNumeroSerie(int numeroSerie) {
    this.numeroSerie = numeroSerie;
  }

  public void setTipoDispositivo(String tipoDispositivo) {
    this.tipoDispositivo = tipoDispositivo;
  }

  public void setFechaAdquisicion(Date fechaAdquisicion) {
    this.fechaAdquisicion = fechaAdquisicion;
  }

  /**
   * gestiona los tipos de estados que tiene un hardware
   * 
   * @param estadoNuevo a cambiar
   * @return estado cambiado
   */
  public boolean CambiarEstado(String estadoNuevo) {
    boolean resultado = false;
    switch (estado) {
      case DISPONIBLE:
        if (estadoNuevo.equals(PRESTADO)) {
          setEstado(estadoNuevo);
          resultado = true;
        }
        if (estadoNuevo.equals(DESHABILITADO)) {
          setEstado(estadoNuevo);
          resultado = true;
        }
        break;

      case DESHABILITADO:
        if (estadoNuevo.equals(DISPONIBLE)) {
          setEstado(estadoNuevo);
          resultado = true;
        }

      case PRESTADO:
        if (estadoNuevo.equals(DISPONIBLE)) {
          setEstado(estadoNuevo);
          resultado = true;
        }
        if (estadoNuevo.equals(EN_MANTENIMIENTO)) {
          setEstado(estadoNuevo);
          resultado = true;
        }

      case EN_MANTENIMIENTO:
        if (estadoNuevo.equals(DISPONIBLE)) {
          setEstado(estadoNuevo);
          resultado = true;
        }
        if (estadoNuevo.equals(DESHABILITADO)) {
          setEstado(estadoNuevo);
          resultado = true;
        }
    }
    return resultado;
  }

}
