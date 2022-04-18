## Fully Dressed Use-Cases (3)

### Onboarding

* Scope: EduBuddy application
* Level: Subfunction
* Primary actor: User
* Stakeholders and interests:
    * User: Wants to understand how the app works and create a secure profile with minimal set up
* Preconditions: N/A
* Success guarantee:
    * User understands how they can use all the features
    * User understands why they need to use the app and how the app gives them the help they need
    * User creates a profile on the system
* Main success scenario:
1. User sees the app from marketing platforms and downloads it
2. User opens the app for the first time
3. User picks their workflows (tutors or clients) and sees tooltips/ product tours to help them achieve their goals
4. User creates an account with their email, date of birth, password and confirms their email
5. Account is saved on the app system
6. User reads and follow setup requirements
1. Setup requirements consist of:
    1. Creating an account (completed)
    2. Adding information to their profile
    3. Allow notifications via email or through the device
7. User adds information to their profile and complete their first activity based on their selected role
    1. If user selects “Tutor” as their role:
        1. Tutoring subjects
        2. Contact
        3. Location: Remote or Offline
        4. Qualifications: History of education, awards, certificates, or teaching testimonies in the subjects they want to tutor
        5. Preferences of students
            1. Age
            2. Gender
            3. Personality traits
        6. Weekly availability (optional)
        7. Rate per hour
        8. Time per day available to give help
        9. Number of students they are able to handle
        10. Short description
    2. If user selects “Find a Tutor” as their role:
        11. Tutoring subjects
        12. Education goals
        13. Contact
        14. Location
        15. Preferred rate per hour
        16. Weekly availability (optional)
8. User picks preferred notification method
9. App displays suggested tutors/clients profile on dashboard based on the information user provided
* Extensions
    * 5a. Email has been used:
        * App signals email has been used and rejects signup
        * App suggests user to change email or recover their password
    * 5b. Password doesn’t follow password rules:
        * App signals error and rejects signup
        * App display password rules
        * User enters new password
        * App resumes as normal
    * 5c. User is under 13, which forbids them to have their information stored under COPPA
        * App signals error and rejects signup
        * App suggests user to consult their parents
        * App suggests user alternative paths to use the platform
    * 5d. User doesn’t receive confirmation email:
        * App suggests user to send confirmation email again
        * App directs user to contact the developers
    * a At any time, system crashes:
        * User restarts app
        * App reconstructs prior state
    * b At any time before the product tour is completed, user exits the app:
        * User reopens app at other time
            * App resumes product tour until completed 