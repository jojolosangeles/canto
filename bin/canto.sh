#!/bin/bash -e
#
# Execute a Canto script
# 


run()
{
    exec "${RUN_CMD[@]}"
    return $?
}


#####################################################
# Try to find CANTO_HOME if not already set
#####################################################

CANTO_JAR_PATH="./lib/canto.jar"
if [ -z $CANTO_HOME ]
then
    if [ -f "$CANTO_JAR_PATH" ]
    then
        CANTO_HOME=$(pwd)

    elif [ -f "../$CANTO_JAR_PATH" ]
    then
        CANTO_HOME=$(pwd)/..

    elif [ -n $SERVICE_NAME ] && [ -f "/opt/$SERVICE_NAME/$CANTO_JAR_PATH" ]
    then
        CANTO_HOME="/opt/$SERVICE_NAME"

    elif [ -f "/opt/canto/$CANTO_JAR_PATH" ]
    then
        CANTO_HOME="/opt/canto"

    elif [ -f "/usr/share/canto/$CANTO_JAR_PATH" ]
    then
        CANTO_HOME="/usr/share/canto"

    elif [ -f "$HOME/canto/$CANTO_JAR_PATH" ]
    then
        CANTO_HOME="$HOME/canto"

    else
      echo "ERROR: CANTO_HOME not set and Canto not installed in a standard location"
      exit 1
    fi
fi

cd "$CANTO_HOME"
CANTO_HOME=$PWD

echo "CANTO_HOME is $CANTO_HOME"

#####################################################
# Set the classpath
#####################################################
for jar_file in $CANTO_HOME/lib/*.jar; do
    if [ -z $CLASSPATH ]
    then
        CLASSPATH="$jar_file"
    else
        CLASSPATH="$CLASSPATH:$jar_file"
    fi
done    


#####################################################
# Setup JAVA if unset
#####################################################
if [ -z "$JAVA" ]
then
    JAVA=$(which java)
fi

if [ -z "$JAVA" ]
then
    echo "Cannot find Java." >&2
    exit 1
fi


RUN_ARGS=(${JAVA_OPTIONS[@]} -cp ${CLASSPATH} canto.runtime.CantoScript "$@")
RUN_CMD=("$JAVA" ${RUN_ARGS[@]})

run

exit $?
