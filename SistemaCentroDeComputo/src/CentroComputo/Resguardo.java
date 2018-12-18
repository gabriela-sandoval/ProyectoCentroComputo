package CentroComputo;

import java.sql.Date;

/**
 * clase de resguardo 
 * 
 * @author Irasema Caicero
 * @since 10/12/18
 * @version 1.0
 */
public class Resguardo {
  private Responsable responsable;
  private Hardware equipo;
  private Date fechaPrestamo;

  public Resguardo(Responsable responsable, Hardware equipo, Date fechaPrestamo) {
    super();
    this.responsable = responsable;
    this.equipo = equipo;
    this.fechaPrestamo = fechaPrestamo;
  }

  public Responsable getResponsable() {
    return responsable;
  }

  public Hardware getEquipo() {
    return equipo;
  }

  public Date getFechaPrestamo() {
    return fechaPrestamo;
  }
}
