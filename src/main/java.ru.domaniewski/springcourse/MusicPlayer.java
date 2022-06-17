package springcourse;

/**
 * Created by Vladislav Domaniewski
 */

public class MusicPlayer {
    private Music music;

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Right now playing: " + music.getMusic());
    }
}
