ipeline {
    agent any
    stages {
        stage('SCM') {
            steps {
                git 'https://github.com/Pradnyadevops0112/studentapp.ui.git'
                echo "Pull successful"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
                echo "Build successful"
            }
        }
        stage('Test') {
            steps {
                withSonarQubeEnv( installationName: 'Sonarqube',credentialsId: 'jenkins-sonar') {
                sh "mvn sonar:sonar"
                echo "Test successful"
                }
            }
        }
        stage('Deploy') {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'tomcat-password', path: '', url: 'http://52.66.203.148:8080/')], contextPath: '/', war: '**/*.war'
                echo "deployment successful"
                }
            }
        }
        
    }
