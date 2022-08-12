package com.example.myapplication;

import org.junit.jupiter.api.Test; // for the @Test annotation
import static org.junit.jupiter.api.Assertions.*;

import com.example.myapplication.model.Currency;
import com.example.myapplication.model.Gender;
import com.example.myapplication.model.Subject;
import com.example.myapplication.model.SubjectFilter;
import com.example.myapplication.model.SubjectLevel;
import com.example.myapplication.model.TutorUser;
import com.example.myapplication.model.User;
import com.example.myapplication.model.UserLibrary;

import java.util.HashSet;
import java.util.Set;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SubjectFilterTest {

    private UserLibrary ul = new UserLibrary();
    private Set<User> resUsers = new HashSet<User>();

    @Test
    void testFilter() {
        Set<Subject> testTeaching = new HashSet<>();
        Set<Subject> testTeaching1 = new HashSet<>();
        Set<Subject> testTeaching2 = new HashSet<>();
        Set<Subject> testLearning = new HashSet<>();


        Subject HIGH_SCHOOL_LITERATURE = new Subject("Literature", SubjectLevel.HIGH_SCHOOL);
        Subject MIDDLE_SCHOOL_MATH = new Subject("Math", SubjectLevel.MIDDLE_SCHOOL);
        Subject PRIMARY_ENGLISH = new Subject("English", SubjectLevel.PRIMARY);
        Subject COLLEGE_PHYSICS = new Subject("Physics", SubjectLevel.COLLEGE);

        testTeaching1.add(MIDDLE_SCHOOL_MATH);
        testTeaching2.add(HIGH_SCHOOL_LITERATURE);
        testTeaching2.add(PRIMARY_ENGLISH);
        testTeaching.add(COLLEGE_PHYSICS);
        testTeaching1.add(COLLEGE_PHYSICS);

        //testTeaching 1 is empty
        User user0 = new TutorUser(
                "a@gmail.com",
                "123456",
                "Linh Pham",
                2002,
                true,
                12604,
                testTeaching,
                testLearning,
                 15.00,
                4,
                Currency.USD);

        User user1 = new TutorUser(
                "user1@gmail.com",
                "user1password",
                "Jason Lee",
                2003,
                true,
                10101,
                testTeaching1,
                testLearning,
                13.25,
                3,
                Currency.USD);

        User user2 = new TutorUser(
                "user2@gmail.com",
                "user2password",
                "Muhtasim Miraz",
                2002,
                true,
                13453,
                testTeaching2,
                testLearning,

                15.00,
                4,
                Currency.USD);

        ul.addUser(user0);
        ul.addUser(user1);
        ul.addUser(user2);

        this.resUsers.add(user0);
        this.resUsers.add(user1);

        SubjectFilter subjectFilter = new SubjectFilter(SubjectLevel.COLLEGE, "Physics");
        Set<User> filteredTutors = subjectFilter.filter(ul.getUsers());

        assertEquals(filteredTutors, resUsers);

    }
}