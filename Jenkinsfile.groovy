    pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }

    stages {
        stage('CheckOut') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/inasribrahim/automatedSearchEngine.git'

                // Run Maven 
                bat("mvn test -PtestngCucumber.xml")
                
        
            }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
