pipeline {
    agent any

    parameters {
        string(name: 'CUCUMBER_TAGS', defaultValue: '@smoke', description: 'Tags de Cucumber a ejecutar (ej: @login, @regression and not @wip)')
    }

    tools {
        maven 'Maven 3.8.8'  // Usa el nombre que le diste en Jenkins
        jdk 'JDK 21'         // O el JDK que estés usando
    }

    environment {
        MAVEN_OPTS = "-Xmx1024m"
    }

    stages {
        stage('Compilar') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Ejecutar tests') {
            steps {
                bat "mvn test -Dcucumber.filter.tags=\"${params.CUCUMBER_TAGS}\""
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*.*', fingerprint: true
            junit 'target/surefire-reports/*.xml'
        }
    }
}
