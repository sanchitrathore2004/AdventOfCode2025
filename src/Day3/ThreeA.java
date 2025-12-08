package Day3;

import java.util.Scanner;

public class ThreeA {
    public static void solve (String[] args) {
        Scanner scanner = new Scanner(System.in);
        long answer = 0;
        while(scanner.hasNext()){
            String input = scanner.next();
            int len = input.length();
            int maxi=Integer.MIN_VALUE;
            for(int i=0;i<len;i++){
                for(int j=i+1;j<len;j++){
                    String temp = ""+input.charAt(i)+input.charAt(j);
                    int num=Integer.parseInt(temp);
                    maxi=Integer.max(maxi, num);
                }
            }
            answer+=maxi;
        }
        System.out.println(answer);
}
}
