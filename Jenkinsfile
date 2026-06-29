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
                // Spin up the official Playwright container manually, mount the workspace, and run tests
                sh '''
                    docker run --rm \
                    -u root \
                    -v "${WORKSPACE}":/usr/src/app \
                    -w /usr/src/app \
                    mcr.microsoft.com/playwright/java:v1.45.0-jammy \
                    mvn test -q
                '''
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