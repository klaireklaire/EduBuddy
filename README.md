# Team D - *EduBuddy*

# EduBuddy Android App - Iteration 3 (May 10, 2022)

This is an Android app that allow user to create and edit their account. User can also search for tutors based on
the subjects they teach and view the tutors' individual profiles. User can create booking requests (but not yet save and send them to other users.)


## Functionality Implemented

The following **required** functionality is completed:

- [x] User can enter their personal information to create an account
- [x] Tutor user can create account with additional required information
- [x] User can search for tutor by teaching subjects.
- [x] User can enter their grade to filter the subject level of tutors.
- [x] User can pick their account mode: Student, Tutor, or Both.
- [x] User can edit their profile.
- [x] User can view search result as a list of profile and view each of the individual profile.
- [x] User can create new request (in progress)
- [x] User can rotate the first screen (asking for user's name), entering tutor preferences screen, and tutor's profile screen (Dynamic state preservation)
- [x] User can get access to tutor's information across devices once tutor create a profile with user's desired learning subject (Persistence state: with Firestore and Persistence Facade for persistent User Library.)


## Limitations and Future Plans
1. More filters and search function: To search for tutors, there is only one filter option: by subjects. Other filters are yet to be implemented.
2. Fully implemented state preservation: Dynamic state needs to work with other screens as well.
3. Navigation: There are no dashboards or toolbars for user to navigate around different features of the app yet.
4. Rearranging fragments: For user creation, some of input fields are not intuitive. For example, entering currency can be
   implemented as a Spinner. Email and password screen should appear first instead of first name and last name screen.
5. User Authentication: Retrieve user from database if existed, adding "salt" to password field.
6. Due to time constraints, the "Send booking request" doesn't have logic yet. In the future, we plan to let user send request to other users and update the changes in real time. For now, the app only allows creating new requests, not saving them. 

## How to run the prototype
1. Build Project
2. Run the "app" configuration
3. For "I'll learn" mode, we suggest searching for "Computer Science, College" as we have added several users teaching this subject.

### App Walkthrough GIF
1. Student Mode
   <br /><img src="http://g.recordit.co/NKMJHwlLKE.gif" width=250><br>


# EduBuddy Android App - Iteration 2 (April 14, 2022)

This is an Android app that allow user to create and edit their account. User can also search for tutors based on 
the subjects they teach and view the tutors' individual profiles.


## Functionality Implemented

The following **required** functionality is completed:

- [x] User can search for tutor by teaching subjects.
- [x] User can enter their grade to filter the subject level of tutors.
- [x] User can enter their personal information to create an account.
- [x] User can pick their account mode: Student, Tutor, or Both.
- [x] User can edit their profile.
- [x] User can view search result as a list of profile and view each of the individual profile.


## Limitations
1. To search for tutors, there is only one filter option: by subjects. Other filters are yet to be implemented.
2. State preservation is not yet implemented, thus a profile can only be edited once (instead of repeatedly.)
3. There are no dashboards or toolbars for user to navigate around different features of the app yet.
4. For user creation, some of input fields are not intuitive. For example, entering currency can be 
implemented as a Spinner. 

## How to run the prototype
1. Build Project
2. Run the "app" configuration


# EduBuddy Android App - Iteration 1 (March 4, 2022)

This is a basic Java text-based application, allow users to provide input about their preferences when finding a tutor. In this iteration, we have implemented by name, by age, by grade, and by subject filters.


## Functionality Implemented

The following **required** functionality is completed:

- [x] User can search for tutor by teaching subjects. 
- [x] User can search for tutor by their exact age.
- [x] User can enter their grade to filter the subject level of tutors.
- [x] User can choose to filter by 1 or more filters.
- [x] User can quit.


## Limitations
1. User library is already provided for the search. We need to implement methods for users to input their profiles themselves.
2. Not all subjects are provided in the test cases. Available options are Math, Literature, and English. For subject level, only high school is available.
3. The age filter is by exact age for simplicity, and we plan to do age range in the later iteration.

## How to run the prototype
1. Build Project
2. In "View" class, hit run button. 
3. Input the search using available options provided in the console.
4. High School English/Literature are suggested to run the filter.
