#!/bin/bash

env mvn DgroupId=es.caib.digitalib -DartifactId=* versions:set -DnewVersion=$@  

