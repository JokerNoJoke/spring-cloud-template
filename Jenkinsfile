pipeline {
    parameters {
        choice(name: 'PROJECT_NAME', choices: ['gateway-template', 'service-template'], description: 'Pick something')
    }
    agent {
        kubernetes {
            yamlFile: 'jenkins-agent.yaml'
        }
    }
    stages {
        // stage('checkout') {
        //     steps {
        //         checkout([
        //             $class: 'GitSCM',
        //             userRemoteConfigs: [[url: 'https://gitee.com/jokerekoj/spring-cloud-template.git']],
        //             branches: [[name: '*/main']],
        //             extensions: []
        //         ])
        //     }
        // }
        stage('build jar') {
            steps {
                dir(env.PROJECT_NAME) {
                    container('maven') {
                        sh 'mvn clean package -DskipTests'
                        sh 'ls -l target'
                        // sh 'MAVEN_PROJECT_NAME=$(mvn help:evaluate -Dexpression=project.name -q -DforceStdout)'
                        // sh 'MAVEN_PROJECT_VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)'
                        script {
                            env.MAVEN_PROJECT_NAME = sh(script: 'mvn help:evaluate -Dexpression=project.name -q -DforceStdout', returnStdout:true)
                            env.MAVEN_PROJECT_VERSION = sh(script: 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout', returnStdout:true)
                        }
                    }
                }
            }
        }
        stage('build image') {
            steps {
                dir(env.PROJECT_NAME) {
                    container('docker') {
                        // 修改 Dockerfile
                        sh 'sed -i "s/{JAR_NAME}/$MAVEN_PROJECT_NAME-$MAVEN_PROJECT_VERSION/" Dockerfile'
                        sh 'docker build -t $MAVEN_PROJECT_NAME:$MAVEN_PROJECT_VERSION .'
                        // 方便测试这里指定个 tag 变量 $BUILD_ID
                        sh 'docker tag $MAVEN_PROJECT_NAME:$MAVEN_PROJECT_VERSION 10.0.0.1:5000/$MAVEN_PROJECT_NAME:$MAVEN_PROJECT_VERSION-$BUILD_ID'
                        sh 'docker push 10.0.0.1:5000/$MAVEN_PROJECT_NAME:$MAVEN_PROJECT_VERSION-$BUILD_ID'
                    }
                }
            }
        }
        stage('deplay') {
            steps {
                dir(env.PROJECT_NAME) {
                    container('kubernetes') {
                        // 修改 k8s.yaml
                        sh 'sed -i "s#{IMAGE}#10.0.0.1:5000/$MAVEN_PROJECT_NAME:$MAVEN_PROJECT_VERSION-$BUILD_ID#" k8s.yaml'
                        sh 'kubectl -n apps apply -f k8s.yaml'
                    }
                }
            }
        }
    }
}