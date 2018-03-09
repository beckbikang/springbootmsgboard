package beckbi.msgboard.controller;

import beckbi.msgboard.entity.db.Msgboard;
import beckbi.msgboard.service.JdbcMsgboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MsgBoardController extends SuperController{

    @Autowired
    protected HttpServletRequest request;


    @Autowired
    JdbcMsgboardService jdbcMsgboardService;

    @RequestMapping(value = "/msgboard/add", method = RequestMethod.GET)
    public ModelAndView edit() throws Exception{
        ModelAndView modelAndView = new ModelAndView("msgboard/add");
        modelAndView.addObject("title","添加留言");
        return modelAndView;
    }

    @RequestMapping(value = "/msgboard/add", method = RequestMethod.POST)
    public void add(HttpServletResponse rsp) throws Exception{
        String name = request.getParameter("name");
        String msg = request.getParameter("msg");

        int retId = jdbcMsgboardService.createMsgboard(name, msg);
        if(retId > 0){
            rsp.sendRedirect("/msgboard/list");
        }else{
            rsp.sendRedirect("/msgboard/add");
        }
    }

    @RequestMapping(value = "/msgboard/list", method = RequestMethod.GET)
    public ModelAndView list() throws Exception{
        ModelAndView modelAndView = new ModelAndView("msgboard/list");

        int page = 1;
        String pageStr = request.getParameter("page");
        if(pageStr != null){
            page = Integer.parseInt(pageStr);
        }

        int pageSize = 20;
        String pageSizeStr = request.getParameter("pagesize");
        if(pageSizeStr != null){
            pageSize = Integer.parseInt(pageSizeStr);
        }

        List<Msgboard> list = jdbcMsgboardService.findByPage(page, pageSize);

        modelAndView.addObject("msgs",list);

        int prePage = page -1;
        if(prePage <= 0) prePage = 0;
        modelAndView.addObject("prePage", prePage);

        int nextPage = page + 1;
        if(list.size() < pageSize){
            nextPage = 0;
        }
        modelAndView.addObject("lastPage", nextPage);

        return modelAndView;
    }

    @RequestMapping(value = "/msgboard/del", method = RequestMethod.GET)
    public void del(HttpServletResponse rsp)throws Exception{
        String idStr = request.getParameter("id");
        if(idStr != null){
            int id = Integer.parseInt(idStr);
            jdbcMsgboardService.deleteMsgboardById(id);
        }
        rsp.sendRedirect("/msgboard/list");
    }
}
