package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class Utils {
    public static void doScroll(WebDriver driver, int heightPixel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+heightPixel+")");
    }

    public static JSONObject loadJSONFile(String fileLocation) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileLocation));
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;

    }

    public static int generateRandomNumber(int min,int max){
        return (int) Math.round(Math.random()*(max-min)+min);

    }

    public static void addJsonArray(String firstName, String lastName, String username, String password,String employeeId) throws IOException, ParseException {
        String fileName="./src/test/resources/employee.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONObject userobj=new JSONObject();
        JSONArray jsonArray = (JSONArray) obj;

        userobj.put("firstName",firstName);
        userobj.put("lastName",lastName);
        userobj.put("username",username);
        userobj.put("password",password);
        userobj.put("employeeId",employeeId);
        jsonArray.add(userobj);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }

    public static List readJsondata(String fileName) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        return jsonArray;

    }

    public static void updateJSONList(int index, String employeeId, String employeeId1) throws IOException, ParseException {
        String fileName="./src/test/resources/employee.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;

        JSONObject jsonObject = (JSONObject) jsonArray.get(3);
        jsonObject.put("employeeId", employeeId1);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();

        }




}

