pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/YeisonArias/TestJenkins.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Ejecutando pruebas con Gradle Wrapper (gradlew)..."

                    // Si quieres ejecutar un Runner específico:
                    if (env.RUNNER) {
                        bat "gradlew -Dtest.single=${env.RUNNER} clean test aggregate"
                    } else {
                        // Ejecución estándar sin Runner
                        bat "gradlew clean test aggregate"
                    }
                }
            }
        }

        stage('Backup Evidencias') {
            steps {
                script {

                    def sourceDir = "${WORKSPACE}\\target\\site\\serenity"
                    def timestamp = new Date().format('yyyyMMddHHmm')
                    def backupName = "serenity_${timestamp}"

                    echo "Verificando carpeta de evidencias..."

                    bat """
                    IF EXIST "${sourceDir}" (
                        echo Evidencias encontradas en: ${sourceDir}
                        rename "${sourceDir}" "${backupName}"
                        echo Backup realizado: ${backupName}
                    ) ELSE (
                        echo No existe carpeta de evidencias. No se realiza backup.
                    )
                    """

                    // Limpieza del proyecto
                    bat "gradlew clean"
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline finalizado correctamente."
        }
        failure {
            echo "Pipeline finalizó con errores."
        }
    }
}
