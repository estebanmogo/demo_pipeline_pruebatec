FROM tomcat:9.0

COPY build/libs/s.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]