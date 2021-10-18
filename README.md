##Customizing REST API token response

Take a look at these files:
* com.company.exttok.web.rest.CustomTokenEnhancer - enhances the token with additional data.
* custom-rest-context-config.xml - overrides the token enhancer.
* web-app.properties - registers additional `cuba.restSpringContextConfig` file.

Launching:
* Create user with login & password rest / rest
* Create and assign role (scope = REST) that gives read access to the UserDetails entity
* Also assign "rest-api-access" role to the user.
* Create UserDetails from UI, set user = rest and set some phone number.
* Test from command line:
```
$ curl -X POST   http://localhost:8080/app/rest/v2/oauth/token \
    -H 'Authorization: Basic Y2xpZW50OnNlY3JldA==' \
    -H 'Content-Type: application/x-www-form-urlencoded' \
    -d 'grant_type=password&username=rest&password=rest' && echo ''
    
{"access_token":"vwvl4tcZ0wF44awGgTVlTNkSiPI","token_type":"bearer",
"refresh_token":"k_aBkjBLEO3sWADHjzEbWmuKrWY",
"expires_in":43199,"scope":"rest-api","telephone":"+79271234567"}
```
