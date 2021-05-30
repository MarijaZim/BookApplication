## Java version used: 11

## Building and starting the application
You can build and start the application in a IDE and see the results in the console or
you can start it in cmd by navigating to the project folder (BookApplication) and typing: 
java -jar target/bookapp-0.0.1-SNAPSHOT.jar


## Second assignment
The results for the second assignment are printed in the IDE console or cmd.
The functions are called in the main method in BookappApplication class.
I wasn't sure whether to use DB & JPA or solve the assignment with plain Java so I solved this assignmend in both ways.
SimpleAuthorService and SimpleBookService is where I used plain java logic. On the other hand, in BookService and Author Service I used
spring JPA repositories and H2 in-memory database.


## Third assignment
The RESTfull API is located in the Controller subfolder.
The API is tested in a separate application (BookApplicationApiTests) using Rest-Assured library.
I used h2 database for this assigment with these specifications:
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
For sending GET request to the API: https://localhost:9090/api/books  


## Testing the API
While the BookApp is running, you can test the API in a cmd by navigating to the BookApplicationApiTests folder and typing: </br>
mvn -Dtest=BookTests test </br>
(or in the IDE)
