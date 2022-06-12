package ba.sum.fpmoz.informatika.lshop.model;

import java.util.HashSet;
import java.util.Set;

public class UserSession {
    private static UserSession instance;

    private Integer id;

    public UserSession(Integer id) {
        this.id = id;
    }

    public static UserSession getInstace(Integer id) {
        if(instance == null) {
            instance = new UserSession(id);
        }
        return instance;
    }

    public Integer getUserId() {
        return id;
    }


    public void cleanUserSession() {
        id = null;// or null
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "id='" + id + '}';
    }
}
