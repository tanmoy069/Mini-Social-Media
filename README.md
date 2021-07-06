# Mini-Social-Media

### How to Run this project

##### 1. Clone the project from root by clicking code button
##### 2. Copy https/ssh link (https://github.com/tanmoy069/Mini-Social-Media.git / git@github.com:tanmoy069/Mini-Social-Media.git)
##### 3. Add a clone repository on your eclipse
##### 4. Then import your git repository to local (it will take time to download dependencies)
##### 5. Create a mysql database (db name can be anything)
##### 6. Change the db name in application.properties
##### 7. Run the project as Spring Boot App
##### 8. Every table will be created automatically.
##### 9. Please add some locations in 'Location' table.

### Tables

##### 1. Location
###### Only locations are stored here. Location can be found by locationId.
##### 2. Status
###### To save post 'Status' table created.
###### statusId will automatically created by system. 
###### userId, visibility, statusBody are must to insert a row in 'Status' table.
###### userId to trace user
###### visibility to know about post, public or private?
###### statusBody is unique, because without stausBody there is no meaning to post a status.
##### 3. User
###### To login in the system a userId with password is mandatory.
###### To create 'user', use unique userId, email and phone number.
###### System will save bcrypted password when you register by registration form. 

### Modules

##### 1. User Login
##### 2. User Registration
##### 3. Home
##### 4. Profile
##### 5. Status Update

### Modules Description

#### User Login
##### If you have created user account then, login to the system by using userId and password
##### If you don't have any account then, click register below the login form or http://localhost:8080/registration

#### User Registration
##### To registration, click register below the login form or http://localhost:8080/registration
##### Anyone can register to this system, but userId, email and phone must be unique.

#### Home
##### Home page we will see when you login to the system
##### If there is no row in status table, it will show "No post available"
##### All public status will be found in home page (including own and anonymous users post)
##### You can post a status from Home.

#### Profile
##### On top of nav bar has your user name and there is a drop down option with profile and logout.
##### By clicking profile you can see your profile.
##### On profile page, all of your post will be found. (Including public and private)
##### If there you haven't post yet, it will show "No post available"
##### You can also post a status from profile.

#### Status Update
##### Edit option of status will be available on profile.
##### So, when you want to update any status click edit button and system will give you edit access.
##### After editing your status, click update button to save your correction.
##### System will automatically redirect to your profile after completing update.

# 
#### Thank you
##### Tanmoy Tushar
###### If you have any suggestion, give me feedback.





