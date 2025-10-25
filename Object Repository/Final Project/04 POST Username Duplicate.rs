<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>04 POST Username Duplicate</name>
   <tag></tag>
   <elementGuidId>9e502669-8adf-487a-8a7b-b557404368a1</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>true</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;contentType&quot;: &quot;application/x-www-form-urlencoded&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;,
  &quot;parameters&quot;: [
    {
      &quot;name&quot;: &quot;first_name&quot;,
      &quot;value&quot;: &quot;${first_name}&quot;
    },
    {
      &quot;name&quot;: &quot;last_name&quot;,
      &quot;value&quot;: &quot;${last_name}&quot;
    },
    {
      &quot;name&quot;: &quot;username&quot;,
      &quot;value&quot;: &quot;${username}&quot;
    },
    {
      &quot;name&quot;: &quot;job_position&quot;,
      &quot;value&quot;: &quot;${job_position}&quot;
    },
    {
      &quot;name&quot;: &quot;job_level&quot;,
      &quot;value&quot;: &quot;${job_level}&quot;
    },
    {
      &quot;name&quot;: &quot;salary&quot;,
      &quot;value&quot;: &quot;${salary}&quot;
    },
    {
      &quot;name&quot;: &quot;work_duration&quot;,
      &quot;value&quot;: &quot;${work_duration}&quot;
    }
  ]
}</httpBodyContent>
   <httpBodyType>x-www-form-urlencoded</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>apikey</name>
      <type>Main</type>
      <value>${GlobalVariable.apikey}</value>
      <webElementGuid>45bcb678-68da-4ff8-8087-69be8ce0e0cb</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.auth}</value>
      <webElementGuid>83c48b02-a7fd-4cb7-beb9-af7658e62dfc</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/x-www-form-urlencoded</value>
      <webElementGuid>2bb01361-0f0d-4ba5-8c2b-ab483cdac3ac</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Prefer</name>
      <type>Main</type>
      <value>${GlobalVariable.pref}</value>
      <webElementGuid>3986a382-bb95-4422-bd27-1d4418fd1b1f</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>10.3.1</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.BaseURL}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <validationSteps>
      <id>712b3ecd-4b5b-478f-92d2-ce5f03aa113e</id>
      <name>PostUserDuplicate</name>
      <type>JSON_SCHEMA</type>
      <dataType>FILE</dataType>
      <target>RESPONSE</target>
      <data>Resource/PostUserDuplicate.txt</data>
      <activate>true</activate>
   </validationSteps>
   <variables>
      <defaultValue>'Felia'</defaultValue>
      <description></description>
      <id>8bd4fd5a-07ae-4310-ae2c-96e1db4838ad</id>
      <masked>false</masked>
      <name>first_name</name>
   </variables>
   <variables>
      <defaultValue>'Anjani'</defaultValue>
      <description></description>
      <id>451c36b1-ecbb-4da9-a605-bc525a2dbcbd</id>
      <masked>false</masked>
      <name>last_name</name>
   </variables>
   <variables>
      <defaultValue>'felia234'</defaultValue>
      <description></description>
      <id>1454d203-92cb-43fa-a719-745226b59a92</id>
      <masked>false</masked>
      <name>username</name>
   </variables>
   <variables>
      <defaultValue>'Software Quality Assurance'</defaultValue>
      <description></description>
      <id>22d46770-bb26-4a66-80f9-dabc6e8f5c83</id>
      <masked>false</masked>
      <name>job_position</name>
   </variables>
   <variables>
      <defaultValue>'Junior'</defaultValue>
      <description></description>
      <id>a5f63d21-e045-4e7f-a4e2-a67d243eb2b1</id>
      <masked>false</masked>
      <name>job_level</name>
   </variables>
   <variables>
      <defaultValue>'9000000'</defaultValue>
      <description></description>
      <id>86929a6a-f315-4294-b284-a1148086d027</id>
      <masked>false</masked>
      <name>salary</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>a46bdc35-8c62-4f1e-b9dd-de00a5c928fa</id>
      <masked>false</masked>
      <name>work_duration</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()


WS.verifyResponseStatusCode(response, 409)

assertThat(response.getStatusCode()).isEqualTo(409)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
