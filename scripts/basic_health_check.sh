#!/bin/bash

# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: MIT-0

set -e

CATALINA_HOME='/usr/share/tomcat8'
DEPLOY_TO_ROOT='true'
#CONTEXT_PATH='##CONTEXT_PATH##'
SERVER_HTTP_PORT='80'

TEMP_STAGING_DIR='/tmp/codedeploy-deployment-staging-area'
WAR_STAGED_LOCATION="$TEMP_STAGING_DIR/springboot-test.war"
HTTP_PORT_CONFIG_XSL_LOCATION="$TEMP_STAGING_DIR/configure_http_port.xsl"

# In Tomcat, ROOT.war maps to the server root
if [[ "$DEPLOY_TO_ROOT" = 'true' ]]; then
    CONTEXT_PATH='ROOT'
fi

# Remove unpacked application artifacts
if [[ -f $CATALINA_HOME/webapps/$CONTEXT_PATH.war ]]; then
    rm $CATALINA_HOME/webapps/$CONTEXT_PATH.war
fi
if [[ -d $CATALINA_HOME/webapps/$CONTEXT_PATH ]]; then
    rm -rfv $CATALINA_HOME/webapps/$CONTEXT_PATH
fi

# Copy the WAR file to the webapps directory
#rm -rf $WAR_STAGED_LOCATION
if [[ -d WAR_STAGED_LOCATION ]]; then
    rm -rf $WAR_STAGED_LOCATION
fi
#rm -rf $HTTP_PORT_CONFIG_XSL_LOCATION
if [[ -d $HTTP_PORT_CONFIG_XSL_LOCATION ]]; then
    rm -rf $HTTP_PORT_CONFIG_XSL_LOCATION
fi

cp $WAR_STAGED_LOCATION $CATALINA_HOME/webapps/$CONTEXT_PATH.war

# Configure the Tomcat server HTTP connector
{ which xsltproc; } || { yum install xsltproc; } || { apt-get install xsltproc; }
cp $CATALINA_HOME/conf/server.xml $CATALINA_HOME/conf/server.xml.bak
xsltproc $HTTP_PORT_CONFIG_XSL_LOCATION $CATALINA_HOME/conf/server.xml.bak > $CATALINA_HOME/conf/server.xml

cd /etc/init.d
service tomcat8 start