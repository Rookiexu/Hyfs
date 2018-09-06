pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
                sshPublisher(publishers: [sshPublisherDesc(configName: 'cloud', transfers: [sshTransfer(excludes: '', execCommand: '/docker/server/mvfile.sh', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/docker/server', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'target/classes/**')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
    }
}