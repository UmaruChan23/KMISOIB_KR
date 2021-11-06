FROM openjdk:15-alpine

COPY ./kr.kmisoib-0.0.1-SNAPSHOT.jar /opt/kr.jar

ENV PORT 5000

EXPOSE $PORT

CMD java -Dserver.port=${PORT} -Xmx2G -jar /opt/diplom.jar