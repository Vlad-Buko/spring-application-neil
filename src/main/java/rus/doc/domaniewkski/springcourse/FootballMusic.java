package rus.doc.domaniewkski.springcourse;

import org.springframework.stereotype.Component;

/**
 * Created by Vladislav Domaniewski
 */

@Component
public class FootballMusic implements Music{
    @Override
    public String getMusic() {
        return "Hey hey, blue is the colour!";
    }
}
