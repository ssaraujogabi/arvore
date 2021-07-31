package Estrutura_2;

import Estrutura_2.Arvore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Arvore<Integer> arvore = new Arvore<Integer>();
        for (int i = 0; i < 7; i++) {
            int num = input.nextInt();
            arvore.inserir(num);
        }
    }
}
