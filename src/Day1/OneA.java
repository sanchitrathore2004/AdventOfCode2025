package Day1;

import java.util.Scanner;

public class OneA {
    public static void solve (String [] args) {
        Scanner scanner = new Scanner(System.in);
        int currPos=50;
        long password=0;
        while(scanner.hasNext()){
            String operation = scanner.next();
            char direction = operation.charAt(0);
            StringBuilder distanceString = new StringBuilder();
            for(int index=1;index<operation.length();index++) distanceString.append(operation.charAt(index));
            String distance = distanceString.toString();
            int steps = Integer.parseInt(distance);
            if(direction=='L'){
                currPos=((((currPos-steps)%100)+100)%100);
            }
            else if(direction=='R'){
                currPos=((currPos+steps)%100);
            }
            if(currPos==0) password++;
        }
        System.out.println(password);
    }
}
