package ar.edu.utn.frc.tup.lciii;

import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

public class Queen {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */
    public Integer queensAttack(Integer n, Integer k, Integer r_q, Integer c_q, List<List<Integer>> obstacles) {
        // Write your code here
        String[][] tablero = new String[n][n];
        int cantidadCasillas = 0;
        r_q = r_q - 1;
        c_q = c_q - 1;

        // Poner reina en el tablero
        for (int fila=0; fila< n; fila++){
            for (int columna=0; columna<n; columna++){
                if(fila == r_q && columna == c_q){
                    tablero[r_q][c_q] = "reina";
                }else{
                    tablero[fila][columna] = "0";
                }
            }
        }

        // Marca las casillas en la diagonal principal
        for (int i = 0; i < n; i++) {
            int j = c_q - r_q + i;
            if (j >= 0 && j < n && i != r_q) {
                tablero[i][j] = "1";
            }
        }

        // Marca las casillas en la diagonal secundaria
        for (int i = 0; i < n; i++) {
            int j = c_q + r_q - i;
            if (j >= 0 && j < n && i != r_q) {
                tablero[i][j] = "1";
            }
        }

        // Marcar Obstaculos
        if(obstacles != null && k != 0){
            for(List<Integer> obstaculo : obstacles){
                int fila = obstaculo.get(0);
                int columna = obstaculo.get(1);
                fila -= 1;
                columna -= 1;
                if(fila >= 0 && fila < n && columna >= 0 && columna < n){
                    tablero[fila][columna] = "x";
                }
            }
        }


        //Contar casillas Arriba
        int contA = r_q;
        while(contA < n-1){
            contA++;
            if(tablero[contA][c_q] != "x"){
                cantidadCasillas++;
            }
            else{
                break;
            }
        }
        //Contar casillas Abajo (Corregir)
        int contAb = r_q;
        while(contAb > 0){
            contAb--;
            if(tablero[contAb][c_q] != "x"){
                cantidadCasillas++;
            }
            else{
                break;
            }
        }
        //Contar casillas Derecha
        int contD = c_q;
        while(contD < n-1){
            contD++;
            if(tablero[r_q][contD] != "x"){
                cantidadCasillas++;
            }
            else{
                break;
            }
        }
        //Contar casillas Izquierda
        int contI = c_q;
        while(contI > 0){
            contI--;
            if(tablero[r_q][contI] != "x"){
                cantidadCasillas++;
            }
            else{
                break;
            }
        }
        // Contar casillas diagonal superior derecha
        int i = r_q + 1;
        int j = c_q + 1;
        while (i < n && j < n) {
            if(tablero[i][j] != "x"){
                cantidadCasillas++;
                i++;
                j++;
            }
            else {
                break;
            }

        }
        // Contar casillas diagonal superior izquierda
        int f = r_q + 1;
        int c = c_q - 1;
        while (f < n && c >= 0) {
            if(tablero[f][c] != "x"){
                cantidadCasillas++;
                f++;
                c--;
            }
            else {
                break;
            }

        }
        // Contar casillas diagonal inferior derecha
        int a = r_q - 1;
        int z = c_q + 1;
        while (a >= 0 && z < n) {
            if(tablero[a][z] != "x"){
                cantidadCasillas++;
                a--;
                z++;
            }
            else {
                break;
            }

        }
        // Contar casillas diagonal inferior izquierda
        int x = r_q - 1;
        int g = c_q - 1;
        while (x >= 0 && g >= 0) {
            if(tablero[x][g] != "x"){
                cantidadCasillas++;
                x--;
                g--;
            }
            else {
                break;
            }
        }

        return cantidadCasillas;
    }
}
