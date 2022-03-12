
## A service that accesses the exchange rate service and displays a gif
If the exchange rate against the ruble for today has become higher than yesterday, then a gif comes with the tag "rich", otherwise "broken". Tags for gifs with different comparison outcomes can be changed in the application.properties file, the currency also changes there (initially rubles).

### Starting the JAR
`java -jar usdgif-0.0.1-SNAPSHOT.jar`

### Display
The data is sent to the root page (localhost:8080/) at the click of the button
