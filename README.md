# MVC Film Site
This project was built in collaboration between Forrest January and Derek Lynch.

# Description
This web application provides an interface to manage a SQL database of Films. The landing page gives the user the options to search for a film by either the film ID or a keyword query. If either query is to return more than one film, the query will fail and the user will be notified. If the query finds no film, the user will be notified. If the query finds only one film, the page will display the contents of that film.

The landing page also has the option to insert a new film into the database. If chosen, it links to a form where all of the information can be changed and inserted other than the actors and categories of the film. Once a film is entered, that film's information is displayed on the results screen in the same way that a film query shows. 

On the results page, there is an option to either delete or update a film, with the field auto-populated with the Film ID of the film displayed on the page. If delete film is used, it will attempt to delete the film with the ID submitted, and it will display an appropriate message to indicate success or failure of deletion. If update film is used, it takes the user to a form that is auto-populated with the film's information and allows for it to be changed. When submitted, it will go to a results page that will indicate the success or failure of the update as well as the new information of the film.


# Technology used

- Java 
- Spring Tool Suite/Eclipse 
- Gradle 
- Github 
- Object Oriented Design
- SQL 
- Atom 
- MySQL Workbench 
- Tomcat 
- MAMP 
- Slack 
- HTML
- Google
- Maven
- DAO
- bootstrap


# Lessons learned

We learned communication is paramount. A lot of our stumbling was due to not knowing what the other was working on, or having to fix issues that cropped up from merging files that we both were working on so a lot of items were reworked. We also learned about the 'git merge' command and how it functions in full detail. 

One large lesson learned was fostering an understanding of how the entire framework of the Model-View-Controller(MVC) design pattern worked. There were many renditions of the FilmController class, and most of the functionality of this application ended up made in the controller class. Prior to this project, the interactions between the different pieces of the MVC design pattern did not click internally as they had not been navigated in great length. The amount of work put into this project and the multiple required small fixes from cascading errors in the controller class strengthened our understanding of how the program was truly meant to function.

Overall, this was a fun project that let us get a deeper understanding of Spring, MVC design patterns, and just the process of building dynamic web applications in general.

# Future Goals. 
We noticed some minor things while adding backgrounds and background images that we would like to fix. The program has some very loose and unresponsive styling due to time constraints on this project, and we would like to improve on how it is presented. 

We would also like to add functionality to this program to enable the insertion of actors and categories to the film, as well give the ability to delete films that are linked in a chain to other tables like inventory.
