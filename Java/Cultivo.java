/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 22 "model.ump"
// line 121 "model.ump"
public class Cultivo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cultivo Attributes
  private string nombreCultivo;
  private string tipoCultivo;
  private string familia;
  private string semilla;

  //Cultivo Associations
  private List<Plantacion> plantacions;
  private List<ConfiguracionUmbral> configuracionUmbrals;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cultivo(string aNombreCultivo, string aTipoCultivo, string aFamilia, string aSemilla)
  {
    nombreCultivo = aNombreCultivo;
    tipoCultivo = aTipoCultivo;
    familia = aFamilia;
    semilla = aSemilla;
    plantacions = new ArrayList<Plantacion>();
    configuracionUmbrals = new ArrayList<ConfiguracionUmbral>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNombreCultivo(string aNombreCultivo)
  {
    boolean wasSet = false;
    nombreCultivo = aNombreCultivo;
    wasSet = true;
    return wasSet;
  }

  public boolean setTipoCultivo(string aTipoCultivo)
  {
    boolean wasSet = false;
    tipoCultivo = aTipoCultivo;
    wasSet = true;
    return wasSet;
  }

  public boolean setFamilia(string aFamilia)
  {
    boolean wasSet = false;
    familia = aFamilia;
    wasSet = true;
    return wasSet;
  }

  public boolean setSemilla(string aSemilla)
  {
    boolean wasSet = false;
    semilla = aSemilla;
    wasSet = true;
    return wasSet;
  }

  public string getNombreCultivo()
  {
    return nombreCultivo;
  }

  public string getTipoCultivo()
  {
    return tipoCultivo;
  }

  public string getFamilia()
  {
    return familia;
  }

  public string getSemilla()
  {
    return semilla;
  }
  /* Code from template association_GetMany */
  public Plantacion getPlantacion(int index)
  {
    Plantacion aPlantacion = plantacions.get(index);
    return aPlantacion;
  }

  public List<Plantacion> getPlantacions()
  {
    List<Plantacion> newPlantacions = Collections.unmodifiableList(plantacions);
    return newPlantacions;
  }

  public int numberOfPlantacions()
  {
    int number = plantacions.size();
    return number;
  }

  public boolean hasPlantacions()
  {
    boolean has = plantacions.size() > 0;
    return has;
  }

  public int indexOfPlantacion(Plantacion aPlantacion)
  {
    int index = plantacions.indexOf(aPlantacion);
    return index;
  }
  /* Code from template association_GetMany */
  public ConfiguracionUmbral getConfiguracionUmbral(int index)
  {
    ConfiguracionUmbral aConfiguracionUmbral = configuracionUmbrals.get(index);
    return aConfiguracionUmbral;
  }

  public List<ConfiguracionUmbral> getConfiguracionUmbrals()
  {
    List<ConfiguracionUmbral> newConfiguracionUmbrals = Collections.unmodifiableList(configuracionUmbrals);
    return newConfiguracionUmbrals;
  }

  public int numberOfConfiguracionUmbrals()
  {
    int number = configuracionUmbrals.size();
    return number;
  }

  public boolean hasConfiguracionUmbrals()
  {
    boolean has = configuracionUmbrals.size() > 0;
    return has;
  }

  public int indexOfConfiguracionUmbral(ConfiguracionUmbral aConfiguracionUmbral)
  {
    int index = configuracionUmbrals.indexOf(aConfiguracionUmbral);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfPlantacionsValid()
  {
    boolean isValid = numberOfPlantacions() >= minimumNumberOfPlantacions();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPlantacions()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Plantacion addPlantacion(string aNombre, date aFechaRegistro, double aCantidadEspacio, ConfiguracionTomaDecisiones aConfiguracionTomaDecisiones)
  {
    Plantacion aNewPlantacion = new Plantacion(aNombre, aFechaRegistro, aCantidadEspacio, this, aConfiguracionTomaDecisiones);
    return aNewPlantacion;
  }

  public boolean addPlantacion(Plantacion aPlantacion)
  {
    boolean wasAdded = false;
    if (plantacions.contains(aPlantacion)) { return false; }
    Cultivo existingCultivo = aPlantacion.getCultivo();
    boolean isNewCultivo = existingCultivo != null && !this.equals(existingCultivo);

    if (isNewCultivo && existingCultivo.numberOfPlantacions() <= minimumNumberOfPlantacions())
    {
      return wasAdded;
    }
    if (isNewCultivo)
    {
      aPlantacion.setCultivo(this);
    }
    else
    {
      plantacions.add(aPlantacion);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePlantacion(Plantacion aPlantacion)
  {
    boolean wasRemoved = false;
    //Unable to remove aPlantacion, as it must always have a cultivo
    if (this.equals(aPlantacion.getCultivo()))
    {
      return wasRemoved;
    }

    //cultivo already at minimum (1)
    if (numberOfPlantacions() <= minimumNumberOfPlantacions())
    {
      return wasRemoved;
    }

    plantacions.remove(aPlantacion);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPlantacionAt(Plantacion aPlantacion, int index)
  {  
    boolean wasAdded = false;
    if(addPlantacion(aPlantacion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlantacions()) { index = numberOfPlantacions() - 1; }
      plantacions.remove(aPlantacion);
      plantacions.add(index, aPlantacion);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePlantacionAt(Plantacion aPlantacion, int index)
  {
    boolean wasAdded = false;
    if(plantacions.contains(aPlantacion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlantacions()) { index = numberOfPlantacions() - 1; }
      plantacions.remove(aPlantacion);
      plantacions.add(index, aPlantacion);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPlantacionAt(aPlantacion, index);
    }
    return wasAdded;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfConfiguracionUmbralsValid()
  {
    boolean isValid = numberOfConfiguracionUmbrals() >= minimumNumberOfConfiguracionUmbrals();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfConfiguracionUmbrals()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public ConfiguracionUmbral addConfiguracionUmbral(double aValorMinimo, double aValorMaximo, date aFechaConfiguracion, VariableAmbiental aVariableAmbiental)
  {
    ConfiguracionUmbral aNewConfiguracionUmbral = new ConfiguracionUmbral(aValorMinimo, aValorMaximo, aFechaConfiguracion, aVariableAmbiental, this);
    return aNewConfiguracionUmbral;
  }

  public boolean addConfiguracionUmbral(ConfiguracionUmbral aConfiguracionUmbral)
  {
    boolean wasAdded = false;
    if (configuracionUmbrals.contains(aConfiguracionUmbral)) { return false; }
    Cultivo existingCultivo = aConfiguracionUmbral.getCultivo();
    boolean isNewCultivo = existingCultivo != null && !this.equals(existingCultivo);

    if (isNewCultivo && existingCultivo.numberOfConfiguracionUmbrals() <= minimumNumberOfConfiguracionUmbrals())
    {
      return wasAdded;
    }
    if (isNewCultivo)
    {
      aConfiguracionUmbral.setCultivo(this);
    }
    else
    {
      configuracionUmbrals.add(aConfiguracionUmbral);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeConfiguracionUmbral(ConfiguracionUmbral aConfiguracionUmbral)
  {
    boolean wasRemoved = false;
    //Unable to remove aConfiguracionUmbral, as it must always have a cultivo
    if (this.equals(aConfiguracionUmbral.getCultivo()))
    {
      return wasRemoved;
    }

    //cultivo already at minimum (1)
    if (numberOfConfiguracionUmbrals() <= minimumNumberOfConfiguracionUmbrals())
    {
      return wasRemoved;
    }

    configuracionUmbrals.remove(aConfiguracionUmbral);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addConfiguracionUmbralAt(ConfiguracionUmbral aConfiguracionUmbral, int index)
  {  
    boolean wasAdded = false;
    if(addConfiguracionUmbral(aConfiguracionUmbral))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfConfiguracionUmbrals()) { index = numberOfConfiguracionUmbrals() - 1; }
      configuracionUmbrals.remove(aConfiguracionUmbral);
      configuracionUmbrals.add(index, aConfiguracionUmbral);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveConfiguracionUmbralAt(ConfiguracionUmbral aConfiguracionUmbral, int index)
  {
    boolean wasAdded = false;
    if(configuracionUmbrals.contains(aConfiguracionUmbral))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfConfiguracionUmbrals()) { index = numberOfConfiguracionUmbrals() - 1; }
      configuracionUmbrals.remove(aConfiguracionUmbral);
      configuracionUmbrals.add(index, aConfiguracionUmbral);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addConfiguracionUmbralAt(aConfiguracionUmbral, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=plantacions.size(); i > 0; i--)
    {
      Plantacion aPlantacion = plantacions.get(i - 1);
      aPlantacion.delete();
    }
    for(int i=configuracionUmbrals.size(); i > 0; i--)
    {
      ConfiguracionUmbral aConfiguracionUmbral = configuracionUmbrals.get(i - 1);
      aConfiguracionUmbral.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "nombreCultivo" + "=" + (getNombreCultivo() != null ? !getNombreCultivo().equals(this)  ? getNombreCultivo().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "tipoCultivo" + "=" + (getTipoCultivo() != null ? !getTipoCultivo().equals(this)  ? getTipoCultivo().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "familia" + "=" + (getFamilia() != null ? !getFamilia().equals(this)  ? getFamilia().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "semilla" + "=" + (getSemilla() != null ? !getSemilla().equals(this)  ? getSemilla().toString().replaceAll("  ","    ") : "this" : "null");
  }
}