package com.de.dhbw.ravensburg.myonlineshopdatabase.thymeleafTests;

import com.de.dhbw.ravensburg.myonlineshopdatabase.ManualTestBean;
import com.de.dhbw.ravensburg.myonlineshopdatabase.controller.ThCarController;
import com.de.dhbw.ravensburg.myonlineshopdatabase.controller.ThCarControllerImpl;
import com.de.dhbw.ravensburg.myonlineshopdatabase.service.CarService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;
import static org.springframework.test.web.client.ExpectedCount.times;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = ThCarControllerImpl.class)
public class ThCarControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Autowired
    private ThCarController carController;

    //Nr.2 a)
    @Test
    public void shouldSuccessfullyReturnMainView() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/main"))
                .andExpect(status().isOk())
                .andExpect(view().name("main"));
    }
}
