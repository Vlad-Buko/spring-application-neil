import org.springframework.context.support.ClassPathXmlApplicationContext;
import rus.doc.domaniewkski.springcourse.ClassicalMusic;
import rus.doc.domaniewkski.springcourse.Music;
import rus.doc.domaniewkski.springcourse.MusicPlayer;

/**
 * Created by Vladislav Domaniewski
 */

public class MainApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        Music music = context.getBean("classicalMusic", ClassicalMusic.class);
        MusicPlayer musicPlayer = new MusicPlayer(music);
        musicPlayer.playMusic();
        context.close();
    }
}
