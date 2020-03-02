package no.didrikpa

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.request.receiveText
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.routing.routing

fun Application.routing() {

    routing {
        get("/route-66") {
            call.respond("Broom broom")
        }

        route("/route-67") {
            get {
                call.respond("GET")
            }

            post {
                call.respond("HELLO ${call.receiveText()}")
            }
        }
    }
}