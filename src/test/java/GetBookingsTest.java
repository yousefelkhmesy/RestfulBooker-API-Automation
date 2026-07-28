import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetBookingsTest {

    @Test (priority = 1)
    public void getAllBookings() {

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .body("$", instanceOf(List.class));
    }


    @Test (priority = 2)
    public void getBookingById() {

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/1")
                .then()
                .statusCode(200);
    }


    @Test (priority = 3)
    public void createBooking() {

        String requestBody = """
                {
                    "firstname": "Yousef",
                    "lastname": "Mahmoud",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2026-07-28",
                        "checkout": "2026-07-30"
                    },
                    "additionalneeds": "Breakfast"
                }
                """;

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .body("bookingid", notNullValue())
                .body("booking.firstname", equalTo("Yousef"))
                .body("booking.lastname", equalTo("Mahmoud"));
    }


    @Test (priority = 4)
    public void updateBooking() {
        {

            String requestBody = """
            {
                "firstname": "Yousef",
                "lastname": "Updated",
                "totalprice": 500,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2026-07-28",
                    "checkout": "2026-07-30"
                },
                "additionalneeds": "Dinner"
            }
            """;

            given()
                    .pathParam("id", 3705)
                    .contentType("application/json")
                    .header("Cookie", "token=0e67ad83ff98dc3")
                    .body(requestBody)
                    .when()
                    .put("https://restful-booker.herokuapp.com/booking/{id}")
                    .then()
                    .statusCode(200)
                    .body("firstname", equalTo("Yousef"))
                    .body("lastname", equalTo("Updated"));
        }
    }


    @Test (priority = 5)
    public void partialUpdateBooking() {

        String requestBody = """
            {
                "firstname": "Ahmed"
            }
            """;

        given()
                .pathParam("id", 3705)
                .contentType("application/json")
                .header("Cookie", "token=0e67ad83ff98dc3")
                .body(requestBody)

                .when()
                .patch("https://restful-booker.herokuapp.com/booking/{id}")

                .then()
                .statusCode(200)
                .body("firstname", equalTo("Ahmed"));
    }


    @Test (priority = 6)
    public void deleteBooking() {

        given()
                .pathParam("id", 3705)
                .header("Cookie", "token=0e67ad83ff98dc3")

                .when()
                .delete("https://restful-booker.herokuapp.com/booking/{id}")

                .then()
                .statusCode(201);
    }
}