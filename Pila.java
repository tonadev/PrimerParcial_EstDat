public class Pila<T> {
  private ListaLigada<T> listaLigada;;

  public Pila() {
    this.listaLigada = new ListaLigada<T>();
  }
  
  public boolean empty() {
    if (this.listaLigada.getCabeza() == null)
      return true;
    return false;
  }

  public T peek() throws PilaVaciaException {
    if (this.empty())
      throw new PilaVaciaException();
    return this.listaLigada.getCabeza().getInformacion();
  }

  public void push(T item) {
    this.listaLigada.insertaAlInicio(new Nodo<T>(item));
  }

  public T pop() throws PilaVaciaException {
    if (this.empty())
      throw new PilaVaciaException();
    T informacion = this.listaLigada.getCabeza().getInformacion();
    this.listaLigada.eliminaAlInicio();
    return informacion;
  }
}

