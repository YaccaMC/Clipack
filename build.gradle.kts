plugins {
    id("java")
}

group = "me.yaccamc.clipack"
version = "0.1.0"

repositories {
    mavenCentral()
    mavenLocal()
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("net.lingala.zip4j:zip4j:2.11.5")
}
