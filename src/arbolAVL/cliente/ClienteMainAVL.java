/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolAVL.cliente;

import arbolAVL.modelo.Entero;
import arbolAVL.modelo.Nodo;
import arbolAVL.modelo.ArbolAVL;

import arbolAVL.graficar.BTreePrinter;
import java.util.Scanner;

public class ClienteMainAVL {

    public static void main(String[] args) {
        int opc;
        Scanner s = new Scanner(System.in);
        ArbolAVL arbolAVL = new ArbolAVL();

        try {
            do {
                menu();
                opc = s.nextInt();
                switch (opc) {
                    case 1:
                        System.out.println(" ingrese el valor");
                        arbolAVL.insertar(new Entero(s.nextInt()));
                        break;
                        case 2:
                          System.out.println(" ingrese el valor");
                        arbolAVL.elminar(new Entero(s.nextInt()));
                        break;
                        case 3:
                         BTreePrinter.printNode(arbolAVL.getRaiz());
                        break;
                        case 4:
                            System.out.println("finalizando programa");
                        break;
                    default:
                        throw new AssertionError();
                }
 
            } while (opc != 4);

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());

        }

    }
    

    public static void menu() {
        System.out.println("\n\n 1: insetar valor en el arbol");
        System.out.println(" 2: eliminar valor en el arbol");
        System.out.println(" 3: ver arbol");
        System.out.println(" 4: salir");
        System.out.println("selecciones un opcion");
    }
}
