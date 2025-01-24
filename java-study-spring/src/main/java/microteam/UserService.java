package microteam;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(String name) {
        userDao.insertUser(name);
        // Additional operations
    }

    public boolean getUserById(long l) {
    }
}

