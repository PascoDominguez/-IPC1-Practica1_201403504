
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
        ij.tablero(tamX, tamY, tablero);

    }

    //tablero

    public void tablero(int tamX, int tamY, String tablero[][]) {
        int frutoX = (int) (Math.random() * tablero.length + 1);
        int frutoY = (int) (Math.random() * tablero.length + 1);
        System.out.println("" + frutoX);
        System.out.println("" + frutoY);
        System.out.println("TABLERO");
        for (int i = 0; i <= tablero.length + 1; i++) {
            for (int j = 0; j <= tablero.length + 2; j++) {
                if (j == 0 || j == tablero.length + 2 || i == 0 || i == tablero.length + 1) {
                    System.out.print(" # ");
                } else {
                    if (i == frutoX && j == frutoY) {
                        System.out.print(" + ");
                    } else {
                        System.out.print("   ");
                    }
                }
            }
            System.out.println();
        }
    }

    public void historial() {
        datos = new String[4];
        datos[0] = usuario;
        datos[1] = String.valueOf(num1);
        datos[2] = String.valueOf(num2);
        datos[3] = String.valueOf(tamSnake);

        //impirmir historial
        System.out.println("    BITACORA DEL JUEGO  ");
        System.out.println("-----------------------------------");
        System.out.print(datos[1] + " X " + datos[2]);
        System.out.println("    " + datos[0]);
        System.out.println("-----------------------------------");
        InicioJuego ij = new InicioJuego();
        ij.tablero(tamX, tamY, tablero);
        System.out.println("------------------------------------");
        System.out.println("TS: " + datos[3]);
    }
}
