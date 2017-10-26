package edu.pucmm.re.controllers

import edu.pucmm.re.domains.eventos.Registro
import edu.pucmm.re.domains.seguridad.Usuario
import edu.pucmm.re.forms.RegistroForm
import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN","ROLE_REGISTRO"])
class RegistroController {

    def registroService

    def index() {
        redirect(action: "list")
    }

    /**
     *
     */
    def lista(){
        List<Registro> listaRegistro = Registro.findAllByHabilitado(true)
        [listaRegistro : listaRegistro]
    }

    def creacion(){

    }

    def procesarCreacion(RegistroForm registroForm){
        withForm {
            if(registroForm.hasErrors()){
                flash.mensaje = registroForm.errors.toString()
                println("Error: "+flash.mensaje)
                redirect(action: "lista")
                return
            }

            //TODO: Cambiar luego
            registroService.crearRegistro(registroForm, new Usuario(username: "admin"))
            redirect(action: "lista")

        }.invalidToken {
            flash.mensaje = "Error Doble Posteo en el servidor"
            redirect(action: "lista")
        }
    }

    def editar(long id){
        Registro registro = Registro.get(id)
        [registro: registro]
    }

    def procesarEdicion(RegistroForm registroForm){
        withForm {
            if(registroForm.hasErrors()){
                flash.mensaje = registroForm.errors.toString()
                println("Error: "+flash.mensaje)
                redirect(action: "lista")
                return
            }

            //TODO: Cambiar luego
            registroService.modificarRegistro(registroForm, new Usuario(username: "admin"))
            redirect(action: "lista")

        }.invalidToken {
            flash.mensaje = "Error Doble Posteo en el servidor"
            redirect(action: "lista")
        }
    }

    /**
     * 
     * @param id
     * @return
     */
    def borrar(long id){
        if(id==0){
            flash.mensaje = "Falta el parametro necesario"
            println("Error: "+flash.mensaje)
            redirect(action: "lista")
            return
        }

        //TODO: Cambiar
        registroService.deshabilitarRegistro(id, new Usuario(username: "admin"))
        redirect(action: "lista")
    }
}
