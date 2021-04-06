package io.portfolio.application.controller;

import io.portfolio.application.service.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDetailsService service;

    @MockBean
    private ClientService clientService;

    @MockBean
    private CountryService countryService;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private LocationService locationService;

    @MockBean
    private StateService stateService;


    @Test
    void indexTest() throws Exception {
        String URI = "/";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }

    @Test
    void error404Test() throws Exception {
        String URI = "/404";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }

    @Test
    void loginTest() throws Exception {
        String URI = "/login";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }



}
