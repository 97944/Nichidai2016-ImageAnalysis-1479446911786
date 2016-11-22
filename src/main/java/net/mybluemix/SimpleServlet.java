package net.mybluemix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/**
 * �N���N���X�ł��B
 */
@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SimpleServlet extends SpringBootServletInitializer {
    /**
     * ���������s���܂��B
     * @param args ����
     * @throws Exception ��O�����������ꍇ
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SimpleServlet.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SimpleServlet.class);
    }
}