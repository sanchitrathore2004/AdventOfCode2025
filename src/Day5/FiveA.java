package Day5;

import java.util.Scanner;
import java.util.Vector;

public class FiveA {
    public static void solve (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Vector<Long>> ranges = new Vector<>();
        Boolean readingRanges = true;
        long answer=0;
        while(scanner.hasNext()){
            String input = scanner.nextLine().trim();
            if(input.isEmpty()){
                readingRanges = false;
                continue;
            }
            if(readingRanges){
                StringBuilder leftString = new StringBuilder();
                StringBuilder rightString = new StringBuilder();
                int index = 0;
                while(input.charAt(index)!='-'){
                    leftString.append(input.charAt(index));
                    index++;
                }
                index++;
                while(index<input.length()){
                    rightString.append(input.charAt(index));
                    index++;
                }
                long left = Long.parseLong(leftString.toString());
                long right = Long.parseLong(rightString.toString());
                Vector<Long> temporary = new Vector<>();
                temporary.add(left);
                temporary.add(right);
                ranges.add(temporary);
            }
            else {
                Long number = Long.parseLong(input);
                for(int index=0;index<ranges.size();index++){
                    long left = ranges.get(index).get(0);
                    long right = ranges.get(index).get(1);
                    if(number>=left && number<=right){
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
