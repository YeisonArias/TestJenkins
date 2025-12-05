pipeline {
    agent any

    environment {
        PATH = "C:\\Program Files\\Git\\bin;${env.PATH}"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/TU_USUARIO/TU_REPOSITORIO.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean verify -DskipTests=false'
            }
        }

        stage('Backup Evidencias') {
            steps {
                script {
                    echo "Iniciando backup de evidencias..."

                    // Ruta de la carpeta generada por Serenity
                    def sourceFolder = "C:\\Users\\yf_ar\\.jenkins\\workspace\\Pipeline Serenity\\target\\site\\serenity"

                    // Nombre del backup basado en fecha y hora
                    def timestamp = new Date().format("yyyyMMddHHmm")
                    def backupFolder = "serenity_${timestamp}"

                    echo "Validando existencia de carpeta: ${sourceFolder}"

                    // 🔥 Corrección final: usar IF EXIST para evitar error
                    bat """
                    IF EXIST "${sourceFolder}" (
                        echo Carpeta encontrada, se procede a renombrar...
                        rename "${sourceFolder}" "${backupFolder}"
                        echo Backup finalizado exitosamente
                    ) ELSE (
                        echo La carpeta de evidencias NO existe. No se puede realizar el backup.
                        exit 1
                    )
                    """
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline finalizado correctamente."
        }
        failure {
            echo "El pipeline terminó con errores."
        }
    }
}
