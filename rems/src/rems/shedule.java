/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rems;

/**
 *
 * @author Anandhu Anil
 */
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class shedule implements Runnable{
    
 

    @Override
    public void run()  {
   try{
   JobDetail j;
       j = JobBuilder.newJob(calltime.class).build();
        
        Trigger t = TriggerBuilder.newTrigger().withIdentity("CroneTrigger").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(01).repeatForever()).build();
     
        Scheduler s =StdSchedulerFactory.getDefaultScheduler();
        
        s.start();
        s.scheduleJob(j,t);
   }catch(SchedulerException hx){
   hx.printStackTrace();
   }
    }
}
