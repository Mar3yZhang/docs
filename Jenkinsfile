pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        // Building Docker images
        stage('K8s') {
            steps {
                sh 'minikube image load marsy298/teedyjenkins'
                sh 'kubectl create deployment hello-node --image=marsy298/teedyjenkins'
                // sh 'kubectl set image deployments/hello-node teedy-lab13=marsy298/teedyjenkins'
                sh 'kubectl expose deployment hello-node --type=LoadBalancer --port=8080'
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
