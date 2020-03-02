package no.didrikpa

import freemarker.cache.ClassTemplateLoader
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.html.respondHtml
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import kotlinx.html.*

fun Application.html() {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }
    
    routing { 
        get("/html-dsl") {
            call.respondHtml { 
                body { 
                    h1 { +"DSL" }
                    a { 
                        href="https://google.com" 
                        +"Google"
                    }
                    ul { 
                        for (i in 1..10) {
                            li { +"$i" }
                        }
                    }
                }
            }
        }
        
        get("/html-template") {
            call.respond(FreeMarkerContent("freemarker.ftl", mapOf("name" to "JVM")))
        }
    }
}