##FROM openjdk:19
##FROM adoptopenjdk/openjdk11:ubi
##ARG JAR_FILE=target/*.jar
##ENV BOT_NAME=JRTESTTARASbot
##ENV BOT_TOKEN=7423140104:AAESG1FDbFsaKM2EcNKwBA1YpOQa5Uq7Ccc
##COPY ${JAR_FILE} app.jar
##ENTRYPOINT ["java","bot.username=${BOT_NAME}", "bot.token=${BOT_TOKEN}",  "-jar","/app.jar"]
##ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM openjdk:19
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=JRTESTTARASbotX
ENV BOT_TOKEN=7423140104:AAESG1FDbFsaKM2EcNKwBA1YpOQa5Uq7CccDOCKERFILE
COPY ${JAR_FILE} taras/app.jar
ENTRYPOINT ["java","-jar", "taras/app.jar", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}"]
##ENTRYPOINT ["java","-jar", "taras/app.jar"]
