package com.katechnologie.jms.mdb;

import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * <p>
 * A simple Message Driven Bean.
 * </p>
 */
@MessageDriven( name = "test",
        activationConfig = {
            @ActivationConfigProperty(
                    propertyName = "destinationLookup",
                    propertyValue = "jms/queue/servlet"),
            @ActivationConfigProperty(
                    propertyName = "destinationType",
                    propertyValue = "javax.jms.Queue"),
            @ActivationConfigProperty(
                    propertyName = "acknowledgeMode",
                    propertyValue = "Auto-acknowledge")
        }
)
public class MsgListener implements MessageListener {

    private final static Logger _logger = Logger.getLogger( MsgListener.class.toString() ) ;

    /**
     * @see MessageListener#onMessage(Message)
     */
    @Override
    public void onMessage( Message message ) {
        TextMessage textMessage = null;
        try {
            if ( message instanceof TextMessage ) {
                textMessage = (TextMessage ) message;
                _logger.info("Received Message from queue: " + textMessage.getText() );
            } else {
                _logger.warning("Message of wrong type: " + Message.getClass().getName() );
            }
        } catch ( JMSException error ) {
            throw error;
        }
    }
}
