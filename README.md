=======
todolist
========

Backend d'une todolist

## Running the application locally

First build with:

    $mvn clean install

Run it with:

    $java -jar target/dependency/webapp-runner.jar target/*.war

Get access to REST :

	GET - http://localhost:8080/tasks - Retrieves not deleted tasks (status < 2)
	GET - http://localhost:8080/tasks/1 - Retrieves task #1
	POST - http://localhost:8080/tasks - Creates a new task
	PUT - http://localhost:8080/tasks/1 - Updates task #1
	DELETE - http://localhost:8080/tasks/1 - Deletes task #1 (set status to 2)

## Running the application on Heroku

	http://kevinya-todolist.herokuapp.com/
