package io.ak1.svg

import io.ak1.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

suspend fun ApplicationCall.badRequest(text: String) = respondText(
    text, status = HttpStatusCode.BadRequest
)

fun ApplicationRequest.getHashMap(): HashMap<String, String?> {
    val github = call.request.queryParameters[GITHUB]
    val linkedin = call.request.queryParameters[LINKEDIN]
    val gitlabs = call.request.queryParameters[GITLABS]
    val twitter = call.request.queryParameters[TWITTER]
    return HashMap<String, String?>().apply {
        this[GITHUB] = github
        this[LINKEDIN] = linkedin
        this[GITLABS] = gitlabs
        this[TWITTER] = twitter
    }
}

fun iconPresenter(icons: java.util.HashMap<String, String?>): String {
    val mainList = icons.filter { it.value != null }
    val size = mainList.size
    val center = 67.0
    val half: Int = size / 2
    val start = center - (half * 5)
    return StringBuilder().apply {
        var index = 0
        mainList.forEach {
            val x = start + (5 * index)
            when (it.key) {
                GITHUB -> append(imageBody(x, "https://github.com/${it.value}") { github })
                LINKEDIN -> append(imageBody(x, "https://www.linkedin.com/in/${it.value}") { linkedin })
                GITLABS -> append(imageBody(x, "https://gitlab.com/${it.value}") { gitlab })
                TWITTER -> append(imageBody(x, "https://twitter.com/${it.value}") { twitter })
            }
            index++
        }
    }.toString()
}