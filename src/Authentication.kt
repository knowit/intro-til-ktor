package no.didrikpa

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authenticate
import io.ktor.auth.basic
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing

fun Application.authentication() {
    install(Authentication) {
        basic("jvmAuth") {
            realm = "Ktor Server"
            validate {
                if (it.name == "jvm" && it.password == "password") {
                    UserIdPrincipal(it.name)
                } else {
                    null
                }
            }
        }
    }

    routing {
        authenticate("jvmAuth") {
            get("/authentication") {
                call.respond("Secure")
            }
        }
    }
}