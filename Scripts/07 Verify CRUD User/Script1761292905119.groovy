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

//Step POST
def txtRandom = generateRandomString(3)

def usernameRandom = 'felia.' + txtRandom

def responsePOST = WS.sendRequest(findTestObject('Final Project/03 POST User', [('first_name') : 'Felia', ('last_name') : 'Anjani'
            , ('username') : usernameRandom, ('job_position') : 'Software Quality Assurance', ('job_level') : 'Junior', ('salary') : '9000000'
            , ('work_duration') : '1']))

WS.verifyResponseStatusCode(responsePOST, 201)

def val_id = WS.getElementPropertyValue(responsePOST, '[0].id')

def val_firstName = WS.getElementPropertyValue(responsePOST, '[0].first_name')

def val_lastName = WS.getElementPropertyValue(responsePOST, '[0].last_name')

def val_username = WS.getElementPropertyValue(responsePOST, '[0].username')

def val_job_pos = WS.getElementPropertyValue(responsePOST, '[0].job_position')

def val_job_lv = WS.getElementPropertyValue(responsePOST, '[0].job_level')

def val_salary = WS.getElementPropertyValue(responsePOST, '[0].salary')

def val_work_dur = WS.getElementPropertyValue(responsePOST, '[0].work_duration')

WS.verifyElementPropertyValue(responsePOST, '[0].id', val_id)

WS.verifyElementPropertyValue(responsePOST, '[0].first_name', val_firstName)

WS.verifyElementPropertyValue(responsePOST, '[0].last_name', val_lastName)

WS.verifyElementPropertyValue(responsePOST, '[0].username', val_username)

WS.verifyElementPropertyValue(responsePOST, '[0].job_position', val_job_pos)

WS.verifyElementPropertyValue(responsePOST, '[0].job_level', val_job_lv)

WS.verifyElementPropertyValue(responsePOST, '[0].salary', val_salary)

WS.verifyElementPropertyValue(responsePOST, '[0].work_duration', val_work_dur)

//Step POST Username Duplicate
println(val_username)

println(val_id)

def responsePOSTduplicate = WS.sendRequest(findTestObject('Final Project/03 POST User', [('first_name') : 'Felia', ('last_name') : 'Anjani'
            , ('username') : val_username, ('job_position') : 'Software Quality Assurance', ('job_level') : 'Junior', ('salary') : '9000000'
            , ('work_duration') : '1']))

WS.verifyResponseStatusCode(responsePOSTduplicate, 409)

def json = new JsonSlurper().parseText(responsePOSTduplicate.getResponseText())

def messageDuplicate = json.message

WS.verifyElementPropertyValue(responsePOSTduplicate, 'message', messageDuplicate)

//Step Get User By Username
def responseGETbyUsername = WS.sendRequest(findTestObject('Final Project/02 GET User By Username', [('username') : val_username]))

WS.verifyResponseStatusCode(responseGETbyUsername, 200)

def idUser = WS.getElementPropertyValue(responseGETbyUsername, '[0].id')

def firstName = WS.getElementPropertyValue(responseGETbyUsername, '[0].first_name')

def lastName = WS.getElementPropertyValue(responseGETbyUsername, '[0].last_name')

WS.verifyElementPropertyValue(responseGETbyUsername, '[0].id', idUser)

WS.verifyElementPropertyValue(responseGETbyUsername, '[0].first_name', firstName)

WS.verifyElementPropertyValue(responseGETbyUsername, '[0].last_name', lastName)

//Step Patch User
def responsePATCH = WS.sendRequest(findTestObject('Final Project/05 PATCH User', [('first_name') : 'Felia Updated', ('last_name') : 'Anjani Updated'
            , ('username') : val_username]))

WS.verifyResponseStatusCode(responsePATCH, 200)

def val_idUpdate = WS.getElementPropertyValue(responsePATCH, '[0].id')

