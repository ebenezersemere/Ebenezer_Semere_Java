package com.company.gamestore.controller;

import com.company.gamestore.model.Shirt;
import com.company.gamestore.repository.ShirtRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ShirtControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ShirtRepository shirtRepo;

    @InjectMocks
    private ShirtController shirtCtrl;

    @Test
    public void testGetShirtById() throws Exception {
        int id = 0;
        Shirt s = new Shirt();
        s.setShirtId(id);
        s.setSize("M");
        s.setColor("Blue");

        when(shirtRepo.findById(id)).thenReturn(java.util.Optional.of(s));

        mockMvc = MockMvcBuilders.standaloneSetup(shirtCtrl).build();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/shirt/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size").value("M"))
                .andExpect(jsonPath("$.color").value("Blue"))
                .andReturn();
    }

    @Test
    public void testCreateShirt() throws Exception {
        int id = 1;
        Shirt s = new Shirt();
        s.setShirtId(id);
        s.setSize("M");
        s.setColor("Blue");

        when(shirtRepo.save(any(Shirt.class))).thenReturn(s);

        mockMvc = MockMvcBuilders.standaloneSetup(shirtCtrl).build();

        String json = "{\"size\":\"M\",\"color\":\"Blue\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/shirt")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size").value("M"))
                .andExpect(jsonPath("$.color").value("Blue"))
                .andReturn();
    }

    @Test
    public void testDeleteShirt() throws Exception {
        int id = 1;

        mockMvc = MockMvcBuilders.standaloneSetup(shirtCtrl).build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/shirt/" + id))
                .andExpect(status().isNoContent())
                .andReturn();
    }

    @Test
    public void testUpdateShirt() throws Exception {
        int id = 1;
        Shirt s = new Shirt();
        s.setShirtId(id);
        s.setSize("M");
        s.setColor("Blue");

        mockMvc = MockMvcBuilders.standaloneSetup(shirtCtrl).build();

        String json = "{\"id\":1,\"size\":\"M\",\"color\":\"Red\"}";

        mockMvc.perform(MockMvcRequestBuilders.put("/shirt/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNoContent())
                .andReturn();
    }
}