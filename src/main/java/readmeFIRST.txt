The overall structure is:
--------------------
Controller -> Service -> Persistence;

So lets assume that the servlet (Controller) receives a GET request.
The servlet calls the appropipate Service that then process the GET request.
The service calls the appropiate Persistence.


Job description:
--------------------
Controller      Process URL requests, calls services
Service         Process data, validation, algoritms, business logic
Persistence     Send data directly to the database


Models:
--------------------
Models are POJO objects which are used to carry data between the views and the database. POJO objects should mainly be generated on the service layer
where data validation happens. The Persistence layer returns arrays of resultsets but does not handle the data manipulation nor does it assemble it
to arrays for the view all that happens on the service layer.


Loose Coupling:
--------------------
In theory all classes should be supported with an interface.

Ex.
interface IMysqlBasicMethods { ... }
class MysqlBasicMethodsImpl implements IMysqlBasicMethods { ... }

This will ensure that you can use the same implemention even if you change the database. The same priciple applies for all other implementations.


Package Controllers.
* contains servlets aka. controllers
* create controllers for different paths

Package Dependencies
* contains classes such as database connection
* other classes with an importance for running the app

Package Models
* contains POJO objects

Package Persistence.DAO:
* this is the place for all DAO classes

Package Persistence:
* The raw database work happens here
* SQL sentences are here

Package Service:
* all business logic here

Package Utils:
* all global util
* test data