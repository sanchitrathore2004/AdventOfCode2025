package Day2;

import java.util.Scanner;
public class TwoA {
    public static void solve (String [] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        long answer=0;
        int index1=0;
        while(index1<inputString.length()){
            StringBuilder start = new StringBuilder();
            StringBuilder end = new StringBuilder();
            int index2=index1;
            while(inputString.charAt(index2)!='-'){
                start.append(inputString.charAt(index2));
                index2++;
            }
            long startInt = Long.parseLong(start.toString());
            index2++;
            while(index2<inputString.length() && inputString.charAt(index2)!=','){
                end.append(inputString.charAt(index2));
                index2++;
            }
            index1=index2+1;
            long endInt = Long.parseLong(end.toString());
            for(long num=startInt;num<=endInt;num++){
                String numString = Long.toString(num);
                if(numString.length()%2==0){
                    StringBuilder first = new StringBuilder();
                    StringBuilder last = new StringBuilder();
                    for(int index=0;index<numString.length()/2;index++){
                        first.append(numString.charAt(index));
                    }
                    for(int index=numString.length()/2;index<numString.length();index++){
                        last.append(numString.charAt(index));
                    }
                    long firstNum = Long.parseLong(first.toString());
                    long lastNum = Long.parseLong(last.toString());
                    if(firstNum==lastNum) answer+=num;
                }
            }
        }
        System.out.println(answer);
    }
}
