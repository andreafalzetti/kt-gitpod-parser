/*
 * Gitpod.kt
 *
 * This code was generated by json-kotlin-schema-codegen - JSON Schema Code Generator
 * See https://github.com/pwall567/json-kotlin-schema-codegen
 *
 * It is not advisable to modify generated code as any modifications will be lost
 * when the generation process is re-run.
 */
package kt.gitpod.parser

import java.math.BigDecimal
import kotlinx.serialization.Serializable

@Serializable
data class GitpodConfig(
    /** List of exposed ports. */
    val ports: List<Port>? = null,
    /** List of tasks to run on start. Each task will open a terminal in the IDE. */
    val tasks: List<Task>? = null,
    /** The Docker image to run your workspace in. */
    val image: String = "gitpod/workspace-full",
    /** List of additional repositories that are part of this project. */
    val additionalRepositories: List<AdditionalRepositorie>? = null,
    /** The main repository, containing the dev environment configuration. */
    val mainConfiguration: String? = null,
    /** Path to where the repository should be checked out relative to `/workspace`. Defaults to the simple repository name. */
    val checkoutLocation: String? = null,
    /** Path to where the IDE's workspace should be opened. Supports vscode's `*.code-workspace` files. */
    val workspaceLocation: String? = null,
    /** Git config values should be provided in pairs. E.g. `core.autocrlf: input`. See https://git-scm.com/docs/git-config#_values. */
    val gitConfig: GitConfig? = null,
    /** Configures Gitpod's GitHub app */
    val github: Github? = null,
    /** Configure VS Code integration */
    val vscode: Vscode? = null,
    /** Configure JetBrains integration */
    val jetbrains: Jetbrains? = null,
    /** Experimental network configuration in workspaces (deprecated). Enabled by default */
    val experimentalNetwork: Boolean? = null,
    /** Configure the default action of certain signals is to cause a process to terminate and produce a core dump file, a file containing an image of the process's memory at the time of termination. Disabled by default. */
    val coreDump: CoreDump? = null
) {
    @Serializable
    data class Port(
        /** The port number (e.g. 1337) or range (e.g. 3000-3999) to expose. */
        val port: Int,
        /** What to do when a service on this port was detected. 'notify' (default) will show a notification asking the user what to do. 'open-browser' will open a new browser tab. 'open-preview' will open in the preview on the right of the IDE. 'ignore' will do nothing. */
        val onOpen: String? = null,
        /** Whether the port visibility should be private or public. 'private' (default) will only allow users with workspace access to access the port. 'public' will allow everyone with the port URL to access the port. */
        val visibility: Visibility = Visibility.private,
        /** Port name. */
        val name: String? = null,
        /** The protocol to be used. (deprecated) */
        val protocol: Protocol? = null,
        /** A description to identify what is this port used for. */
        val description: String? = null
    ) {

        init {
            if (onOpen != null)
                require(onOpen in cg_array0) { "onOpen not in enumerated values - $onOpen" }
        }

    }

    /**
     * Whether the port visibility should be private or public. 'private' (default) will only allow users with workspace access to access the port. 'public' will allow everyone with the port URL to access the port.
     */
    @Serializable
    enum class Visibility {
        private,
        public
    }

    /**
     * The protocol to be used. (deprecated)
     */
    @Serializable
    enum class Protocol {
        http,
        TCP,
        UDP
    }

    @Serializable
    data class Task(
        /** Name of the task. Shown on the tab of the opened terminal. */
        val name: String? = null,
        /** A shell command to run before `init` and the main `command`. This command is executed on every start and is expected to terminate. If it fails, the following commands will not be executed. */
        val before: String? = null,
        /** A shell command to run between `before` and the main `command`. This command is executed only on after initializing a workspace with a fresh clone, but not on restarts and snapshots. This command is expected to terminate. If it fails, the `command` property will not be executed. */
        val init: String? = null,
        /** A shell command to run after `before`. This command is executed only on during workspace prebuilds. This command is expected to terminate. If it fails, the workspace build fails. */
        val prebuild: String? = null,
        /** The main shell command to run after `before` and `init`. This command is executed last on every start and doesn't have to terminate. */
        val command: String? = null,
        /** Environment variables to set. */
        val env: Env? = null,
        /** The panel/area where to open the terminal. Default is 'bottom' panel. */
        val openIn: OpenIn? = null,
        /** The opening mode. Default is 'tab-after'. */
        val openMode: String? = null
    ) {

        init {
            if (openMode != null)
                require(openMode in cg_array1) { "openMode not in enumerated values - $openMode" }
        }

    }

    /**
     * Environment variables to set.
     */
    @Serializable
    open class Env

    /**
     * The panel/area where to open the terminal. Default is 'bottom' panel.
     */
    @Serializable
    enum class OpenIn {
        bottom,
        main,
        left,
        right
    }

    @Serializable
    data class AdditionalRepositorie(
        /** The url of the git repository to clone. Supports any context URLs. */
        val url: String,
        /** Path to where the repository should be checked out relative to `/workspace`. Defaults to the simple repository name. */
        val checkoutLocation: String? = null
    )

    /**
     * Git config values should be provided in pairs. E.g. `core.autocrlf: input`. See https://git-scm.com/docs/git-config#_values.
     */
    @Serializable
    open class GitConfig

    /**
     * Configures Gitpod's GitHub app
     */
    @Serializable
    data class Github(
        /** Set to true to enable workspace prebuilds, false to disable them. Defaults to true. */
        val prebuilds: Boolean? = null
    )

    /**
     * Configure VS Code integration
     */
    @Serializable
    data class Vscode(
        /** List of extensions which should be installed for users of this workspace. The identifier of an extension is always '${publisher}.${name}'. For example: 'vscode.csharp'. */
        val extensions: List<String>? = null
    )

    /**
     * Configure JetBrains integration
     */
    @Serializable
    data class Jetbrains(
        /** List of plugins which should be installed for all JetBrains product for users of this workspace. From the JetBrains Marketplace page, find a page of the required plugin, select 'Versions' tab, click any version to copy pluginId (short name such as org.rust.lang) of the plugin you want to install. */
        val plugins: List<String>? = null,
        /** Configure IntelliJ integration */
        val intellij: JetbrainsProduct? = null,
        /** Configure GoLand integration */
        val goland: JetbrainsProduct? = null,
        /** Configure PyCharm integration */
        val pycharm: JetbrainsProduct? = null,
        /** Configure PhpStorm integration */
        val phpstorm: JetbrainsProduct? = null
    )

    /**
     * Configure IntelliJ integration
     */
    @Serializable
    data class JetbrainsProduct(
        /** List of plugins which should be installed for users of this workspace. From the JetBrains Marketplace page, find a page of the required plugin, select 'Versions' tab, click any version to copy pluginId (short name such as org.rust.lang) of the plugin you want to install. */
        val plugins: List<String>? = null,
        /** Enable warming up of JetBrains backend in prebuilds. */
        val prebuilds: Prebuilds? = null,
        /** Configure JVM options, for instance '-Xmx=4096m'. */
        val vmoptions: String? = null
    )

    /**
     * Enable warming up of JetBrains backend in prebuilds.
     */
    @Serializable
    data class Prebuilds(
        /** Whether only stable, latest or both versions should be warmed up. Default is stable only. */
        val version: Version? = null
    )

    /**
     * Whether only stable, latest or both versions should be warmed up. Default is stable only.
     */
    enum class Version {
        stable,
        latest,
        both
    }

    /**
     * Configure the default action of certain signals is to cause a process to terminate and produce a core dump file, a file containing an image of the process's memory at the time of termination. Disabled by default.
     */
    @Serializable
    data class CoreDump(
        val enabled: Boolean? = null,
        /** upper limit on the size of the core dump file that will be produced if it receives a core dump signal */
        val softLimit: Int? = null,
        /** the hard limit acts as a ceiling for the soft limit. For more details please check https://man7.org/linux/man-pages/man2/getrlimit.2.html */
        val hardLimit: Int? = null
    )

    companion object {
        private val cg_array0 = setOf(
            "open-browser",
            "open-preview",
            "notify",
            "ignore"
        )
        private val cg_array1 = setOf(
            "split-left",
            "split-right",
            "tab-before",
            "tab-after"
        )
    }

}
