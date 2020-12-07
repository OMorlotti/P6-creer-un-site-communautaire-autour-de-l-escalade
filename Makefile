all:
	mvn clean package
	/Users/omorlotti/workspace/tomcat/bin/catalina.sh stop
	rm -fr /Users/omorlotti/workspace/tomcat/webapps/Escalade /Users/omorlotti/workspace/tomcat/webapps/Escalade.war
	cp target/escalade-*.war /Users/omorlotti/workspace/tomcat/webapps/Escalade.war
	/Users/omorlotti/workspace/tomcat/bin/catalina.sh start
