package BLogDandelion.BLogDandelion.service.impl;

import BLogDandelion.BLogDandelion.model.User;
import BLogDandelion.BLogDandelion.repository.UserRepository;
import BLogDandelion.BLogDandelion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);

        // ban ex khi user null
        if (user == null) {

            throw new UsernameNotFoundException(username);
        }

        return user;
    }
    @Override
    public boolean checkLogin(User user) {
        Iterable<User> users = this.findAll();
        boolean isCorrectUser = false;
        for (User currentUser : users) {
            if (currentUser.getUserName().equals(user.getUserName())
                    && user.getPassword().equals(currentUser.getPassword())) {
                isCorrectUser = true;
            }
        }
        return isCorrectUser;
    }

    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }
}
