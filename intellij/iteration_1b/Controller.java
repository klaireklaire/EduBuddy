import java.sql.Array;
import java.util.*;

public class Controller {
    UserLibrary ul = new UserLibrary();

    // default values
    public static int DEFAULT_AGE = -1;
    public static String DEFAULT_SUBJECT = "";
    public static int DEFAULT_GRADE = 0;

    public Controller() {

        // set up test User Library

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


        ul.users.add(user0);
        ul.users.add(user1);
        ul.users.add(user2);
        ul.users.add(user3);
        ul.users.add(user4);
        ul.users.add(user5);

    }

    public UserLibrary filterTutors(int age, int grade, String subject) {
        List<IFilter> filters = new ArrayList<>();

        if (age != -1) {
            AgeFilter af = new AgeFilter(age);
            filters.add(af);
        }

        if (!subject.equals(DEFAULT_SUBJECT) && grade > DEFAULT_GRADE) {
            SubjectFilter sf = new SubjectFilter(grade, subject);
            filters.add(sf);
        }

        return new UserLibrary(ul.filterUsers(filters));
    }
}
