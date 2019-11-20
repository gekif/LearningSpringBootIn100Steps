package com.gekif.springboot.controller;

import com.gekif.springboot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {


    @LocalServerPort
    private int port;


    /*@Test
    public void testJsonAssert() {
        String expect = "{id: 2, role: Admin}";
        String actual = "{id: 2, name:Ranga, role: Admin}";

        JSONAssert.assertEquals(expect, actual,  false);
    }
*/

    @Test
    public void testRetrieveSurveyQuestion() {

        String url = "http://localhost:" + port + "/surveys/Survey1/questions/Question1";

        TestRestTemplate restTemplate = new TestRestTemplate();

//        String output = restTemplate.getForObject(url, String.class);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Response:  " + response.getBody());

        assertTrue(response.getBody().contains("\"id\":\"Question1\""));
        assertTrue(response.getBody().contains("\"description\":\"Largest Country in the World\""));

        String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia}";
        JSONAssert.assertEquals(expected, response.getBody(), false);

    }


}
