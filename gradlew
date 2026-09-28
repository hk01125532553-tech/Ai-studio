#!/bin/sh
#
# Lightweight Gradle wrapper for GitHub Actions.
# Default Gradle version: 8.7
# You can override it with: GRADLE_VERSION=8.8 ./gradlew ...
#

set -e

GRADLE_VERSION="${GRADLE_VERSION:-8.7}"
GRADLE_HOME="${GRADLE_USER_HOME:-$HOME/.gradle}/wrapper/dists/gradle-$GRADLE_VERSION"
DIST_DIR="$GRADLE_HOME/gradle-$GRADLE_VERSION"
ZIP="$GRADLE_HOME/gradle-$GRADLE_VERSION-bin.zip"
URL="https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-bin.zip"

if [ ! -x "$DIST_DIR/bin/gradle" ]; then
    mkdir -p "$GRADLE_HOME"
    if [ ! -f "$ZIP" ]; then
        echo "Downloading Gradle $GRADLE_VERSION..."
        if command -v curl >/dev/null 2>&1; then
            curl -fL --retry 3 -o "$ZIP" "$URL"
        elif command -v wget >/dev/null 2>&1; then
            wget -O "$ZIP" "$URL"
        else
            echo "Error: curl or wget is required." >&2
            exit 1
        fi
    fi

    rm -rf "$DIST_DIR"
    if command -v unzip >/dev/null 2>&1; then
        unzip -q "$ZIP" -d "$GRADLE_HOME"
    else
        echo "Error: unzip is required." >&2
        exit 1
    fi
fi

exec "$DIST_DIR/bin/gradle" "$@"
