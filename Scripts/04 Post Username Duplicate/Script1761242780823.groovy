import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper

def responseGetAll = WS.sendRequest(findTestObject('Final Project/01 GET Users All'))

def jsonResponse = new JsonSlurper().parseText(responseGetAll.getResponseText())

assert jsonResponse.size() > 0 : 'Tidak ada data user!'

def lastUser = jsonResponse.max({ 
        it.id
    })

def lastUserName = lastUser.username

def username = lastUserName

def response = WS.sendRequest(findTestObject('Final Project/03 POST User'))

WS.verifyResponseStatusCode(response, 409)

def json = new JsonSlurper().parseText(response.getResponseText())

def messageDuplicate = json.message

WS.verifyElementPropertyValue(response, 'message', messageDuplicate)

