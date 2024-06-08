pipeline {
    agent any

    stages {
        stage('Информация о дисках') {
            steps {
                sh 'df -h'
            }
        }
        stage('Build') {
            steps {
                sh 'apt-get update && sudo apt-get install -y maven' // Install Maven on the agent
                sh 'mvn clean package'
            }
        }
        stage('Performance') {
            steps {
                plot {
                    title 'Performance'
                    xaxis {
                        label 'Time'
                    }
                    yaxis {
                        label 'Response Time'
                    }
                    series {
                        file 'performance-data.csv'
                    }
                }
            }
        }
    }
}
