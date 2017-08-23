package snake;

import java.util.Scanner;

public class Snake {
    
    public static void main(String[] args) {
        InicioJuego ij = new InicioJuego();
        Scanner sc = new Scanner(System.in);
        Snake s = new Snake();
        s.menu();
        int numero = sc.nextInt();
        int seleccionar = numero;
        while (seleccionar<1000) {
            switch (seleccionar) {
                case 1:
                    ij.InicioJuego();
                    break;
                case 2:
                    DatosEstudiante de = new DatosEstudiante();
                    de.misDatos();
                    break;
                case 3:
                    ij.historial();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }    
            System.out.println("");
            System.out.println("**********************************************");
            System.out.println("MENU");
            s.menu();
            seleccionar = sc.nextInt();
        }
    }

    public void menu() {
        System.out.println("+================================================+");
        System.out.println("+======        SELECCIONE LA OPCION        ======+");
        System.out.println("+================================================+");
        System.out.println("+ 1.  Inicio del Juego                           +");
        System.out.println("+ 2.  Datos del Estudiante                       +");
        System.out.println("+ 3.  Historial de Partidas Jugadas              +");
        System.out.println("+ 4.  Salir                                      +");
        System.out.println("+================================================+");
    }

}
