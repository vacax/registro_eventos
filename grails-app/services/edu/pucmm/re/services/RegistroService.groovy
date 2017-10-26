package edu.pucmm.re.services

import edu.pucmm.re.domains.eventos.Registro
import edu.pucmm.re.domains.seguridad.Usuario
import edu.pucmm.re.forms.RegistroForm
import grails.gorm.transactions.Transactional

@Transactional
class RegistroService {

    /**
     * 
     * @param registroForm
     * @param usuario
     * @return
     */
    Registro crearRegistro(RegistroForm registroForm, Usuario usuario){

        Registro r = new Registro()

        r.nombre = registroForm.nombre
        r.email = registroForm.email
        r.rfid = registroForm.rfid.toBigInteger()
        r.creadoPor=r.modificadoPor=usuario.username

        r.save(flush: true, failOnError: true)

        return r
    }

    /**
     * 
     * @param registroForm
     * @param usuario
     * @return
     */
    Registro modificarRegistro(RegistroForm registroForm, Usuario usuario){

        Registro r = Registro.get(registroForm.id)

        r.nombre = registroForm.nombre
        r.email = registroForm.email
        r.rfid = registroForm.rfid
        r.modificadoPor=usuario.username

        r.save(flush: true, failOnError: true)

        return r
    }

    /**
     * 
     * @param id
     * @param usuario
     * @return
     */
    boolean deshabilitarRegistro(long id, Usuario usuario){
       Registro r = Registro.get(id)
        r.modificadoPor=usuario.username
        r.habilitado=false
        return r.habilitado
    }

}
