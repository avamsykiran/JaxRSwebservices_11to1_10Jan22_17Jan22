Topics
-------------------------------------------------------------

    Build / Implement REST Web Services (JAX - RS)  API using Jersey
    Write code to use annotations , request method designators, customize request and response formats, extract request parameters.
    Develop REST Client and invoke service
    Test RESTful services.

Dynamic Web Appliction
-----------------------------------------------------------------

    Project Structure
        ProjectRoot
            |- src  *.java
            |- WebContent       (ContextRoot)
                |- META-INF
                |- WEB-INF
                    |- lib
                    |- classes
                    |- web.xml  Deployment Descriptor file
                                    1. Application Name
                                    2. Servlets, Url Mapped to the Servlets
                                    3. Listneers, Filters ..etc , Url Mappings
                                    4. Session Time out
                                    5. Security Configs ......

    ServletConfigInitializer        Servlets 3.0
        Annotation Based configuaration
            @WebServlet
            @Listener
            @Filter ....
        
    
WebService
-----------------------------------------------------------------

    a webservice is any method that can be invoked via a remote call.


    WebApplication

        DAO  <----> SERVICE <----> CONTROLLER <-----> VIEW (JSP)

    Windows / Linux Standalone 

        DAO  <----> SERVICE <----> CONTROLLER <-----> VIEW (Java Swings/AWT)

    Andriod Mobile Applciation
        
        DAO  <----> SERVICE <----> CONTROLLER <-----> VIEW (Andriod Views)


    BackEnd Application (SOAP WebService)     <---SOAP----->  UI/UX
                                                                Andriod
                                                                Angular
        DAO  <----> SERVICE <----> CONTROLLER                   JSP Web
                                                                Java Swing/AWT
                                                                React
                                                                .....etc

    BackEnd Application (REST WebService)     <---HTTP----->  UI/UX
                                                                Andriod
                                                                Angular
        DAO  <----> SERVICE <----> CONTROLLER                   JSP Web
                                                                Java Swing/AWT
                                                                React
                                                                .....etc

    SOAP Webservice

        protocol of communciation is SOAP

        'xml' as medium of communcation

        if the caller has to send data to the method (webservice) OR
        if the method (webservice) has to return to the caller, in both
        cases XML was the format of communication.

    Restful WebService -  REpresentational State Transfer 

        protocol of communication is HTTP

        http supports a large varaity of media like
            XML
            JSON
            IMAGE
            Binary Files
            Strings / Text ...etc


JAX-RS
-----------------------------------------------------------------------

    JavaEE 6 specification for REST api

    JAX-RS implementations
        Jersy
        Resteasy
        ....etc

    Deploying JAX-RS

        on a web server                             Tomcat/Wildfly/Glassfish
        or on a any simple http server as well.     Jetty

Lab Setup
------------------------------------------------------------------------

    Eclipse         IDE
    Maven           Build Tool
    Tomcat 8        Web Server
    PostMan         Rest Client

REST api        - Standards
------------------------------------------------------------------------

    1. Routing the urls

        Resource:       Employee

        Non-standard way

            addEmployee()               /emp/add        /addEmp
            getEmployeebyId()           /emp/get/101    /getEmp/101
            getAllEmployees()           ............
            delketeEmployee()
            updateEmployee()

        Standard way
            (Http mehtod [POSt/PUT/DELTE...] ar each mapped to a CRUD operation)
            and it is recommanded to use a common URL (End Point) for all
            operation against a single Resource

            Employee            /emps
            Department          /depts ...etc


            GET     /emps       retrive all emplyee records
            GET     /emps/101   retrive the employee with id 101
            POST    /emps       create an employee record
            PUT     /emps       update an entire employee record
            PATCH   /emps       update a part of the employee record
            DELETE  /emps/101   delete the employee with id 101

    2. Http Status Codes

        1xx         indicate the reception of a request and that the req is under process
        3xx         indicate that a req is being redirected....

        2xx         indicate the successful completion of a req.
            200     OK                  when a GET req is sucessful
            201     CREATED             when a POST req is sucessful 
            202     ACCEPTED            when a PUT/PATCH req is sucessful 
            204     NO CONTENT          when a DELETE req is sucessful 

        4xx         indicates the req got failed due to client side error
            400     BAD REQUEST when a req fails due to incorrect or insuffient data from the client
            404     NOT FOUND   when a GET req failed because of the data to be feteched is not found

        5xx         indicates the req got failed due to server side error

            500     INTERNAL SERVER ERROR       in case of an unhandled exception on the server


JAX-RS Annotations
-----------------------------------------------------------------------------------------

    @Path("/endPoint")

    @GET
    @PUT
    @POST
    @DELETE
    @PATCH

    @Produces()
    @Consumes()

    @Context

Maven Dependecies (Jersy 1.x)
-------------------------------------------------------------------------------------------

        <dependency>
			<groupId>asm</groupId>
			<artifactId>asm</artifactId>
			<version>3.3.1</version>
		</dependency>
		<dependency>
			<groupId>com.sun.jersey</groupId>
			<artifactId>jersey-bundle</artifactId>
			<version>1.19.4</version>
		</dependency>
		<dependency>
			<groupId>com.sun.jersey</groupId>
			<artifactId>jersey-server</artifactId>
			<version>1.19.4</version>
		</dependency>
		<dependency>
			<groupId>com.sun.jersey</groupId>
			<artifactId>jersey-core</artifactId>
			<version>1.19.4</version>
		</dependency>

    web.xml

    <servlet>
		<servlet-name>Jersey Web Application</servlet-name>
		<servlet-class>com.sun.jersey.spi.container.servlet.ServletContainer</servlet-class>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>Jersey Web Application</servlet-name>
		<url-pattern>/*</url-pattern>
	</servlet-mapping>

Maven Dependency (Jersy 2.x)
--------------------------------------------------------------------------------

        <dependency>
                <groupId>org.glassfish.jersey.containers</groupId>
                <artifactId>jersey-container-servlet</artifactId>
                <version>2.24</version>
         </dependency>
 
       <dependency>
			<groupId>org.glassfish.jersey.media</groupId>
			<artifactId>jersey-media-json-jackson</artifactId>
			<version>2.24</version>
		</dependency>

    web.xml

    <servlet>
        <servlet-name>jersey-serlvet</servlet-name>
         <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
        <init-param>
            <param-name>jersey.config.server.provider.packages</param-name>
            <param-value>your-package</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
   </servlet>
 
    <servlet-mapping>
        <servlet-name>jersey-serlvet</servlet-name>
        <url-pattern>/*</url-pattern>
    </servlet-mapping>