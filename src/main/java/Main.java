import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * @author by chengsecret
 * @date 2023/8/25.
 */
public class Main {
    public static void main(String[] args) throws JSchException {
//        //新建会话，此会话用于ssh连接到跳板机（堡垒机）
//        Session session = JschUtil.getSession("10.4.177.56", 22, "anns", "anns706");
//        int portForwardingL = session.setPortForwardingL("127.0.0.1", 0, "10.100.29.62", 22);
//
//        Session session1 = JschUtil.getSession("127.0.0.1", portForwardingL, "zjlab", "xuxiaoliangcgzh");
//
//        // 将内网主机的22端口映射到localhost，我们就可以通过访问http://localhost:22/访问内网服务了
//        JschUtil.bindPort(session1, "koisecret.site", 22, 1022);


        //新建会话，此会话用于ssh连接到跳板机（堡垒机），此处为10.1.1.1:22
        Session session = JschUtil.getSession("10.4.177.56", 22, "anns", "anns706");

        // 将堡垒机保护的内网8080端口映射到localhost，我们就可以通过访问http://localhost:8080/访问内网服务了
        JschUtil.bindPort(session, "10.100.29.62", 22, 1022);

    }
}
