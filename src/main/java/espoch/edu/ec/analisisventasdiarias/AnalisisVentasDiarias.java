package espoch.edu.ec.analisisventasdiarias;

import java.util.Scanner;

public class AnalisisVentasDiarias {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Double[] ventasDiarias = new Double[7];
        

        System.out.println("Ingrese el monto de  ventas diarias para cada dia (Lunes-Viernes): ");

        for (int i = 0; i < 7; i++) {
            System.out.print("Ingrese el monto para el DIA " + (i + 1) + ": ");
            ventasDiarias[i] = entrada.nextDouble();
            while (!(ventasDiarias[i] >= 0)) {
                System.out.print("ERROR: valor no valido\nIntente de nuevo, DIA " + (i + 1) + ": ");
                ventasDiarias[i] = entrada.nextDouble();
            }
        }

        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Calcular el total de ventas semanales");
        System.out.println("2. Calcular el dia con ventas mas cercanas al promedio");
        System.out.println("3. Mostrar el dia con la venta mas alta y el dia con la venta mas baja");
        System.out.println(
                "4. Calcular el monto acumulado de ventas durante los primeros tres dias y los ultimos tres dias");
        System.out.println("5. Salir");

        int opcion;
        opcion = entrada.nextInt();
        Double totalVentas = 0d, promedioVentas = 0d;
        switch (opcion) {
            case 1:
                System.out.println("CALCULAR TOTAL DE VENTAS SEMANALES");

                for (int i = 0; i < 7; i++) {
                    totalVentas += ventasDiarias[i];
                    System.out.println(totalVentas);
                    break;
                }
                break;
            case 2:

                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }

    }
}
