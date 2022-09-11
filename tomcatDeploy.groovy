def call(ips,user,credId){
  sshagent([credId]) {
    ips.each {
      echo "deploying on ${it}"
      sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${it}:/opt/tomcat9/webapps/app.war"
      sh "ssh ${user}@${it} /opt/tomcat9/bin/shutdown.sh"
      sh "ssh ${user}@${it} /opt/tomcat9/bin/startup.sh"
    }
   }
}
