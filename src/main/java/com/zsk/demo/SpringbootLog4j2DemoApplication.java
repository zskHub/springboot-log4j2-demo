package com.zsk.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;


@Slf4j
@SpringBootApplication
public class SpringbootLog4j2DemoApplication {

    public static void main(String[] args) throws UnknownHostException {
        main(SpringbootLog4j2DemoApplication.class, args);
    }

    public static void main(Class<?> clazz, String[] args) throws UnknownHostException {
        if (null != clazz){
            String appName = clazz.getName();
            appName = appName.substring(appName.lastIndexOf(".") + 1);
            appName = appName.replace("Application", "").toLowerCase();
            System.setProperty("applicationName", appName);
        }
        ConfigurableApplicationContext application = new SpringApplicationBuilder(clazz)
                .initializers((ConfigurableApplicationContext appplicaionContext) -> {
                    System.setProperty("port", appplicaionContext.getEnvironment().getProperty("server.port"));
                    System.setProperty("ip", getLinuxLocalIp());
                })
                .run(args);
        Environment env = application.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "应用 '{}' 运行成功! 访问连接:\n\t" +
                        "Swagger文档: \t\thttp://{}:{}/doc.html\n\t" +
                        "数据库监控: \t\thttp://{}:{}/druid\n\t" +
                        "日志文件夹名称: \t\t{}\n" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port", "8080"),
                "127.0.0.1",
                env.getProperty("server.port", "8080")
                ,System.getProperty("applicationName"));
    }

    private static String getLinuxLocalIp() {
        String ip = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipaddress = inetAddress.getHostAddress().toString();
                            if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                                ip = ipaddress;
                            }
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            ip = "127.0.0.1";
            ex.printStackTrace();
        }
        return ip;
    }

}
