def call(String appName , String credId){
    withCredentials([usernamePassword(
                    credentialsId : "${credId}",
                    passwordVariable : "dockhubpass",
                    usernameVariable : "dockhubuser"
                    )]){
                        sh "docker login -u ${env.dockhubuser} -p ${env.dockhubpass}"
                        sh "docker image tag "${appName}" ${env.dockhubuser}/"${appName}""
                        sh "docker push ${env.dockhubuser}/"${appName}"
                    }
}