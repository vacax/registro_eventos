package edu.pucmm.re.controllers

import edu.pucmm.re.domains.eventos.MovEntradaSalida
import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN","ROLE_REGISTRO"])
class MovEntradaSalidaController {

    def index() {
        redirect(action: "lista")
    }

    def lista(){
        [listaMov : MovEntradaSalida.findAllByHabilitado(true)]
    }
}
