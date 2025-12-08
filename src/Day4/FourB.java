package Day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class FourB {
    public static void solve (String[] args) {
        int drow [] = {-1, -1, 0, 1, 1, 1, 0, -1};
        int dcol [] = {0, 1, 1, 1, 0, -1, -1, -1};
        Scanner scanner = new Scanner(System.in);
        Vector<String> input = new Vector<>();
        int answer=0;
        while(scanner.hasNext()){
            String line = scanner.next();
            input.add(line);
        }
        int rows = input.size();
        int columns = input.get(0).length();
        Map<Integer, Map<Integer, Boolean>> mpp = new HashMap<>();
        while(true){
            int currStateScore=0;
            for(int row=0;row<rows;row++){
                for(int column=0;column<columns;column++){
                    if(input.get(row).charAt(column)=='@' && !(mpp.containsKey(row) && mpp.get(row).containsKey(column))){
                        int paperCount=0;
                        for(int direction=0;direction<8;direction++){
                            int newRow=row+drow[direction];
                            int newColumn=column+dcol[direction];
                            if(newRow>=0 && newRow<rows && newColumn>=0 && newColumn<columns){
                                if(input.get(newRow).charAt(newColumn)=='@' && !(mpp.containsKey(newRow) && mpp.get(newRow).containsKey(newColumn))) paperCount++;
                            }
                        }
                        if(paperCount<4){
                            currStateScore++;
                            mpp.putIfAbsent(row, new HashMap<>());
                            mpp.get(row).put(column, true);
                        }
                    }
                }
            }
            answer+=currStateScore;
            if(currStateScore==0) break;
        }
        System.out.println(answer);
    }
}
