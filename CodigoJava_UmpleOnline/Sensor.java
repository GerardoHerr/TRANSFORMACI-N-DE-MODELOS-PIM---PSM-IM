/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 78 "model.ump"
// line 151 "model.ump"
public class Sensor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Sensor Attributes
  private string tipoSensor;
  private string estado;
  private string ubicacion;

  //Sensor Associations
  private Plantacion plantacion;
  private List<DatoSensor> datoSensors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Sensor(string aTipoSensor, string aEstado, string aUbicacion, Plantacion aPlantacion)
  {
    tipoSensor = aTipoSensor;
    estado = aEstado;
    ubicacion = aUbicacion;
    boolean didAddPlantacion = setPlantacion(aPlantacion);
    if (!didAddPlantacion)
    {
      throw new RuntimeException("Unable to create sensor due to plantacion. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    datoSensors = new ArrayList<DatoSensor>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTipoSensor(string aTipoSensor)
  {
    boolean wasSet = false;
    tipoSensor = aTipoSensor;
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

  public boolean setUbicacion(string aUbicacion)
  {
    boolean wasSet = false;
    ubicacion = aUbicacion;
    wasSet = true;
    return wasSet;
  }

  public string getTipoSensor()
  {
    return tipoSensor;
  }

  public string getEstado()
  {
    return estado;
  }

  public string getUbicacion()
  {
    return ubicacion;
  }
  /* Code from template association_GetOne */
  public Plantacion getPlantacion()
  {
    return plantacion;
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
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setPlantacion(Plantacion aPlantacion)
  {
    boolean wasSet = false;
    //Must provide plantacion to sensor
    if (aPlantacion == null)
    {
      return wasSet;
    }

    if (plantacion != null && plantacion.numberOfSensors() <= Plantacion.minimumNumberOfSensors())
    {
      return wasSet;
    }

    Plantacion existingPlantacion = plantacion;
    plantacion = aPlantacion;
    if (existingPlantacion != null && !existingPlantacion.equals(aPlantacion))
    {
      boolean didRemove = existingPlantacion.removeSensor(this);
      if (!didRemove)
      {
        plantacion = existingPlantacion;
        return wasSet;
      }
    }
    plantacion.addSensor(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDatoSensors()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public DatoSensor addDatoSensor(string aValor, date aFechaRegistro, time aHoraRegistro, VariableAmbiental aVariableAmbiental)
  {
    return new DatoSensor(aValor, aFechaRegistro, aHoraRegistro, this, aVariableAmbiental);
  }

  public boolean addDatoSensor(DatoSensor aDatoSensor)
  {
    boolean wasAdded = false;
    if (datoSensors.contains(aDatoSensor)) { return false; }
    Sensor existingSensor = aDatoSensor.getSensor();
    boolean isNewSensor = existingSensor != null && !this.equals(existingSensor);
    if (isNewSensor)
    {
      aDatoSensor.setSensor(this);
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
    //Unable to remove aDatoSensor, as it must always have a sensor
    if (!this.equals(aDatoSensor.getSensor()))
    {
      datoSensors.remove(aDatoSensor);
      wasRemoved = true;
    }
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
    Plantacion placeholderPlantacion = plantacion;
    this.plantacion = null;
    if(placeholderPlantacion != null)
    {
      placeholderPlantacion.removeSensor(this);
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
            "  " + "tipoSensor" + "=" + (getTipoSensor() != null ? !getTipoSensor().equals(this)  ? getTipoSensor().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "estado" + "=" + (getEstado() != null ? !getEstado().equals(this)  ? getEstado().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "ubicacion" + "=" + (getUbicacion() != null ? !getUbicacion().equals(this)  ? getUbicacion().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "plantacion = "+(getPlantacion()!=null?Integer.toHexString(System.identityHashCode(getPlantacion())):"null");
  }
}