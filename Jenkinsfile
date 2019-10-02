node('master') {


	def mvn = '/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/mvn_3.62/bin/mvn'
	
	def seleniumUrl = 'http://172.17.0.3:4444/wd/hub'

	
stage('checkout') {

		checkout([$class: 'GitSCM', branches: [[name: '*/comautomationpractice']], browser: [$class: 'GithubWeb', repoUrl: ''], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github-ssh', url: 'git@github.com:serhii-zaitsev/comautomationpractice.git']]])
    }
	
stage('Cross-browser testing') {
		parallel "Chrome": {
			def buildDir = 'target-chrome'
			sh "${mvn} clean test -Dtest=**/LoginTest.java -Dbrowser=Chrome -Dselenium.url=${seleniumUrl} -DbuildDirectory=${buildDir} -Dmaven.test.failure.ignore=true"
			junit "${buildDir}/surefire-reports/*.xml"
		}, "Firefox": {
			def buildDir = 'target-firefox'
			sh "${mvn} clean test -Dtest=**/LoginTest.java -Dbrowser=Firefox -Dselenium.url=${seleniumUrl} -DbuildDirectory=${buildDir} -Dmaven.test.failure.ignore=true"
			junit "${buildDir}/surefire-reports/*.xml"
		}
	}
}