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
                git 'https://github.com/akiraq10/newSES.WEB.git'



                // To run Maven on a Windows agent, use
                bat "mvn clean test -Dfile=.\\XMLs\\BasicTest.xml"
            }

            post {
             always {
            allure jdk: '', results: [[path: 'allure-results']]

            archiveArtifacts(artifacts: '**/TestCaptures/*.png', allowEmptyArchive: true, caseSensitive: false)
        }

        success {
            echo "SUCCESS"
            emailext to:'youremailhere',
            subject: env.JOB_NAME,
            body: '''${SCRIPT, template="managed:groovy-email-template"}''' 
        }

        unstable {
            echo "UNSTABLE"
            emailext to:'youremailhere',
            subject: env.JOB_NAME,
            body: '''${SCRIPT, template="managed:groovy-email-template"}''' 
        }

        failure {
            echo "FAILURE"
            emailext to:'youremailhere',
            subject: env.JOB_NAME,
            body: '''${SCRIPT, template="managed:groovy-email-template"}''' 
        }
                
        }
           
            
    }
}
}
