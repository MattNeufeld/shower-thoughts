This is an api constructed with spring that allows a user to create, read, update and delete "Shower Thoughts".
This implementation is overkill for this specific use case however the api was primarily created in order to get more familiar with spring boot.

Note that currently the "database" the api interacts with is an in-memory map holding all of the thoughts. As a result of this, there is no persistence when restarting the api. A potential expansion of this project is to create an actual SQL server to interact with to allow for persistence between runs. This however comes with the downside of having to run additional applications if there was ever the need to run this project locally on another machine.

API Endpoints:

http://localhost:8080/showerthought
Accepted Methods: Post

This endpoint allows the user to create new showerthoughts, only requiring a "thought" arguement in the body of the request.

http://localhost:8080/showerthought/{id}
Accepted Methods: Get, Put, Delete

This endpoint allows the user to get, put and delete "thought"s at a specific id. Both the get and delete commands require no data in the body while the update requires a "thought" arguement.

http://localhost:8080/showerthought/all
Accepted Methods: Get

This endpoint returns a list of all the "thought"s currently in the database.

