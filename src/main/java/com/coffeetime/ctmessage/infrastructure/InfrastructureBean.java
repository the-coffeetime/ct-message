package com.coffeetime.ctmessage.infrastructure;

import com.coffeetime.ctmessage.infrastructure.persistent.rdbms.property.RdbmsProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InfrastructureBean {

    // TODO : Use Etcd
    @Configuration
    public static class RdbmsDBRepository {
        public RdbmsProperty getDatabaseProperties(String rdsConnectionInfoPath) throws IOException {
            List<String> lines = Files.readAllLines(Paths.get(rdsConnectionInfoPath));
            if (lines.size() < 4) throw new IllegalArgumentException("Configuration file is invalid.");

            return new RdbmsProperty(
                    "jdbc:mariadb://${lines[0]}:${lines[1]}/user?useUnicode=true&characterEncoding=utf-8",
                    lines.get(2),
                    lines.get(3),
                    "org.mariadb.jdbc.Driver"
            );
        }
        @Bean
        @ConfigurationProperties(prefix = "spring.datasource")
        public DataSource dataSource() throws IOException {
            // 로컬 파일 경로 지정
            String rdsConnectionInfoPath = "D:\\aws_rds_access_info.txt";

            // DB 연결 정보 로드
            RdbmsProperty properties = getDatabaseProperties(rdsConnectionInfoPath);

            // HikariDataSource 구성
            return DataSourceBuilder.create()
                    .url(properties.url())
                    .username(properties.username())
                    .password(properties.password())
                    .build();
        }
    }
}
