package dk.tv2.pushinterface

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PushInterfaceApplication

fun main(args: Array<String>) {
    runApplication<PushInterfaceApplication>(*args)
}