def val_usernameUpdate = WS.getElementPropertyValue(responsePATCH, '[0].username')

def val_firstNameUpdate = WS.getElementPropertyValue(responsePATCH, '[0].first_name')

def val_lastNameUpdate = WS.getElementPropertyValue(responsePATCH, '[0].last_name')

WS.verifyElementPropertyValue(responsePATCH, '[0].id', val_idUpdate)

WS.verifyElementPropertyValue(responsePATCH, '[0].username', val_usernameUpdate)

WS.verifyElementPropertyValue(responsePATCH, '[0].first_name', val_firstNameUpdate)

WS.verifyElementPropertyValue(responsePATCH, '[0].last_name', val_lastNameUpdate)

//Step Get User Update
def responseGET_userUpdate = WS.sendRequest(findTestObject('Final Project/02 GET User By Username', [('username') : val_usernameUpdate]))

WS.verifyResponseStatusCode(responseGET_userUpdate, 200)

def user_usernameUpdate = WS.getElementPropertyValue(responseGET_userUpdate, '[0].username')

def user_firstNameUpdate = WS.getElementPropertyValue(responseGET_userUpdate, '[0].first_name')

def user_lastNameUpdate = WS.getElementPropertyValue(responseGET_userUpdate, '[0].last_name')

println('User yg sudah Update: ' + user_usernameUpdate)

println('User yg sudah Update: ' + user_firstNameUpdate)

println('User yg sudah Update: ' + user_lastNameUpdate)

WS.verifyElementPropertyValue(responseGET_userUpdate, '[0].username', user_usernameUpdate)

WS.verifyElementPropertyValue(responseGET_userUpdate, '[0].first_name', user_firstNameUpdate)

WS.verifyElementPropertyValue(responseGET_userUpdate, '[0].last_name', user_lastNameUpdate)

//Step Delete User
def responseDELETE = WS.sendRequest(findTestObject('Final Project/06 DELETE User', [('username') : user_usernameUpdate]))

WS.verifyResponseStatusCode(responseDELETE, 204)

//Step Get User ALL
def responseGETall = WS.sendRequest(findTestObject('Final Project/01 GET Users All'))

WS.verifyResponseStatusCode(responseGETall, 200)

def Get_idUser = WS.getElementPropertyValue(responseGETall, '[0].id')

def Get_first_name = WS.getElementPropertyValue(responseGETall, '[0].first_name')

def Get_last_name = WS.getElementPropertyValue(responseGETall, '[0].last_name')

def Get_username = WS.getElementPropertyValue(responseGETall, '[0].username')

def Get_job_position = WS.getElementPropertyValue(responseGETall, '[0].job_position')

def Get_job_level = WS.getElementPropertyValue(responseGETall, '[0].job_level')

def Get_salary = WS.getElementPropertyValue(responseGETall, '[0].salary')

def Get_work_duration = WS.getElementPropertyValue(responseGETall, '[0].work_duration')

WS.verifyElementPropertyValue(responseGETall, '[0].id', Get_idUser)

WS.verifyElementPropertyValue(responseGETall, '[0].first_name', Get_first_name)

WS.verifyElementPropertyValue(responseGETall, '[0].last_name', Get_last_name)

WS.verifyElementPropertyValue(responseGETall, '[0].username', Get_username)

WS.verifyElementPropertyValue(responseGETall, '[0].job_position', Get_job_position)

WS.verifyElementPropertyValue(responseGETall, '[0].job_level', Get_job_level)

WS.verifyElementPropertyValue(responseGETall, '[0].salary', Get_salary)

WS.verifyElementPropertyValue(responseGETall, '[0].work_duration', Get_work_duration)

def generateRandomString(int length) {
    def charPool = ((('a'..'z') + '0-9a-f') + ('0'..'9')).join()

    def random = new Random()

    return (1..length).collect({ 
            charPool[random.nextInt(charPool.length())]
        }).join()
}

