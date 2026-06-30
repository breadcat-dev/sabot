plugins {
    id("java")
    id("maven-publish")
}

group = "cat.breadcat"
version = "1.0.4"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {

}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            artifactId = rootProject.name;
        }
    }
}