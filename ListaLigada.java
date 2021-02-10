public class ListaLigada<T> {
  private Nodo<T> cabeza;

  public ListaLigada() { this.cabeza = null; }

  public void insertaAlInicio(Nodo<T> nodo) {
    if (nodo == null) return;
    if (this.cabeza == null) {
      this.cabeza = nodo;
    } else {
      nodo.setSiguiente(this.cabeza);
      this.cabeza = nodo;
    }
  }

  public void eliminaAlInicio() {
    if (this.cabeza == null) return;
    this.cabeza = this.cabeza.getSiguiente();
  }

  public Nodo<T> getCabeza() { return this.cabeza; }

  public void setCabeza(Nodo<T> cabeza) {
    this.cabeza = cabeza;
  }

}
