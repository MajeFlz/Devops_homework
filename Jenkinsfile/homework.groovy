pipeline {
    agent any

    stages {
        stage('Информация о дисках') {
            steps {
                sh 'df -h --output=size'
            }
        }
        stage('Докер') {
            steps {
                dir('../docker') {
                    dockerBuild('my-image', '.')
                    sh 'docker-compose up -d'
                }
            }
        }
    }
}
