/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia5;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Dario
 */
public class Guia5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String vResp;
        do {
            System.out.println(" *************** MENU ***************** \n"
                    + " 1 ---- Practica nro 1 de Arreglos  \n"
                    + " 2 ---- Llenar un vector de 100 y mostrarlo de forma decendente   \n"
                    + " 3 ---- Llenar vector con N elementos y buscar las repeticiones \n"
                    + " 4 ---- Matriz Transpuesta \n"
                    + " 5 ---- Matriz Anti Simetrica \n"
                    + " 6 ---- Cubo magico \n"
                    + " 7 ---- Buscar una Matriz mas pequeña en una mas grande \n"
                    + " S ---- Salir \n");
            vResp = JOptionPane.showInputDialog("Que Opcion Elijes, S Sale");
            if (vResp == null){
                vResp = "S";
            }
            switch (vResp) {
                case "1":
                    //Luego desde el método main de una clase de nombre PruebaArreglo, invocar los métodos
                    //de la clase Arreglo creada por usted.
                    int[] vector =new int[10];
                    System.out.println("Vector: ");
                    for (int i=0;i< 10;i++){
                        vector[i] = (int) (Math.random() * 10 + 1);
                        System.out.print(vector[i] + "  ");
                    }
                    Arreglo.sumarLista(vector);
                    int [][] matrizi = new int[10][];
                    for (int i = 0; i<10;i++){
                        matrizi[i]=new int[(int) (Math.random() * 5 + 1)];
                    }
                    System.out.println("********************");
                    System.out.println("Matriz Irregular");
                    for (int i = 0; i < 10;i++){
                        for (int x = 0;x<matrizi[i].length;x++){
                            matrizi[i][x]=(int) (Math.random() * 9 + 1);
                            System.out.print(" " + matrizi[i][x]);
                        }
                        //System.out.println(matrizi[i].length);
                        System.out.println(" ");
                    }
                    System.out.println("Buscando ...");
                    System.out.println("El elemento mayor es: " + Arreglo.buscarMayor(matrizi));
                    System.out.println("******************");
                    String cadena = "Como estamos hoy EE";
                    System.out.println("Buscando vocales en una cadena: " + cadena);
                    System.out.println("La cantidad de vocales es: " + Arreglo.cuentaVocales(cadena));
                    System.out.println("******************");
                    char caracter = 't';
                    System.out.println("en la misma cadena la cantidad de " + caracter + " es: " + Arreglo.cuentaCaracter(cadena,caracter));
                    break;
                case "2":
                    /*En un nuevo proyecto en el método main de su clase principal, se pide crear un algoritmo que
                     rellene un vector con los 100 primeros números enteros y los muestre por pantalla en orden
                    descendente.*/
                    int[] vector1 = new int[100];
                    for (int i=0;i<100;i++){
                        vector1[i]=i+1;
                        System.out.print(vector1[i] + " ");
                    }
                    System.out.println(" ***** ");
                    for (int i=99;i>-1;i--){
                        System.out.print(vector1[i] + " ");
                    }
                    break;
                case "3":
                    /*En un nuevo proyecto, en el método main de su clase principal, se pide crear un algoritmo que
                     rellene un vector de tamaño N con valores aleatorios y le pida al usuario un número a buscar en el
                     vector. El programa mostrará donde se encuentra el número y si se encuentra repetido*/
                    System.out.print("de que tamaño el vector: ");
                    int tam = teclado.nextInt();
                    int[] vector2 = new int[tam];
                    System.out.println("Cargando vector!!!");
                    for (int i=0;i<tam;i++){
                        vector2[i]=(int) (Math.random() * 10 + 1);
                        System.out.print(vector2[i]+ "  ");
                    }
                    System.out.println("");
                    System.out.print("Que numero buscar... ");
                    int buscar = teclado.nextInt();
                    int rep = 0;
                    for (int i = 0;i<tam;i++){
                        if (vector2[i]==buscar){
                            rep++;
                            System.out.println("Encontrado en la posicion: " + i);
                        }
                    }
                    break;
                case "4":
                    int[][] matriz = new int[4][4];
                    int[][] matriz1 = new int[4][4];
                    Arreglo.llenarMatriz(matriz);
                    Arreglo.mostrarMatriz(matriz);
                    System.out.println("*****************");
                    System.out.println("Transpuesta:");
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            matriz1[j][i] = matriz[i][j];
                        }
                    }
                    Arreglo.mostrarMatriz(matriz1);
                    break;
                case "5":
                    /*En un nuevo proyecto, en el método main de su clase principal, se pide realice un algoritmo que
compruebe si una matriz dada es anti simétrica. Se dice que una matriz A es anti simétrica cuando

ésta es igual a su propia traspuesta, pero cambiada de signo. Es decir, A es anti simétrica si A = -
AT. La matriz traspuesta de una matriz A se denota por AT y se obtiene cambiando sus filas por
columnas (o viceversa).*/
                    int[][] matriz2 = new int[3][3];
                    int[][] matriz3 = new int[3][3];
                    matriz2[0][0] = 0;
                    matriz2[0][1] = -2;
                    matriz2[0][2] = 4;
                    matriz2[1][0] = 2;
                    matriz2[1][1] = 0;
                    matriz2[1][2] = 2;
                    matriz2[2][0] = -4;
                    matriz2[2][1] = -2;
                    matriz2[2][2] = 0;
                    for (int i = 0; i < matriz2.length; i++) {
                        for (int j = 0; j < matriz2[i].length; j++) {
                            matriz3[j][i] = matriz2[i][j];
                        }
                    }
                    System.out.println("Matriz recibida...");
                    Arreglo.mostrarMatriz(matriz2);
                    System.out.println("Matriz Transpuesta ..");                    
                    Arreglo.mostrarMatriz(matriz3);
                    System.out.println("Comprobando....");
                    boolean anti = true;
                    for (int i=0;i<matriz2.length;i++){
                        for (int j=0;j<matriz2[i].length;j++){
                            //System.out.println(" i = " + i + "   j=" + j );
                            if (matriz2[i][j]!=matriz3[i][j]*-1){
                                System.out.println(" " + matriz2[i][j]*(-1) + " == " + matriz3[i][j]);
                                anti = false;
                            }
                        }
                    }
                    if (anti){
                        System.out.println("SI es antisimetrica");
                    }else{
                        System.out.println("NO es antisimetrica");
                    }
                    
                    break;
                case "6":
                    int[][] esmagico = new int[3][3];
                    esmagico[0][0] = 2;
                    esmagico[0][1] = 7;
                    esmagico[0][2] = 6;
                    esmagico[1][0] = 9;
                    esmagico[1][1] = 5;
                    esmagico[1][2] = 1;
                    esmagico[2][0] = 4;
                    esmagico[2][1] = 3;
                    esmagico[2][2] = 8;
                    Arreglo.mostrarMatriz(esmagico);
                    if (Arreglo.esMagico(esmagico)) {
                        System.out.println("Si es un cubo magico...");
                    } else {
                        System.out.println("No es un cubo magico...");
                    }
                    break;
                case "7":
                    int [][] gigante = new int[10][10];
                    int [][] peque = new int[3][3];
                    Arreglo.llenarMatriz(gigante);
                    Arreglo.mostrarMatriz1(gigante, peque);
                    Arreglo.mostrarMatriz(gigante);
                    //Arreglo.llenarMatriz(peque);
                    Arreglo.mostrarMatriz(peque);
                    Arreglo.buscarMatriz(gigante, peque);
                    break;


            }
        } while (!vResp.toUpperCase().equals("S"));
        JOptionPane.showMessageDialog(null, "Gracias por usar nuestros software!!");
    }
    
}
