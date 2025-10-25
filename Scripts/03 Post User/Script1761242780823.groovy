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

def txtRandom = generateRandomString(3)

def usernameRandom = 'felia.' + txtRandom

def response = WS.sendRequest(findTestObject('Final Project/03 POST User', [('first_name') : 'Felia', ('last_name') : 'Anjani'
            , ('username') : usernameRandom, ('job_position') : 'Software Quality Assurance', ('job_level') : 'Junior', ('salary') : '9000000'
            , ('work_duration') : '1']))

WS.verifyResponseStatusCode(response, 201)
println(usernameRandom)

def val_id = WS.getElementPropertyValue(response, '[0].id')

println(val_id) 
def val_firstName = WS.getElementPropertyValue(response, '[0].first_name')

def val_lastName = WS.getElementPropertyValue(response, '[0].last_name')

def val_username = WS.getElementPropertyValue(response, '[0].username')

def val_job_pos = WS.getElementPropertyValue(response, '[0].job_position')

def val_job_lv = WS.getElementPropertyValue(response, '[0].job_level')

def val_salary = WS.getElementPropertyValue(response, '[0].salary')

def val_work_dur = WS.getElementPropertyValue(response, '[0].work_duration')

WS.verifyElementPropertyValue(response, '[0].id', val_id)

WS.verifyElementPropertyValue(response, '[0].first_name', val_firstName)

WS.verifyElementPropertyValue(response, '[0].last_name', val_lastName)

WS.verifyElementPropertyValue(response, '[0].username', val_username)

WS.verifyElementPropertyValue(response, '[0].job_position', val_job_pos)

WS.verifyElementPropertyValue(response, '[0].job_level', val_job_lv)

WS.verifyElementPropertyValue(response, '[0].salary', val_salary)

WS.verifyElementPropertyValue(response, '[0].work_duration', val_work_dur)

def generateRandomString(int length) {
    def charPool = ((('a'..'z') + '0-9a-f') + ('0'..'9')).join()

    def random = new Random()

    return (1..length).collect({ 
            charPool[random.nextInt(charPool.length())]
        }).join()
}

