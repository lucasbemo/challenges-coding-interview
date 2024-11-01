package com.lucaszamboni.challenges.coding.interview.dynamic_programming.fibonacci;

public class Principal {
    public static void main(String[] args) {
        Principal.printFibonacci(100);
    }

    public static void printFibonacci(int target) {
        if (target < 0) {
            System.out.println(0);
            return;
        }

        if (target >= 1) {
            System.out.println(0);
            System.out.println(1);
        }

        int penultimoNumero = 0;
        int ultimoNumero = 1;
        int valor = 1;

        while (valor <= target) {
            valor = penultimoNumero + ultimoNumero;

            penultimoNumero = ultimoNumero;
            ultimoNumero = valor;

            if (valor <= target)
                System.out.println(ultimoNumero);
        }
    }
}
