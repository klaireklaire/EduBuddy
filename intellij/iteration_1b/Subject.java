public class Subject {

    // fields
    String subjectName;
    SubjectLevel subjectLevel;

    Subject(String subjectName, SubjectLevel subjectLevel) {
        this.subjectName = subjectName;
        this.subjectLevel = subjectLevel;
    }

    // methods
    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Subject)) return false;
        Subject newSubject = (Subject) o;
        return (this.subjectName.equals(newSubject.subjectName) && this.subjectLevel == newSubject.subjectLevel);

    }

    @Override
    public int hashCode() {
        return (subjectName + subjectLevel).hashCode();
    }

    @Override
    public String toString() {

        String result = "";

        result += this.subjectName + ", ";

        switch (this.subjectLevel) {

            case PRIMARY:
                result += "Primary level";
                break;

            case MIDDLE_SCHOOL:
                result += "Middle school level";
                break;

            case HIGH_SCHOOL:
                result += "High school level";
                break;

            case COLLEGE:
                result += "College level";
                break;

        }

        return result;

    }

}