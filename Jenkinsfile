pipeline {
    agent any

    tools {
        jdk 'jdk-21'
        maven 'maven-3.9'
    }

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 30, unit: 'MINUTES')
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests -q'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/playwright*.jar', fingerprint: true
                }
            }
        }

        stage('Test') {
            // Tell Jenkins to run ONLY this stage inside the official Playwright container
            agent {
                docker {
                    image 'mcr.microsoft.com/playwright/java:v1.45.0-jammy'
                    args '-u root --entrypoint='
                }
            }
            steps {
                // No need for install-deps anymore! The image already has them.
                sh 'mvn test -q'
            }
            post {
                always {
                    // This will execute safely back on the agent host
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}