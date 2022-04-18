## Fully Dressed Use-Cases (6)

### Booking 
**Scope**: EduBuddy application \
**Level**: Sub-function \
**Primary Actor**: Client \
**Stakeholders and interests:**
* Tutor: want to be notified when students request to have lesson with them, be able to schedule lesson with students
* Students: want to get notification when a tutor agrees to teach, be able to schedule lesson with tutors 
* Parents: same wants as students


**Preconditions**: students or tutors have already initialized the matching process by click on "request" button. tutor accepts 
the request 

**Postconditions**:
* Tutor and student successfully schedule meetings base on how often and how long they want to meet

**Main success scenario:**
1. Clients go to the “Booking” screen
2. Clients start booking process based on tutors availability: \
   a. Frequency 
   b. Days in a week           
   c. Hour
3. Clients confirm their selection \
4. System informs tutor about student's booking
5. Tutor review booking and accept/request change/reject booking 
6. Tutors and students are successfully matched

*a At any time, system crashes
* User restarts system
* User contacts system support
* System reconstructs prior state
