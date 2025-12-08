package Day3;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class ThreeB {
    public static void solve (String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger answer = BigInteger.ZERO;
        while(scanner.hasNext()){
            String input = scanner.next();
            Stack<Integer> st = new Stack<>();
            int toRemove=input.length()-12;
            int i=0;
            while(i<input.length()){
                if(st.empty()){
                    st.push(input.charAt(i)-'0');
                    i++;
                    continue;
                }
                while(!st.empty() && toRemove>0 && input.charAt(i)-'0'>st.peek()){
                    toRemove--;
                    st.pop();
                }
                st.push(input.charAt(i)-'0');
                i++;
            }
            if(toRemove>0){
                while(toRemove>0){
                    st.pop();
                    toRemove--;
                }
            }
            StringBuilder num = new StringBuilder();
            while(!st.empty()){
                num.append((char)(st.peek()+'0'));
                st.pop();
            }
            String number = new StringBuilder(num).reverse().toString();
            BigInteger value = new BigInteger(number);
            answer=answer.add(value);
        }
        System.out.println(answer);
    }
}
