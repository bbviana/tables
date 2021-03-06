package br.com.viana.hal.money

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

/**
 * @author bbviana
 */
@Component
class Scheduler {

    @Autowired
    private SantanderFetcher fetcher

    @Autowired
    private SantanderParser parser

    @Autowired
    private EmailSender emailSender

    // 8:00
    @Scheduled(cron = "0 0 8 * * *")
    // 2h, delay inicial para não atrapalhar o boot
//    @Scheduled(fixedRate = 7200_000L, initialDelay = 60_000L)
    void run() {
        println "${new Date()}: Executando importação agendada..."

        fetcher.fetch()

        println "${new Date()}: Processando dados..."

        def summary = parser.parse()

        println "Enviando email..."

        emailSender.send(summary)

        println "Email enviado com sucesso"
    }
}
