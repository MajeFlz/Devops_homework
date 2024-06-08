pipeline {
    agent any

    stages {
        stage('Информация о дисках') {
            steps {
                sh 'df -h'
            }
        }
       
        stage('Build and deploy') {
            steps {
                dir('../docker') {
                    sh 'docker build -t my-image.'
                    sh 'docker-compose up -d'
                }
            }
        }
    }
}
