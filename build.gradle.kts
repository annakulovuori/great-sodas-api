plugins {
	java
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("org.mariadb.jdbc:mariadb-java-client")

	implementation ("org.mapstruct:mapstruct:1.5.2.Final")
	annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.2.Final")
	annotationProcessor ("org.projectlombok:lombok-mapstruct-binding:0.2.0")
	testAnnotationProcessor ("org.mapstruct:mapstruct-processor:1.5.2.Final")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
