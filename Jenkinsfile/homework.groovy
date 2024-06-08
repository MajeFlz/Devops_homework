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
                    sh 'docker run --rm -v $PWD:/app -w /app docker:latest docker build -t my-image.'
                    sh 'docker run --rm -v $PWD:/app -w /app docker:latest docker-compose up -d'
                }
            }
        }
    }
}
