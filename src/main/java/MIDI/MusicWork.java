package MIDI;

import javax.sound.midi.*;
import java.io.*;

/**
 * Created by Abdusalam on 18/10/18.
 */
public class MusicWork {
    MusicWork() throws MidiUnavailableException, InvalidMidiDataException, IOException {
        Synthesizer synthesizer= MidiSystem.getSynthesizer();//Synthesizer 接口包括可从音库加载和卸载乐器 (instrument) 的方法
        synthesizer.open();
        synthesizer.unloadAllInstruments(synthesizer.getDefaultSoundbank());
       synthesizer.loadAllInstruments(MidiSystem.getSoundbank(new File("C:\\Users\\34784\\IdeaProjects\\Learning\\src\\MIDI\\FluidR3_GM.sf2")));
       Instrument[] instruments= synthesizer.getAvailableInstruments();
//        for (Instrument i :
//                instruments) {
//            System.out.println(i.getName());
//        }
        Sequencer sequencer = MidiSystem.getSequencer();//回放 MIDI sequence 的硬件或软件设备就是所谓的 sequencer。
        // MIDI sequence 包含加了时间戳的 MIDI 数据列表，例如可从标准 MIDI 文件读取的数据。多数 sequencer 还提供创建和编辑 sequence 的功能。
        sequencer.open();
        sequencer.getTransmitter().setReceiver(synthesizer.getReceiver());//乐库和音轨连接
        InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\34784\\IdeaProjects\\Learning\\src\\MIDI\\成都.mid")));
        sequencer.setSequence(inputStream);//依次取入Sequence
        sequencer.start();

    }

    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException, IOException {
            MusicWork musicWork=new MusicWork();
    }
}
