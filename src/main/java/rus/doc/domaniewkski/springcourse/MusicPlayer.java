package rus.doc.domaniewkski.springcourse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav Domaniewski
 */

public class MusicPlayer {
    private List<Music> musicList = new ArrayList<>();
    private Music music;

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic() {
        System.out.println("Right now playing: " + music.getMusic());
    }

    public void playMusicList() {
        for(Music music1 : musicList) {
            System.out.println("Playing: " + music1.getMusic());
        }
    }
}
