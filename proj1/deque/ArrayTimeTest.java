package deque;

import edu.princeton.cs.algs4.Stopwatch;

public class ArrayTimeTest {
    private static void printTimingTable(ArrayDeque<Integer> Ns, ArrayDeque<Double> times, ArrayDeque<Integer> opCounts) {
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
        timeArrayDequeConstruction();
    }

    public static void timeArrayDequeConstruction() {
        // TODO: YOUR CODE HERE
        int num=500;
        ArrayDeque<Integer> al=new ArrayDeque<>();
        ArrayDeque<Integer> N=new ArrayDeque<>();
        ArrayDeque<Double> time=new ArrayDeque<>();
        ArrayDeque<Integer> opcount=new ArrayDeque<>();
        Stopwatch sw=new Stopwatch();
        for(int i=1;i<=128000;i++){
            al.addLast(i);
            if(i==num*2){
                N.addLast(i);
                time.addLast(sw.elapsedTime());
                num*=2;
            }
        }
        opcount=N;
        printTimingTable(N,time,opcount);
    }


}
