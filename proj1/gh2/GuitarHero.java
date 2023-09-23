package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static GuitarString[] strings = new GuitarString[37];

    public static void main(String[] args){
        for(int i=0;i<37;i++){
            double formula = (double) (i-24)/12;
            double d = 440 * Math.pow(2,formula);
            strings[i]=new GuitarString(d);
        }
        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int i=keyboard.indexOf(key);
                if(i != -1) {
                    strings[i].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample=0.0;
            for(GuitarString i : strings){
                sample+=i.sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for(GuitarString i : strings){
                i.tic();
            }
        }
    }
}
