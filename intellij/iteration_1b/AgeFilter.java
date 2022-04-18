import java.util.*;

public class AgeFilter implements IFilter {

    // fields
    /**
     * The age that the filter would use to filter among User objects
     */
    int compAge;

    // constructors
    AgeFilter(int compAge) {
        this.compAge = compAge;
    }

    // methods
    public HashSet<User> filter(HashSet<User> users) {

        HashSet<User> resUsers = new HashSet<User>();

        for (User user : users) {
            if (user.age == compAge) {
                resUsers.add(user);
            }
        }

        return resUsers;

    }

}
