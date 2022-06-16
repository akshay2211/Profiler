package io.ak1.plugins

import io.ak1.svg.badRequest
import io.ak1.svg.generate
import io.ak1.svg.getHashMap
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

//http://0.0.0.0:8080/banner?title=Hi,%20i%20am%20Akshay&desc1=Opensource%20Enthusiast,%20Software&desc2=architect%20and%20User%20Experience%20Designer&url=https://ak1.io
fun Application.configureRouting() {
    // Starting point for a Ktor app:
    routing {
        static("assets") {
            // files("fonts")
            resources("fonts")
        }
        bannerCreation()
    }
}

fun Application.installCors() {
    install(CORS) {
        anyHost()
    }
}

fun Route.bannerCreation() {
    get {
        val title = call.request.queryParameters["title"] ?: return@get call.badRequest("Missing title")
        val desc1 = call.request.queryParameters["desc1"]
        val desc2 = call.request.queryParameters["desc2"]


        val image = call.request.queryParameters["image"]
        val url = call.request.queryParameters["url"]

        val icons = call.request.getHashMap()
        val modifiedWidth = try {
            val width = (call.request.queryParameters["width"] ?: "1200").toInt()
            if ((800..2000).contains(width)) width else 1200
        } catch (nfe: NumberFormatException) {
            print(nfe.message)
            1200
        }
        call.respondText(
            generate(title, desc1, desc2, image, url, icons, modifiedWidth),
            contentType = ContentType.Image.SVG
        )
    }
}









