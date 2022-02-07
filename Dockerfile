FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./build/libs/pokesearch-0.0.1-SNAPSHOT.jar pokesearch.jar
ENTRYPOINT ["java","-jar","/pokesearch.jar"]