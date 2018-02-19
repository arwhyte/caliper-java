# IMS Global Learning Consortium, Inc.

# caliper-java

The [Caliper Analytics&reg; Specification](https://www.imsglobal.org/caliper/v1p1/caliper-spec-v1p1) provides a structured approach to describing, collecting and exchanging learning activity data at scale.  Establishing a common vocabulary for describing learning interactions is a central objective.  Promoting data interoperability, data sharing and data-informed decision making are also important goals.

Caliper also defines an application programming interface (the Sensor API&trade;) for marshalling and transmitting event data from instrumented applications to target endpoints for storage, analysis and use.  *caliper-java* is a reference implementation of the Sensor API&trade; written in Java.

## Branches
* __master__: stable, deployable branch that stores the official release history.  
* __develop__: unstable development branch.  Current work that targets a future release is merged to this branch.

## Tags
*caliper-java* releases are tagged and versioned MAJOR.MINOR.PATCH\[-label\] (e.g., 1.2.0).  Pre-release tags are identified with an extensions label (e.g., "1.2.0-RC01").  The tags are stored in this repository.

## Getting Started
Fork the IMS Global *caliper-java* project to your Github account and then clone your copy to your local development machine.  

### Prerequisites
*caliper-java* uses Apache [Maven](https://maven.apache.org/) 3.x to manage the build process, documentation and reporting.

### Building
First, clone the *caliper-common-fixtures* project to your development machine and add a symbolic link: 

```
ln -s /Path/to/caliper-common-fixtures/src/test/resources/fixtures/ src/test/resources/fixtures
``` 

Then from your local *caliper-java* directory run:

```
mvn clean install
```

You can also build a jar with all the dependencies compiled by invoking the `uber-jar` build profile:

```
mvn clean -P uber-jar install
```

This will create a jar in: `target/caliper-java-{version}.jar`

### Dependency Management
You can specify *caliper-java* as a project or module dependency in the appropriate `pom.xml` file:

```
<dependency>
    <groupId>org.imsglobal.caliper</groupId>
    <artifactId>caliper-java</artifactId>
    <version>1.2.0</version>
</dependency>
```

## License
This project is licensed under the terms of the GNU Lesser General Public License (LGPL), version 3.  See the [LICENSE](./LICENSE) file for details.

©2018 IMS Global Learning Consortium, Inc. All Rights Reserved.
Trademark Information - http://www.imsglobal.org/copyright.html