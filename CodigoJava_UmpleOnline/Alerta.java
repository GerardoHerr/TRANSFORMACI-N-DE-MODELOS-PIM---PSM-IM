/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 92 "model.ump"
// line 161 "model.ump"
public class Alerta
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Alerta Attributes
  private string tipoAlerta;
  private string descripcion;
  private string estado;
  private date fechaGeneracion;

  //Alerta Associations
  private Plantacion plantacion;
  private Recomendacion recomendacion;
  private Accion accion;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Alerta(string aTipoAlerta, string aDescripcion, string aEstado, date aFechaGeneracion, Plantacion aPlantacion, Recomendacion aRecomendacion, Accion aAccion)
  {
    tipoAlerta = aTipoAlerta;
    descripcion = aDescripcion;
    estado = aEstado;
    fechaGeneracion = aFechaGeneracion;
    boolean didAddPlantacion = setPlantacion(aPlantacion);
    if (!didAddPlantacion)
    {
      throw new RuntimeException("Unable to create alerta due to plantacion. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aRecomendacion == null || aRecomendacion.getAlerta() != null)
    {
      throw new RuntimeException("Unable to create Alerta due to aRecomendacion. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    recomendacion = aRecomendacion;
    if (aAccion == null || aAccion.getAlerta() != null)
    {
      throw new RuntimeException("Unable to create Alerta due to aAccion. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    accion = aAccion;
  }

  public Alerta(string aTipoAlerta, string aDescripcion, string aEstado, date aFechaGeneracion, Plantacion aPlantacion, string aDescripcionForRecomendacion, date aFechaEmisionForRecomendacion, string aTipoAccionForAccion, date aFechaEjecucionForAccion)
  {
    tipoAlerta = aTipoAlerta;
    descripcion = aDescripcion;
    estado = aEstado;
    fechaGeneracion = aFechaGeneracion;
    boolean didAddPlantacion = setPlantacion(aPlantacion);
    if (!didAddPlantacion)
    {
      throw new RuntimeException("Unable to create alerta due to plantacion. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    recomendacion = new Recomendacion(aDescripcionForRecomendacion, aFechaEmisionForRecomendacion, this);
    accion = new Accion(aTipoAccionForAccion, aFechaEjecucionForAccion, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTipoAlerta(string aTipoAlerta)
  {
    boolean wasSet = false;
    tipoAlerta = aTipoAlerta;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescripcion(string aDescripcion)
  {
    boolean wasSet = false;
    descripcion = aDescripcion;
    wasSet = true;
    return wasSet;
  }

  public boolean setEstado(string aEstado)
  {
    boolean wasSet = false;
    estado = aEstado;
    wasSet = true;
    return wasSet;
  }

  public boolean setFechaGeneracion(date aFechaGeneracion)
  {
    boolean wasSet = false;
    fechaGeneracion = aFechaGeneracion;
    wasSet = true;
    return wasSet;
  }

  public string getTipoAlerta()
  {
    return tipoAlerta;
  }

  public string getDescripcion()
  {
    return descripcion;
  }

  public string getEstado()
  {
    return estado;
  }

  public date getFechaGeneracion()
  {
    return fechaGeneracion;
  }
  /* Code from template association_GetOne */
  public Plantacion getPlantacion()
  {
    return plantacion;
  }
  /* Code from template association_GetOne */
  public Recomendacion getRecomendacion()
  {
    return recomendacion;
  }
  /* Code from template association_GetOne */
  public Accion getAccion()
  {
    return accion;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setPlantacion(Plantacion aPlantacion)
  {
    boolean wasSet = false;
    //Must provide plantacion to alerta
    if (aPlantacion == null)
    {
      return wasSet;
    }

    if (plantacion != null && plantacion.numberOfAlertas() <= Plantacion.minimumNumberOfAlertas())
    {
      return wasSet;
    }

    Plantacion existingPlantacion = plantacion;
    plantacion = aPlantacion;
    if (existingPlantacion != null && !existingPlantacion.equals(aPlantacion))
    {
      boolean didRemove = existingPlantacion.removeAlerta(this);
      if (!didRemove)
      {
        plantacion = existingPlantacion;
        return wasSet;
      }
    }
    plantacion.addAlerta(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Plantacion placeholderPlantacion = plantacion;
    this.plantacion = null;
    if(placeholderPlantacion != null)
    {
      placeholderPlantacion.removeAlerta(this);
    }
    Recomendacion existingRecomendacion = recomendacion;
    recomendacion = null;
    if (existingRecomendacion != null)
    {
      existingRecomendacion.delete();
    }
    Accion existingAccion = accion;
    accion = null;
    if (existingAccion != null)
    {
      existingAccion.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tipoAlerta" + "=" + (getTipoAlerta() != null ? !getTipoAlerta().equals(this)  ? getTipoAlerta().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "descripcion" + "=" + (getDescripcion() != null ? !getDescripcion().equals(this)  ? getDescripcion().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "estado" + "=" + (getEstado() != null ? !getEstado().equals(this)  ? getEstado().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "fechaGeneracion" + "=" + (getFechaGeneracion() != null ? !getFechaGeneracion().equals(this)  ? getFechaGeneracion().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "plantacion = "+(getPlantacion()!=null?Integer.toHexString(System.identityHashCode(getPlantacion())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "recomendacion = "+(getRecomendacion()!=null?Integer.toHexString(System.identityHashCode(getRecomendacion())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "accion = "+(getAccion()!=null?Integer.toHexString(System.identityHashCode(getAccion())):"null");
  }
}