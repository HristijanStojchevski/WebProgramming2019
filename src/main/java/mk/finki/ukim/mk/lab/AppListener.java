package mk.finki.ukim.mk.lab;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class AppListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        String log = "[WP-log] {" + applicationEvent.toString()+ "}";
        System.out.println(log);
    }
}
