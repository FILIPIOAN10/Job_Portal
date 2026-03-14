import java.util.Scanner;

public class Solution {

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();

        int a,b,n;

        for(int k=0;k<t;k++){
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();




            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <n; i++) {
                int result=a;
                for (int j =0; j <=i; j++) {
                    result+=Math.pow(2,j)*b;

                }
                sb.append(result +" ");

            }
            System.out.println(sb.toString());

        }
        in.close();
    }
}

