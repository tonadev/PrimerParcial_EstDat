public class Nodo<T> {
  private T informacion;
  private Nodo<T> siguiente;

  public Nodo(T informacion) {
    this.informacion = informacion;
  }

  public Nodo(T informacion, Nodo<T> siguiente) {
    this.informacion = informacion;
    this.siguiente = siguiente;
  }

  public T getInformacion() { return this.informacion; }
  public Nodo<T> getSiguiente() { return this.siguiente; }

  public void setInformacion(T informacion) {
    this.informacion = informacion;
  }

  public void setSiguiente(Nodo<T> siguiente) {
    this.siguiente = siguiente;
  }
}

