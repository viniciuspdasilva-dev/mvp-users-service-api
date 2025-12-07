package io.git.mvp.mvp_users_service_api;

import org.springframework.boot.SpringApplication;

public class TestMvpUsersServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(MvpUsersServiceApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
