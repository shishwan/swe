pipeline {
    agent any

    environment {
        PROJECT_ID = 'rancher'
        CLUSTER_NAME = 'rancher'
        LOCATION = 'us-east-1a'
        DOCKERHUB_PASS = 'AJ@gmu-2024'
        MAVEN_HOME = '/usr/share/maven'
    }

    stages {
        stage("Checkout code") {
            steps {
                checkout scm
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                echo 'Building the Docker Image ...'
                script {
                    docker.image('maven:3.8.4').inside('-u root') {
                        // Install Maven in the container
                        sh 'apt-get update && apt-get install -y maven'

                        // Build the Maven project
                        sh 'mvn clean install'
                    }
                }

                // Docker login, build, and push steps
                echo 'Building the Docker Image ...'
                sh "docker login -u ajagadis -p ${DOCKERHUB_PASS}"
                sh 'docker build -t 645_survey .'
                sh 'docker push 645_survey'
            }
        }

        stage("Update Deployment") {
            steps {
                // Assuming Kubernetes is installed on Jenkins agent
                sh 'kubectl rollout restart deploy deploy'
            }
        }
    }
}
