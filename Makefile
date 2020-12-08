all:
	mvn clean package
	~/workspace/tomcat/bin/catalina.sh stop
	rm -fr /~/workspace/tomcat/webapps/Escalade ~/workspace/tomcat/webapps/Escalade.war
	cp target/escalade-*.war ~/workspace/tomcat/webapps/Escalade.war
	~/workspace/tomcat/bin/catalina.sh start

restart:
	~/workspace/tomcat/bin/catalina.sh stop
	~/workspace/tomcat/bin/catalina.sh start

start:
	~/workspace/tomcat/bin/catalina.sh start

stop:
	~/workspace/tomcat/bin/catalina.sh stop

clean:
	mvn clean