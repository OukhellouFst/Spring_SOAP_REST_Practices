# Spring_SOAP_REST_Practices
Practicing the implementation of both soap ( SimpleJaxWSservelt ) and rest ( Jersey-JAXRS &amp; Spring Data REST &amp; REST Controller ) using Spring Framework 

## Practice of the existing solutions to implement web services using spring framework 
this is a practical project created by me following along my teacher Youssfi Mohammed .
## Objective 
- build a web service for a simple banque containing clients and accounts . 
- for the web services based on SOAP protocol , we can only add the annotations of the JAX-WS ( like @WebService & @Method ... ) and we do not forget to add JaxB library annotations for serialization @XMLRootElement and in the end we deploy this WS using a simple servelt offered by Spring framework .
- for the web services based on RESTful architecture , we have implemented them using 3 solutions : 
  * JAX-RS specification : by adding the annnotations like @Path & @GET or @POST ... ( don't forget to add the annotation @Component for the WS class so Spring Framework can perform IOC over the components of Spring DATA ) . in addtion don't forget to deploy this using a jersey servlet ( by configuring Spring ).
  * REST Controller : in this solution we don't use an external servlet to intercept the user request but we use instead the solutions offered in first place by Spring ( using the annotations like @RequestMapping @GetMapping @PostMapping ... ) . Note : no need to add the annotation @Component because REST Controller is already a class of Spring Framework ( it is not an external thing ) , that's mean it can do IOC over the things inside this class easly . 
  * Spring Data Rest : this solution also offered by the amazing framework Spring . you can easly add this annotation @RepositoryRestResource over the generic interfaces of Spring Data and you get the REST solution : No need to do extra works and you have then a beautiful REST api with extra features ( like the pagination , search , .... ) 
  
