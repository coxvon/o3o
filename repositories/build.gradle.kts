plugins {
    id("buildlogic.java-library-conventions")
}
dependencies {
    api(project(":domain"))
    api(project(":utilities"))
    api("com.ibeetl:sql-springboot-starter")
    runtimeOnly("mysql:mysql-connector-java")

}