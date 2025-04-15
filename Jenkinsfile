pipeline {
    agent any

    parameters {
        string(name: 'CUCUMBER_TAGS', defaultValue: '@smoke', description: 'Tags de Cucumber a ejecutar (ej: @login, @regression and not @wip)')
    }

    tools {
        maven 'Maven_3.9.6' // Ajusta según el nombre que configuraste en Jenkins
        jdk 'JDK_17'         // Ajusta según el JDK configurado
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

        stage('Generar reporte') {
            steps {
                bat 'mvn verify'
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
