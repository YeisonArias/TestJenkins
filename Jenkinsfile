import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()

pipeline {
    agent any

    stages {

        stage('Actualizar fuentes Nodo Windows') {
            steps {
                git url: 'https://github.com/YeisonArias/TestJenkins.git',
                    branch: 'main'
            }
        }

        stage('Test_GUI_Junit') {
            steps {
                script {
                    try {
                        echo "Ejecutando Runner: ${RUNNER}"

                        // Ejecutar Serenity + JUnit4 usando gradlew
                        bat """
                            .\\gradlew clean test aggregate -Dtest.single=${RUNNER}
                        """

                        echo 'Ejecución de pruebas completada sin fallos'
                    } catch (ex) {
                        echo 'La ejecución del framework JUnit finalizó con fallos'
                        error('Failed')
                    }
                }
            }
        }

        stage('BackupEvidencias') {
            steps {
                script {
                    try {
                        echo "Realizando backup de evidencias con timestamp: ${timestamp}"

                        bat """
                            rename "${WORKSPACE}\\target\\site\\serenity" "serenity_${timestamp}"
                        """

                        bat ".\\gradlew clean"

                        echo 'Backup de evidencias realizado con éxito'
                    } catch (ex) {
                        echo 'Backup de evidencias finalizado con fallos'
                        error('Failed')
                    }
                }
            }
        }

    } // fin stages
}
