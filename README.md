#Download/Install git
from: https://git-scm.com/

#Clone repository
run: git clone https://almeida_lucas@bitbucket.org/almeida_lucas/grupomns-backend.git

#Download/Install Java
from: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Create JAVA_HOME environment variable and add to PATH

#Download/Install maven
from: https://maven.apache.org/download.cgi
(Download Binary zip archive - apache-maven-3.6.0-bin.zip)
Unzip, create MAVEN_HOME environment variable from unzipped folder and add to PATH

#Install maven dependencies *Optional 
run(from cloned project dir): mvn clean install

#Run project
run(from cloned project dir): mvn spring-boot:run
