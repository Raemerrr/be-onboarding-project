dependencies {
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    implementation(project(":common"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-integration")

    implementation("org.apache.commons:commons-lang3")
    implementation("org.apache.commons:commons-collections4")

    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
