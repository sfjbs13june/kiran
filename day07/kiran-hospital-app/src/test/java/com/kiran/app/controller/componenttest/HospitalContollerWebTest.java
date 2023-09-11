package com.kiran.app.controller.componenttest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kiran.app.controller.HosController;
import com.kiran.app.model.Hospital;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({HosController.class})
@ActiveProfiles(value = "test")
public class HospitalContollerWebTest {
    @Autowired
    private MockMvc mockMvc;

    @Value("${student.create.url}")
    String create_url;
    @Value("${student.read.url}")
    String read_url;
    @Value("${student.update.url}")
    String update_url;
    @Value("${student.delete.url}")
    String delete_url;


    @Test
    public void test_createStudent() throws Exception {
        Hospital hospital = new Hospital("stud1", "123", 12);
        ResultActions resultActions=mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("stud1",result.getHname());
        assertEquals("123",result.getAddress());
        assertEquals(12,result.getId());
    }

    @Test
    public void test_readeStudent() throws Exception {
        Hospital hospital = new Hospital("stud1", "123", 12);
        ResultActions resultActions_create=mockMvc.perform(post("/create").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(get("/read").param("name","stud1").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("stud1",result.getHname());
        assertEquals("123",result.getAddress());

        assertEquals(12,result.getId());
    }

    @Test
    public void test_updateStudent() throws Exception {
        Hospital hospital = new Hospital("stud1", "123", 12);
        ResultActions resultActions_create=mockMvc.perform(post("/create").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(put("/update")
                .param("name","stud1")
                .param("age","13")
                .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals("stud1",result.getHname());
        assertEquals("123",result.getAddress());
        assertEquals(13,result.getId());

    }

    @Test
    public void test_deleteStudent() {

    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
