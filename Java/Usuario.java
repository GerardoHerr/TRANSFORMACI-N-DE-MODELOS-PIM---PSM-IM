/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 12 "model.ump"
// line 116 "model.ump"
public class Usuario
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Usuario Attributes
  private string nombre;
  private string correo;
  private string clave;

  //Usuario Associations
  private Rol rol;
  private Plantacion plantacion;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Usuario(string aNombre, string aCorreo, string aClave, Rol aRol, Plantacion aPlantacion)
  {
    nombre = aNombre;
    correo = aCorreo;
    clave = aClave;
    boolean didAddRol = setRol(aRol);
    if (!didAddRol)
    {
      throw new RuntimeException("Unable to create usuario due to rol. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddPlantacion = setPlantacion(aPlantacion);
    if (!didAddPlantacion)
    {
      throw new RuntimeException("Unable to create usuario due to plantacion. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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

  public boolean setCorreo(string aCorreo)
  {
    boolean wasSet = false;
    correo = aCorreo;
    wasSet = true;
    return wasSet;
  }

  public boolean setClave(string aClave)
  {
    boolean wasSet = false;
    clave = aClave;
    wasSet = true;
    return wasSet;
  }

  public string getNombre()
  {
    return nombre;
  }

  public string getCorreo()
  {
    return correo;
  }

  public string getClave()
  {
    return clave;
  }
  /* Code from template association_GetOne */
  public Rol getRol()
  {
    return rol;
  }
  /* Code from template association_GetOne */
  public Plantacion getPlantacion()
  {
    return plantacion;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setRol(Rol aRol)
  {
    boolean wasSet = false;
    //Must provide rol to usuario
    if (aRol == null)
    {
      return wasSet;
    }

    if (rol != null && rol.numberOfUsuarios() <= Rol.minimumNumberOfUsuarios())
    {
      return wasSet;
    }

    Rol existingRol = rol;
    rol = aRol;
    if (existingRol != null && !existingRol.equals(aRol))
    {
      boolean didRemove = existingRol.removeUsuario(this);
      if (!didRemove)
      {
        rol = existingRol;
        return wasSet;
      }
    }
    rol.addUsuario(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setPlantacion(Plantacion aPlantacion)
  {
    boolean wasSet = false;
    //Must provide plantacion to usuario
    if (aPlantacion == null)
    {
      return wasSet;
    }

    if (plantacion != null && plantacion.numberOfUsuarios() <= Plantacion.minimumNumberOfUsuarios())
    {
      return wasSet;
    }

    Plantacion existingPlantacion = plantacion;
    plantacion = aPlantacion;
    if (existingPlantacion != null && !existingPlantacion.equals(aPlantacion))
    {
      boolean didRemove = existingPlantacion.removeUsuario(this);
      if (!didRemove)
      {
        plantacion = existingPlantacion;
        return wasSet;
      }
    }
    plantacion.addUsuario(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Rol placeholderRol = rol;
    this.rol = null;
    if(placeholderRol != null)
    {
      placeholderRol.removeUsuario(this);
    }
    Plantacion placeholderPlantacion = plantacion;
    this.plantacion = null;
    if(placeholderPlantacion != null)
    {
      placeholderPlantacion.removeUsuario(this);
    }
  }

  // line 17 "model.ump"
  public boolean iniciarSesion(){
    
  }

  // line 18 "model.ump"
  public void cerrrarSesion(){
    
  }

  // line 19 "model.ump"
  public boolean actualizarPerfil(){
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "nombre" + "=" + (getNombre() != null ? !getNombre().equals(this)  ? getNombre().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "correo" + "=" + (getCorreo() != null ? !getCorreo().equals(this)  ? getCorreo().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "clave" + "=" + (getClave() != null ? !getClave().equals(this)  ? getClave().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "rol = "+(getRol()!=null?Integer.toHexString(System.identityHashCode(getRol())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "plantacion = "+(getPlantacion()!=null?Integer.toHexString(System.identityHashCode(getPlantacion())):"null");
  }
}