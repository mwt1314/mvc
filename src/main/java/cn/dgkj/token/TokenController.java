package cn.dgkj.token;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mawt
 */
@Controller
@RequestMapping("/api/form")
public class TokenController {

    @RequestMapping("/token")
    @ResponseBody
    @Token(key = "${tokenKey}")
    public Object token() {

        return null;
    }


}
