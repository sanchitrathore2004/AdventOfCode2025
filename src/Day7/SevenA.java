package Day7;

import java.util.Scanner;
import java.util.Vector;

public class SevenA {
    static void solve () {
        Scanner scanner = new Scanner(System.in);
        Vector<String> input = new Vector<>();
        while(scanner.hasNext()){
            String currLine = scanner.nextLine();
            input.add(currLine);
        }
        int n=input.size();
        int m=input.getFirst().length();
        Vector<Vector<Boolean>> vis = new Vector<>();
        for (int i = 0; i < n; i++) {
            Vector<Boolean> row = new Vector<>();
            for (int j = 0; j < m; j++) {
                row.add(false);
            }
            vis.add(row);
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
        long answer = helper(input, startX+1, startY, n, m, vis);
        System.out.println(answer);
    }
    private static long helper(Vector<String> input, int x, int y, int n, int m, Vector<Vector<Boolean>> vis){
        if(x>=n || x<0 || y>=m || y<0 || vis.get(x).get(y)==true) return 0;
        if(input.get(x).charAt(y)=='^'){
            int val=(vis.get(x).get(y)==false ? 1 : 0);
            vis.get(x).set(y, true);
            return (val+helper(input, x, y-1, n, m, vis) + helper(input, x, y+1, n, m, vis));
        }
        return helper(input, x+1, y, n, m, vis);
    }
}

