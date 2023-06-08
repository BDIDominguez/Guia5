
package guia5;

public class Arreglo {
    
    
    static void sumarLista(int[] vector){
        int i=0;
        double suma = 0; // no se porque no me deja al dividir convertirlo en doble, sino lo declaro como double lo trunca en la divicion
        for (int j:vector){
            suma = suma + vector[i];
            i++;
        }
        System.out.println("La suma del vector es de: " + suma);
        double prom = suma/i; 
        //System.out.println("El promedio es: " + (Math.round((suma/i)*100)/100));
        System.out.println("El promedio de los  " + i + " elementos, es de  "  + prom);
    }
    static int buscarMayor(int[][] matriz){
        
        int max;
        max = matriz[0][0];
        for (int a=0; a<matriz.length;a++){
            for (int b=0;b<matriz[a].length;b++){
                if (matriz[a][b]>max){
                    max = matriz[a][b];
                }
            }
        }
        return max;
    }
    public static int cuentaVocales(String cadena) {
        int vocales = 0;
        for (int x = 0; x < cadena.length(); x++) {
            char letraActual = cadena.charAt(x);
            if ("aeiou".contains(String.valueOf(letraActual).toLowerCase())) {
                vocales++;
            }
        }
      return vocales;  
    }
    public static int cuentaCaracter(String cadena,char caracter){
        int posicion,cantidad=0;
        posicion = cadena.indexOf(caracter);
        while (posicion != -1){
            cantidad++;
            posicion = cadena.indexOf(caracter,posicion+1);
        }
        return cantidad;
    }

    static void llenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int x = 0; x < matriz[i].length; x++) {
                matriz[i][x] = (int) (Math.random() * 9 + 1);
               // System.out.print(" " + matriz[i][x]);
            }
            //System.out.println(matrizi[i].length);
           // System.out.println(" ");
        }
    }
    static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int x = 0; x < matriz[i].length; x++) {
                //matriz[i][x] = (int) (Math.random() * 9 + 1);
                System.out.print(" " + matriz[i][x]);
            }
            //System.out.println(matrizi[i].length);
            System.out.println(" ");
        }
    }
    static boolean esMagico(int[][] matriz) {
        int tam = matriz.length; // Asumiendo que es una matriz cuadrada!!!
        // primero se comprueban las filas
        int valor = 0, valor1 = 0;
        boolean estado = true;
        for (int i = 0; i < tam; i++) { // se calcula la primera fila
            valor += matriz[0][i];
        }
        //System.out.println("La suma de la primera fila es " + valor);
        for (int i = 1; i < tam; i++) { // se compara con el primer calculo el resto de las filas
            for (int b = 0; b < tam; b++) {
                valor1 += matriz[i][b];
            }
            if (valor != valor1) {
                System.out.println("La suma de la fila es " + valor1);
                estado = false;
                i = 5;
            }
            valor1 = 0;
        }
        if (estado) { // se comprueban las columnas
            for (int i = 0; i < tam; i++) {
                for (int b = 0; b < tam; b++) {
                    valor1 += matriz[b][i];
                }
                if (valor != valor1) {
                    System.out.println("La suma de la fila es " + valor1);
                    estado = false;
                    i = 5;
                }
                valor1 = 0;

            }
            if (estado) { // se comprueba la diagonal principal \
                for (int b = 0; b < tam; b++) {
                    valor1 += matriz[b][b];
                }
                if (valor != valor1) {
                    System.out.println("La suma de la fila es " + valor1);
                    estado = false;
                }
                if (estado) { // se comprueba la diagonal secundaria /
                    valor1 = 0;
                    int a = 0;
                    for (int b = tam-1; b > -1; b--) {
                        valor1 += matriz[a][b];
                        a++;
                    }
                    if (valor != valor1) {
                        System.out.println("La suma de la fila es " + valor1);
                        estado = false;
                    }
                }
            }

        }
        return estado;
    }
    
    public static void buscarMatriz(int[][] matriz,int[][] buscada){
        int fila=0,vFilaFinal=0,columna=0,vColumnaFinal=0;
        int coin = 0,vuelta = 0;
        boolean vResp = false;
        for (int i = 0;i<matriz.length;i++) {
            for (int b = 0; b < matriz.length;b++){
                //if (compara(buscada, matriz[i][b], coin) && (b <= matriz.length - (buscada.length-1))) {
                if (compara(buscada, matriz[i][b], coin) ) { 
                    coin++;
                    if (coin==1){
                        fila = i;
                        vFilaFinal=fila;
                        columna = b;
                        vColumnaFinal = columna;
                    }
                    //System.out.println("Councidencia nro " + coin + " en la posicion [" + i + "," + b + "]");
                    if (coin == buscada.length) {
                       // System.out.println("Primera Fila encontrada en [" + fila + columna + "]");
                        vResp = true;
                        fila++;
                        for (int c = 1; c < buscada.length; c++) {
                            if (!buscarLinea(matriz, buscada, fila, columna, c)) {
                                c = buscada.length + 2;
                                vResp = false;
                             //   System.out.println("No se encontro la siguiente fila reiniciando!!!");
                            } else {
                            //    System.out.println("Otra Fila encontrada en [" + fila + columna + "]");
                                fila++;
                            }
                        }
                        if (vResp){
                           i=matriz.length + 10;
                           b=matriz.length + 10;
                        }
                    }
                } else {
                    coin = 0;
                }
            }
        }
        if (vResp){
            System.out.println("La matriz buscada si esta contenida en la posicion [" + vFilaFinal + "][" + vColumnaFinal + "]");
        }else{
            System.out.println("No se encuentra la Matriz");
        }
    }
    
    public static boolean compara(int[][] buscada,int valor,int posi){
        int dime = buscada.length;
        int columna = posi / dime;
        int fila = posi - (columna * dime);
        if (valor == buscada[columna][fila]){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean buscarLinea(int[][] matriz,int[][] peque,int fila,int columna,int nro){
        boolean vResp = true;
        //System.out.println("Comparando " + matriz.length + " >= " + fila );
        if (matriz.length >= fila) {
            if (matriz[fila].length >= columna + (peque.length - 1)) {
                for (int i = 0; i < peque.length; i++) {
                    if (matriz[fila][columna] == peque[nro][i]) {
                        columna++;
                    } else {
                        //System.out.println("Errroorrrr");
                        vResp = false;
                    }
                }
            }else{
               // System.out.println("Se pasa de Columnas");
                vResp = false;
            }
        }else{
           // System.out.println("Se pasa de Filas");
            vResp = false;
        }
        
        return vResp;
    }
    
 static void mostrarMatriz1(int[][] matriz, int[][] matriz2){
     // Cargamos una matriz manualmente en una seccion de la grande
     matriz[7][7]=3;
     matriz[7][8]=2;
     matriz[7][9]=1;
     matriz[8][7]=6;
     matriz[8][8]=5;
     matriz[8][9]=4;
     matriz[9][7]=9;
     matriz[9][8]=8;
     matriz[9][9]=7;
     
     // Cargamos la matriz pequeña identica!!!
     matriz2[0][0]=3;
     matriz2[0][1]=2;
     matriz2[0][2]=1;
     matriz2[1][0]=6;
     matriz2[1][1]=5;
     matriz2[1][2]=4;
     matriz2[2][0]=9;
     matriz2[2][1]=8;
     matriz2[2][2]=7;
 }
}
