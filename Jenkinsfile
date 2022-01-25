import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()

pipeline{
    agent any
    
    stages{
        stage('Actualizar fuentes Nodo Windows') {
            steps{
                git url: 'https://github.com/YeisonArias/TestJenkins.git', credentialsId: 'yfarias@gmail.com', branch: 'master'
            }
        }

        stage('Test_GUI_Junit'){
                steps{
                    script{
                        try{                            
                            bat "gradle -Dtest.single=\"${RUNNER}\" test aggregate"
                            echo 'Ha ejecutado sin fallo hasta test junit'
                        }
                        catch(ex)
                        {    
                            echo 'Finalizo ejecucion de framework junit con fallos'
                            error('Failed')
                        }
                    }
                }
            }           
        stage('BackupEvidencias'){
                steps{
                    script{
                        try{
                            bat "rename ${WORKSPACE}\\target\\site\\serenity serenity_${timestamp}"
                            bat "gradle clean"
                            echo 'Backup de evidencias realizado con exito'
                        }
                        catch(ex)
                        {    
                            echo 'Backup de evidencias realizado con fallos'
                            error('Failed')
                        }
                    }
                }
            }

        }   
}