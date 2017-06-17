<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="weblogic.coherence.application.webapp.beans.CacheControlBean" %>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <head>
    <LINK REL=StyleSheet HREF="../Example.css" TYPE="text/css" MEDIA=all>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Contact Details</title>

  </head>
  <body>
    <img alt="Oracle " src="../Oracle_3d_v3.jpg" align="right" width="216" height="47" >
    <h1>Contact Details</h1>
    <f:view>
      <h:form>
      <center>
      <h:panelGrid width="70%" columns="4" border="0"  styleClass="edit" >
      
        <!-- LINE 1 -->
        <h:outputLabel for="lastName" value="Last Name" />
        <h:inputText id="lastName" value="#{contactBean.currentContact.lastName}"
				     maxlength="40" size="40" >		
          <f:validateLength>1</f:validateLength>
        </h:inputText>
        <h:outputText value = "" /> <h:outputText value = "" />
  
        <!-- LINE 2 -->
        <h:outputLabel for="firstName" value="First Name" />
        <h:inputText id="firstName" value="#{contactBean.currentContact.firstName}" 
				     maxlength="40" size="40"  />

        <h:outputText value = "" /> <h:outputText value = "" />

        <!-- LINE 3 -->  
        <h:outputLabel for="birthDate" value="BirthDate" />

        <h:panelGroup id="dateofBirthFormat">
          <h:inputText id="birthDate" value="#{contactBean.currentContact.birthDate}" 
		       		   maxlength="10" size="10"  >
            <f:convertDateTime type="date" dateStyle="short" pattern="MM/dd/yyyy" />
          </h:inputText>
          <h:outputText value = " (mm/dd/yyyy)" />
        </h:panelGroup>
  
        <h:outputText value = "" /> <h:outputText value = "" />  
        <h:outputText value = "" /> <h:outputText value = "" />  
        <h:outputText value = "" /> <h:outputText value = "" />  
  
        <!-- LINE 4 -->  
  
        <h:outputLabel for="workstreet1" value="Work Address" />
        <h:inputText id="workstreet1" value="#{contactBean.currentContact.workAddress.street1}"  
  				     maxlength="40" size="40" />
  
        <h:outputLabel for="workstreet2" value="Address 2" />
        <h:inputText id="workstreet2" value="#{contactBean.currentContact.workAddress.street2}"  
				     maxlength="40" size="40"/>
  
        <!-- LINE 5 -->  
        <h:outputLabel for="workcity" value="City" />
        <h:inputText id="workcity" value="#{contactBean.currentContact.workAddress.city}" 
				     maxlength="40" size="30" />
  
        <h:outputLabel for="workstate" value="State" />
        <h:selectOneMenu id="workState" value="#{contactBean.currentContact.workAddress.state}">
          <f:selectItems value="#{referenceData.stateCodes}" />
        </h:selectOneMenu>
        
        <!-- LINE 6 -->  
        <h:outputLabel for="workzipCode" value="Zip Code" />
        <h:inputText id="workzipCode" value="#{contactBean.currentContact.workAddress.zipCode}"  
		   		     size="10" maxlength="10" />
  
        <h:outputLabel for="workCountry" value="Country" />
        <h:selectOneMenu id="workCountry" value="#{contactBean.currentContact.workAddress.country}">
          <f:selectItems value="#{referenceData.countryCodes}" />
        </h:selectOneMenu>

        <h:outputText value = "" /> <h:outputText value = "" />
        <h:outputText value = "" /> <h:outputText value = "" />  
  
        <!-- LINE 7 -->  
        <h:outputLabel for="street1" value="Home Address" />
        <h:inputText id="street1" value="#{contactBean.currentContact.homeAddress.street1}"
				     maxlength="40"  size="40" />

        <h:outputLabel for="street2" value="Address 2" />
        <h:inputText id="street2" value="#{contactBean.currentContact.homeAddress.street2}" 
				     maxlength="40" size="40"/>
  
        <!-- LINE 8 -->  
        <h:outputLabel for="city" value="City" />
        <h:inputText id="city" value="#{contactBean.currentContact.homeAddress.city}"
				     maxlength="40" size="30"  />

        <h:outputLabel for="state" value="State" />
        <h:selectOneMenu id="state" value="#{contactBean.currentContact.homeAddress.state}">
          <f:selectItems value="#{referenceData.stateCodes}" />
        </h:selectOneMenu>

        <!-- LINE 9 -->  
        <h:outputLabel for="zipCode" value="Zip Code" />
        <h:inputText id="zipCode" value="#{contactBean.currentContact.homeAddress.zipCode}" 
				     size="10" maxlength="10" />
  
        <h:outputLabel for="homeCountry" value="Country" />
        <h:selectOneMenu id="homeCountry" value="#{contactBean.currentContact.homeAddress.country}">
          <f:selectItems value="#{referenceData.countryCodes}" />
        </h:selectOneMenu>
 
        <h:outputText value = "" /> <h:outputText value = "" />  
        <h:outputText value = "" /> <h:outputText value = "" />  
  
        <!-- LINE 10 -->  
        <h:outputLabel for="workAccessCode" value="Work Phone" />  
        <h:panelGroup id="workPhone">
          <h:inputText id="workAccessCode"  value="#{contactBean.currentContact.workPhone.accessCode}"  size="3" maxlength="3" />
          <h:inputText id="workCountryCode" value="#{contactBean.currentContact.workPhone.countryCode}" size="5" maxlength="5" />
          <h:inputText id="workAreaCode"    value="#{contactBean.currentContact.workPhone.areaCode}"    size="5" maxlength="5" />
          <h:inputText id="workLocalNumber" value="#{contactBean.currentContact.workPhone.localNumber}" size="12" maxlength="12" />
        </h:panelGroup>
   
        <h:outputText value = "" />   <h:outputText value = "(Access code) (Country Code) (Area Code) (Number)" />  
     
        <!-- LINE 11 -->       
        <h:outputLabel for="homeAccessCode" value="Home Phone" />  
        <h:panelGroup id="homePhone">
          <h:inputText id="homeAccessCode"  value="#{contactBean.currentContact.homePhone.accessCode}"  size="3" maxlength="3" />
          <h:inputText id="homeCountryCode" value="#{contactBean.currentContact.homePhone.countryCode}" size="5" maxlength="5" />
          <h:inputText id="homeAreaCode"    value="#{contactBean.currentContact.homePhone.areaCode}"    size="5" maxlength="5" />
          <h:inputText id="homeLocalNumber" value="#{contactBean.currentContact.homePhone.localNumber}" size="12" maxlength="12" />
       </h:panelGroup>

      <h:outputText value = "" />   <h:outputText value = "" />

      <!-- LINE 12 -->  
      <h:outputLabel for="cellAccessCode" value="Cell Phone" />  
      <h:panelGroup>
        <h:inputText id="cellAccessCode"  value="#{contactBean.currentContact.cellPhone.accessCode}"  size="3" maxlength="3" />
        <h:inputText id="cellCountryCode" value="#{contactBean.currentContact.cellPhone.countryCode}" size="5" maxlength="5" />
        <h:inputText id="cellAreaCode"    value="#{contactBean.currentContact.cellPhone.areaCode}"    size="5" maxlength="5" />
        <h:inputText id="cellLocalNumber" value="#{contactBean.currentContact.cellPhone.localNumber}" size="12" maxlength="12" />
      </h:panelGroup>
   
      <h:outputText value = "" />   <h:outputText value = "" />
 
      <f:facet name="footer">
        <h:panelGroup style="display:block; text-align:center">
          <h:commandButton id="submit" value = "Save" action="#{cacheControlBean.saveOrInsert}" />
          <h:commandButton             value="Cancel" action="#{cacheControlBean.cancelEdit}" 
      		onclick="if (!confirm('You will lose all changes made. Are you sure?')) return false" />
        </h:panelGroup>
      </f:facet>
    </h:panelGrid>
    </center>
    
    <h:messages id="msg1" 
	            errorStyle="color:red;font-family: Arial, Verdana, sans-serif;font-size:12px;font-weight:bold;"
	            infoStyle="color:blue;font-family: Arial, Verdana, sans-serif;font-size:12px;font-weight:bold;" 
	            layout="table"
	            showDetail="true" />
  </h:form>
  
  </f:view>
</body>
</html>
