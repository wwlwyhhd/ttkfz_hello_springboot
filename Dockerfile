FROM registry.cn-beijing.aliyuncs.com/ttkfz/myjdk:1.8
MAINTAINER ttkfz
ADD ./target/hellspringboot-0.0.1-SNAPSHOT.jar /opt/
EXPOSE 9238
WORKDIR /opt
ENTRYPOINT java  -jar /opt/hellspringboot-0.0.1-SNAPSHOT.jar