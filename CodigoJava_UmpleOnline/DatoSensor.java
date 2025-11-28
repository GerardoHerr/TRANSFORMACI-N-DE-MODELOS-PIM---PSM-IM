/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 68 "model.ump"
// line 146 "model.ump"
public class DatoSensor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DatoSensor Attributes
  private string valor;
  private date fechaRegistro;
  private time horaRegistro;

  //DatoSensor Associations
  private Sensor sensor;
  private VariableAmbiental variableAmbiental;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DatoSensor(string aValor, date aFechaRegistro, time aHoraRegistro, Sensor aSensor, VariableAmbiental aVariableAmbiental)
  {
    valor = aValor;
    fechaRegistro = aFechaRegistro;
    horaRegistro = aHoraRegistro;
    boolean didAddSensor = setSensor(aSensor);
    if (!didAddSensor)
    {
      throw new RuntimeException("Unable to create datoSensor due to sensor. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddVariableAmbiental = setVariableAmbiental(aVariableAmbiental);
    if (!didAddVariableAmbiental)
    {
      throw new RuntimeException("Unable to create datoSensor due to variableAmbiental. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setValor(string aValor)
  {
    boolean wasSet = false;
    valor = aValor;
    wasSet = true;
    return wasSet;
  }

  public boolean setFechaRegistro(date aFechaRegistro)
  {
    boolean wasSet = false;
    fechaRegistro = aFechaRegistro;
    wasSet = true;
    return wasSet;
  }

  public boolean setHoraRegistro(time aHoraRegistro)
  {
    boolean wasSet = false;
    horaRegistro = aHoraRegistro;
    wasSet = true;
    return wasSet;
  }

  public string getValor()
  {
    return valor;
  }

  public date getFechaRegistro()
  {
    return fechaRegistro;
  }

  public time getHoraRegistro()
  {
    return horaRegistro;
  }
  /* Code from template association_GetOne */
  public Sensor getSensor()
  {
    return sensor;
  }
  /* Code from template association_GetOne */
  public VariableAmbiental getVariableAmbiental()
  {
    return variableAmbiental;
  }
  /* Code from template association_SetOneToMany */
  public boolean setSensor(Sensor aSensor)
  {
    boolean wasSet = false;
    if (aSensor == null)
    {
      return wasSet;
    }

    Sensor existingSensor = sensor;
    sensor = aSensor;
    if (existingSensor != null && !existingSensor.equals(aSensor))
    {
      existingSensor.removeDatoSensor(this);
    }
    sensor.addDatoSensor(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setVariableAmbiental(VariableAmbiental aVariableAmbiental)
  {
    boolean wasSet = false;
    //Must provide variableAmbiental to datoSensor
    if (aVariableAmbiental == null)
    {
      return wasSet;
    }

    if (variableAmbiental != null && variableAmbiental.numberOfDatoSensors() <= VariableAmbiental.minimumNumberOfDatoSensors())
    {
      return wasSet;
    }

    VariableAmbiental existingVariableAmbiental = variableAmbiental;
    variableAmbiental = aVariableAmbiental;
    if (existingVariableAmbiental != null && !existingVariableAmbiental.equals(aVariableAmbiental))
    {
      boolean didRemove = existingVariableAmbiental.removeDatoSensor(this);
      if (!didRemove)
      {
        variableAmbiental = existingVariableAmbiental;
        return wasSet;
      }
    }
    variableAmbiental.addDatoSensor(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Sensor placeholderSensor = sensor;
    this.sensor = null;
    if(placeholderSensor != null)
    {
      placeholderSensor.removeDatoSensor(this);
    }
    VariableAmbiental placeholderVariableAmbiental = variableAmbiental;
    this.variableAmbiental = null;
    if(placeholderVariableAmbiental != null)
    {
      placeholderVariableAmbiental.removeDatoSensor(this);
    }
  }

  // line 75 "model.ump"
  public string obtenerValor(){
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "valor" + "=" + (getValor() != null ? !getValor().equals(this)  ? getValor().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "fechaRegistro" + "=" + (getFechaRegistro() != null ? !getFechaRegistro().equals(this)  ? getFechaRegistro().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "horaRegistro" + "=" + (getHoraRegistro() != null ? !getHoraRegistro().equals(this)  ? getHoraRegistro().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "sensor = "+(getSensor()!=null?Integer.toHexString(System.identityHashCode(getSensor())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "variableAmbiental = "+(getVariableAmbiental()!=null?Integer.toHexString(System.identityHashCode(getVariableAmbiental())):"null");
  }
}