/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 41 "model.ump"
// line 131 "model.ump"
public class Plantacion
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Plantacion Attributes
  private string nombre;
  private date fechaRegistro;
  private double cantidadEspacio;

  //Plantacion Associations
  private List<Usuario> usuarios;
  private List<Sensor> sensors;
  private Cultivo cultivo;
  private ConfiguracionTomaDecisiones configuracionTomaDecisiones;
  private List<Alerta> alertas;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Plantacion(string aNombre, date aFechaRegistro, double aCantidadEspacio, Cultivo aCultivo, ConfiguracionTomaDecisiones aConfiguracionTomaDecisiones)
  {
    nombre = aNombre;
    fechaRegistro = aFechaRegistro;
    cantidadEspacio = aCantidadEspacio;
    usuarios = new ArrayList<Usuario>();
    sensors = new ArrayList<Sensor>();
    boolean didAddCultivo = setCultivo(aCultivo);
    if (!didAddCultivo)
    {
      throw new RuntimeException("Unable to create plantacion due to cultivo. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aConfiguracionTomaDecisiones == null || aConfiguracionTomaDecisiones.getPlantacion() != null)
    {
      throw new RuntimeException("Unable to create Plantacion due to aConfiguracionTomaDecisiones. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    configuracionTomaDecisiones = aConfiguracionTomaDecisiones;
    alertas = new ArrayList<Alerta>();
  }

  public Plantacion(string aNombre, date aFechaRegistro, double aCantidadEspacio, Cultivo aCultivo, string aTipoConfiguracionForConfiguracionTomaDecisiones, string aCriterioDecisionForConfiguracionTomaDecisiones)
  {
    nombre = aNombre;
    fechaRegistro = aFechaRegistro;
    cantidadEspacio = aCantidadEspacio;
    usuarios = new ArrayList<Usuario>();
    sensors = new ArrayList<Sensor>();
    boolean didAddCultivo = setCultivo(aCultivo);
    if (!didAddCultivo)
    {
      throw new RuntimeException("Unable to create plantacion due to cultivo. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    configuracionTomaDecisiones = new ConfiguracionTomaDecisiones(aTipoConfiguracionForConfiguracionTomaDecisiones, aCriterioDecisionForConfiguracionTomaDecisiones, this);
    alertas = new ArrayList<Alerta>();
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

  public boolean setFechaRegistro(date aFechaRegistro)
  {
    boolean wasSet = false;
    fechaRegistro = aFechaRegistro;
    wasSet = true;
    return wasSet;
  }

  public boolean setCantidadEspacio(double aCantidadEspacio)
  {
    boolean wasSet = false;
    cantidadEspacio = aCantidadEspacio;
    wasSet = true;
    return wasSet;
  }

  public string getNombre()
  {
    return nombre;
  }

  public date getFechaRegistro()
  {
    return fechaRegistro;
  }

  public double getCantidadEspacio()
  {
    return cantidadEspacio;
  }
  /* Code from template association_GetMany */
  public Usuario getUsuario(int index)
  {
    Usuario aUsuario = usuarios.get(index);
    return aUsuario;
  }

  public List<Usuario> getUsuarios()
  {
    List<Usuario> newUsuarios = Collections.unmodifiableList(usuarios);
    return newUsuarios;
  }

  public int numberOfUsuarios()
  {
    int number = usuarios.size();
    return number;
  }

  public boolean hasUsuarios()
  {
    boolean has = usuarios.size() > 0;
    return has;
  }

  public int indexOfUsuario(Usuario aUsuario)
  {
    int index = usuarios.indexOf(aUsuario);
    return index;
  }
  /* Code from template association_GetMany */
  public Sensor getSensor(int index)
  {
    Sensor aSensor = sensors.get(index);
    return aSensor;
  }

  public List<Sensor> getSensors()
  {
    List<Sensor> newSensors = Collections.unmodifiableList(sensors);
    return newSensors;
  }

  public int numberOfSensors()
  {
    int number = sensors.size();
    return number;
  }

  public boolean hasSensors()
  {
    boolean has = sensors.size() > 0;
    return has;
  }

  public int indexOfSensor(Sensor aSensor)
  {
    int index = sensors.indexOf(aSensor);
    return index;
  }
  /* Code from template association_GetOne */
  public Cultivo getCultivo()
  {
    return cultivo;
  }
  /* Code from template association_GetOne */
  public ConfiguracionTomaDecisiones getConfiguracionTomaDecisiones()
  {
    return configuracionTomaDecisiones;
  }
  /* Code from template association_GetMany */
  public Alerta getAlerta(int index)
  {
    Alerta aAlerta = alertas.get(index);
    return aAlerta;
  }

  public List<Alerta> getAlertas()
  {
    List<Alerta> newAlertas = Collections.unmodifiableList(alertas);
    return newAlertas;
  }

  public int numberOfAlertas()
  {
    int number = alertas.size();
    return number;
  }

  public boolean hasAlertas()
  {
    boolean has = alertas.size() > 0;
    return has;
  }

  public int indexOfAlerta(Alerta aAlerta)
  {
    int index = alertas.indexOf(aAlerta);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfUsuariosValid()
  {
    boolean isValid = numberOfUsuarios() >= minimumNumberOfUsuarios();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsuarios()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Usuario addUsuario(string aNombre, string aCorreo, string aClave, Rol aRol)
  {
    Usuario aNewUsuario = new Usuario(aNombre, aCorreo, aClave, aRol, this);
    return aNewUsuario;
  }

  public boolean addUsuario(Usuario aUsuario)
  {
    boolean wasAdded = false;
    if (usuarios.contains(aUsuario)) { return false; }
    Plantacion existingPlantacion = aUsuario.getPlantacion();
    boolean isNewPlantacion = existingPlantacion != null && !this.equals(existingPlantacion);

    if (isNewPlantacion && existingPlantacion.numberOfUsuarios() <= minimumNumberOfUsuarios())
    {
      return wasAdded;
    }
    if (isNewPlantacion)
    {
      aUsuario.setPlantacion(this);
    }
    else
    {
      usuarios.add(aUsuario);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUsuario(Usuario aUsuario)
  {
    boolean wasRemoved = false;
    //Unable to remove aUsuario, as it must always have a plantacion
    if (this.equals(aUsuario.getPlantacion()))
    {
      return wasRemoved;
    }

    //plantacion already at minimum (1)
    if (numberOfUsuarios() <= minimumNumberOfUsuarios())
    {
      return wasRemoved;
    }

    usuarios.remove(aUsuario);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUsuarioAt(Usuario aUsuario, int index)
  {  
    boolean wasAdded = false;
    if(addUsuario(aUsuario))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsuarios()) { index = numberOfUsuarios() - 1; }
      usuarios.remove(aUsuario);
      usuarios.add(index, aUsuario);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUsuarioAt(Usuario aUsuario, int index)
  {
    boolean wasAdded = false;
    if(usuarios.contains(aUsuario))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsuarios()) { index = numberOfUsuarios() - 1; }
      usuarios.remove(aUsuario);
      usuarios.add(index, aUsuario);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUsuarioAt(aUsuario, index);
    }
    return wasAdded;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfSensorsValid()
  {
    boolean isValid = numberOfSensors() >= minimumNumberOfSensors();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSensors()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Sensor addSensor(string aTipoSensor, string aEstado, string aUbicacion)
  {
    Sensor aNewSensor = new Sensor(aTipoSensor, aEstado, aUbicacion, this);
    return aNewSensor;
  }

  public boolean addSensor(Sensor aSensor)
  {
    boolean wasAdded = false;
    if (sensors.contains(aSensor)) { return false; }
    Plantacion existingPlantacion = aSensor.getPlantacion();
    boolean isNewPlantacion = existingPlantacion != null && !this.equals(existingPlantacion);

    if (isNewPlantacion && existingPlantacion.numberOfSensors() <= minimumNumberOfSensors())
    {
      return wasAdded;
    }
    if (isNewPlantacion)
    {
      aSensor.setPlantacion(this);
    }
    else
    {
      sensors.add(aSensor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSensor(Sensor aSensor)
  {
    boolean wasRemoved = false;
    //Unable to remove aSensor, as it must always have a plantacion
    if (this.equals(aSensor.getPlantacion()))
    {
      return wasRemoved;
    }

    //plantacion already at minimum (1)
    if (numberOfSensors() <= minimumNumberOfSensors())
    {
      return wasRemoved;
    }

    sensors.remove(aSensor);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSensorAt(Sensor aSensor, int index)
  {  
    boolean wasAdded = false;
    if(addSensor(aSensor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSensors()) { index = numberOfSensors() - 1; }
      sensors.remove(aSensor);
      sensors.add(index, aSensor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSensorAt(Sensor aSensor, int index)
  {
    boolean wasAdded = false;
    if(sensors.contains(aSensor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSensors()) { index = numberOfSensors() - 1; }
      sensors.remove(aSensor);
      sensors.add(index, aSensor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSensorAt(aSensor, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setCultivo(Cultivo aCultivo)
  {
    boolean wasSet = false;
    //Must provide cultivo to plantacion
    if (aCultivo == null)
    {
      return wasSet;
    }

    if (cultivo != null && cultivo.numberOfPlantacions() <= Cultivo.minimumNumberOfPlantacions())
    {
      return wasSet;
    }

    Cultivo existingCultivo = cultivo;
    cultivo = aCultivo;
    if (existingCultivo != null && !existingCultivo.equals(aCultivo))
    {
      boolean didRemove = existingCultivo.removePlantacion(this);
      if (!didRemove)
      {
        cultivo = existingCultivo;
        return wasSet;
      }
    }
    cultivo.addPlantacion(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfAlertasValid()
  {
    boolean isValid = numberOfAlertas() >= minimumNumberOfAlertas();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAlertas()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Alerta addAlerta(string aTipoAlerta, string aDescripcion, string aEstado, date aFechaGeneracion, Recomendacion aRecomendacion, Accion aAccion)
  {
    Alerta aNewAlerta = new Alerta(aTipoAlerta, aDescripcion, aEstado, aFechaGeneracion, this, aRecomendacion, aAccion);
    return aNewAlerta;
  }

  public boolean addAlerta(Alerta aAlerta)
  {
    boolean wasAdded = false;
    if (alertas.contains(aAlerta)) { return false; }
    Plantacion existingPlantacion = aAlerta.getPlantacion();
    boolean isNewPlantacion = existingPlantacion != null && !this.equals(existingPlantacion);

    if (isNewPlantacion && existingPlantacion.numberOfAlertas() <= minimumNumberOfAlertas())
    {
      return wasAdded;
    }
    if (isNewPlantacion)
    {
      aAlerta.setPlantacion(this);
    }
    else
    {
      alertas.add(aAlerta);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAlerta(Alerta aAlerta)
  {
    boolean wasRemoved = false;
    //Unable to remove aAlerta, as it must always have a plantacion
    if (this.equals(aAlerta.getPlantacion()))
    {
      return wasRemoved;
    }

    //plantacion already at minimum (1)
    if (numberOfAlertas() <= minimumNumberOfAlertas())
    {
      return wasRemoved;
    }

    alertas.remove(aAlerta);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAlertaAt(Alerta aAlerta, int index)
  {  
    boolean wasAdded = false;
    if(addAlerta(aAlerta))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAlertas()) { index = numberOfAlertas() - 1; }
      alertas.remove(aAlerta);
      alertas.add(index, aAlerta);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAlertaAt(Alerta aAlerta, int index)
  {
    boolean wasAdded = false;
    if(alertas.contains(aAlerta))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAlertas()) { index = numberOfAlertas() - 1; }
      alertas.remove(aAlerta);
      alertas.add(index, aAlerta);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAlertaAt(aAlerta, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=usuarios.size(); i > 0; i--)
    {
      Usuario aUsuario = usuarios.get(i - 1);
      aUsuario.delete();
    }
    for(int i=sensors.size(); i > 0; i--)
    {
      Sensor aSensor = sensors.get(i - 1);
      aSensor.delete();
    }
    Cultivo placeholderCultivo = cultivo;
    this.cultivo = null;
    if(placeholderCultivo != null)
    {
      placeholderCultivo.removePlantacion(this);
    }
    ConfiguracionTomaDecisiones existingConfiguracionTomaDecisiones = configuracionTomaDecisiones;
    configuracionTomaDecisiones = null;
    if (existingConfiguracionTomaDecisiones != null)
    {
      existingConfiguracionTomaDecisiones.delete();
    }
    for(int i=alertas.size(); i > 0; i--)
    {
      Alerta aAlerta = alertas.get(i - 1);
      aAlerta.delete();
    }
  }

  // line 48 "model.ump"
  public Alerta generarAlerta(){
    
  }

  // line 49 "model.ump"
  public boolean excedeValorUmbral(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "cantidadEspacio" + ":" + getCantidadEspacio()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "nombre" + "=" + (getNombre() != null ? !getNombre().equals(this)  ? getNombre().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "fechaRegistro" + "=" + (getFechaRegistro() != null ? !getFechaRegistro().equals(this)  ? getFechaRegistro().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "cultivo = "+(getCultivo()!=null?Integer.toHexString(System.identityHashCode(getCultivo())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "configuracionTomaDecisiones = "+(getConfiguracionTomaDecisiones()!=null?Integer.toHexString(System.identityHashCode(getConfiguracionTomaDecisiones())):"null");
  }
}