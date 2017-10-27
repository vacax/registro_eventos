package registro_eventos

import edu.pucmm.re.domains.configuracion.Parametro
import edu.pucmm.re.domains.eventos.Evento
import edu.pucmm.re.domains.eventos.Registro
import edu.pucmm.re.domains.seguridad.Perfil
import edu.pucmm.re.domains.seguridad.Usuario
import edu.pucmm.re.domains.seguridad.UsuarioPerfil
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        //Parametros
        Parametro.findByCodigo(Parametro.ANTENA_ENTRADA) ?: new Parametro(codigo: Parametro.ANTENA_ENTRADA, nombre: "ANTENA_ENTRADA", valor: "1").save(flush: true, failOnError: true)
        Parametro.findByCodigo(Parametro.ANTENA_SALIDA) ?: new Parametro(codigo: Parametro.ANTENA_SALIDA, nombre: "ANTENA_ENTRADA", valor: "2").save(flush: true, failOnError: true)
        Parametro.findByCodigo(Parametro.HABILITAR_NOTIFICACIONES) ?: new Parametro(codigo: Parametro.HABILITAR_NOTIFICACIONES, nombre: "ANTENA_ENTRADA", valor: "1").save(flush: true, failOnError: true)
        Parametro.findByCodigo(Parametro.JMS_URL) ?: new Parametro(codigo: Parametro.JMS_URL, nombre: "JMS_URL", valor: "failover:tcp://192.168.1.100:61616").save(flush: true, failOnError: true)
        Parametro.findByCodigo(Parametro.JMS_COLA) ?: new Parametro(codigo: Parametro.JMS_COLA, nombre: "JMS_COLA", valor: "mercadeo").save(flush: true, failOnError: true)
        Parametro.findByCodigo(Parametro.JMS_USUARIO) ?: new Parametro(codigo: Parametro.JMS_USUARIO, nombre: "JMS_USUARIO", valor: "admin").save(flush: true, failOnError: true)
        Parametro.findByCodigo(Parametro.JMS_PASSWORD) ?: new Parametro(codigo: Parametro.JMS_PASSWORD, nombre: "JMS_PASSWORD", valor: "admin").save(flush: true, failOnError: true)
        Parametro.findByCodigo(Parametro.JMS_HABILITAR) ?: new Parametro(codigo: Parametro.JMS_HABILITAR, nombre: "JMS_HABILITAR", valor: "1").save(flush: true, failOnError: true)

        //Creando Usuario y Perfiles
        Usuario usuario = Usuario.findByUsername("admin") ? null :new Usuario(username: "admin", password: "admin", nombre: "Administrador").save(flush: true, failOnError: true)
        if(usuario) {
            Perfil perfil = new Perfil(authority: "ROLE_ADMIN").save(flush: true, failOnError: true)

            UsuarioPerfil.create(usuario, perfil)

            new Perfil(authority: "ROLE_REGISTRO").save(flush: true, failOnError: true)
        }

        //Creando Data
        if(Environment.current == Environment.DEVELOPMENT){
            new Evento(nombre: "Charla #1", fechaInicio: Date.parse("dd/MM/yyyy HH:mm:ss", "26/10/2017 23:00:00"), fechaFin: Date.parse("dd/MM/yyyy HH:mm:ss", "27/10/2017 23:00:00")).save(failOnError: true)
            
            (1..10).each {

                new Registro(nombre: "Nombre ${it}", rfid: "${it}0000000000".toBigInteger()).save(failOnError: true)
            }

            //
            new Registro(nombre: "Nombre", rfid: "134000000000".toBigInteger()).save(failOnError: true)
            new Registro(nombre: "Nombre", rfid: "162000000000".toBigInteger()).save(failOnError: true)
            new Registro(nombre: "Nombre", rfid: "270000000000".toBigInteger()).save(failOnError: true)
            new Registro(nombre: "Nombre", rfid: "930000000000".toBigInteger()).save(failOnError: true)
            new Registro(nombre: "Nombre", rfid: "350000000000".toBigInteger()).save(failOnError: true)
            new Registro(nombre: "Nombre", rfid: "243000000000".toBigInteger()).save(failOnError: true)
            new Registro(nombre: "Nombre", rfid: "233000000000".toBigInteger()).save(failOnError: true)
        }

    }
    def destroy = {
    }
}
