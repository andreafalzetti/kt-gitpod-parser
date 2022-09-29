@file:DependsOn("net.pwall.json:json-kotlin-schema-codegen:0.82")

fun main(args: Array<String>) {
    val codeGenerator = CodeGenerator()
    codeGenerator.baseDirectoryName = "generated"
    codeGenerator.basePackageName = "com.example"
    codeGenerator.generate(File("/workspace/kt-gitpod-parser/gitpod-schema.json"))
}

main(args)
