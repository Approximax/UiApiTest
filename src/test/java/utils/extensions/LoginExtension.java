package utils.extensions;

import models.LoginResponseModel;
import models.UserLoginModel;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static specs.LoginSpecs.loginRequestSpec;
import static specs.LoginSpecs.loginResponse;
import static com.codeborne.selenide.Selenide.open;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        UserLoginModel userLoginModel = new UserLoginModel();
        userLoginModel.setUserName("test123456");
        userLoginModel.setPassword("Test123456@");

        LoginResponseModel responseModel = given(loginRequestSpec)
                .body(userLoginModel)
                .when()
                .post("/Account/v1/login")
                .then()
                .spec(loginResponse)
                .extract().as(LoginResponseModel.class);

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userId", responseModel.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("token", responseModel.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", responseModel.getExpires()));
    }
}
