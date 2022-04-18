import java.util.*;

public class View {

    public static int getAge(Scanner sc) {
        System.out.println("Enter the tutor's age:");
        int age = -1;
        while (age <= 0) {
            try {
                age = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid age '%s' (not a positive whole number).");
                break;
            }
        }
        return age;
    }

    public static int getGrade(Scanner sc) {
        System.out.println("Enter a number 1-12 to search for tutoring subjects within K12. Enter any number larger than 12 to search for college-level tutors:");
        // int grade = sc.nextInt();
        int grade = -1;
        while (grade <= 0) {
            try {
                grade = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid grade '%s' (not a positive whole number).");
                break;
            }
        }
        return grade;
    }

    public static String getSubject(Scanner sc) {
        System.out.println("Enter the name of the subject with the first letter capitalized:");
        // String subject = sc.nextLine();
        return sc.nextLine();
    }

    // check if the user inputs something equivalent to yes
    public static boolean isYes(Scanner sc) {
        String line = sc.nextLine();

        return (line.equals("Yes") ||
                line.equals("yes") ||
                line.equals("Y") ||
                line.equals("y"));
    }

    public static void main(String[] args) {

        Controller controller = new Controller();
        Scanner sc = new Scanner(System.in);

        // print welcome message
        System.out.println("/*** Welcome to EduBuddy tutor matching app! Let's find out who can be your tutor. ***/");
        System.out.println("Instructions:");
        System.out.println("   - Available options are searchByAge, searchByTeachingSubject, and quit.");
        System.out.println("   - seachByAge can be used to search for tutors by their exact age.");
        System.out.println("   - searchByTeachingSubject can be used to search for tutors by their teaching subjects.");
        System.out.println("   - quit can be used whenever the menu is printed to quit the search.");


        outerloop:
        while (true) {

            // print out menu of options
            System.out.println("Available options: searchByAge, searchByTeachingSubject, and quit.");
            String line = sc.nextLine();

            boolean printUl = true;
            boolean printProfile = true;
            boolean moreSearch = true;
            int searchAge = Controller.DEFAULT_AGE;
            String searchSubject = Controller.DEFAULT_SUBJECT;
            int searchGrade = Controller.DEFAULT_GRADE;

            // process inputs
            switch (line) {

                case "quit":
                    System.out.println("Thank you, and goodbye!");
                    printUl = false;
                    printProfile = false;
                    moreSearch = false;
                    break outerloop;

                // process filtering by age
                case "searchByAge":

                    // process the age input
                    searchAge = getAge(sc);

                    // ask if the user wants to proceed with other options
                    System.out.println("Would you like to add more filters?");
                    if (isYes(sc)) continue;
                    else break;


                    // process filtering by teaching subject
                case "searchByTeachingSubject":

                    // process the grade and subject name inputs
                    searchGrade = getGrade(sc);
                    searchSubject = getSubject(sc);

                    // ask if the user wants to proceed with other options
                    System.out.println("Would you like to add more filters? Enter Yes or No.");
                    if (isYes(sc)) continue;
                    else break;


                default:
                    System.out.println("Input not recognized.");
                    continue;

            }

            UserLibrary filteredLibrary = new UserLibrary();

            if (printUl) {
                filteredLibrary = controller.filterTutors(searchAge, searchGrade, searchSubject);
                if (!filteredLibrary.users.isEmpty()) {
                    System.out.println(filteredLibrary);
                } else {
                    System.out.println("There are no tutors matching your search. Try again? Enter Yes or No.");
                    if (isYes(sc)) {
                        continue;
                    } else {
                        printProfile = false;
                        break;
                    }
                }
            }

            innerloop1:
            while (printProfile) {

                System.out.println("Do you want to print out any tutor's profile? Enter Yes or No.");
                if (isYes(sc)) {
                    System.out.println("Enter the name of the tutor you want to view profile of: ");

                    boolean noMatched = true;
                    while (true) {
                        String tutorName = sc.nextLine();
                        for (User u : filteredLibrary.users) {
                            if (tutorName.equals(u.name)) {
                                noMatched = false;
                                System.out.println(u);
                            }
                        }

                        if (noMatched) {
                            System.out.println("Please re-enter the name correctly as displayed on this search result.");
                            continue;
                        } else continue innerloop1;
                    }

                } else break;

            }

            while (moreSearch) {

                System.out.println("Search again? Enter Yes or No.");
                if (isYes(sc)) {
                    continue outerloop;
                } else {
                    printProfile = false;
                    break outerloop;
                }

            }

        }

    }

}
