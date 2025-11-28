/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 52 "model.ump"
// line 136 "model.ump"
public class ConfiguracionUmbral
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConfiguracionUmbral Attributes
  private double valorMinimo;
  private double valorMaximo;
  private date fechaConfiguracion;

  //ConfiguracionUmbral Associations
  private VariableAmbiental variableAmbiental;
  private Cultivo cultivo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConfiguracionUmbral(double aValorMinimo, double aValorMaximo, date aFechaConfiguracion, VariableAmbiental aVariableAmbiental, Cultivo aCultivo)
  {
    valorMinimo = aValorMinimo;
    valorMaximo = aValorMaximo;
    fechaConfiguracion = aFechaConfiguracion;
    boolean didAddVariableAmbiental = setVariableAmbiental(aVariableAmbiental);
    if (!didAddVariableAmbiental)
    {
      throw new RuntimeException("Unable to create configuracionUmbral due to variableAmbiental. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddCultivo = setCultivo(aCultivo);
    if (!didAddCultivo)
    {
      throw new RuntimeException("Unable to create configuracionUmbral due to cultivo. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setValorMinimo(double aValorMinimo)
  {
    boolean wasSet = false;
    valorMinimo = aValorMinimo;
    wasSet = true;
    return wasSet;
  }

  public boolean setValorMaximo(double aValorMaximo)
  {
    boolean wasSet = false;
    valorMaximo = aValorMaximo;
    wasSet = true;
    return wasSet;
  }

  public boolean setFechaConfiguracion(date aFechaConfiguracion)
  {
    boolean wasSet = false;
    fechaConfiguracion = aFechaConfiguracion;
    wasSet = true;
    return wasSet;
  }

  public double getValorMinimo()
  {
    return valorMinimo;
  }

  public double getValorMaximo()
  {
    return valorMaximo;
  }

  public date getFechaConfiguracion()
  {
    return fechaConfiguracion;
  }
  /* Code from template association_GetOne */
  public VariableAmbiental getVariableAmbiental()
  {
    return variableAmbiental;
  }
  /* Code from template association_GetOne */
  public Cultivo getCultivo()
  {
    return cultivo;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setVariableAmbiental(VariableAmbiental aVariableAmbiental)
  {
    boolean wasSet = false;
    //Must provide variableAmbiental to configuracionUmbral
    if (aVariableAmbiental == null)
    {
      return wasSet;
    }

    if (variableAmbiental != null && variableAmbiental.numberOfConfiguracionUmbrals() <= VariableAmbiental.minimumNumberOfConfiguracionUmbrals())
    {
      return wasSet;
    }

    VariableAmbiental existingVariableAmbiental = variableAmbiental;
    variableAmbiental = aVariableAmbiental;
    if (existingVariableAmbiental != null && !existingVariableAmbiental.equals(aVariableAmbiental))
    {
      boolean didRemove = existingVariableAmbiental.removeConfiguracionUmbral(this);
      if (!didRemove)
      {
        variableAmbiental = existingVariableAmbiental;
        return wasSet;
      }
    }
    variableAmbiental.addConfiguracionUmbral(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setCultivo(Cultivo aCultivo)
  {
    boolean wasSet = false;
    //Must provide cultivo to configuracionUmbral
    if (aCultivo == null)
    {
      return wasSet;
    }

    if (cultivo != null && cultivo.numberOfConfiguracionUmbrals() <= Cultivo.minimumNumberOfConfiguracionUmbrals())
    {
      return wasSet;
    }

    Cultivo existingCultivo = cultivo;
    cultivo = aCultivo;
    if (existingCultivo != null && !existingCultivo.equals(aCultivo))
    {
      boolean didRemove = existingCultivo.removeConfiguracionUmbral(this);
      if (!didRemove)
      {
        cultivo = existingCultivo;
        return wasSet;
      }
    }
    cultivo.addConfiguracionUmbral(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    VariableAmbiental placeholderVariableAmbiental = variableAmbiental;
    this.variableAmbiental = null;
    if(placeholderVariableAmbiental != null)
    {
      placeholderVariableAmbiental.removeConfiguracionUmbral(this);
    }
    Cultivo placeholderCultivo = cultivo;
    this.cultivo = null;
    if(placeholderCultivo != null)
    {
      placeholderCultivo.removeConfiguracionUmbral(this);
    }
  }

  // line 59 "model.ump"
  public string obtenerValores(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "valorMinimo" + ":" + getValorMinimo()+ "," +
            "valorMaximo" + ":" + getValorMaximo()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "fechaConfiguracion" + "=" + (getFechaConfiguracion() != null ? !getFechaConfiguracion().equals(this)  ? getFechaConfiguracion().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "variableAmbiental = "+(getVariableAmbiental()!=null?Integer.toHexString(System.identityHashCode(getVariableAmbiental())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "cultivo = "+(getCultivo()!=null?Integer.toHexString(System.identityHashCode(getCultivo())):"null");
  }
}