pipeline {
    agent none

    stages {
        stage('build_test') {
            steps {
                echo 'jenkins sample build ! %{AUTHOR}'
            }
        }
    }

    post {
        always {
            echo 'post process !'
        }
    }

}

