package cn.dgkj.binder;

import lombok.Data;

/**
 * @author mawt
 * @description
 * @date 2019/11/25
 */
@Data
public class User {

    private Long id;

    private String username;

    private String password;

    private Integer sex;

    private Integer age;

}
