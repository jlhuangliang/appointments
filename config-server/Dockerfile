FROM java:8
VOLUME /tmp

ADD build/libs/repo-server-*.jar /work/app.jar
ADD run.sh /

ENTRYPOINT ["/run.sh"]
