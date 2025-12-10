package Day8;

import Day8.DSU;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class EightB {
    static void solve () {
        Scanner scanner = new Scanner(System.in);
        Vector<Vector<Long>> points = new Vector<>();
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            String[] values = input.split(",");
            long x=Long.parseLong(values[0]);
            long y=Long.parseLong(values[1]);
            long z=Long.parseLong(values[2]);
            Vector<Long> coords = new Vector<>();
            coords.add(x);
            coords.add(y);
            coords.add(z);
            points.add(coords);
        }
        Vector<Vector<Long>> distance = new Vector<>();
        for(int i=0;i<points.size();i++) {
            for (int j = i+1; j < points.size(); j++) {
                if(i==j) continue;
                long x1 = points.get(i).get(0), y1 = points.get(i).get(1), z1 = points.get(i).get(2);
                long x2 = points.get(j).get(0), y2 = points.get(j).get(1), z2 = points.get(j).get(2);
                long dx = x1 - x2;
                long dy = y1 - y2;
                long dz = z1 - z2;
                long d = dx*dx + dy*dy + dz*dz;
                Vector<Long> temporary = new Vector<>();
                temporary.add(d);
                temporary.add((long)i);
                temporary.add((long)j);
                distance.add(temporary);
            }
        }
        distance.sort((a, b)-> Long.compare(a.get(0), b.get(0)));
        System.out.println(distance);
        var dsu = new DSU(points.size());
        int i=0;
        while(i<distance.size()){
            dsu.unionBySize(distance.get(i).get(1), distance.get(i).get(2));
            if(dsu.fullyConnected()==1){
                int i1=Math.toIntExact(distance.get(i).get(1));
                int i2= Math.toIntExact(distance.get(i).get(2));
                System.out.println(points.get(i1).get(0));
                System.out.println(points.get(i2).get(0));
                System.out.println(points.get(i1).get(0)*points.get(i2).get(0));
                return ;
            }
            i++;
        }
    }
}
