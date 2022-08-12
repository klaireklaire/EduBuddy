## Fully Dressed Use-Cases (6)

### Request a booking / Accept a booking
**Scope**: EduBuddy application \
**Level**: Function \
**Primary Actor**: Client, Tutor \
**Stakeholders and interests:**
* Clients: Want to book a tutor and send their availability to the tutor;
Want to receive notification about the decision of the tutor on the booking
* Tutors: Want to receive notification with information on the booking request


**Preconditions**: Students have already initialized the matching process by clicking on the "Request" button. 

**Postconditions**: Tutor and student successfully schedule meetings base on how often and how long they want to meet

**Main success scenario:**
1. Clients go to the tutor's Profile page
2. Clients start the booking process by clicking on the "Book" button on the tutor's Profile page. 
3. The system prompts a Booking Request Creation pop-up for the client to enter their booking info
4. Clients confirm their request
5. System informs the tutor about the client's booking
6. Tutor reviews booking and accepts the booking
7. Tutor and student are successfully matched
8. Student's information is moved to the "Students" section under the tutor's Profile page
9. Tutor's information is moved to the "Tutors" section under the student's Profile page
10. The booking request is deleted from the "Request" section under the tutor's and the student's Profile page

* Extensions:
    * a At any time, system crashes:
        * User restarts app
        * App reconstructs prior state
    * 2a Tutor's number of students already exceeded their stated capacity 
      * System displays warning: "Are you sure? This tutor is over capacity. This request will go into their waitlist."
      * Client can choose either Yes or No. If Yes, the booking process proceeds as normal. If No, the process terminates. 
    * 2b User already booked the tutor (i.e., previous booking process is not finished)
      * System displays warning: "Are you sure? Your previous booking has not been resolved yet."
      * Client can choose either Yes or No. If Yes, the booking process proceeds as normal. If No, the process terminates.
    * 5a Tutor reviews the booking and declines the booking 
      * System prompts tutor to pick the reason for the decline 
      * System informs the student of the tutor's decline and their reason
