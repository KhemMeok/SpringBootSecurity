package project_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) //mongod
@SpringBootApplication
public class ProjectApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjectApiApplication.class, args);
	}
}
