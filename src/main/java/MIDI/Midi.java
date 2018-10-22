package MIDI;


import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Abdusalam on 18/10/19.
 */
class MyPanel extends JPanel implements ControllerEventListener {
    boolean msg = false;

    public void paintComponent( Graphics g ) {
        if ( msg ) {
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);
            g.fillOval(70, 40, 100, 100);
            msg = false;
        }
    }

    public void controlChange(ShortMessage event) {
        msg = true;
        repaint();
    }
}

public class Midi{

    JFrame frame = new JFrame("My first Music Video");
    MyPanel panel;

    public void show_my_panel() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyPanel();
        frame.setContentPane(panel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public static MidiEvent makeEvent(int cmd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(cmd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {}
        return event;
    }

    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            int[] eventsIWant = {127};
            player.addControllerEventListener(panel, eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);//divisionType, resolution

            Track track = seq.createTrack();

            for (int i = 1; i < 100; i++) {
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }

            player.setSequence(seq);
            player.setTempoInBPM(220);
            player.start();
            while( player.isRunning() ) {
                Thread.sleep(1000);
            }
            player.close();

        } catch( Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Midi midi = new Midi();

        midi.show_my_panel();
        midi.play();
    }
}
