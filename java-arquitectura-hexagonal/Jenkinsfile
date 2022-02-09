@Library('ceiba-jenkins-library') _
pipeline{

    agent {
        label 'Slave_Induccion'
    }


    options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
    }

    tools {
        jdk 'JDK8_Centos'
    }

    stages{
        stage('Checkout') {
            steps {
                echo '------------>Checkout desde Git Microservicio<------------'
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    gitTool: 'Default' ,
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: 'GitHub_AndresEduVillamizar',
                        url: 'https://github.com/AndresEduVillamizar/ADNMensajeria/tree/master/java-arquitectura-hexagonal']]])
                }
        }
        stage('Compilacion y Test Unitarios'){
            steps {
                echo '------------>Test Backend<------------'
                sh 'chmod +x ./microservicio/gradlew'
                sh './microservicio/gradlew --b ./microservicio/build.gradle clean'
                sh './microservicio/gradlew --b ./microservicio/build.gradle test'
            }
        }

		stage('Static Code Analysis') {
			steps{
				sonarqubeMasQualityGatesP(sonarKey:'co.com.ceiba.adn:adnmensajeria.envio-eduardo.villamizar',
				sonarName:'CeibaADN-ADNMensajeria(eduardo.villamizar)',
				sonarPathProperties:'./sonar-project.properties')
			}
		}

        stage('Build'){
            steps{
                echo "------------>Compilación backend<------------"
                    sh 'chmod +x ./microservicio/gradlew'
                    sh './microservicio/gradlew --b ./microservicio/build.gradle clean'
                    sh './microservicio/gradlew --b ./microservicio/build.gradle build -x test'
                }
            }
        }

    post {
        failure {
            echo 'This will run only if failed'
            mail(
                to: 'eduardo.villamizar@ceiba.com.co',
                body:"Something is wrong with ${env.BUILD_URL}",
                subject: "Failed Pipeline:${currentBuild.fullDisplayName}"
            )
        }
        success {
            echo 'This will run only if successful'
        }
    }
}