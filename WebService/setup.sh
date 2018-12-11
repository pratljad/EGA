 #!/bin/sh
clear
echo "-------------------------- New --------------------------"

#Paths
src="./At.Htl.EGA/src"


srcDB=$src/db
jars="./At.Htl.EGA/WebContent/WEB-INF/lib/"
srcDomains=$src/domains
srcApi=$src/api

srcServlet=$src/servlet11
bin="./At.Htl.EGA/build/classes/"
sqlScript="./"
workspaceWebFolder="./WebContent"
tomcat="/opt/apache-tomcat-9.0.4/webapps/"
servletApi="/opt/apache-tomcat-9.0.4/lib/servlet-api.jar"


#Database parameters
dbpwd=Pupil!#1
dbuser=pupil
dbdriver=com.mysql.jdbc.Driver
dbdatabase=jdbc:mysql://localhost:3306/


echo "Compiling domain classes"
javac -sourcepath $srcDomains -d $bin $srcDomains/*.java  
if [ $? -ne 0 ]; then
    echo "failed to compile the domain classes"
    exit -3
fi

echo "Compiling ConnectionFactory and Properties"
javac -sourcepath $srcDB -d $bin $srcDB/*.java  

if [ $? -ne 0 ]; then
    echo "failed to compile the ConnectionFactory and Properties"
    exit -3
fi

echo "Compiling api classes"
javac -sourcepath ./;$jars -d $bin $srcApi/*.java  
if [ $? -ne 0 ]; then
    echo "failed to compile the api classes"
    exit -3
fi



echo "Creating database"
cat $sqlScript/dbscript.sql | mysql -u $dbuser -p$dbpwd

if [ $? -ne 0 ]; then
    echo "failed to create database"
    exit -3
fi

echo "Restarting tomcat"
cd $tomcat../bin/
./shutdown.sh
./startup.sh

