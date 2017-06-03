#! /bin/sh -e
# $1 profile, wave3_dev

if [ -n "$1" ]; then
    profile=$1
else
    if [ -f "profile" ]; then
    	profile=$(more profile)
    fi
fi

if [ -n "${profile}" ]; then
    runParam=${runParam}' --spring.profiles.active='${profile}
fi

if [ -n "${2}" ]; then
    runParam=${runParam}' --server.port='${2}
fi

if [ -n "${3}" ]; then
    jarFileName=${3}
fi

java -Dpinpoint.agentId=configuration-ser -Dpinpoint.applicationName=configuration-service -javaagent:/data/pinpoint-agent-1.5.2/pinpoint-bootstrap-1.5.2.jar -Djava.security.egd=file:/dev/./urandom -jar ${jarFileName} ${runParam} 1>> log.log 2>&1&
echo $! > pidFile