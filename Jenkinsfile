pipeline {
   agent any
   
   environment {
       gitAddr="ssh://git@192.168.1.102:2345/root/hellspringboot.git"
       SCRIPT_PATH="/opt/cicd/scripts"
   }
   stages {
      stage("获取代码") {
         steps {
            echo "BRANCH ${BRANCH}"
            echo "start fetch code from $gitAddr"
            deleteDir()
            git "$gitAddr" 
         }
      }
      
       stage("编译打包") {
         steps {
            echo "begin clean and package"
            sh "mvn clean package -Dmaven.test.skip=true"
         }
      }

   }
}