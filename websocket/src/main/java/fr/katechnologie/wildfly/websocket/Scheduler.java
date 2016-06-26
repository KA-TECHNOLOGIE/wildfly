package fr.katechnologie.wildfly.websocket;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.ScheduleExpression;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.ejb.Schedule;
import java.util.Random;

/**
 * Created by Mike on 11/06/2016.
 */
@Singleton
@LocalBean
@Startup
public class Scheduler {

    private final static Logger logger = Logger.getLogger( Scheduler.class.toString() ) ;

    @Resource
    private TimerService timerService;

    private Random random;
    private volatile double valeur = 100.0;


    @PostConstruct
    public void init() {
        random = new Random();
    }

    @Schedule(second="*/1", minute="*", hour="*", persistent = false)
    public void timeoutx() {
        valeur += 1.0 * (random.nextInt(100) -50) / 100.0;
        logger.info("nouvelle valeur "+valeur);
        ValeursEndpoint.send(valeur);
    }


}
