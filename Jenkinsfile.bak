pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        // Building Docker images
        stage('Building image') {
            steps {
                sh 'docker build -t marsy298/teedyjenkins .'
            }
        }
        // Uploading Docker images into Docker Hub
        stage('Upload image') {
            steps {
                sh 'docker image push marsy298/teedyjenkins'
            }
        }
        //Running Docker container
        stage('Run containers') {
            steps {
                script {
                    sh 'docker pull marsy298/teedyjenkins:latest'
                    sh 'docker run -d -p 8084:8080 --name teedyjenkins01 marsy298/teedyjenkins'
                    sh 'docker run -d -p 8082:8080 --name teedyjenkins02 marsy298/teedyjenkins'
                    sh 'docker run -d -p 8083:8080 --name teedyjenkins03 marsy298/teedyjenkins'
                }
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/target/site/**', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
        }
    }
}
