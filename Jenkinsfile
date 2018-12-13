pipeline {
    agent any

    stages {
        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
              sh 'mvn clean'
              sh 'mvn sonar:sonar'
            }
        }
    }
}
