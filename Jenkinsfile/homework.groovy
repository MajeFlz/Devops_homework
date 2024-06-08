pipeline {
    agent any

    stages {
        stage('Информация о дисках') {
            steps {
                sh 'df -h --output=source,fstype,size,used,avail,pcent,targets'
            }
        }
    }
}
