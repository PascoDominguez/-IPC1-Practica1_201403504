package snake;

import java.util.Scanner;

public class InicioJuego {

    int num1 = 0;
    int num2 = 0;
    int tamX = 0;
    int tamY = 0;
    int tamSnake;
    String usuario;
    String tablero[][];
    String datos[];
    Scanner sc = new Scanner(System.in);
    Culebra culebra = new Culebra();
    Fruto fruto = new Fruto();

    public void InicioJuego() {
        System.out.println("Nombre de Usuario");
        usuario = sc.nextLine();

        //     TAMAÑO EN X
        while (num1 < 10 && num1 <= 15) {
            System.out.println("Tamaño en X del tablero");
            num1 = sc.nextInt();
            tamX = num1;
        }

        //     TAMAÑO EN Y
        while (num2 < 10 && num2 <= 15) {
            System.out.println("Tamaño en Y del tablero");
            num2 = sc.nextInt();
            tamY = num2;
        }
        //TAMAÑO DE LA SERPIENTE
        System.out.println("Tamaño inicial del Snake");
        tamSnake = sc.nextInt();
        System.out.println("tamanio inicial del snake " + tamSnake);
        tablero = new String[tamX][tamY];
        InicioJuego ij = new InicioJuego();
        fruto = new Fruto((int) (Math.random() * tablero.length), (int) (Math.random() * tablero.length), '*');
        culebra = new Culebra(tamX, tamY, 5, 5, '@', 1);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                this.tablero[i][j] = "\033[33m.";
            }
        }
        this.imprimeTablero();
        this.moverse();

    }

    public void imprimeTablero() {
        this.actulizarMatriz();
        for (int i = 0; i <= tablero.length; i++) {
            for (int j = 0; j <= tablero.length; j++) {
                if (j == 0 || i == 0 || j == tablero.length || i == tablero.length) {
                    System.out.print(" # ");
                } else {
                    System.out.print(this.tablero[i][j] + "  ");
                }

            }
            System.out.println();
        }

    }

    public void actulizarMatriz() {
        this.tablero[this.culebra.posicionX][this.culebra.posicionY] = String.valueOf(this.culebra.caracter);
        this.tablero[this.fruto.posicionX][this.fruto.posicionY] = String.valueOf(this.fruto.caracter);

    }

    public void comido() {

        if (this.culebra.posicionX == this.fruto.posicionX && this.culebra.posicionY == this.fruto.posicionY) {
            this.fruto = new Fruto((int) (Math.random() * tablero.length), (int) (Math.random() * tablero.length), '*');
            this.crecer();
        }

    }

    public void finJuego() {
        for (int i = 0; i < this.tablero.length; i++) {
            if (this.culebra.posicionX == i && this.culebra.posicionY == 0 || //vertical inicial
                    this.culebra.posicionX == i && this.culebra.posicionY == this.tablero.length || //vertical final
                    this.culebra.posicionY == i && this.culebra.posicionX == 0 || //horizontal inicial
                    this.culebra.posicionY == i && this.culebra.posicionX == this.tablero.length) {   //horizontal final
                System.out.println("\033[32m----------------------------------");
                System.out.println("\033[32m--          GAME OVER           --");
                System.out.println("\033[32m----------------------------------");
                System.out.println();
                System.out.println();
                this.historial();
                break;
            }
        }
    }

    public void crecer() {
        this.culebra.tamanio += 1;
        for (int i = 0; i < this.culebra.tamanio; i++) {
            this.culebra.cuerpo[i] = this.culebra.caracter;
        }
    }

    public void moverse() {
        boolean continuar = true;
        char movimiento;

        while (continuar) {
            sc = new Scanner(System.in);
            movimiento = sc.nextLine().charAt(0);

            this.tablero[this.culebra.posicionX][this.culebra.posicionY] = ".";
            switch (movimiento) {
                case 'w':

                    this.culebra.posicionX = this.culebra.posicionX - 1;
                    this.finJuego();
                    this.comido();
                    this.imprimeTablero();
                    break;
                case 'a':
                    this.culebra.posicionY = this.culebra.posicionY - 1;
                    this.finJuego();
                    this.comido();
                    this.imprimeTablero();
                    break;
                case 's':
                    this.culebra.posicionX = this.culebra.posicionX + 1;
                    this.finJuego();
                    this.comido();
                    this.imprimeTablero();
                    break;
                case 'd':
                    this.culebra.posicionY = this.culebra.posicionY + 1;
                    this.finJuego();
                    this.comido();
                    this.imprimeTablero();
                    break;

            }
        }
    }

    public void historial() {
        datos = new String[4];
        datos[0] = usuario;
        datos[1] = String.valueOf(this.culebra.posicionX);
        datos[2] = String.valueOf(this.culebra.posicionY);
        datos[3] = String.valueOf(tamSnake);

        //impirmir historial
        System.out.println("    BITACORA DEL JUEGO  ");
        System.out.println("-----------------------------------");
        System.out.print(datos[1] + " X " + datos[2]);
        System.out.println("    " + datos[0]);
        System.out.println("-----------------------------------");
        this.imprimeTablero();

        System.out.println("------------------------------------");
        System.out.println("TS: " + datos[3]);
    }

}
