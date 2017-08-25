
package snake;

/**
 *
 * @author Pasco Dominguez
 */
public class Culebra {

    int posicionX;
    int posicionY;
    char caracter;
    char[] cuerpo;
    int tamanio;

    public Culebra() {
    }

    public Culebra(int tamX, int tamY, int x, int y, char caracter, int tamanio) {
        this.posicionX = x;
        
        
        this.posicionY = y;
        
        
        this.caracter = caracter;
        this.tamanio = tamanio;
        this.cuerpo = new char[100];
        for (int i = 0; i < this.cuerpo.length; i++) {
            this.cuerpo[i] = '.';
        }
        this.cuerpo[0] = caracter;
    }

}
