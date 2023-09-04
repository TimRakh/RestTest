package torg.timurka.RestAuthorazitionService.Repository;

import org.springframework.stereotype.Repository;
import torg.timurka.RestAuthorazitionService.Authorities.Authorities;
import java.util.*;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("admin") && password.equals("qwerty")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("Nana") && password.equals("12")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else {
            return Collections.EMPTY_LIST;
        }
        return authorities;
    }
}
