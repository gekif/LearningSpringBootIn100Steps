package com.gekif.springboot.controller;

import com.gekif.springboot.model.Question;
import com.gekif.springboot.service.SurveyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@WebMvcTest(SurveyController.class)
public class SurveyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyService surveyService;


    @Test
    public void retrieveDetailsForQuestion() throws Exception {
        Question mockQuestion = new Question("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));

        // When
        Mockito.when(
                surveyService.retrieveQuestion(Mockito.anyString(),
                        Mockito.anyString())).thenReturn(mockQuestion);

        // Make A Call Service
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/surveys/Survey1/questions/Question1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result =  mockMvc.perform(requestBuilder).andReturn();
        String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia}";

        // Assert
        JSONAssert.assertEquals(
                expected,
                result.getResponse().getContentAsString(),
                false);

    }

}
