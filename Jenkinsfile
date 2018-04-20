node {

  stage('Configure') {
    env.JAVA_HOME="${tool 'jdk8'}"
    env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"
    sh 'java -version'
  }

  stage('Checkout') {
    checkout scm
  }

  stage('Build') {
    def mvnHome = tool 'Maven-3.5.0'
    sh "${mvnHome}/bin/mvn clean install sonar:sonar -U -Pqa"
  }

  stage('Result') {
    junit '**/target/surefire-reports/TEST*.xml, **/target/failsafe-reports/TEST*.xml'
    jacoco classPattern: '**/target/classes', execPattern: '**/target/coverage-reports/jacoco**.exec', sourcePattern: '**/src/main/java'
    checkstyle canComputeNew: false, defaultEncoding: '', healthy: '', pattern: '', unHealthy: ''
    findbugs canComputeNew: false, defaultEncoding: '', excludePattern: '', healthy: '', includePattern: '', isRankActivated: true, pattern: '', unHealthy: ''
    openTasks canComputeNew: false, defaultEncoding: '', excludePattern: '', healthy: '', high: 'FIXME', ignoreCase: true, low: '', normal: 'TODO', pattern: 'src/main/java/**/*.java, src/test/java/**/*.java', unHealthy: ''
  }

  stage('Archive') {
    archiveArtifacts 'target/tutorials*.jar, target/tutorials*project.zip'
  }

}
