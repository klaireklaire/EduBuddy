import java.util.*;
import java.util.stream.Collectors;
public class UserLibrary {

    // fields
    HashSet<User> users;

    // constructors
    public UserLibrary() {
        this.users = new HashSet<User>();
    }
    public UserLibrary(HashSet<User> us) { this.users = us; }
    public UserLibrary(User u) {
        assert false;
        this.users.add(u);
    }

    @Override
    public String toString() {

        HashSet<User> thisUsers = this.users;
        String res = "Your search returns: \n";

        for (User user : thisUsers) {
            res += user.name + "\n";
        }

        return res;
    }

    HashSet<User> filterUsers(List<IFilter> fl) {

        HashSet<User> resUsers = this.users;

        for (IFilter f : fl) {
            resUsers = f.filter(resUsers);
        }

        return resUsers;

    }

    public static void main(String[] args) {
        UserLibrary test = new UserLibrary();

        Set<Subject> testLearning = new HashSet<>();
        Set<Subject> testTeaching = new HashSet<>();
        Set<Subject> testLearning1 = new HashSet<>();
        Set<Subject> testTeaching1 = new HashSet<>();
        Set<Subject> testLearning2 = new HashSet<>();
        Set<Subject> testTeaching2 = new HashSet<>();


        Subject HIGH_SCHOOL_LITERATURE = new Subject("Literature", SubjectLevel.HIGH_SCHOOL);
        Subject HIGH_SCHOOL_MATH = new Subject("Math", SubjectLevel.HIGH_SCHOOL);
        Subject HIGH_SCHOOl_ENGLISH = new Subject("English", SubjectLevel.HIGH_SCHOOL);

        testTeaching.add(HIGH_SCHOOl_ENGLISH);
        testLearning.add(HIGH_SCHOOL_LITERATURE);
        testTeaching1.add(HIGH_SCHOOL_LITERATURE);
        testLearning1.add(HIGH_SCHOOl_ENGLISH);
        testTeaching2.add(HIGH_SCHOOl_ENGLISH);

        User user0 = new User(
                "a@gmail.com",
                "123456",
                "Khanh Le",
                19,
                "College",
                "Female",
                true,
                "Poughkeepsie",
                testLearning,
                testTeaching);

        User user1 = new TutorUser(
                "user1@gmail.com",
                "user1password",
                "Brooklynn Pierce",
                17,
                "High",
                "Female",
                true,
                "USA",
                testLearning1,
                testTeaching1,
                13.25,
                3);

        User user2 = new TutorUser(
                "user2@gmail.com",
                "user2password",
                "Karli Cardenas",
                17, "College",
                "Male",
                true,
                "USA",
                testLearning2,
                testTeaching2,
                15.00,
                4);

        User user3 = new TutorUser("user3@gmail.com", "user3password", "Camden Hardin", 19, "Middle", "Male",
                true, "USA", testLearning1, testTeaching, 5.00, 2);

        User user4 = new TutorUser("user4@gmail.com", "user4password", "Lee Blankenship", 19, "Other", "Female",
                true, "USA", testLearning2, testTeaching, 12.5, 1);

        User user5 = new TutorUser("user5@gmail.com", "user5password", "Hara Lee", 20, "Other", "Female",
                true, "Germany", testLearning2, testTeaching, 11.00, 6);


        test.users.add(user0);
        test.users.add(user1);
        test.users.add(user2);
        test.users.add(user3);
        test.users.add(user4);
        test.users.add(user5);


        // Set<User> result = test.filter(user -> user.age == 19 && user.teachingList.contains(HIGH_SCHOOl_ENGLISH));

        // TO DO: Test: AgeFilter
        AgeFilter ageFilter = new AgeFilter(17);
        List<IFilter> filters = new ArrayList<>();

        filters.add(ageFilter);
        HashSet<User> newUsers = test.filterUsers(filters);
        UserLibrary newUserLib = new UserLibrary(newUsers);

        System.out.println(newUsers.size());
        System.out.println(newUserLib);

    }
}
