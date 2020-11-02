<div align="center">
<img src="https://i.imgur.com/zTCTCWG.png" alt="Magma logo" align="middle"></img>

![](https://img.shields.io/badge/Minecraft%20Forge-1.15.2%20--%2031.2.45%209ea3f8f-orange.svg?style=for-the-badge) ![](https://img.shields.io/badge/Status-Unstable-red?style=for-the-badge) [![](https://img.shields.io/jenkins/build?jobUrl=https%3A%2F%2Fci.hexeption.dev%2Fjob%2FMagma%2520Foundation%2Fjob%2FMagma-1.15.x%2Fjob%2F1.15.x%2F&style=for-the-badge)](https://ci.hexeption.dev/job/Magma%20Foundation/job/Magma-1.15.x/job/1.15.x/)
</div>

## About

Magma is the next generation of hybrid minecraft server softwares.

Magma is based on Forge and Paper, meaning it can run both Craftbukkit/Spigot/Paper plugins and Forge mods.

We hope to eliminate all issues with craftbukkit forge servers. In the end, we envision a seamless, low lag Magma experience with support for newer 1.12+ versions of Minecraft.

## Downloads & Install
1. Download and install [Java 8](https://adoptopenjdk.net/?variant=openjdk8&jvmVariant=hotspot) 
2. Download the installer from [here](https://ci.hexeption.dev/job/Magma%20Foundation/job/Magma-1.15.x/job/1.15.x/lastSuccessfulBuild/)
3. Install the server using the Gui and selecting Server or use the terminal 
`java -jar forge-1.15.2-31.2.0-installer.jar --installServer`
4. Now launch it using `java -jar forge-1.15.2-31.2.0.jar`

### Building the sources
* Checkout project
  * You can use IDE or clone from console:
  `git clone https://github.com/magmafoundation/Magma-1.15.x.git`
* Setup
  * Build with Linux:
  `bash gradlew setup`
  * Build with Windows:
  `gradlew.bat setup `
* Building
  * Build with Linux:
  `bash gradlew setup installerJar`
  * Build with Windows:
  `gradlew.bat setup installerJar`

## Contribute to Magma

If you wish to inspect Magma, submit PRs, or otherwise work with Magma itself, you're in the right place!.

Please read the [CONTRIBUTING.md](https://github.com/magmafoundation/Magma-1.15.x/blob/master/CONTRIBUTING.md) to see how to contribute, setup, and run.

## Chat

You are welcome to visit Magma Discord server [here](https://discord.gg/6rkqngA).

You could also go to Magma's subreddit [here](https://www.reddit.com/r/Magma).

## Partners

<a href="https://aternos.org/en/"><img src="https://company.aternos.org/img/logotype-blue.svg" width="200"></a>
<a href="https://songoda.com/"><img src="https://cdn2.songoda.com/branding/logo.png" width="200"></a>
<a href="https://serverjars.com/"><img src="https://serverjars.com/assets/img/logo_white.svg" width="200"></a>
<a href="https://craftycontrol.com/"><img src="https://i.imgur.com/243oDOX.png" width="200"></a>

![YourKit-Logo](https://www.yourkit.com/images/yklogo.png)

[YourKit](http://www.yourkit.com/), makers of the outstanding java profiler, support open source projects of all kinds with their full featured [Java](https://www.yourkit.com/java/profiler/index.jsp) and [.NET](https://www.yourkit.com/.net/profiler/index.jsp) application profilers.
