# Accounts API
API to get user accounts and transactions for a particular account.

The API exposes following URLs.

**Get list of all accounts for a user**

_GET_: /api/v1/users/{user}/accounts

**Get list of all transactions under a account for a user**

_GET_: /api/v1/users/{user}/accounts/{account}/transactions


## Technologies Used
1. Java 8
2. Spring Boot
3. Maven
4. HSQLDB (In-memory Database)
5. Spring Data JPA

## Build Instructions

### Prerequisite
To build the applicaiton locally, Java 8+ must be installed and configured on local machine.

### Steps
1. Download the code from git repo as zip.

2. Extract the zip to any location. Ex
	```~/accounts-api-main```

3. Open terminal (unix) or command prompt (windows).

4. Navigate to loaction where zip is extracted.
	```cd ~/accounts-api-main```

7. From terminal, run below command to create executable jar.
    ```
    ./mvnw clean package -DskipTests
    ```

8. Run the application using command
    ```
    ./mvnw spring-boot:run
    ```
	
**NOTE**: Sample data gets pre-loaded in database during application startup and it can be found here 'src/main/resources/data.sql'