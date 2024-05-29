//in app module gradle file

import java.util.Properties

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localPropertiesFile.inputStream().use { input ->
        localProperties.load(input)
    }
}

android {

    defaultConfig {
    
        buildConfigField(
            type = "String",
            name = "API_KEY",
            value = localProperties["API_KEY"].toString()
        )
    }
    
    buildFeatures {
        buildConfig = true
    }
}
