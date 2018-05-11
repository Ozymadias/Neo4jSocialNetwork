package com.network.social.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("com.network.social.neo4j.repositories")
public class SampleMovieApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleMovieApplication.class, args);
    }
}