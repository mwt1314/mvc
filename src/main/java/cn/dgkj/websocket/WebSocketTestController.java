package cn.dgkj.websocket;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mawt
 */
@Controller
@RequestMapping("/ws")
public class WebSocketTestController {

    @RequestMapping("/index")
    public String index() {
        return "/ws/index";
    }

}
