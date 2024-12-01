**Spring Security architecture** and the relationships among them shown in below 

<img width="600" alt="image" src="https://github.com/user-attachments/assets/ec79a3c6-35d6-4418-b363-520071ea82be">

**It shows that** - 
1. The authentication filter delegates the authentication request to the authentication manager, and based on the response, it configures the security context.
2. The authentication manager uses the authentication provider to process authentication.
3. The authentication provider implements the authentication logic.
4. The user details service implements user management responsibility, which the authentication provider uses in the authentication logic.
5. The password encoder implements password management, which the authentication provider uses in the authentication logic.
6. The security context keeps the authentication data after the authentication process. The security context will hold the data until the action ends. Usually, in a
   thread-per-request app, that means until the app sends a response back to the client.
