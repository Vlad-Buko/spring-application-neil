import org.springframework.context.support.ClassPathXmlApplicationContext;
import springcourse.Music;
import springcourse.MusicPlayer;

/**
 * Created by Vladislav Domaniewski
 */

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        Music music = context.getBean("musicBean", Music.class);

        MusicPlayer musicPlayer = new MusicPlayer(music);

        musicPlayer.playMusic();
        context.close();
    }
}
