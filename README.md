# Team: Minimum Viable Product
## OOP Iteration 3 -- COP4331


We used Apache Maven to build this project.  
Make sure it is installed by typing `which mvn`

Homepage:
https://github.com/Iteration-3/Code

### Running the Pre-Compiled Jar File
To run the Pre-Built version of the Game:
   - Copy the Root of the CD-ROM into a Folder on your Desktop
   - `cd` to the folder called Pre-Built-Jar
   - execute the command `sh RunGame.sh`, or on a Windows box, run `RunGame.bat`

### Build Instructions
To build:
  - Copy the Root of the CD-ROM to a Folder on your Desktop
  - `cd` to the root of the src directory
  - Upon executing the `ls` command, you should see a file called `pom.xml`
  - Execute the command: `mvn clean install`
  - To run the built .jar file, execute: `java -jar target/MinimumViableProduct.jar`
  
>  Note, you may also get the source code by running the command:
> `git clone https://github.com/Iteration-3/Code`
