pipeline {
    agent any
    tools { 
        maven 'Maven 3.5.2' 
        jdk 'jdk8' 
    }
    stages {
        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
              sh 'mvn clean'
              sh 'mvn site'
              sh 'mvn sonar:sonar'
            }
        }
    }
}
