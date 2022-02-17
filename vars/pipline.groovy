#!/usr/bin/env groovy

def call(Map args) {
 pipeline {
    agent any

    stages {
        stage('git') {
            steps {
               git credentialsId: 'git_credentials', url: 'https://github.com/lakshmiKrishnaa/hello-world.git'
            }
        }
        stage('build') {
            steps {
              bat "mvn clean install"
              script{
                    hello.info('Maven clean install is done')
                }
            }
        }
    }
}
}
