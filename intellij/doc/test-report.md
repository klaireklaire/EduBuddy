# System tests report 
The tests report include screenshots in which white texts are what the console printed out, 
and green texts are what the user entered.

## 1. Test: Searching tutors by age
- The user answers questions prompted by the system to configure the filter.
- Screenshot of a successful search by age that returns a list of filtered tutors:
  <br />  <img src="Test_screenshots/searchByAge_s1.png" width=800><br>
- Screenshot of a successful search by age that returns no tutors:
  <br /> <img src="Test_screenshots/searchByAge_s2.png" width=800><br>

## 2. Test: Searching tutors by teaching subjects
- The user answers questions prompted by the system to configure the filter. 
- Screenshot of a successful search by teaching subject that returns a list of filtered tutors:
  <br />  <img src="Test_screenshots/searchBySubject_s1.png" width=800><br>
- Screenshot of a successful search by teaching subject that returns no tutors:
  <br />  <img src="Test_screenshots/searchBySubject_s2.png" width=800><br>

## 3. Test: Showing profile of a selected tutor 
- The user types the name of the tutor and receives a textual representation of their profile.
- Screenshot of a successful call to show profile:
  <br />  <img src="Test_screenshots/printProfile_s1.png" width=800><br>
- Screenshot of an unsuccessful call to show profile in which user entered the name of the 
tutor incorrectly. <br /> The system re-asks for the tutor's name and proceeded with the search.
  <br />  <img src="Test_screenshots/printProfile_s2.png" width=800><br>

## 4. Test: Searching tutors by both age and teaching subjects 
- The user answers questions prompted by the system to configure the filter. 
- Screenshot of a successful search that returns a list of filtered tutors:
  <br /> <img src="Test_screenshots/twoFilters_s1.png" width=800><br>

## 5. Test: Consecutive searches 
- The user answers yes to the prompt "Search again? Enter Yes or No." to execute a new search.
- Screenshot of two successful consecutive searches:
  <br />   <img src="Test_screenshots/repeatedSearches_s1.png" width=800><br>

## 6. Test: Quit 
- The user enters quit when the option is presented to terminate the search. 
- Screenshot of a successful call to quit:
  <br /> <img src="Test_screenshots/Quit_s1.png" width=800><br>