package com.example.cardatabase;

import com.example.cardatabase.domain.Owner;
import com.example.cardatabase.domain.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.
        request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.
        servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.
        servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.
        Autowired;
import org.springframework.boot.test.autoconfigure.
        web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.
        SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

@DataJpaTest
public class OwnerRepositoryTest {
    @Autowired
    private OwnerRepository repository;



    @Test
    void saveOwner(){
        repository.save(new Owner("Lucy","Smith"));
        assertThat(repository.findByFirstname("Lucy").isPresent()).isTrue();
    }

    @Test
    void deleteOwners(){
        repository.save(new Owner("Lisa","Morrison"));
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }
}


@SpringBootTest
class Cartest{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAuthentication() throws Exception {
        // Testing authentication with correct credentials
        this.mockMvc.
                perform(post("/login").
                        content("{\"username\":\"admin\",\"password\":\"admin\"}").
                        header(HttpHeaders.CONTENT_TYPE,
                                "application/json")).
                andDo(print()).andExpect(status().isOk());
    }
}
