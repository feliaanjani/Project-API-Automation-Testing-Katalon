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

def response = WS.sendRequest(findTestObject('Final Project/01 GET Users All'))

WS.verifyResponseStatusCode(response, 200)

def idUser = WS.getElementPropertyValue(response, '[0].id')
def first_name = WS.getElementPropertyValue(response, '[0].first_name')
def last_name = WS.getElementPropertyValue(response, '[0].last_name')
def username = WS.getElementPropertyValue(response, '[0].username')
def job_position = WS.getElementPropertyValue(response, '[0].job_position')
def job_level = WS.getElementPropertyValue(response, '[0].job_level')
def salary = WS.getElementPropertyValue(response, '[0].salary')
def work_duration = WS.getElementPropertyValue(response, '[0].work_duration')


WS.verifyElementPropertyValue(response, '[0].id', idUser)
WS.verifyElementPropertyValue(response, '[0].first_name', first_name)
WS.verifyElementPropertyValue(response, '[0].last_name', last_name)
WS.verifyElementPropertyValue(response, '[0].username', username)
WS.verifyElementPropertyValue(response, '[0].job_position', job_position)
WS.verifyElementPropertyValue(response, '[0].job_level', job_level)
WS.verifyElementPropertyValue(response, '[0].salary', salary)