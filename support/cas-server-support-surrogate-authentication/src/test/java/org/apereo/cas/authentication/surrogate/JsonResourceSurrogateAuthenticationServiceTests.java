package org.apereo.cas.authentication.surrogate;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.core.io.ByteArrayResource;

/**
 * This is {@link JsonResourceSurrogateAuthenticationServiceTests}.
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@Getter
@SpringBootTest(classes = {
    RefreshAutoConfiguration.class
})
public class JsonResourceSurrogateAuthenticationServiceTests extends BaseSurrogateAuthenticationServiceTests {
    private static String SURROGATES = "{\"casuser\": [\"jsmith\", \"banderson\"],\"adminuser\": [\"jsmith\", \"tomhanks\"]}";

    private SurrogateAuthenticationService service;

    @Before
    @SneakyThrows
    public void initTests() {
        val resource = new ByteArrayResource(SURROGATES.getBytes());
        service = new JsonResourceSurrogateAuthenticationService(resource, servicesManager);
    }
}
