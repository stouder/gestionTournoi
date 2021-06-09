pipeline {
  agent any
  stages {
    stage('git') {
      steps {
        sh 'sh \'mvn clean install\''
      }
    }

  }
}