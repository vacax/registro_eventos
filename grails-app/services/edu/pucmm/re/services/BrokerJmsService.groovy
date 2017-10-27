package edu.pucmm.re.services

import edu.pucmm.re.domains.configuracion.Parametro
import grails.gorm.transactions.Transactional
import org.apache.activemq.ActiveMQConnectionFactory

import javax.jms.*

@Transactional
class BrokerJmsService {

    /**
     *
     * @param cola
     * @param mensajeEnviar
     * @throws javax.jms.JMSException
     */
    public void enviarMensaje(String cola, String mensajeEnviar) throws JMSException {

        String habilitado = Parametro.findByCodigo(Parametro.JMS_HABILITAR).valor
        if(habilitado != "1"){
            println("Parametro JMS HABILITADO NO DISPONIBLE")
           return;
        }

        String url = Parametro.findByCodigo(Parametro.JMS_URL).valor
        String usuario = Parametro.findByCodigo(Parametro.JMS_USUARIO).valor
        String password = Parametro.findByCodigo(Parametro.JMS_PASSWORD).valor

        //Creando el connection factory indicando el host y puerto, en la trama el failover indica que reconecta de manera
        // automatica
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);

        //Crea un nuevo hilo cuando hacemos a conexión, que no se detiene cuando
        // aplicamos el metodo stop(), para eso tenemos que cerrar la JVM o
        // realizar un close().
        Connection connection = factory.createConnection(usuario, password);
        connection.start();

        // Creando una sesión no transaccional y automatica.
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Creamos o nos connectamos a la una cola, por defecto ActiveMQ permite
        // la creación si no existe. Si la cola es del tipo Queue es acumula los mensajes, si es
        // del tipo topic es en el momento.
        //Queue queue = session.createQueue(cola);
        Topic topic = session.createTopic(cola);


        // Creando el objeto de referencia para enviar los mensajes.
        //MessageProducer producer = session.createProducer(queue);
        MessageProducer producer = session.createProducer(topic);


        String mensaje = mensajeEnviar;


        // Creando un simple mensaje de texto y enviando.
        TextMessage message = session.createTextMessage(mensaje);
        producer.send(message);

        //Desconectando la referencia.
        producer.close();
        session.close();
        connection.close();
    }
}
