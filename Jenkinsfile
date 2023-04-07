pipeline {
    agent any
    environment {
        DOCKER_PASSWORD = credentials("docker_password")
        MAJOR_VERSION = 0
        MINOR_VERSION = 0
        PATCH_VERSION = 0
    }

    stages {
        stage('Build & Test') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Tag image') {
              steps {
                script {
                    GIT_TAG = sh([script: 'git fetch --tag && git tag', returnStdout: true]).trim()
                    MAJOR_VERSION = sh([script: 'git tag | cut -d . -f 1', returnStdout: true]).trim()
                    MINOR_VERSION = sh([script: 'git tag | cut -d . -f 2', returnStdout: true]).trim()
                    PATCH_VERSION = sh([script: 'git tag | cut -d . -f 3', returnStdout: true]).trim()
                }
                sh "docker build -t $DOCKER_PASSWORD_USR/hello-img:${MAJOR_VERSION}.\$((${MINOR_VERSION} + 1)).${PATCH_VERSION} ."
                sh "docker login docker.io -u $DOCKER_PASSWORD_USR -p $DOCKER_PASSWORD_PSW "
                sh "docker push $DOCKER_PASSWORD_USR/hello-img:${MAJOR_VERSION}.\$((${MINOR_VERSION} + 1)).${PATCH_VERSION} "
              }
        }
    }
}
