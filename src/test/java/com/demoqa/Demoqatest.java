package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
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
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8900800908");
        $("#dateOfBirthInput").click();
        $("#dateOfBirth-wrapper").$(byText("2003")).click();
        $("#dateOfBirth-wrapper").$(byText("March")).click();
        $("#dateOfBirth-wrapper").$(byText("16")).click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("pic.png");
        $("#currentAddress").setValue("Example address");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();


        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Ravi Satha"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("ravi.satha@test.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8900800908"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("16 March,2003"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Biology"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("pic.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Example address"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));


    }
}