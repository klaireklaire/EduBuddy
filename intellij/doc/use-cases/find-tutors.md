## Fully Dressed Use-Cases (2)

### Find Tutors
**Scope**: EduBuddy application \
**Level**: User goal \
**Primary Actor**: Client \
**Stakeholders and interests:** 
* Tutor: want to be paired with clients with educational goals that match their interests and skills; 
* Students: want fast service with minimal effort. Wants easily visible display of tutors skill and achievements. Wants proof of achievement to validate tutors’ profile 
* Parents: same wants as students 

**Preconditions**: students are identified and authenticated.

**Postconditions**:
* Tutors’ profiles appeared on clients’ search screen
Clients are able to scroll matching profiles
Clients can message tutors

**Main success scenario:**
1. Clients go to the “find tutor” screen
2. Clients start the filtering process: \
a. Subjects: pick subjects from the list \
b. Location: choose from 3 options (online/tutor to student/student to tutor)            
c. Study goals  \
d. Preferred gender\
e. Availability time range 
3. Clients are able to see the full list of potential tutors that match their needs \
4. System presents tutors’ profile including tutors’ name, gender, availability (hour), expertise, ratings, price, location
5. Clients can hit the “save” button while scrolling the profile to go back later if they want to connect with the tutors
6. Clients can tap a profile they are interested in to see more details about tutors
7. Clients message favorite tutors - execute “send message” use case (title - body of text)

**Extensions**: \
4a. Students are not interested in any of the tutors shown on the screen
* Not enough tutors signed up → clients can choose “alert” option to notify when there are new tutors
* Alternative search: clients can modify their filtering 

6a. Browsing the lists, students can see the details by clicking tutor profile
A detailed description and view linked to each profile 

*a At any time, system crashes
* User restarts system
* User contacts system support
* System reconstructs prior state
