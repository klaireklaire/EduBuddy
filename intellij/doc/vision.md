# Project Inception: EduBuddy

## Vision Document



* **Introduction**: Having noticed the demand to find tutors from many K-12 students and parents, and the abundance of experienced high school students not knowing where to find students, we decided that this app would be helpful in bridging that information gap. 
* **Main business cases**:
    * Connects students/ parents (A) in need to tutors (B)
    * Provide a safe place to communicate between A and B
        * For tutors to avoid fraud tutoring centers 
        * For parents and students to **confirm** the teaching quality/ qualifications of the tutors through tutor profiles and ratings 

    → Find matches fast and safely, unlike through third party tutoring center or connections 

* Users can use the app to find or give homework help or educational advice 
* High-level goals:
    * All the features work out as expected with reliability (features listed below)
    * The development process is iterative so that versions are launched until completion of the app (as opposed to spending too much time on one stuck spot and never getting it finished) 
    * Visual elements are consistent 
    * The app has its niche and doesn’t overlap with features of competing platforms 
* Features: 
    * Tutors can create profiles to advertise themselves
        * General information page 
            * Name
            * Age
            * Contact
            * Location: Remote or Offline 
            * Qualifications: History of education, awards, certificates, or teaching testimonies in the subjects they want to tutor
                * Number of questions answered successfully is also a qualification 
            * Preferences of students
                * Age 
                * Gender 
                * Personality traits in terms of studying 
            * Hours per week
            * Rate per hour 
            * Time per day available to give help 
            * Number of students they are able to handle (if they already reach their students limit then their profile will not pop up in search?)
    * Students/ parents can create profile
        * General information page
            * Name
            * Age 
            * Contact 
            * Education goals 
            * Locations 	
        * Preferred rate per hour 
    * Search feature for each party to find each other
        * Filter
        * Random match feature 
    * Rating feature for both parties 
    * QnA forum 
        * Questions will be directed to a general question board or to a tutor according to their availability (paid or not) 
        * Questions can be in form of text or images 
        * Forum is sectioned in terms of topics 
* Constraints:
    * Safety concerns: The project will not be able to ensure safe and secure transactions between tutors and their clients because transactions are not in app 
* Inspiration/ Competitors:
    * Since the app is expected to work in Vietnam, where apps like this are not as available, the following platforms are more inspiration than competitors
        * [https://www.ringleplus.com/en/student/landing/home](https://www.ringleplus.com/en/student/landing/home)
        * [https://preply.com/](https://preply.com/)
        * [https://gopeer.org/](https://gopeer.org/) (Android)
        * [https://apps.apple.com/us/app/wyzant-find-a-tutor/id1042081370](https://apps.apple.com/us/app/wyzant-find-a-tutor/id1042081370) (iOS) 
        * Brainly (iOS) 
        * [https://tutormatchingservice.com/#/press/tms-mobile-launch](https://tutormatchingservice.com/#/press/tms-mobile-launch)
        * 
* Actor-goal table:

<table>
  <tr>
   <td>
<strong>Actor</strong>
   </td>
   <td><strong>Goals</strong>
   </td>
  </tr>
  <tr>
   <td>Tutor
   </td>
   <td>Find students 
<p>
Gain credibility in teaching
<p>
Earn money
   </td>
  </tr>
  <tr>
   <td>Students
   </td>
   <td>Find suitable tutors in terms of subjects, teaching style
<p>
Betterment in their grades/school work
<p>
Learning how to study better
   </td>
  </tr>
  <tr>
   <td>Parents
   </td>
   <td>Able to find tutors who can help their kids
   </td>
  </tr>
  <tr>
   <td>Friend of students 
   </td>
   <td>Doesn’t need to use the app yet 
<p>
Sometimes need homework help 
   </td>
  </tr>
</table>


### Find Tutors

**Scope**: EduBuddy application 

**Level**: User goal

**Primary actor**: Client 

**Stakeholders and interests: **



* Tutor: want to be paired with clients with educational goals that match their interests and skills; 
* Students: want fast service with minimal effort. Wants easily visible display of tutors skill and achievements. Wants proof of achievement to validate tutors’ profile
* Parents: same wants as students

**Preconditions** (what must be true at the start of the use case): students are identified and authenticated.

**Postconditions** (success guarantee):



* Tutors’ profiles appeared on clients’ search screen
* Clients are able to scroll matching profiles
* Clients can message tutors

**Main success scenario: **
1. Clients go to the “find tutor” screen 
2. Clients start the filtering process: 
    1. Subjects: pick subjects from the list
    2. Location: choose from 3 options (online/tutor to student/student to tutor)
    3. Study goals
    4. Preferred gender
    5. Availability time range
3. Clients are able to see the full list of potential tutors that match their needs 
4. System presents tutors’ profile including tutors’ name, gender, availability (hour), expertise, ratings, price, location
5. Clients can hit the “save” button while scrolling the profile to go back later if they want to connect with the tutors
6. Clients message favorite tutors - execute “send message” use case (title - body of text) 

**Extensions (or alternate flows):**

4a. Students are not interested in any of the tutors shown on the screen
* Not enough tutors signed up → clients can choose “alert” option to notify when there are new tutors
* Alternative search: clients can modify their filtering
4b. Browsing the lists, students can see the details by clicking tutor profile
4c. Save - hit save button to save search 


### Send Message  {#send-message}

Scope: EduBuddy application 

Level: User goal

Primary actor: tutors, clients

Stakeholders and interests:



* Tutors: Want to communicate their preferences and rates to client. Want to have a consistent communication channel with clients.
* Clients (students/parents): want fast responses and save time finding a tutor,  confirmation to get a tutor happens through messaging

Preconditions: Clients are able to find tutors that they’re interested in connecting with.

Postconditions:

Main success scenario:



1. Users initiate a conversation with others by hitting the “send message” button in “view full profile” page
2. A message box pops up with title and body text
3. Users can type their message in the box and hit send button
4. Messages are successfully delivered to the receiving party 
5. Push notifications: tutors/clients get notifications when there are new messages
6. Users enter chat box, new messages
7. Delete/archive message: users can delete/archive conversations that they no longer want to display or to save memory

Extensions (alternate flows)
