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

    environment {
            // ⚠️ CHANGE THIS to your actual Docker Hub username
            DOCKER_HUB_USER = 'mba90'
            IMAGE_NAME      = 'crm-customer'
            IMAGE_TAG       = "${BUILD_NUMBER}"

            // This matches the ID you just created in the credentials store
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