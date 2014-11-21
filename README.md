[![License](http://img.shields.io/badge/license-Apache-brightgreen.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

# EWERK Gradle Plugins
## Introduction
This repository was introduced in order to use the Github/Bintray/Gradle Plugin Portal
capabilities for publishing open source Gradle plugins and using them with the new plugin
declaration syntax introduced in Gradle 2.1.

The plugins are released using the [gradle-plugindev-plugin](https://github.com/etiennestuder/gradle-plugindev-plugin/blob/master/README.md).

The plugins can also be downloaded from [bintray](http://www.bintray.com) as long as they are not
available through the gradle plugin portal.

## Plugins
### Integration test plugin

[ ![Download](https://api.bintray.com/packages/holgerstolzenberg/gradle-plugins/integration-test-plugin/images/download.svg) ](https://bintray.com/holgerstolzenberg/gradle-plugins/integration-test-plugin/_latestVersion)

The plugin can be used to execute integration tests from a sophisticated sourceSet. Just place
your integration tests and resources under `src/integration/java` and `src/integration/resources`
and run task `integrationTest`.

The plugin was inspired by the sources taken from [here](http://blog.lick-me.org/2014/07/fun-with-gradle-plugins-integration-tests/).

__Example__

A full example will be provided after the plugin has been published to the 
[Gradle Plugin Portal](http://plugins.gradle.org).