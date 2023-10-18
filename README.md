# onlinesale_task2

im using a 3rd party api to calculate the math equations.

download the project or git clone the code

to start the programm:
  step1: navigate to the project file (demo)
  step2: mvn spring-boot:run
  that's it... the programm is up and running
      or
  run by using intellij, eclipse or vscode IDE & the programm starts in 8080 port

open the postman:
  select get method
  in the url-> http://localhost:8080/input
  in the body select the form-data and insert key-value pair
  example:
    key    value
    input  sqrt(5^2 - 2^2)
click on send

you can send as many math equations input as you want

finally, you should send input:end  to return the output of each equation or query you passed....


output would look like:
  
  4 /(7-5) => 2
  2*4*4 => 32
  sqrt(5^2 - 2^2) => 3^(1/2) 7^(1/2)
  sqrt(-3^2 - 4^2) => 5 i

