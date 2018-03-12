package beckbi.msgboard;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import  beckbi.msgboard.Interceptor.MyLister;

@SpringBootApplication
@ServletComponentScan
public class Application {


    public static void main(String[] args){
        //app.addListeners(new StartApplicationListener());
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addListeners();
        springApplication.run(args);
    }



}
