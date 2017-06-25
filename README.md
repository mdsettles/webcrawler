# webcrawler
Web Crawler Sample

Sample results included in SampleOutput file.  Results are written to the console when run.

## Build and Run
Java 8 installed

Required libraries are included in the lib directory of the project for simplicity and brevity:
 - jsoup-1.10.3.jar
 
Unit tests also require:
 - junit-4.12.jar
 - hamcrest-core-1.3.jar

Build the project either in an IDE or command line to produce class files. 
  For command line windows, in the root directory of the project:
  
    javac -d out -sourcepath src -cp out\production\webcrawler;lib\jsoup-1.10.3.jar mike.crawler.WebCrawler
    
  Linux:
    javac -d out -sourcepath src -cp out/production/webcrawler;lib/jsoup-1.10.3.jar mike.crawler.WebCrawler

  
Run from command line in the root directory of the project or from within an IDE:
  Windows:
    java -cp out\production\webcrawler;lib\jsoup-1.10.3.jar mike.crawler.WebCrawler http://wiprodigital.com

  Linux:
    java -cp out/production/webcrawler;lib/jsoup-1.10.3.jar mike.crawler.WebCrawler http://wiprodigital.com

## Improvements With More Time

 - Write more junit test - PageContent
 - Improve Junit code coverage
 - Add a UI frontend with display of the results
 - Maven or Gradle for build, instead of manual build and libs within project.  
 - Create Jar file for easier deploy.
 - Improve exception handling, which is crude.
 - Use Spring for improved dependency injection.
 - Consider making PageCrawler implement an interface to facilitate a mock for additional junit tests. 
