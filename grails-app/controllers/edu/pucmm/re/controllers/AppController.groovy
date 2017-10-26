package edu.pucmm.re.controllers

import edu.pucmm.re.domains.eventos.Registro
import grails.plugin.springsecurity.annotation.Secured

@Secured(["IS_AUTHENTICATED_REMEMBERED"])
class AppController {

    def index() {
        int entrada = Registro.countByUbicacionAndHabilitado("ENTRADA", true)
        int salida = Registro.countByUbicacionAndHabilitado("SALIDA", true)
        int sinmov = Registro.countByUbicacionAndHabilitado("", true)
        [entrada: entrada, salida: salida, sinmov: sinmov]
    }
}
