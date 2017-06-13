package cn.jasframework.file.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "cn.jasframework.file.manage")
@EnableSwagger2 // 使客户端和文件系统作为服务器以同样的速度来更新
@Configuration
public class FileManageApplication {

	public static void main(String args[]) {
		SpringApplication.run(FileManageApplication.class, args);
	}

}
