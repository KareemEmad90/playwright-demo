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

    environment {
        DOCKER_HUB_USER = 'mba90'
        IMAGE_NAME      = 'crm-customer'
        IMAGE_TAG       = "${BUILD_NUMBER}"
        DOCKER_CREDENTIALS_ID = 'docker-hub-credentials'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                // Running without -q so you can see your API test output logs
                sh 'mvn test'
            }
            post {
                always {
                    // This will now successfully find the reports once the tests run
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