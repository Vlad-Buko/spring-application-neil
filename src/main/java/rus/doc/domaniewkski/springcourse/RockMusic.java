package rus.doc.domaniewkski.springcourse;

import org.springframework.stereotype.Component;

/**
 * Created by Vladislav Domaniewski
 */

@Component
public class RockMusic implements Music
{
    @Override
    public String getMusic() {
        return "Wind Cries Mary";
    }
}
