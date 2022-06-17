package rus.doc.domaniewkski.springcourse;

import org.springframework.stereotype.Component;

/**
 * Created by Vladislav Domaniewski
 */

@Component
public class ClassicalMusic implements Music {
    @Override
    public String getMusic() {
        return "Hungarian rhapsody";
    }
}
