# Client_Server-airport_flights
Using ConcurrentHashMap.
Each flight has its own code. First the Multithreaded Server is started.
Then 3 "Reader" type threads and 3 "Writer" type threads are created. Each thread sends a random request 10 times. 
There can't be an error because of the simultaneous writing/editing/deletion of two "Writer" type threads. More than one "Writers" can work simultaneously on different flights. Also, reading a flight's details doesn't affect a "Writer's" work and many "Readers" can read the last state of each flight's details. 
