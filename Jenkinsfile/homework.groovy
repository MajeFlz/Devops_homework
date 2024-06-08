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
