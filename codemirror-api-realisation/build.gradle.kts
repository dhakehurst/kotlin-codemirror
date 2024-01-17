val version_codemirror:String by project

dependencies {
    "jsMainApi"(project(":codemirror-api"))
    "jsMainApi"(npm("codemirror", version_codemirror))
//    "jsMainApi"(npm("@codemirror/view", "6.23.0"))
}