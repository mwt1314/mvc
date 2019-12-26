package cn.dgkj.ifelse;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author mawt
 * @description
 * @date 2019/11/18
 */
@Data
@AllArgsConstructor
public class MessageInfo {

    // 消息类型
    private Integer type;
    // 消息内容
    private String content;

}
