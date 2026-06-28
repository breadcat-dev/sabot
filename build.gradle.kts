plugins {
    id("java")
    id("maven-publish")
}

group = "cat.breadcat"
version = "1.0.1"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("cat.breadcat:breech:1.2.0")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            artifactId = rootProject.name;
        }
    }
}