package beckbi.msgboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public abstract class SuperController {

    protected Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${msgboard.title}")
    protected String msgboardTitle;

}
