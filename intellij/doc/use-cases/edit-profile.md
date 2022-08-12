## Fully Dressed Use-Case (1)

###Edit Profile
**Scope**: EduBuddy application \
**Level**: Subfunction \
**Primary actor**: Tutors, clients \
**Stakeholders and interests**: \
Tutors: Want to update their profile data like changing name, passwords, profile pics, rate per hours, or adding teaching subjects. \
Clients (Students/ Parents): Want to update their profile data like changing name, passwords, profile pics. \
**Preconditions**: Clients have already had a profile on file and have logged in with their credentials.\
**Postconditions**:
Profiles are updated and saved. \
**Main success scenario:**
1. Users navigate to profile screen and hit the “Edit Profile” button
Users are allowed to change their profile information without verification except for passwords.
2. User picture: optional section, allows user to change profile picture. “Choose a file” button will appear for user to input their picture in a suitable format.
image file will be cropped to a square and resized down to 100x100 pixels.
3. User general information: all the other information except profile picture and passwords, some compulsory fields are first and last name, email. This information can be changed directly on the profile page
4. User password: a verification email is generated to verify the user and navigate the user to the new password screen.
5. Users are able to save all updated information.
6. User information is up-to date-on user library.

**Extensions (alternate flows):** \
3a. The picture is larger than the maximum size listed \
Ask the user to reduce the size \
5a. Old password entered is wrong \
User can hit “forgot password” button to get a link to “new password” screen via their email. \
*a At any time, system crashes \
User restarts system \
User contacts system support \
System reconstructs prior state 
