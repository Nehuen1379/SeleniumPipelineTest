pipeline {
    agent any

    tools {
        maven 'Maven 3.8.8'  // Usa el nombre que le diste en Jenkins
        jdk 'JDK 21'         // O el JDK que estés usando
    }

    stages {
        stage('Clonar repositorio') {
            steps {
                git url: 'https://github.com/Nehuen1379/SeleniumPipelineTest', branch: 'main'
            }
        }

        stage('Instalar dependencias y compilar') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Ejecutar pruebas') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publicar reporte') {
            steps {
                publishHTML(target: [
                        reportDir: 'target/cucumber-reports',
                        reportFiles: 'index.html',
                        reportName: 'Reporte de Pruebas Automatizadas'
                ])
            }
        }
    }
}
