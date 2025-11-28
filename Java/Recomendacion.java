/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 102 "model.ump"
// line 166 "model.ump"
public class Recomendacion
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Recomendacion Attributes
  private string descripcion;
  private date fechaEmision;

  //Recomendacion Associations
  private Alerta alerta;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Recomendacion(string aDescripcion, date aFechaEmision, Alerta aAlerta)
  {
    descripcion = aDescripcion;
    fechaEmision = aFechaEmision;
    if (aAlerta == null || aAlerta.getRecomendacion() != null)
    {
      throw new RuntimeException("Unable to create Recomendacion due to aAlerta. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    alerta = aAlerta;
  }

  public Recomendacion(string aDescripcion, date aFechaEmision, string aTipoAlertaForAlerta, string aDescripcionForAlerta, string aEstadoForAlerta, date aFechaGeneracionForAlerta, Plantacion aPlantacionForAlerta, Accion aAccionForAlerta)
  {
    descripcion = aDescripcion;
    fechaEmision = aFechaEmision;
    alerta = new Alerta(aTipoAlertaForAlerta, aDescripcionForAlerta, aEstadoForAlerta, aFechaGeneracionForAlerta, aPlantacionForAlerta, this, aAccionForAlerta);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescripcion(string aDescripcion)
  {
    boolean wasSet = false;
    descripcion = aDescripcion;
    wasSet = true;
    return wasSet;
  }

  public boolean setFechaEmision(date aFechaEmision)
  {
    boolean wasSet = false;
    fechaEmision = aFechaEmision;
    wasSet = true;
    return wasSet;
  }

  public string getDescripcion()
  {
    return descripcion;
  }

  public date getFechaEmision()
  {
    return fechaEmision;
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


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "descripcion" + "=" + (getDescripcion() != null ? !getDescripcion().equals(this)  ? getDescripcion().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "fechaEmision" + "=" + (getFechaEmision() != null ? !getFechaEmision().equals(this)  ? getFechaEmision().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "alerta = "+(getAlerta()!=null?Integer.toHexString(System.identityHashCode(getAlerta())):"null");
  }
}