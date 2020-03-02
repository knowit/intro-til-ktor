package no.didrikpa

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing

data class TestJson(val name: String, val email: String, val phoneNumber: String)

fun Application.json() {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
    
    routing { 
        get("/json") {
            val testJson = TestJson("Didrik", "didrik.aalen@knowit.no", "46646168")
            call.respond(mapOf("test" to testJson))
        }
    }
}