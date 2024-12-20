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

**The interfaces that represent the main contracts for authentication flow in Spring Security**

**UserDetail**s - Represents the user as seen by Spring Security.

**GrantedAuthority** - Defines an action within the purpose of the application that is allowable to the user (for example, read, write, delete,etc.).

**UserDetailsService** -Represents the object used to retrieve user details by username.

**UserDetailsManager** -A more particular contract for UserDetailsService. Besides retrieving the user by username, it can also be used to mutate a collection of users or a                            specific user.

**PasswordEncoder** - Specifies how the password is encrypted or hashed and how to check whether a given encoded string matches a plaintext password.

 **web app’s security begins with filters**
1. The first layer of the web application architecture, which intercepts HTTP
requests, is a filter chain. As for other components in Spring Security architecture, you can customize them to match your requirements.
2. You can customize the filter chain by adding new filters before, after, or at the
position of an existing filter.
3. You can have multiple filters at the same position of an existing filter. In this case,
the order in which the filters are executed is not defined.
4. Changing the filter chain helps you customize authentication and authorization
to match the requirements of your application. For eg. OncePerRequestFilter, GenericFilterBean etc.
