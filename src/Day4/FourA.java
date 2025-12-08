package Day4;

import java.util.Scanner;
import java.util.Vector;

public class FourA {
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
        for(int row=0;row<rows;row++){
            for(int column=0;column<columns;column++){
                if(input.get(row).charAt(column)=='@'){
                    int paperCount=0;
                    for(int direction=0;direction<8;direction++){
                        int newRow=row+drow[direction];
                        int newColumn=column+dcol[direction];
                        if(newRow>=0 && newRow<rows && newColumn>=0 && newColumn<columns){
                            if(input.get(newRow).charAt(newColumn)=='@') paperCount++;
                        }
                    }
                    if(paperCount<4) answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
