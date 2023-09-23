package deque;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;

public class TimeTest {
    private static void printTimingTable(ArrayList<Integer> Ns, ArrayList<Double> times, ArrayList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int num=500;
        LinkedListDeque<Integer> sl=new LinkedListDeque<>();
        ArrayList<Integer> N=new ArrayList<>();
        ArrayList<Double> time=new ArrayList<>();
        ArrayList<Integer> M=new ArrayList<>();
        for(int i=1;i<=128000;i++){
            sl.addLast(i);
            if(i==num*2){
                M.add(10000);
                N.add(i);
                Stopwatch sw=new Stopwatch();
                for(int j=0;j<M.get(0);j++){
                    sl.get(10000);
                }
                time.add(sw.elapsedTime());
                num*=2;
            }
        }
        printTimingTable(N,time,M);
    }

}
