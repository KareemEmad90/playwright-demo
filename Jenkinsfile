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
        
        // Tells Playwright to completely skip host dependency verification checks
        PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD = '0'
        PLAYWRIGHT_SKIP_VALIDATE_HOST_REQUIREMENTS = 'true'
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
                // Run Maven test directly with a fallback/headless argument pattern
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