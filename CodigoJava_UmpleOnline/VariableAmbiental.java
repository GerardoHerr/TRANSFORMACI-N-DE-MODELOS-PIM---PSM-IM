/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 62 "model.ump"
// line 141 "model.ump"
public class VariableAmbiental
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VariableAmbiental Attributes
  private string nombre;
  private string unidad;

  //VariableAmbiental Associations
  private List<ConfiguracionUmbral> configuracionUmbrals;
  private List<DatoSensor> datoSensors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VariableAmbiental(string aNombre, string aUnidad)
  {
    nombre = aNombre;
    unidad = aUnidad;
    configuracionUmbrals = new ArrayList<ConfiguracionUmbral>();
    datoSensors = new ArrayList<DatoSensor>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNombre(string aNombre)
  {
    boolean wasSet = false;
    nombre = aNombre;
    wasSet = true;
    return wasSet;
  }

  public boolean setUnidad(string aUnidad)
  {
    boolean wasSet = false;
    unidad = aUnidad;
    wasSet = true;
    return wasSet;
  }

  public string getNombre()
  {
    return nombre;
  }

  public string getUnidad()
  {
    return unidad;
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
  /* Code from template association_GetMany */
  public DatoSensor getDatoSensor(int index)
  {
    DatoSensor aDatoSensor = datoSensors.get(index);
    return aDatoSensor;
  }

  public List<DatoSensor> getDatoSensors()
  {
    List<DatoSensor> newDatoSensors = Collections.unmodifiableList(datoSensors);
    return newDatoSensors;
  }

  public int numberOfDatoSensors()
  {
    int number = datoSensors.size();
    return number;
  }

  public boolean hasDatoSensors()
  {
    boolean has = datoSensors.size() > 0;
    return has;
  }

  public int indexOfDatoSensor(DatoSensor aDatoSensor)
  {
    int index = datoSensors.indexOf(aDatoSensor);
    return index;
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
  public ConfiguracionUmbral addConfiguracionUmbral(double aValorMinimo, double aValorMaximo, date aFechaConfiguracion, Cultivo aCultivo)
  {
    ConfiguracionUmbral aNewConfiguracionUmbral = new ConfiguracionUmbral(aValorMinimo, aValorMaximo, aFechaConfiguracion, this, aCultivo);
    return aNewConfiguracionUmbral;
  }

  public boolean addConfiguracionUmbral(ConfiguracionUmbral aConfiguracionUmbral)
  {
    boolean wasAdded = false;
    if (configuracionUmbrals.contains(aConfiguracionUmbral)) { return false; }
    VariableAmbiental existingVariableAmbiental = aConfiguracionUmbral.getVariableAmbiental();
    boolean isNewVariableAmbiental = existingVariableAmbiental != null && !this.equals(existingVariableAmbiental);

    if (isNewVariableAmbiental && existingVariableAmbiental.numberOfConfiguracionUmbrals() <= minimumNumberOfConfiguracionUmbrals())
    {
      return wasAdded;
    }
    if (isNewVariableAmbiental)
    {
      aConfiguracionUmbral.setVariableAmbiental(this);
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
    //Unable to remove aConfiguracionUmbral, as it must always have a variableAmbiental
    if (this.equals(aConfiguracionUmbral.getVariableAmbiental()))
    {
      return wasRemoved;
    }

    //variableAmbiental already at minimum (1)
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
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfDatoSensorsValid()
  {
    boolean isValid = numberOfDatoSensors() >= minimumNumberOfDatoSensors();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDatoSensors()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public DatoSensor addDatoSensor(string aValor, date aFechaRegistro, time aHoraRegistro, Sensor aSensor)
  {
    DatoSensor aNewDatoSensor = new DatoSensor(aValor, aFechaRegistro, aHoraRegistro, aSensor, this);
    return aNewDatoSensor;
  }

  public boolean addDatoSensor(DatoSensor aDatoSensor)
  {
    boolean wasAdded = false;
    if (datoSensors.contains(aDatoSensor)) { return false; }
    VariableAmbiental existingVariableAmbiental = aDatoSensor.getVariableAmbiental();
    boolean isNewVariableAmbiental = existingVariableAmbiental != null && !this.equals(existingVariableAmbiental);

    if (isNewVariableAmbiental && existingVariableAmbiental.numberOfDatoSensors() <= minimumNumberOfDatoSensors())
    {
      return wasAdded;
    }
    if (isNewVariableAmbiental)
    {
      aDatoSensor.setVariableAmbiental(this);
    }
    else
    {
      datoSensors.add(aDatoSensor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDatoSensor(DatoSensor aDatoSensor)
  {
    boolean wasRemoved = false;
    //Unable to remove aDatoSensor, as it must always have a variableAmbiental
    if (this.equals(aDatoSensor.getVariableAmbiental()))
    {
      return wasRemoved;
    }

    //variableAmbiental already at minimum (1)
    if (numberOfDatoSensors() <= minimumNumberOfDatoSensors())
    {
      return wasRemoved;
    }

    datoSensors.remove(aDatoSensor);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDatoSensorAt(DatoSensor aDatoSensor, int index)
  {  
    boolean wasAdded = false;
    if(addDatoSensor(aDatoSensor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDatoSensors()) { index = numberOfDatoSensors() - 1; }
      datoSensors.remove(aDatoSensor);
      datoSensors.add(index, aDatoSensor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDatoSensorAt(DatoSensor aDatoSensor, int index)
  {
    boolean wasAdded = false;
    if(datoSensors.contains(aDatoSensor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDatoSensors()) { index = numberOfDatoSensors() - 1; }
      datoSensors.remove(aDatoSensor);
      datoSensors.add(index, aDatoSensor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDatoSensorAt(aDatoSensor, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=configuracionUmbrals.size(); i > 0; i--)
    {
      ConfiguracionUmbral aConfiguracionUmbral = configuracionUmbrals.get(i - 1);
      aConfiguracionUmbral.delete();
    }
    for(int i=datoSensors.size(); i > 0; i--)
    {
      DatoSensor aDatoSensor = datoSensors.get(i - 1);
      aDatoSensor.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "nombre" + "=" + (getNombre() != null ? !getNombre().equals(this)  ? getNombre().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "unidad" + "=" + (getUnidad() != null ? !getUnidad().equals(this)  ? getUnidad().toString().replaceAll("  ","    ") : "this" : "null");
  }
}