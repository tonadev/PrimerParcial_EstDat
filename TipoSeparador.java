public enum TipoSeparador {
  PARENTESIS ('(', ')'),
  CORCHETE ('[', ']'),
  LLAVE ('{', '}');

  private final char simboloApertura;
  private final char simboloCerradura;

  TipoSeparador (char simboloApertura, char simboloCerradura) {
    this.simboloApertura = simboloApertura;
    this.simboloCerradura = simboloCerradura;
  }

  public char getSimboloApertura() { return this.simboloApertura; }
  public char getSimboloCerradura() { return this.simboloCerradura; }

}

