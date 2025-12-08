package Day6;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class SixB {
    public void solve (String [] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<String> input = new Vector<>();
        long answer = 0;
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            input.add(line);
        }
        Collections.reverse(input);
        int n = input.getFirst().length();
        int iterator = 0;
        while(iterator<n){
            char operation = input.getFirst().charAt(iterator);
            Vector<Long> nums = new Vector<>();
            StringBuilder firstNum = new StringBuilder();
            for(int index=1;index<input.size();index++){
                if(input.get(index).charAt(iterator)!=' ') firstNum.append(input.get(index).charAt(iterator));
            }
            firstNum.reverse();
            nums.add(Long.parseLong(firstNum.toString()));
            iterator++;
            while(iterator<n && input.getFirst().charAt(iterator)==' '){ //fix
                StringBuilder numString = new StringBuilder();
                for(int index=1;index<input.size();index++){
                    if(input.get(index).charAt(iterator)!=' ') numString.append(input.get(index).charAt(iterator));
                }
                iterator++;
                if(numString.isEmpty()) continue ;
                numString.reverse();
                nums.add(Long.parseLong(numString.toString()));
            }
            if(operation=='+'){
                long value = 0;
                for(int position=0;position<nums.size();position++) value+=nums.get(position);
                answer+=value;
            }
            else if(operation=='*'){
                long value = 1;
                for(int position=0;position<nums.size();position++) value*=nums.get(position);
                answer+=value;
            }
        }
        System.out.println(answer);
    }
}
