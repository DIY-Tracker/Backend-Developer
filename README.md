POST /createnewuser
Expects:
{
    "username": {String},
    "password": {String}
}
Returns: nothing

POST /login
Expects: (along with the funky headers we worked out)
{
    "username": {String},
    "password": {String}
}
Returns: token

GET /oauth/revoke-token
Expects: nothing
Returns: nothing (but revokes the access token issued on login)

------------------------------------------------------------------

Note: All /users endpoints require authentication to access

GET /users/getusername
Expects: nothing
Returns: logged-in user
GET /users/users

Expects: nothing
Returns: all users

GET /users/user/{userid}
Expects: nothing
Returns: Single user with matching ID

GET /users/{username}
Expects: nothing
Returns: Single user with matching username

------------------------------------------------------------------

Note: /projects endpoints do not require authentication, but POST/PUT/DELETE require that the user making the request matches the user assigned to the project being accessed

GET /projects/projects
Expects: nothing
Returns: all projects

GET /projects/projects/{projectid}
Expects: nothing
Returns: Single project with matching ID

POST /projects/projects/{userid}
Expects:
{
    "projectName": {String},
    "description": {String},
    "photoUrl": {String},
    "materials": [{String}, {String}, ...],
    "steps": [{String}, {String}, ...]
}
Returns: nothing

PUT /projects/project/{projectid}
Expects:
{
    {project fields that are being updated}
}
Returns: nothing

DELETE /projects/project/{projectid}
Expects: nothing
Returns: nothing (but does delete project with matching ID)