package fr.katechnologie.wildfly.scheduler.session;

import java.util.Date;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.ScheduleExpression;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;


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

    @PostConstruct
    private void init() {
        TimerConfig timerConfig = new TimerConfig();
        timerConfig.setInfo("SchedulerInfo");
        ScheduleExpression schedule = new ScheduleExpression();
        schedule.hour("*").minute("*").second("13,34,57");
        timerService.createCalendarTimer(schedule, timerConfig);
    }

    @Timeout
    public void execute(Timer timer) {
        logger.info( "Timer Service : " + timer.getInfo() );
        logger.info( "Execution Time : " + new Date());
        logger.info( "____________________________________________" );
    }


}
