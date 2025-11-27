package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Olivas {
    static void main() {
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        System.out.println("**** BIENVENIDO AL OLIVÓMETRO ****");
        System.out.println("Introduce el tamaño de tu bancal");
        boolean estado = false;
        int ancho = 0;
        int largo = 0;
        do {
            try {
                System.out.println("Introduce el ancho");
                ancho = entrada.nextInt();
                System.out.println("Introduce el largo");
                largo = entrada.nextInt();
                estado = true;
            } catch (InputMismatchException e) {
                System.out.println("Formato Incorrecto, vuelva a introducir los valores");
            }
            entrada.nextLine();
        }while (!estado);

        String[][] matriz = new String[largo][ancho];
        float total = 0;
        System.out.println("Introduce (por hileras) los kg por árbol de tu bancal");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (entrada.hasNextInt()) {
                    matriz[i][j] = entrada.next();
                    if (Integer.parseInt(matriz[i][j]) < 1 || Integer.parseInt(matriz[i][j]) > 50 )
                    {
                        System.out.println("Valor no valido, Adios");
                        return;
                    }
                    total += Integer.parseInt(matriz[i][j]);
                }else{
                    System.out.println("Valor no valido");
                    return;
                }
            }
        }
        System.out.println("====================");
        System.out.println("Mapa de tu bancal actual:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("====================");
        System.out.println("Total kg generados: " + total + "kg");
        System.out.println("Total litros obtenidos: " + (total/8) + " L");
        System.out.println("Litros por hilera:");
        for (int i = 0; i < matriz[0].length; i++) {
            total = 0;
            for (int j = 0; j < matriz.length; j++) {
                total += Integer.parseInt(matriz[j][i]);
            }
            System.out.println(" - Hilera " + (i + 1) + ": " + (total/8) + " L");
        }
        int mayor = 0;
        int letra1= 0;
        int letra2 = 0;
        System.out.println("Olivos mas productivos (>35kg)");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (Integer.parseInt(matriz[i][j]) > 35){
                    System.out.println(" - En la posicion (" + (i+ 1) + "," + (j+ 1) + ") con " + matriz[i][j] + "kg");
                }
                if (mayor < Integer.parseInt(matriz[i][j])){
                    mayor = Integer.parseInt(matriz[i][j]);
                    letra1 = i;
                    letra2 = j;
                }
            }
        }
        int random = 0;
        System.out.println("Olivo TOP (" + mayor + "kg generados) en la posicion (" + (letra1 + 1) + "," + (letra2 + 1 )+ ") del bancal." );
        String[][] replantar = new String[largo][ancho];
        for (int i = 0; i < replantar.length; i++) {
            for (int j = 0; j < replantar[0].length; j++) {
                if (Integer.parseInt(matriz[i][j]) < 5){
                    replantar[i][j] = "X";
                    random = aleatorio.nextInt(15,36);
                    matriz[i][j]= Integer.toString(random);

                }else{
                    replantar[i][j] = "O";
                }
            }
        }
        System.out.println("=======================");
        System.out.println("Mapa para replantar");
        for (int i = 0; i < replantar.length; i++) {
            for (int j = 0; j < replantar[0].length; j++) {
                System.out.print(replantar[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=======================");
        System.out.println("Mapa estimación despues de replantar");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

    }
}


