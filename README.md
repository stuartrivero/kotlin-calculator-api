# kotlin-calculator-api

Task details:
- Consider you are developing an application serving multiple concurrent users.
- Use TDD approach to build a “Calculator” Spring Boot microservice which if given
two numbers can perform (Addition, Subtraction, Multiplication and Division)
- The response format should be a String
Number 1 + Number 2 = Number 3
For example, for adding operation of two number 1 and 2 the response will be
1+ 2= 3
- Expose these as REST API
- Create your own mechanism to store the calculation API request, response along
with latest accessed timestamp (or created time for first request) in the local cache.
- When the API is requested check if the same calculation was already queried. If so,
serve from the local cache or else perform the calculation and store in the local
cache and return the response. Update the last accessed timestamp in the cache.
- Provide exception handling as you think necessary.
- Provide logging as you think necessary. (console or log file)
- Deploy the application into a docker container and should be able to access all the
API’s exposed by the microservice.
- Provide OpenAPI Swagger documentation or any other REST API documentation for
at least one API.
