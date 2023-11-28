pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/jglick/simple-maven-project-with-tests.git'



                // To run Maven on a Windows agent, use
                bat "mvn clean test -Dfile=.\XMLs\BasicTest.xml"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
                always {
                            allure jdk: '', results: [[path: 'target/allure-results']]

                            archiveArtifacts(artifacts: '**/screenshots/*.png', allowEmptyArchive: true, caseSensitive: false)
                        }

                        success {
                            echo "SUCCESS"
                            emailext to:'khoi.nguyen@winmagic.com',
                            subject: env.JOB_NAME,
                            body: '''${SCRIPT, template="managed:Allure Groovy Email Template"}'''
                        }

                        unstable {
                            echo "UNSTABLE"
                            emailext to:'khoi.nguyen@winmagic.com',
                            subject: env.JOB_NAME,
                            body: '''${SCRIPT, template="managed:Allure Groovy Email Template"}'''
                        }

                        failure {
                            echo "FAILURE"
                            emailext to:'khoi.nguyen@winmagic.com',
                            subject: env.JOB_NAME,
                            body: '''${SCRIPT, template="managed:Allure Groovy Email Template"}'''
                        }
            }
        }
    }
}
