package com.selectors.test;

import com.selectors.test.configuration.PostgresInitializer;
import com.selectors.test.util.IntegrationTestRepoHelper;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(initializers = {PostgresInitializer.class})
@Sql(scripts = "/sql-scripts/clean-tables.sql",
        executionPhase = AFTER_TEST_METHOD,
        config = @SqlConfig(encoding = "UTF8"))
public class BaseIntegrationTest extends IntegrationTestRepoHelper {

}
