import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lexer {
  public void analizar(String nombreArchivo) throws SeparadorFaltanteException {
    BufferedReader entrada = null;
    Pila<Separador> separadores = new Pila<Separador>();

    int chr;
    Separador tope;
    char separadorEsperado;

    try {
      entrada = new BufferedReader(new FileReader(nombreArchivo));
      while ((chr = entrada.read()) != -1) {
        switch((char) chr) {
          case '(':
            separadores.push(new Separador(TipoSeparador.PARENTESIS)); 
            break;
          case ')':
            try {
              tope = separadores.pop();
              separadorEsperado = tope.getTipo().getSimboloCerradura();
              if (separadorEsperado != ')')
                throw new SeparadorFaltanteException(separadorEsperado);
            } catch (PilaVaciaException e) {
              throw new SeparadorFaltanteException('(');
            }
            break;
          case '{':
            separadores.push(new Separador(TipoSeparador.LLAVE)); 
            break;
          case '}':
            try {
              tope = separadores.pop();
              separadorEsperado = tope.getTipo().getSimboloCerradura();
              if (separadorEsperado != '}')
                throw new SeparadorFaltanteException(separadorEsperado);
            } catch (PilaVaciaException e) {
              throw new SeparadorFaltanteException('{');
            }
            break;
          case '[':
            separadores.push(new Separador(TipoSeparador.CORCHETE)); 
            break;
          case ']':
            try {
              tope = separadores.pop();
              separadorEsperado = tope.getTipo().getSimboloCerradura();
              if (separadorEsperado != ']')
                throw new SeparadorFaltanteException(separadorEsperado);
            } catch (PilaVaciaException e) {
              throw new SeparadorFaltanteException('[');
            }
            break;
          default:
            break;
        }
      }
      if (!separadores.empty()) {
        try {
          separadorEsperado = separadores.peek().getTipo().getSimboloCerradura();
          throw new SeparadorFaltanteException(separadorEsperado);
        } catch (PilaVaciaException e) {
          e.printStackTrace();
        }
      }
      System.out.println("El archivo no contiene errores.");
    } catch (FileNotFoundException e2) {
      System.out.println("No se ha encontrado el archivo.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String args[]) {
    Lexer lex = new Lexer();
    try {
      lex.analizar("test.txt");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
