package com.revature.caliber.controllers;

import com.revature.caliber.Application;
import com.revature.caliber.beans.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuestionControllerTest {

	@LocalServerPort
	int port;

	@Test
	public void testGetQuestions() {
		given()
				.port(port)
				.when()
				.get("/question/all")
				.then()
				.statusCode(200);
	}

	@Test
	public void testGetBucketQuestions() {
		given()
				.port(port)
				.when()
				.get("/question/getByBucket/{bucketId}", 404)
				.then()
				.statusCode(200);
	}

	@Test
	public void testDeleteByBucket() {
		given()
				.port(port)
				.when().delete("/question/deleteByBucket/" + 404)
				.then().log().ifError()
				.assertThat().statusCode(204);
	}

	@Test
	public void testCreate() {
		Question question = new Question(99999, null, false, "Test", "Test", "Test", "Test", "Test", "Test");

		given()
				.port(port)
				.contentType("application/json")
				.body(question)
				.when()
				.post("/question/new")
				.then()
				.statusCode(201);
	}

	@Test
	public void testUpdateQuestion() {
		Question question = new Question(1007, null, false, "Test", "Test", "Test", "Test", "Test", "Test");

		given()
				.port(port)
				.contentType("application/json")
				.body(question)
				.when()
				.put("/question/update")
				.then()
				.statusCode(200);
	}

	@Test
	public void testDeleteByQuestionId() {
		int questionId = 1007;

		given()
				.port(port)
				.when()
				.delete("/question/deleteByBucket/{bucketId}", questionId)
				.then()
				.statusCode(204);
	}

	@Test
	public void testActivateQuestion() {
		int questionId = 1007;

		given()
				.port(port)
				.when()
				.put("/question/toggle/" + questionId)
				.then()
				.log()
				.ifError()
				.assertThat()
				.statusCode(204);
	}
}
