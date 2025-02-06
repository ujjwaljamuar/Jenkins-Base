def gv

pipeline {
    agent any

    environment {
        GITHUB_CREDS = credentials('github-credentials')
    }

    parameters {
        string(name: 'version', defaultValue: 'lts', description: 'version for each deployment')
        choice(name: 'env', choices: ['dev', 'uat', 'pd'], description: 'environment for deployment')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'want to run tests or not')
    }

    // tools {
    //     maven 'Maven'
    //     gradle 'Gradle'
    //     jdk 'JDK'
    // }

    stages {
        // stage("creds") {
        //     steps {
        //         echo "creds"
        //         sh "echo $GITHUB_CREDS"
        //         withCredentials([
        //             usernamePassword(credentials: 'github-credentials', usernameVariable: USER, passwordVariable: PWD) 
        //         ]) {
        //              sh "username: ${USER} \npassword: ${PWD}"
        //         }
        //     }
        // }

        stage("Init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("Build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }

        stage("Test") {
            when {
                expression {
                    params.executeTests
                }
            }

            steps {
                echo 'Running Tests ...'
            }
        }

        stage("Deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}