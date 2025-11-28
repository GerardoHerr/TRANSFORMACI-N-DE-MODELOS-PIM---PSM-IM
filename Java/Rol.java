/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 111 "model.ump"
public class Rol
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Rol Attributes
  private string tipo;
  private boolean isActivo;

  //Rol Associations
  private List<Usuario> usuarios;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Rol(string aTipo, boolean aIsActivo)
  {
    tipo = aTipo;
    isActivo = aIsActivo;
    usuarios = new ArrayList<Usuario>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTipo(string aTipo)
  {
    boolean wasSet = false;
    tipo = aTipo;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsActivo(boolean aIsActivo)
  {
    boolean wasSet = false;
    isActivo = aIsActivo;
    wasSet = true;
    return wasSet;
  }

  public string getTipo()
  {
    return tipo;
  }

  public boolean getIsActivo()
  {
    return isActivo;
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
  public Usuario addUsuario(string aNombre, string aCorreo, string aClave, Plantacion aPlantacion)
  {
    Usuario aNewUsuario = new Usuario(aNombre, aCorreo, aClave, this, aPlantacion);
    return aNewUsuario;
  }

  public boolean addUsuario(Usuario aUsuario)
  {
    boolean wasAdded = false;
    if (usuarios.contains(aUsuario)) { return false; }
    Rol existingRol = aUsuario.getRol();
    boolean isNewRol = existingRol != null && !this.equals(existingRol);

    if (isNewRol && existingRol.numberOfUsuarios() <= minimumNumberOfUsuarios())
    {
      return wasAdded;
    }
    if (isNewRol)
    {
      aUsuario.setRol(this);
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
    //Unable to remove aUsuario, as it must always have a rol
    if (this.equals(aUsuario.getRol()))
    {
      return wasRemoved;
    }

    //rol already at minimum (1)
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

  public void delete()
  {
    for(int i=usuarios.size(); i > 0; i--)
    {
      Usuario aUsuario = usuarios.get(i - 1);
      aUsuario.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "isActivo" + ":" + getIsActivo()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tipo" + "=" + (getTipo() != null ? !getTipo().equals(this)  ? getTipo().toString().replaceAll("  ","    ") : "this" : "null");
  }
}