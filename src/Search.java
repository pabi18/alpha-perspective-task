import java.util.Random;
import java.util.Scanner;
public class Search {
    private int min, max, size, X;

    public void mainFunction () {
        sizeMinMax();
        X=xValue();
        int[] array=arrayCreation();
        array=arraySort(array);
        arrayWrite(array);
        bsearch(array, X,25,"vfdfvd");
    }

    private void sizeMinMax (){
        sizeValue();
        minValue();
        maxValue();
    }

    private void sizeValue(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество элементов массива:");
        while (true) {
            if (scan.hasNextInt()) {
                size = scan.nextInt();
                if (size >= 1) {
                    break;
                } else {
                    System.out.println("Количество элементов не может быть равным 0 или быть отрицательным, повторите ввод:");
                    String line = scan.nextLine();
                }
            }
            else if (!scan.hasNextInt()) {
                String line = scan.nextLine();
                System.out.println("Введено не целое число, повторите ввод:");
            }
        }
    }

    private void minValue(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите минимальное значение:");
        while (true) {
            if (scan.hasNextInt()) {
                min = scan.nextInt();
                break;
            } else {
                String line = scan.nextLine();
                System.out.println("Введено не целое число, повторите ввод:");
            }
            if (!scan.hasNextInt()) {

            }
        }
    }

    private void maxValue (){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите максимальное значение:");
        while (true) {
            if (scan.hasNextInt()) {
                max = scan.nextInt();
                if (max>=min)
                {
                    break;
                }
                else {
                    System.out.println("Максимальное значение не может быть меньше минимального, повторите ввод:");
                    String line = scan.nextLine();
                }
            } else {
                if (!scan.hasNextInt()){
                    String line = scan.nextLine();
                    System.out.println("Введено не целое число, повторите ввод:");
                }
            }
        }
    }

    private int xValue () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите значение целого числа X:");
        while (true) {
            if (scan.hasNextInt()){
                X = scan.nextInt();
                break;
            } else {
                String line = scan.nextLine();
             }
            if (!scan.hasNextInt()) {
                System.out.println("Введено не целое число, повторите ввод:");
            }
        }
        return X;
    }

    private int[] arrayCreation (){
        int array[] =new int [size];
        Random rnd = new Random(System.currentTimeMillis());
        for (int i=0; i<array.length; i++){
            int number = min + rnd.nextInt(max - min + 1);
            array[i]=number;
        }
        return array;
    }

    private int[] arraySort (int[] array)
    {
        for (int i=0; i<array.length; i++){
            int max =array[i];
            int max_index = i;
            for (int j=i+1; j<array.length; j++) {
                if (array[j]>max){
                    max=array[j];
                    max_index=j;
                }
            }
            if (i!=max_index){
                int tmp = array[i];
                array[i]=array[max_index];
                array[max_index]=tmp;
            }
        }
        return array;
    }

    private void bsearch (int array[], int X, Object ... Obj ){
        boolean found = false;
                if (X > min){
                    for (int i = 0; i < array.length; i++){
                        if (array[i] < X){
                            found = true;
                            System.out.println("Индекс первого элемента массива, который строго меньше " + X + " равен " + i
                            +"\nИндексация начинается с 0");
                            break;
                        }
                    }
                    if (!found){
                        System.out.println("В массиве нет числа, которое строго меньше X");
                    }
                }
                    else {
                        System.out.println("В массиве нет числа, которое строго меньше X, который равен " + X);
                    }


    }

    private void  arrayWrite (int [] array)
    {
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
