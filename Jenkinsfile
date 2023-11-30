pipeline {
    agent any
    environment {
        LOCATION = 'us-east-1c'
        DOCKERHUB_PASS = 'AJ@gmu-2024'
    }

    stages {
        stage("Checkout code") {
            steps {
                checkout scm
            }
        }
        stage("Building the Student Survey Image") {
            steps {
                script {
                    echo 'Creating the Jar..'
                    sh 'rm -rf *.jar'
                    sh 'mvn clean package'
                }
            }
        }
        stage("Docker image building"){
            steps{
                script{
                    sh 'echo ${BUILD_TIMESTAMP}'
                    sh 'echo $DOCKERHUB_PASS | docker login -u ajagadis --password-stdin'
                    sh 'docker build -t ajagadis/645_survey .'
                }
            }
        }
        stage("Pushing image to docker") {
            steps {
                script {
                    sh 'docker push ajagadis/645_survey:new'
                }
            }
        }
        stage("Deploying to rancher") {
            steps {
                script {
                    sh 'kubectl rollout restart deploy swe-backend'
                }
            }
        }
    }
}
