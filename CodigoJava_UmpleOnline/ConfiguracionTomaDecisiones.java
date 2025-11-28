/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 85 "model.ump"
// line 156 "model.ump"
public class ConfiguracionTomaDecisiones
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConfiguracionTomaDecisiones Attributes
  private string tipoConfiguracion;
  private string criterioDecision;

  //ConfiguracionTomaDecisiones Associations
  private Plantacion plantacion;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConfiguracionTomaDecisiones(string aTipoConfiguracion, string aCriterioDecision, Plantacion aPlantacion)
  {
    tipoConfiguracion = aTipoConfiguracion;
    criterioDecision = aCriterioDecision;
    if (aPlantacion == null || aPlantacion.getConfiguracionTomaDecisiones() != null)
    {
      throw new RuntimeException("Unable to create ConfiguracionTomaDecisiones due to aPlantacion. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    plantacion = aPlantacion;
  }

  public ConfiguracionTomaDecisiones(string aTipoConfiguracion, string aCriterioDecision, string aNombreForPlantacion, date aFechaRegistroForPlantacion, double aCantidadEspacioForPlantacion, Cultivo aCultivoForPlantacion)
  {
    tipoConfiguracion = aTipoConfiguracion;
    criterioDecision = aCriterioDecision;
    plantacion = new Plantacion(aNombreForPlantacion, aFechaRegistroForPlantacion, aCantidadEspacioForPlantacion, aCultivoForPlantacion, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTipoConfiguracion(string aTipoConfiguracion)
  {
    boolean wasSet = false;
    tipoConfiguracion = aTipoConfiguracion;
    wasSet = true;
    return wasSet;
  }

  public boolean setCriterioDecision(string aCriterioDecision)
  {
    boolean wasSet = false;
    criterioDecision = aCriterioDecision;
    wasSet = true;
    return wasSet;
  }

  public string getTipoConfiguracion()
  {
    return tipoConfiguracion;
  }

  public string getCriterioDecision()
  {
    return criterioDecision;
  }
  /* Code from template association_GetOne */
  public Plantacion getPlantacion()
  {
    return plantacion;
  }

  public void delete()
  {
    Plantacion existingPlantacion = plantacion;
    plantacion = null;
    if (existingPlantacion != null)
    {
      existingPlantacion.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tipoConfiguracion" + "=" + (getTipoConfiguracion() != null ? !getTipoConfiguracion().equals(this)  ? getTipoConfiguracion().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "criterioDecision" + "=" + (getCriterioDecision() != null ? !getCriterioDecision().equals(this)  ? getCriterioDecision().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "plantacion = "+(getPlantacion()!=null?Integer.toHexString(System.identityHashCode(getPlantacion())):"null");
  }
}