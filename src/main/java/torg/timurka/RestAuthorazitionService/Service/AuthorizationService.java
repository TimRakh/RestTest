package torg.timurka.RestAuthorazitionService.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import torg.timurka.RestAuthorazitionService.Authorities.Authorities;
import torg.timurka.RestAuthorazitionService.Exceptions.InvalidCredentials;
import torg.timurka.RestAuthorazitionService.Exceptions.UnauthorizedUser;
import torg.timurka.RestAuthorazitionService.Repository.UserRepository;


import java.util.List;

@AllArgsConstructor
@Service
public class AuthorizationService {

    UserRepository userRepository;

    public List<Authorities> getAuthorities(String userName, String password) {
        if (isEmpty(userName) || isEmpty(password)) {
            throw new InvalidCredentials("user or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(userName, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("unknown user" + userName);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private  boolean isEmpty(List<?> str) {
        return  str == null || str.isEmpty();
    }
}