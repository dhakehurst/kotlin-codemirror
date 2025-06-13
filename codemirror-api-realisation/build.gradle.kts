val version_codemirror = libs.versions.codemirror.get()

dependencies {
    jsMainApi(project(":codemirror-api"))
    jsMainApi(npm("codemirror", version_codemirror))
//    "jsMainApi"(npm("@codemirror/view", "6.23.0"))
}