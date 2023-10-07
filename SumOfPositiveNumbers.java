public class SumOfPositiveNumbers {
    public static int sum(int n)  {
       if (n < 0)
           throw new RuntimeException();

        return  n *(n +1) / 2;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " : " + sum(i));
        }
    }

}
