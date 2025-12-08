package Day6;

import java.awt.image.BandedSampleModel;
import java.util.Scanner;
import java.util.Vector;

public class SixA {
    public static void solve(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long ans=0;
        Vector<Vector<Long>> nums = new Vector<>();
        Vector<Character> operations = new Vector<Character>();
        while(scanner.hasNext()){
            String input = scanner.nextLine().trim();
            if(input.charAt(0)=='+' || input.charAt(0)=='*'){
                int index = 0;
                while(index<input.length()){
                    int iterator = index;
                    while(iterator<input.length() && input.charAt(iterator)==' ') iterator++;
                    operations.add(input.charAt(iterator));
                    index=iterator+1;
                }
                continue;
            }
            Vector<Long> temporary = new Vector<>();
            int index=0;
            while(index<input.length()){
                int iterator = index;
                StringBuilder num = new StringBuilder();
                while(iterator<input.length() && input.charAt(iterator)!=' '){
                    num.append(input.charAt(iterator));
                    iterator++;
                }
                temporary.add(Long.parseLong(num.toString()));
                while(iterator<input.length() && input.charAt(iterator)==' ') iterator++;
                index=iterator;
            }
            nums.add(temporary);
        }
        for(int i=0;i<operations.size();i++){
            if(operations.get(i)=='+'){
                long value=0;
                for(int iterator=0;iterator<nums.size();iterator++){
                    if(i<nums.get(iterator).size()) {
                        value += nums.get(iterator).get(i);
                    }
                }
                ans+=value;
            }
            else if(operations.get(i)=='*'){
                long value=1;
                for(int iterator=0;iterator<nums.size();iterator++){
                    if(i<nums.get(iterator).size()) {
                        value*=nums.get(iterator).get(i);
                    }
                }
                ans+=value;
            }
        }
        System.out.println(ans);
    }
}
