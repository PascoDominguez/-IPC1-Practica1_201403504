package snake;

import java.util.Scanner;

public class Snake {

    public static void main(String[] args) {
        Snake sk = new Snake();
        sk.menuInicio();
    }
    public void menuInicio(){
                InicioJuego ij = new InicioJuego();
        Scanner sc = new Scanner(System.in);
        Snake s = new Snake();
        s.menu();
        int numero = sc.nextInt();
        int seleccionar = numero;
        char salir = 'n';
        while (salir < 1000) {
            switch (seleccionar) {
                case 1:
                    ij.InicioJuego();
                    ij.moverse();
                            
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
            System.out.println();
            System.out.println("MENU");
            s.menu();
                    
            seleccionar = sc.nextInt();
        }
    }

    public void menu() {
        System.out.println("\033[33m+================================================+");
        System.out.println("\033[33m+======        \033[32mSELECCIONE LA OPCION        \033[33m======+");
        System.out.println("\033[33m+================================================+");
        System.out.println("\033[33m+ \033[32m1.  Inicio del Juego                           \033[33m+");
        System.out.println("\033[33m+ \033[32m2.  Datos del Estudiante                       \033[33m+");
        System.out.println("\033[33m+ \033[32m3.  Historial de Partidas Jugadas              \033[33m+");
        System.out.println("\033[33m+ \033[32m4.  Salir                                      \033[33m+");
        System.out.println("\033[33m+================================================+");
        
    }
    
   
    

}
