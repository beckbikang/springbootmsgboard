package beckbi.msgboard.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MsgBoardController extends SuperController{

    @RequestMapping(value = "/msgboard/add", method = RequestMethod.GET)
    public ModelAndView edit(ModelMap map) throws Exception{
        ModelAndView modelAndView = new ModelAndView("msgboard/add");
        modelAndView.addObject("title","添加留言");
        return modelAndView;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list() throws Exception{

    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public void del()throws Exception{

    }
}
