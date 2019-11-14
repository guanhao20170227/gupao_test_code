package com.haohao.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  这个类 是与 在 <bean> 中配置相当的, 直接的配置
 *  但是这个还是没有实现:
 *
 *  <!-- 配置 scheduler -->
 *     <bean name="scheduler" class="org.springframework.scheduling.quartz.SchedulerFactoryBean">
 *         <property name="triggers">
 *             <list>
 *                 <ref bean="simpleTrigger"></ref>
 *                 <ref bean="cronTrigger"></ref>
 *             </list>
 *         </property>
 *     </bean>
 *
 *     回报错: 找不到  simpleTrigger/ cronTrigger;
 */

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printTimeJobDetail() {
        return JobBuilder.newJob(MyJob1.class)
                .withIdentity("haohaoJobDetail")
                .usingJobData("name", "pie")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger printTimeJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(printTimeJobDetail())
                .withIdentity("quartzTaskService")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
