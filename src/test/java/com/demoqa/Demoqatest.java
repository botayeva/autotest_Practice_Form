package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Demoqatest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Ravi");
        $("#lastName").setValue("Satha");
        $("#userEmail").setValue("ravi.satha@test.com");
        $("#genterWrapper").$(byText("Male"));
        $("#userNumber").setValue("8900800908");
        $("#dateOfBirthInput").click();
        $("#dateOfBirth-wrapper").$(byText("2003")).click();
        $("#dateOfBirth-wrapper").$(byText("March")).click();
        $("#dateOfBirth-wrapper").$(byText("16")).click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("pic.png")
        $("#currentAddress").setValue("Example adress");
        $("#stateCity-wrapper").$("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

    }
}