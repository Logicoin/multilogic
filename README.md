### Introduction

MultiLogic is a Simplified Payment Verification (SPV) Logicoin desktop client.
It is ported from the MultiBit Bitcoin client. Huge thanks to the original devs for this awesome project!

MultiLogic relies on the following technologies:

* Maven as the build system, so the usual Maven processes apply. If you're not familiar
with Maven then [download it first](http://maven.apache.org) and follow their installation instructions.
* [ZXing ("Zebra Crossing")](https://code.google.com/p/zxing/) for QR codes
* [Logicoinj](https://github.com/logicoin/logicoinj) for access to the Logicoin network
* IzPack for creating installers for Windows, Mac, Linux
* [Bitcoinj Enforcer Rules](https://github.com/gary-rowe/BitcoinjEnforcerRules) to prevent dependency chain attacks
* [XChange](https://github.com/timmolter/XChange) for access to several Bitcoin exchanges

#### A note on the Logicoinj dependency

MultiLogic depends on a special fork of Logicoinj for its Bitcoin support. This is due to legacy wallet serialization issues
and the MultiLogic team are working towards a complete integration. To build MultiLogic you will need to clone this fork from
here:
```
http://github.com/logicoin/logicoinj
```

The branch you should use for the MultiLogic develop code is: `bcj-0.10.3-mb-alice`

Once cloned, you should then install the custom Logicoinj library using

```
mvn clean install
```

### Branching strategy

This follows the  [master-develop](http://nvie.com/posts/a-successful-git-branching-model/) pattern.

There are 2 main branches: `master` and `develop`. The `master` branch is exclusively for releases, while the `develop`
is exclusively for release candidates. The `develop` branch always has a Maven version of `develop-SNAPSHOT`.

Every GitHub Issue gets a branch off develop. When it is complete and code reviewed it is merged into `develop`.

When sufficient Issues are merged into `develop` to justify a release, a new branch off `develop` is created with the release number (e.g. `release-1.2.3`).
The Maven `pom.xml` is updated to reflect the snapshot version (e.g. `1.2.3-SNAPSHOT`).

Once the release has been tested and is ready to go live, the final act is to update the `pom.xml` to remove the SNAPSHOT suffix and merge it into `master`.

The `master` branch is then tagged with the release number. Tags are in the format `v1.2.3` to distinguish them from branch names.

An announcement is made on the MultiLogic website to alert everyone that a new version is available.

### Maven build targets

The important targets are:

```
mvn clean package
```

which will package the MultiLogic project into `multilogic-x.y.z.jar` where `x.y.z` is the current version
number. This is suitable for local development work.

If you want to generate a complete set of multi-platform installers (Windows, Mac and Linux) you 
use the following command

```
maven clean install
```

After some processing, you will have the following artifacts in the target directory:

* an executable jar = multilogic-exe.jar
* a Mac application bundle = MultiLogic.app
* a Mac DMG file = multilogic-x.y.z.dmg
* an installer for Windows = multilogic-x.y.z-windows.exe
* an installer for Linux = multilogic-x.y.z-linux.jar

To run MultiLogic from these artifacts you can follow the instructions provided on the main MultiLogic
website](https://logicoin.info/help.html)

### MultiLogic contains cut down JREs so is a large clone

The MultiLogic installers contain cut down JREs so the project clone is quite large.
(100 to 200 MB).

### Custom configuration

MultiLogic is quite flexible and has several features only accessible to power users through the configuration file. This
is discussed in more detail in [configuration.md](configuration.md)

### Contributing

If you want to contribute, please contact me at: [info@logicoin.info](mailto:info@logicoin.info).
