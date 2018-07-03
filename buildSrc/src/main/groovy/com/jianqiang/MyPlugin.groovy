package com.jianqiang

import org.gradle.api.Plugin
import org.gradle.api.Project

public class MyPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create('pluginSrc', MyExtension)

        project.task('testPlugin') << {
            println project.pluginSrc.message
        }

        project.afterEvaluate() {
            def preBuild = project.tasks['preBuild']
            preBuild.doFirst {
                println 'hookPreReleaseBuild'
            }
            preBuild.doLast {
                println 'hookPreReleaseBuild2'
            }
        }
    }
}