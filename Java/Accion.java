/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 32 "model.ump"
// line 126 "model.ump"
public class Accion
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Accion Attributes
  private string tipoAccion;
  private date fechaEjecucion;

  //Accion Associations
  private Alerta alerta;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Accion(string aTipoAccion, date aFechaEjecucion, Alerta aAlerta)
  {
    tipoAccion = aTipoAccion;
    fechaEjecucion = aFechaEjecucion;
    if (aAlerta == null || aAlerta.getAccion() != null)
    {
      throw new RuntimeException("Unable to create Accion due to aAlerta. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    alerta = aAlerta;
  }

  public Accion(string aTipoAccion, date aFechaEjecucion, string aTipoAlertaForAlerta, string aDescripcionForAlerta, string aEstadoForAlerta, date aFechaGeneracionForAlerta, Plantacion aPlantacionForAlerta, Recomendacion aRecomendacionForAlerta)
  {
    tipoAccion = aTipoAccion;
    fechaEjecucion = aFechaEjecucion;
    alerta = new Alerta(aTipoAlertaForAlerta, aDescripcionForAlerta, aEstadoForAlerta, aFechaGeneracionForAlerta, aPlantacionForAlerta, aRecomendacionForAlerta, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTipoAccion(string aTipoAccion)
  {
    boolean wasSet = false;
    tipoAccion = aTipoAccion;
    wasSet = true;
    return wasSet;
  }

  public boolean setFechaEjecucion(date aFechaEjecucion)
  {
    boolean wasSet = false;
    fechaEjecucion = aFechaEjecucion;
    wasSet = true;
    return wasSet;
  }

  public string getTipoAccion()
  {
    return tipoAccion;
  }

  public date getFechaEjecucion()
  {
    return fechaEjecucion;
  }
  /* Code from template association_GetOne */
  public Alerta getAlerta()
  {
    return alerta;
  }

  public void delete()
  {
    Alerta existingAlerta = alerta;
    alerta = null;
    if (existingAlerta != null)
    {
      existingAlerta.delete();
    }
  }

  // line 37 "model.ump"
  public boolean ejecutarAccion(){
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tipoAccion" + "=" + (getTipoAccion() != null ? !getTipoAccion().equals(this)  ? getTipoAccion().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "fechaEjecucion" + "=" + (getFechaEjecucion() != null ? !getFechaEjecucion().equals(this)  ? getFechaEjecucion().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "alerta = "+(getAlerta()!=null?Integer.toHexString(System.identityHashCode(getAlerta())):"null");
  }
}