package company.fb;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        char[] num1Array = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] num2Array = new StringBuilder(num2).reverse().toString().toCharArray();

        int[] rstArray = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1Array.length; i++) {
            for (int j = 0; j < num2Array.length; j++) {
                int tmpProd = (num1Array[i] - '0') * (num2Array[j] - '0');
                int existProd = rstArray[i + j] + 10 * rstArray[i + j + 1];
                int newProd = tmpProd + existProd;
                rstArray[i + j] = newProd % 10;
                rstArray[i + j + 1] = newProd / 10;
            }
        }
        int counter = rstArray.length - 1;
        while (counter > 0 && rstArray[counter] == 0) {
            counter--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = counter; i >= 0; i--) {
            sb.append(rstArray[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("0", "1"));
        System.out.println(multiply("123", "456"));
    }
}
