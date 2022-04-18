import java.util.*;

/**
 * The Profile class represents all necessary information to make a new user. It stores the user's
 * login credentials and profile information. For the first iteration, fields not relevant to implementing the
 * filtered search features are omitted.
 *
 * @author Klaire Pham
 * @version 2022.03.02
 */

public class User {

    // fields
    /**
     * The user's email
     */
    String email;

    /**
     * The user's password
     */
    String password;

    /**
     * The user's name
     */
    String name;

    /**
     * The user's age
     */
    int age;

    /**
     * The user's education level: Primary, Middle, High, College, and Other
     */
    String level;

    /**
     * The user's gender: Male, Female, and Other
     */
    String gender;

    /**
     * True if the user can engage with the tutoring process remotely. False otherwise.
     */
    boolean isRemote;

    /**
     * The user's location
     */
    String location;

    /**
     * List of subjects that the users want to teach
     */
    Set<Subject> teachingList = new HashSet<Subject>();

    /**
     * List of subjects that the users want to learn
     */
    Set<Subject> learningList = new HashSet<Subject>();

    // fields that are not relevant to this iteration yet
    // String bio;
    // String goals;
    // String awards;
    // List<EduHistory> eduList;


    /** Default constructor
     *
     */
    public User(){

    }

    /** Constructor for objects of class User
     *
     * @param email
     * @param password
     * @param name
     * @param age
     * @param level
     * @param gender
     * @param isRemote
     * @param location
     * @param learningList
     * @param teachingList
     */
    User(String email, String password, String name, int age, String level, String gender, boolean isRemote,
            String location, Set<Subject> learningList, Set<Subject> teachingList) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.level = level;
        this.gender = gender;
        this.isRemote = isRemote;
        this.location = location;
        this.learningList = learningList;
        this.teachingList = teachingList;
    }

    @Override
    public String toString() {

        String result = "";

        result += "Name: " + this.name;
        result += "\nAge: " + this.age;
        result += "\nEducation: " + this.level;
        result += "\nGender: " + this.gender;

        result += "\nRemote tutoring available: ";
        if (this.isRemote) {
            result += "Yes";
        } else result += "No";

        result += "\nLocation: " + this.location;

        result += "\nTeaching subjects: ";
        for (Subject s : teachingList) {
            result += s.toString() + "; ";
        }

        result += "\nLearning subjects: ";
        for (Subject s : teachingList) {
            result += s.toString() + "; ";
        }

        return result;

    }

}