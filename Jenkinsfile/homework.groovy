pipeline {
    agent any

    stages {
        stage('Информация о дисках') {
            steps {
                git url: 'https://github.com/MajeFlz/jenkins_homework', credentialsId: 'belous_github'
                sh 'df -h --output=source,fstype,size,used,avail,pcent,targets'
            }
        }
    }
}
