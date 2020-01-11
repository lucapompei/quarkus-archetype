# Quarkus Archetype v.1.0.0

[![Build Status](https://travis-ci.org/lucapompei/quarkus-archetype.svg?branch=master)](https://travis-ci.org/lucapompei/quarkus-archetype) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0) [![CodeFactor](https://www.codefactor.io/repository/github/lucapompei/quarkus-archetype/badge)](https://www.codefactor.io/repository/github/lucapompei/quarkus-archetype)

=============================

This maven project represents a generic web template based on Quarkus, a Kubernetes Native Java framework tailored for GraalVM and HotSpot.


Summary features
-------

- Java 11;
- Maven project based on Quarkus;
- Netty embedded;
- CORS configuration;
- Logback configuration for uniquely record each request;
- Junit 5 with coverage >= 75%;
- API response time auto-calculated and logged;
- Swagger auto-generated;
- Dockerfile pre-configuration;
- Jenkinsfile pre-configuration;
- OpenShift pre-configuration;
- Fully customizable through the environment properties.


Usage
-------

Clone or download the maven archetype and then:

- Install the archetype

```
  mvn install
```

- Create a new project starting from the archetype
	
```
  mvn archetype:generate
```
 


License
-------

  Copyright (C) 2020 lucapompei
 
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
