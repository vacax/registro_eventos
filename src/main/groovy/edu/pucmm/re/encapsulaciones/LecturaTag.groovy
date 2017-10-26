package edu.pucmm.re.encapsulaciones

import grails.validation.Validateable

class LecturaTag implements Validateable {


    //procesado por la clase.
    int antenaRecibida;
    String tagRfid;
    int vecesLeidas;
    String rssi;


    static constraints = {
    }
}
