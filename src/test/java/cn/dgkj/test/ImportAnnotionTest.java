package cn.dgkj.test;

import cn.dgkj.App;
import cn.dgkj.ifelse.MSG_TYPE;
import cn.dgkj.ifelse.MessageInfo;
import cn.dgkj.ifelse.MessageService;
import cn.dgkj.ifelse.MessageServiceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ImportAnnotionTest {

    @Autowired
    MessageServiceContext messageServiceContext;

    @Test
    public void contextLoads() {
        // 构建一个文本消息
        MessageInfo messageInfo = new MessageInfo(MSG_TYPE.TEXT.code, "消息内容");
        MessageService messageService = messageServiceContext.getMessageService(messageInfo.getType());
        // 处理文本消息 消息内容
        // 可以看到文本消息被文本处理类所处理
        messageService.handleMessage(messageInfo);
    }


    @Autowired
    TestIOCBean testA;

    @Autowired
    TestIOCBean2 testB;

    @Autowired
    TestC testC;

    @Autowired
    TestD testD;

    @Test
    public void TestD() {
        testD.printName();
    }

    @Test
    public void TestC() {
        testC.printName();
    }

    @Test
    public void TestA() {
        testA.printName();
    }

    @Test
    public void testB() {
        testB.printName();
    }


    @Test
    public void test(){
        //获取所有的属性
        Properties properties = System.getProperties();
        //遍历所有的属性
        for (String key : properties.stringPropertyNames()) {
            //输出对应的键和值
            System.out.println(key + "=" + properties.getProperty(key));
        }
        System.out.println("----------------------------------------");
    }

    @Test
    public void env() {
        //环境变量
        System.setProperty("file.encoding", "UTF8");
        String encoding = System.getProperty("file.encoding");
        System.out.println(encoding);
        System.out.println(">>>>>>>>>>>>>>>>>>>");

        Map map = System.getenv();
        Iterator it = map.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry entry = (Map.Entry)it.next();
            System.out.print(entry.getKey()+"=");
            System.out.println(entry.getValue());
        }
    }


}
