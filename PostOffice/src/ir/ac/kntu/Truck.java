package ir.ac.kntu;

public class Truck {
    public static int[] fillTruck(int[] weights, int n, int k) {
        int[] truck = new int[k];


        for (int i = 0; i < weights.length; i++) {
            truck[indexOfSmallest(truck)] += weights[i];
        }

        return truck;
    }

    public static int indexOfSmallest(int[] array){

        // add this
        if (array.length == 0) {
            return -1;
        }

        int index = 0;
        int min = array[index];

        for (int i = 1; i < array.length; i++){
            if (array[i] <= min){
                min = array[i];
                index = i;
            }
        }
        return index;
    }
}
