pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FakeChefOnline"
include(":app")
include(":core:design")
include(":core:common")
include(":core:realtime")
include(":feature:home")
include(":feature:game")
