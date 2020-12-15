all: clean stop deploy start
	echo "Done."

deploy:
	mvn package
	rm -fr ~/workspace/tomcat/webapps/Escalade/logs/* ~/workspace/tomcat/webapps/Escalade ~/workspace/tomcat/webapps/Escalade.war
	cp target/escalade-*.war ~/workspace/tomcat/webapps/Escalade.war

start:
	~/workspace/tomcat/bin/catalina.sh start

stop:
	~/workspace/tomcat/bin/catalina.sh stop

clean:
	mvn clean