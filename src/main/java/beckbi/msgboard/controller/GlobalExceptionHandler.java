package beckbi.msgboard.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public String  handleMyExcepteHandler(MyException  e){

        return "catch MyException";
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public void  handleAllExcepteHandler(Exception e) throws Exception{
        throw e;
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public void  handleRuntimeExcepteHandler(RuntimeException e){
        throw e;
    }


}
