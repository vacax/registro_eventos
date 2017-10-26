package edu.pucmm.re.controllers

import edu.pucmm.re.encapsulaciones.LecturaTag
import grails.converters.JSON

class MovimientoController {

    def movimientoService;

    def index() {
        render "Controlador de Movimiento"
    }

    /**
     *
     * @param lecturaTag
     */
    def procesarRegistroEvento(LecturaTag lecturaTag){
        //println("Procesando la salida: "+(lecturaTag as JSON))
        movimientoService.procesarMovimiento(lecturaTag)
        render "OK"
    }

    /**
     * 
     * @param mac_address
     * @param clave_notificacion
     */
    def notificacionLector(String mac_address, String clave_notificacion){
        println("Reciendo la lector: ${mac_address} - clave: ${clave_notificacion}")
        render "Ok - ${new Date()}"
    }
}
