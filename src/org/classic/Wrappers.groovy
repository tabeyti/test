#!/usr/bin/groovy
/**
 * This script contains a host of methods which wrap/simplify
 * verbose pipeline steps (e.g. withCredentials)
 */

package org.classic

import hudson.model.*
import groovy.transform.Field
import hudson.console.*
import groovy.json.JsonSlurper

/**
 * Executes a provided closure with the specified username/password credentials 
 * loaded in. Loaded credentials are stored under environmental variables 
 * USERNAME and PASSWORD.
 */
def creds(credId, closure) {
  withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: credId,
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {

    closure();
  }
}

/**
 * Executes a provided closure with the specified 'secret' credentials loaded 
 * in as a variable. Loaded credentials are stored under environmental variable
 * SECRET.
 */
def credsSecret(credId, closure) {
  withCredentials([[$class: 'StringBinding', credentialsId: credId, variable: 'SECRET']]) {
    closure()
  }
}