package engine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;


/** 
 * 
 * The method that plays music in general.
 * 
 */
public class MusicManager {

    private final static File main_Bgm = new File("C:/Users/heroi/Desktop/Code/Java/invader/Invaders/res/Main BGM.wav" 
                                                    /** 각자의 res 폴더 경로를 지정... 혹은 상대경로 설정?*/); // runtime 265000
    private final static File shoot = new File("C:/Users/heroi/Desktop/Code/Java/invader/Invaders/res/Shoot.wav" 
                                                    /** 각자의 res 폴더 경로를 지정... 혹은 상대경로 설정?*/); // runtime 1000
    private final static File come_boss = new File("C:/Users/heroi/Desktop/Code/Java/invader/Invaders/res/Begin boss.wav" 
                                                    /** 각자의 res 폴더 경로를 지정... 혹은 상대경로 설정?*/); // runtime 32000
    private final static File during_boss = new File("C:/Users/heroi/Desktop/Code/Java/invader/Invaders/res/During boss.wav" 
                                                    /** 각자의 res 폴더 경로를 지정... 혹은 상대경로 설정?*/); // runtime 168000

    private static final int MAIN_BGM_LENGTH = 264000;
    private static final int BEGIN_BOSS_LENGTH = 31000;
    private static final int DURING_BOSS_LENGTH = 167000;

    public static Cooldown mainCooldown = Core.getCooldown(MAIN_BGM_LENGTH);
    public static Cooldown beginCooldown = Core.getCooldown(BEGIN_BOSS_LENGTH);
    public static Cooldown duringCooldown = Core.getCooldown(DURING_BOSS_LENGTH);

    /** 
     * Method for run shooting sound.
     * 
     */
    public void run_shoot() {
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(shoot);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
        } catch(Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    /** 
     * Method for run BGM for main lobby.
     * 
     */
    public void run_main() {
        if(this.mainCooldown.checkFinished()) {
            try {
                AudioInputStream stream = AudioSystem.getAudioInputStream(main_Bgm);
                Clip clip = AudioSystem.getClip();
                clip.open(stream);
                clip.start();
            } catch(Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    /** 
     * Method for run BGM for boss round.
     * 
     */
    public void run_boss() {
        if(this.duringCooldown.checkFinished()) {
            try {
                AudioInputStream stream = AudioSystem.getAudioInputStream(during_boss);
                Clip clip = AudioSystem.getClip();
                clip.open(stream);
                clip.start();
            } catch(Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    /** 
     * Method for run BGM for boss appearance.
     * 
     */
    public void run_begin_boss() {
        if(this.duringCooldown.checkFinished()) {
            try {
                AudioInputStream stream = AudioSystem.getAudioInputStream(come_boss);
                Clip clip = AudioSystem.getClip();
                clip.open(stream);
                clip.start();
            } catch(Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    /**
     * 
     * for code test
    public static void main(String[] args) {
        run_shoot();
    }
    */
}
