package MIDI;

/**
 * Created by Abdusalam on 18/10/18.
 */
import sun.audio.*;
import java.io.*;
public class playsound{
    public static void main(String[] args){
        try {
            FileInputStream fileau=new FileInputStream("01.mid" );
            AudioStream as=new AudioStream(fileau);
            AudioPlayer.player.start(as);
        }
        catch (Exception e) {System.out.println("失败咯！");}
    }
}