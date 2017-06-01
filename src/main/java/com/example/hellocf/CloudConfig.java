package com.example.hellocf;

import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
 * AbstractCloudConigクラスを継承して、spring cloud connectorを使うための設定を
 * JavaConfigクラスで行う。
 * Spring Cloud Connector は、以下のサービスがバインドされた場合の設定に対応している。
 * 詳細：http://cloud.spring.io/spring-cloud-connectors/spring-cloud-spring-service-connector.html
 * RabbitMQ
 * Relational database (DB2, MySQL, Oracle, PostgreSQL, SQL Server)
 * MongoDB
 * Redis
 * SMTP
 * 
 * @Profile は、指定のプロファイルでのみ有効になるコンフィグということ。
 */
@Configuration
@Profile("cloud")
public class CloudConfig extends AbstractCloudConfig {
	
	@Bean
	DataSource dataSource() {
		// AbstractCloudConfigを継承することで、connectionFactory()メソッドが使える。
		// これを使って、DataSourceオブジェクトを作成する。
		// すると、バインドされたサービスインスタンスを認識してDataSourceオブジェクトが作成される。
		return connectionFactory().dataSource();
	}

}
