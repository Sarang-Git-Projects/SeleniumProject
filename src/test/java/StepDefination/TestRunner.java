package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

///the below two tags will only run when we import cucumber JUNIT and CUCUMBER JVM JUNIT dependencies from maven
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefination"},
plugin = {"pretty","junit:target/JunitReport/junitReprot.xml",
		"json:target/JSONReports/report.json",
		"html:target/HtmlReports/report.html"},
tags="@test2"
		)

public class TestRunner {

	
}
