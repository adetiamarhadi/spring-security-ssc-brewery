package com.github.adetiamarhadi.springsecuritysscbrewery.web.controllers;

import com.github.adetiamarhadi.springsecuritysscbrewery.repositories.BeerInventoryRepository;
import com.github.adetiamarhadi.springsecuritysscbrewery.repositories.BeerRepository;
import com.github.adetiamarhadi.springsecuritysscbrewery.repositories.CustomerRepository;
import com.github.adetiamarhadi.springsecuritysscbrewery.services.BeerService;
import com.github.adetiamarhadi.springsecuritysscbrewery.services.BreweryService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

public abstract class BaseIT {
    @Autowired
    WebApplicationContext wac;

    protected MockMvc mockMvc;

    @MockBean
    BeerRepository beerRepository;

    @MockBean
    BeerInventoryRepository beerInventoryRepository;

    @MockBean
    BreweryService breweryService;

    @MockBean
    CustomerRepository customerRepository;

    @MockBean
    BeerService beerService;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .apply(springSecurity())
                .build();
    }
}
