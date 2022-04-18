import java.util.*;

public class TutorUser extends User{

    // fields
    double ratePerHour;
    int numStudents;

    // fields not relevant to this iteration yet
    // List<String> testimonies;

    /** Default constructor
     *
     */
    TutorUser(){

    }

    /** Constructor for objects of class TutorProfile
     *
     * @param email
     * @param password
     * @param name
     * @param age
     * @param level
     * @param gender
     * @param isRemote
     * @param location
     * @param teachingList
     * @param learningList
     * @param ratePerHour
     * @param numStudents
     */
    TutorUser(String email, String password, String name, int age, String level, String gender, boolean isRemote,
              String location, Set<Subject> teachingList, Set<Subject> learningList, double ratePerHour, int numStudents){
        super(email, password, name, age, level, gender, isRemote, location, teachingList, learningList);
        this.ratePerHour = ratePerHour;
        this.numStudents = numStudents;

    }

}