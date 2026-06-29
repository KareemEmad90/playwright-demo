pipeline {
    agent any

    tools {
        // Name must match a JDK 21 installation configured in
        // Manage Jenkins → Tools → JDK installations
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
            steps {
                // 1. Install the host system dependencies required by Playwright browsers
                sh 'mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install-deps"'

                // 2. Run your tests
                sh 'mvn test -q'
            }
            post {
                always {
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