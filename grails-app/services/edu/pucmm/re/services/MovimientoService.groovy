package edu.pucmm.re.services

import edu.pucmm.re.domains.configuracion.Parametro
import edu.pucmm.re.domains.eventos.Evento
import edu.pucmm.re.domains.eventos.MovEntradaSalida
import edu.pucmm.re.domains.eventos.Registro
import edu.pucmm.re.encapsulaciones.LecturaTag
import grails.gorm.transactions.Transactional

@Transactional
class MovimientoService {

    def brokerJmsService

    void procesarMovimiento(LecturaTag l) {
        try {
            String ubicacion = ""
            Date fecha = new Date()
            //000000000000680000000000
            BigInteger bigInteger = (l.tagRfid.substring(0, 14)).toBigInteger()
            println("El tag recibido es: " + bigInteger)
            println("Antena: " + l.antenaRecibida)

            //verificando el registro y el evento.
            Registro registro = Registro.findByRfidAndHabilitado(bigInteger, true)
            if(!registro){
                println("Tag ${l.tagRfid} - No registrado.")
                return;
            }

            //verificando el evento.
            Evento evento = Evento.findByFechaInicioLessThanEqualsAndFechaFinGreaterThanAndHabilitado(fecha, fecha, true)
            if(!evento){
                println("No existe evento en la fecha ${fecha}")
                return;
            }

            if(l.antenaRecibida == 1){
                ubicacion = "ENTRADA"
            }  else if(l.antenaRecibida == 2){
                ubicacion = "SALIDA"
            }

            if(registro.ubicacion == ubicacion){
                println("Sin cambio de movimiento para registro ${registro.id} - Evento: ${evento.id}")
                return;
            }

            //proceando el movimiento
            println("Moviento procesado para registro ${registro.id} - Evento: ${evento.id}")
            new MovEntradaSalida(registro: registro, evento: evento, antena: l.antenaRecibida, rfid: "${bigInteger}", accion: ubicacion).save(flush: true, failOnError: true)
            registro.ubicacion = ubicacion
            registro.save(flush: true, failOnError: true)

            
            //enviando la notificación.
            if(ubicacion == "ENTRADA") {
                brokerJmsService.enviarMensaje(Parametro.findByCodigo(Parametro.JMS_COLA).valor, "${registro.nombre}")
            }


        }catch (Exception ex){
            println("Problema procesando ${l.tagRfid} - ${l.antenaRecibida}. Error: "+ex.message)
        }
    }
}
