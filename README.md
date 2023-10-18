# onlinesale_task2

I'm using a 3rd party API to calculate the math equations.

download the project or git clone the code

to start the program:
  step1: navigate to the project file (demo)
  step2: mvn spring-boot:run
  that's it... the program is up and running
      or
  run by using IntelliJ, eclipse or vs code IDE & the program starts in 8080 port

open the postman:
  select get method
  in the URL-> http://localhost:8080/input
  in the body select the form data and insert the key-value pair
  example:
    key    value
    input  sqrt(5^2 - 2^2)
click on send

you can send as many math equations input as you want

finally, you should send input: end  to return the output of each equation or query you passed....


the output would look like:
  
  4 /(7-5) => 2
  2*4*4 => 32
  sqrt(5^2 - 2^2) => 3^(1/2) 7^(1/2)
  sqrt(-3^2 - 4^2) => 5 i


