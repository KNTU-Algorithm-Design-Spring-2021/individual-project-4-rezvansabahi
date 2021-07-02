package ir.ac.kntu;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k;
        int[] weights;
        System.out.println("N :");
        n = scanner.nextInt();
        System.out.println("K :");
        k = scanner.nextInt();
        weights = new int[n];

        System.out.println("Weight of parts :");

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        Truck truck = new Truck();

        System.out.println("Weight of trucks :");

        System.out.println(Arrays.toString(truck.fillTruck(weights, n, k)));


    }
}
