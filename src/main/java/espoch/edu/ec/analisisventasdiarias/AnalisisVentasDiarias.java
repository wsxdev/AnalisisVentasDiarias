package espoch.edu.ec.analisisventasdiarias;

import java.util.Scanner;

public class AnalisisVentasDiarias {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Double[] ventasDiarias = new Double[7];
        String[] dias = new String[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

        System.out.println("\n| Monto de  ventas diarias |");

        for (int i = 0; i < 7; i++) {
            System.out.print("Ingrese el monto para el DIA " + dias[i] + ": ");
            ventasDiarias[i] = entrada.nextDouble();
            while (!(ventasDiarias[i] >= 0)) {
                System.out.print("ERROR: valor no valido\nIntente de nuevo, DIA " + dias[i] + ": ");
                ventasDiarias[i] = entrada.nextDouble();
            }
        }

        Double totalVentas = 0d, promedioVentas = 0d, diferencia = 0d, diferenciaMinima = Double.MAX_VALUE;

        for (int i = 0; i < 7; i++) {
            totalVentas += ventasDiarias[i];
        }
        
        int opcion;

        do {

            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1. Calcular el total de ventas semanales");
            System.out.println("2. Calcular el dia con ventas mas cercanas al promedio");
            System.out.println("3. Mostrar el dia con la venta mas alta y el dia con la venta mas baja");
            System.out.println("4. Calcular el monto acumulado de ventas durante los primeros tres dias y los ultimos tres dias");
            System.out.println("5. Salir");
            System.out.print("\nIngrese una opcion (1-5): ");
            opcion = entrada.nextInt();

            promedioVentas = totalVentas / ventasDiarias.length;
            switch (opcion) {
                case 1:
                    System.out.println("CALCULAR TOTAL DE VENTAS SEMANALES");
                    
                    System.out.println("El total de ventas es: $ " + totalVentas);
                    break;
                case 2:
                    int indiceDiaCercanoPromedio = 0;
                    for (int i = 0; i < ventasDiarias.length; i++) {
                        diferencia = ventasDiarias[i] - promedioVentas;
                        if (diferencia < 0) {
                            diferencia = -diferencia;
                        }
                        if (diferencia < diferenciaMinima) {
                            diferenciaMinima = diferencia;
                            indiceDiaCercanoPromedio = i;
                        }

                    }
                    System.out.println("El dia con la venta mas cercana al promedio es: " + dias[indiceDiaCercanoPromedio] + " con " + ventasDiarias[indiceDiaCercanoPromedio] );
                    
                    break;
                case 3:
                    // Mostrar el dia con la venta mas alta y el dia con la venta mas baja
                    Double ventaMasAlta = ventasDiarias[0];
                    Double ventaMasBaja = ventasDiarias[0];
                    int indiceVentaMasAlta = 0;
                    int indiceVentaMasBaja = 0;

                    for (int i = 1; i < ventasDiarias.length; i++) {
                        if (ventaMasAlta > ventasDiarias[i]) {
                            ventaMasAlta = ventasDiarias[i];
                            indiceVentaMasAlta = i;
                        }    
                    }

                    for (int i = 1; i < ventasDiarias.length; i++) {
                        if (ventaMasBaja < ventasDiarias[i]) {
                            ventaMasBaja = ventasDiarias[i];
                            indiceVentaMasBaja = i;
                        }    
                    }

                    System.out.println("El dia con la venta mas alta es: " + dias[indiceVentaMasAlta] + " con " + ventasDiarias[indiceVentaMasAlta]);
                    System.out.println("El dia con la venta mas baja es: " + dias[indiceVentaMasBaja] + " con " + ventasDiarias[indiceVentaMasBaja]);
                    break;
                case 4:
                    // Calcular el monto acumulado de ventas durante los primeros tres dias y los ultimos tres dias
                    Double ventaTresPrimerosDias = 0d, ventaTresUltimosDias = 0d;
                    for (int i = 0; i < 3; i++) {
                        ventaTresPrimerosDias += ventasDiarias[i];
                    }
                    System.out.println("Total de ventas de los primeros tres dias: " + ventaTresPrimerosDias);

                    for (int i = 4; i < ventasDiarias.length; i++) {
                        ventaTresUltimosDias += ventasDiarias[i];
                    }
                    System.out.println("Total de ventas de los ultimos tres dias: " + ventaTresUltimosDias);

                    break;
                case 5:
                    System.out.println("Hasta la proxima...");
                    break;
                default:
                    System.out.println("Opcion no valida, intente de nuevo...");
                    break;
            }
        } while(opcion != 5);
        
        entrada.close();
    }
}
