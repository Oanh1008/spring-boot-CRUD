package com.example.connectmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ConnectMySqlApplication implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
        SpringApplication.run(ConnectMySqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql="insert into loaihang (MaLH,TenLH) values (?,?)";
        int rs=jdbcTemplate.update(sql,1,"Candy");
        if(rs>0){
            System.out.println("A new row has been inserted");
        }

    }
}
