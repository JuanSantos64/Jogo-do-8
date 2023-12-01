/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author juans
 */
public class jogodo8 {

    public static void main(String[] args) {
        Integer[][] a = criarMatriz();
        a = preencherVetor(a);
        Integer[][] b = embaralharMatriz(a);
        boolean aaa = matrizPerfeita(b);
        jogar(b, aaa);
    }

    public static Integer[][] criarMatriz() {
        Integer[][] aa = {};
        return aa;
    }

    public static Integer[][] preencherVetor(Integer[][] a) {
        int cont = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = cont;
                cont++;
            }
        }
        return a;
    }

    public static Integer[][] embaralharMatriz(Integer[][] a) {
        Integer[][] array = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        List<Integer[]> list = Arrays.asList(array);
        Collections.shuffle(list);
        Collections.shuffle(list);
        Collections.shuffle(list);
        list.toArray(array);
        return array;
    }

    public static void imprimirMatriz(Integer[][] a) {
        String[][] aa = new String[3][3];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                aa[i][j] = a[i][j].toString();
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if ("0".equals(aa[i][j])) {
                    aa[i][j] = " ";
                }
                System.out.print(aa[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean matrizPerfeita(Integer[][] b) {
        boolean pft = false;
        if (Arrays.deepToString(b).equals("[[0, 1, 2], [3, 4, 5], [6, 7, 8]]")) {
            pft = true;
        }
        return pft;
    }

    public static void jogar(Integer[][] a, boolean b) {
        Scanner entrada = new Scanner(System.in);
        int movimentos = 0;
        while (b == false) {
            b = matrizPerfeita(a);
            if (b == true) {
                break;
            }

            imprimirMatriz(a);
            System.out.println("Movimentos: " + movimentos);
            System.out.println("Digite o número: ");

            int numero = entrada.nextInt();
            if (numero == 69) {
                a = preencherVetor(a);
                System.out.println("Você ganhou!");
            }
            int linhaChute = 0, colunaChute = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    if (numero == a[i][j]) {
                        linhaChute = i;
                        colunaChute = j;
                    }
                }
            }
            if (colunaChute < (a[0].length - 1) && a[linhaChute][colunaChute + 1] == 0) { // Verificação do lado direito
                a[linhaChute][colunaChute + 1] = a[linhaChute][colunaChute];
                a[linhaChute][colunaChute] = 0;
            } else if (colunaChute > 0 && a[linhaChute][colunaChute - 1] == 0) { // Verificação do lado esquerdo
                a[linhaChute][colunaChute - 1] = a[linhaChute][colunaChute];
                a[linhaChute][colunaChute] = 0;
            } else if (linhaChute > 0 && a[linhaChute - 1][colunaChute] == 0) { // Verificação do lado superior
                a[linhaChute - 1][colunaChute] = a[linhaChute][colunaChute];
                a[linhaChute][colunaChute] = 0;
            } else if (linhaChute < a.length - 1 && a[linhaChute + 1][colunaChute] == 0) { // Verificação do lado inferior
                a[linhaChute + 1][colunaChute] = a[linhaChute][colunaChute];
                a[linhaChute][colunaChute] = 0;
            }
            movimentos++;
        }

    }
}
