# Team D - *EduBuddy*

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
