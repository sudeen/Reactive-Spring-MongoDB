# Reactive-Spring-MongoDB

Simple Project based on Spring Boot, Reactive Spring, MongoDB with Spring5.

To make the code simpler lombok feature has been used.

You need mongodb installed on your machine to run this application.

Make sure to remove all the previous version installation of mongodb for clean installation.
To remove all the previous version hit this command "sudo apt-get remove mongodb* --purge"

Follow the instructions from this site if you want to install mongodb on you machine.

https://sainirahul.wordpress.com/2015/04/02/installing-mongodb-on-linux/

While following the instructions from this link, this short command can be a handy one "--allow-unaunthenticated" add this at the end of the command.

or

https://www.digitalocean.com/community/tutorials/how-to-install-mongodb-on-ubuntu-16-04

Make sure you have installed mongodb properly.

Use these commands to check and run your mongodb server.

"sudo service mongod start" to start the mongodb server.

"service mongod status" to check the status of mongodb server.

"systemctl enable mongod.service" to start mongodb automatically when the system starts.

Also you can go to the var/log/mongodb and check for the log file. You can find port number and some of the logs in the text file.

#Router Function in Spring 5

RouterFunction serves as an alternative to the @RequestMapping annotation. It’s used for routing incoming requests to handler functions

In this particular example the MVC style are commented out to use the new Router function of Spring5.

To use the MVC style you need to remove the comment in the controller and comment the router function part.



