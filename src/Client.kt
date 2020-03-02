package no.didrikpa

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing

fun Application.client() {
    val client = HttpClient(CIO) {
    }
    
    routing { 
        get("/client") {
            val bytes = client.get<ByteArray>("http://0.0.0.0:8081/")
            val string = bytes.toString(Charsets.UTF_8)
            call.respond(string)
        }
    }
}