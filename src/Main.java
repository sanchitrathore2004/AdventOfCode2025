import java.util.Scanner;
import java.util.Vector;

public class Main {
    private static Vector<Vector<Long>> dp = new Vector<>();
    static void main () {
        Scanner scanner = new Scanner(System.in);
        Vector<String> input = new Vector<>();
        while(scanner.hasNext()){
            String currLine = scanner.nextLine();
            input.add(currLine);
        }
        int n=input.size();
        int m=input.getFirst().length();
        for(int i=0;i<n;i++){
            Vector<Long> temp = new Vector<>();
            for(int j=0;j<m;j++){
                temp.add(-1L);
            }
            dp.add(temp);
        }
        int startX=0;
        int startY=0;
        boolean flag = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(input.get(i).charAt(j)=='S'){
                    startY=j;
                    startX=i;
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }
        long answer = helper(input, startX+1, startY, n, m);
        System.out.println(answer);
    }
    private static long helper(Vector<String> input, int x, int y, int n, int m){
        if(x>=n || x<0 || y>=m || y<0) return 1;
        if(dp.get(x).get(y)!=-1) return dp.get(x).get(y);
        if(input.get(x).charAt(y)=='^'){
            dp.get(x).set(y, (helper(input, x, y-1, n, m) + helper(input, x, y+1, n, m)));
            return dp.get(x).get(y);
        }
        dp.get(x).set(y, helper(input, x+1, y, n, m));
        return dp.get(x).get(y);
    }
}