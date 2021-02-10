public class SeparadorFaltanteException extends Exception {
  public SeparadorFaltanteException(char separador) {
    super("¡Error! Falta un '" + separador + "'");
  }
}
