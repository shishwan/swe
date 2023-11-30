pipeline {
    agent any
    environment {
        PROJECT_ID = 'rancher'
        CLUSTER_NAME = 'rancher'
        LOCATION = 'us-east-1a'
        DOCKERHUB_PASS = 'AJ@gmu-2024'
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
                        sh 'mvn clean install'
                    }
                }
                echo 'Building the Docker Image ...'
                sh "docker login -u ajagadis -p ${DOCKERHUB_PASS}"
                sh 'docker build -t 645_survey .'
                sh 'docker push 645_survey'
            }
        }
        stage("Update Deployment") {
            steps {
                sh 'kubectl rollout restart deploy deploy'
            }
        }
    }
}
