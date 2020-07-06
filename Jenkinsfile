@Library('forge-shared-library')_

pipeline {
    agent {
        docker { image 'openjdk:8-jdk' }
    }
    environment {
        DISCORD_PREFIX = "Magma: ${BRANCH_NAME} #${BUILD_NUMBER}"
        CHANGES = getChanges(currentBuild)
        ARTIFACT = " https://ci.hexeption.dev/job/Magma%20Foundation/job/Magma-1.15.x/job/1.15.x/${currentBuild.id}/artifact/projects/magma/build/libs/forge-1.15.2-31.2.23-${GIT_COMMIT[0..7]}-installer.jar"
    }
    stages {
        stage('Setup') {
            steps {
                withCredentials([string(credentialsId: 'DISCORD_WEBHOOK', variable: 'discordWebhook')]) {
                    discordSend(
                            title: "${DISCORD_PREFIX} Started",
                            successful: true,
                            link: env.BUILD_URL,
                            result: 'ABORTED', //White border
                            thumbnail: "https://i.imgur.com/NqnOifl.png",
                            webhookURL: "${discordWebhook}"
                    )
                }
                sh 'chmod +x gradlew'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew setup installerJar --console=plain'
            }
        }
    }
    post {
        always {
            script {
                archiveArtifacts artifacts: 'projects/magma/build/libs/*-installer.jar', fingerprint: true, onlyIfSuccessful: true, allowEmptyArchive: true
                withCredentials([string(credentialsId: 'DISCORD_WEBHOOK', variable: 'discordWebhook')]) {
                   discordSend(
                           title: "Finished ${DISCORD_PREFIX} ${currentBuild.currentResult}",
                           description: "**Build:** [${currentBuild.id}](${env.BUILD_URL})\n**Status:** [${currentBuild.currentResult}](${env.BUILD_URL})\n\n**Changes:**\n```$CHANGES```\n**Artifacts:**\n - $ARTIFACT",
                           successful: currentBuild.resultIsBetterOrEqualTo("SUCCESS"),
                           result: currentBuild.currentResult,
                           link: env.BUILD_URL,
                           thumbnail: "https://i.imgur.com/NqnOifl.png",
                           webhookURL: "${discordWebhook}"
                   )
                }
                cleanWs()
            }
        }
    }
}

