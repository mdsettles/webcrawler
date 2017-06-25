# webcrawler
Web Crawler Sample

## Build and Run
Java 8 installed

Requires libraries downloaded and in classpath:
 - jsoup-1.10.3.jar
 
Unit tests also require:
 - junit-4.12.jar
 - hamcrest-core-1.3.jar

Build the project either in an IDE or command line to produce class files. 
  For command line windows, in the root directory of the project:
  
    javac -d out -sourcepath src -cp out\production\webcrawler;lib\jsoup-1.10.3.jar mike.crawler.WebCrawler
    
  
Run from command line in the root directory of the project:
 
    java -cp out\production\webcrawler;lib\jsoup-1.10.3.jar mike.crawler.WebCrawler http://wiprodigital.com

## Improvements Needed

 - Write junit tests 
 - Add a UI frontend with display of the results
 - Maven or Gradle for build, instead of manual build and libs within project.  
 - Create Jar file for easier deploy.
 - Improve exception handling, which is crude.
 - Use Spring for improved dependency injection.
