import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SubjectFilter implements IFilter {

    Subject teachingSubject;

    public SubjectFilter(int grade, String subject) {
        if (!subject.equals("") && grade > 0) { // put in view
            SubjectLevel subjectlevel;
            if (grade <= 6)
                subjectlevel = SubjectLevel.PRIMARY;
            else if (grade <= 9)
                subjectlevel = SubjectLevel.MIDDLE_SCHOOL;
            else if (grade <= 12)
                subjectlevel = SubjectLevel.HIGH_SCHOOL;
            else
                subjectlevel = SubjectLevel.COLLEGE;
            this.teachingSubject = new Subject(subject, subjectlevel);
        }
    }

    @Override
    public HashSet<User> filter(HashSet<User> users) {
        HashSet<User> resUsers = new HashSet<User>();
        for (User user : users) {
            if (user.teachingList.contains(this.teachingSubject)) {
                resUsers.add(user);
            }
        }
        return resUsers;
    }
}
