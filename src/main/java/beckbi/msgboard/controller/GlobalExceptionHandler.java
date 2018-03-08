package beckbi.msgboard.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public String  handleMyExcepteHandler(){

        return "catch MyException";
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String  handleAllExcepteHandler(){

        return "catch Exception";
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public String  handleRuntimeExcepteHandler(){

        return "catch RuntimeException";
    }


}
