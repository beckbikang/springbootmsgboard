package beckbi.msgboard.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public abstract class SuperController {


    @Value("${msgboard.title}")
    protected String msgboardTitle;

}
