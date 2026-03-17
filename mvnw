#!/bin/sh
# Maven Wrapper script
set -e
MAVEN_PROJECTBASEDIR="${MAVEN_BASEDIR:-$(cd "$(dirname "$0")" && pwd)}"
MAVEN_WRAPPER_JAR="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar"
MAVEN_WRAPPER_PROPERTIES="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.properties"

if [ -r "$MAVEN_WRAPPER_PROPERTIES" ]; then
    MAVEN_URL=$(grep 'distributionUrl' "$MAVEN_WRAPPER_PROPERTIES" | cut -d'=' -f2-)
fi

MAVEN_HOME="$HOME/.m2/wrapper/dists/$(basename "$MAVEN_URL" .zip)"
if [ ! -d "$MAVEN_HOME" ]; then
    echo "Downloading Maven..."
    mkdir -p "$MAVEN_HOME"
    TMP_FILE=$(mktemp)
    curl -sL "$MAVEN_URL" -o "$TMP_FILE"
    unzip -q "$TMP_FILE" -d "$MAVEN_HOME"
    rm "$TMP_FILE"
fi

MAVEN_BIN=$(find "$MAVEN_HOME" -name mvn -type f | head -1)
exec "$MAVEN_BIN" "$@"
