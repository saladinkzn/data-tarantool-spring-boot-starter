#data-tarantool-spring-boot-starter
[![Build Status](https://travis-ci.org/saladinkzn/data-tarantool-spring-boot-starter.svg?branch=master)](https://travis-ci.org/saladinkzn/data-tarantool-spring-boot-starter)
[![License](http://img.shields.io/badge/license-MIT-47b31f.svg)](#copyright-and-license)
 
[Spring boot](http://projects.spring.io/spring-boot/) starter for [spring-data-tarantool](https://github.com/saladinkzn/spring-data-tarantool)

## Usage:
```groovy
repositories {
    jcenter()
}

dependencies {
  compile 'ru.shadam:data-tarantool-spring-boot-starter:0.1.0'
}
```

spring-data-tarantool repositories will be configured by default. 

## Available properties:

 | property | defaultValue |  description | 
 | --- | --- | --- |   
 | ru.shadam.tarantool.host | localhost | tarantool server host |
 | ru.shadam.tarantool.port | 3301 | tarantool server port |
 | ru.shadam.tarantool.user | guest | tarantool server user |
 | ru.shadam.tarantool.password | `null` | tarantool server password |
 
## Copyright and License

Copyright 2017 (c) Timur Shakurov.

All versions, present and past, of spring-data-tarantool are licensed under [MIT license](LICENSE).
