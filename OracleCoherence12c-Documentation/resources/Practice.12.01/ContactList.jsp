<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
  <html>
    <head>
      <LINK REL=StyleSheet HREF="../Example.css" TYPE="text/css" MEDIA=all>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Managed Coherence Servers - Contact Demo</title>
    </head>
    <body>
      <img alt="Oracle " src="../Oracle_3d_v3.jpg" align="right" width="216" height="47" >
      <h1>Managed Coherence Servers - Contact Demo</h1>

      <h:outputText value="#{cacheControlBean.init}"></h:outputText>

      <h:form id="form1">
        <p>Current cache size:  <h:outputText value="#{cacheControlBean.cacheSize}"></h:outputText>
        &nbsp;&nbsp;&nbsp;	
        Total cluster size: <h:outputText value="#{cacheControlBean.totalClusterMembers}"></h:outputText>
        &nbsp;&nbsp;&nbsp;	
        Total storage-enabled members: <h:outputText value="#{cacheControlBean.totalStorageEnabledMembers}"></h:outputText>
        <br><br>
        <h:commandButton value="Insert 20 Random Contacts" action="#{cacheControlBean.insertData}" />
        <h:commandButton value="Create Contact" 		   action="#{cacheControlBean.insertContact}" />
        <h:commandButton value="Clear Cache" 			   action="#{cacheControlBean.clearData}"  
     				     rendered="#{cacheControlBean.cacheSize > 0}"/>
      </h:form>
    
    </div>
    <p> 
    <h:form id="tableForm">
      <h:dataTable value="#{contactBean.contact}" var="contact"
	               styleClass="contacts"
	               cellspacing="0"
	               cellpadding="0" 
	               border="0"
	               rowClasses="odd,even"
	               columnClasses="lastName,firstName,workAddress,homeAddress,birthDate,phoneNumbers,actions" >
 
        <h:column>
          <f:facet name="header" >
            <h:outputText value="Last Name"/>
          </f:facet>  
          <h:outputText value="#{contact.lastName}" />
        </h:column> 

        <h:column>
          <f:facet name="header" >
            <h:outputText value="First Name"/>
          </f:facet>  
          <h:outputText value="#{contact.firstName}" />
        </h:column> 

        <h:column>
          <f:facet name="header" >
            <h:outputText value="Work Address"/>
          </f:facet>  
          <h:outputText value="#{contact.workAddress}" />
        </h:column> 
  
        <h:column>
          <f:facet name="header" >
            <h:outputText value="Home Address"/>
          </f:facet>  
          <h:outputText value="#{contact.homeAddress}" />
        </h:column> 
  
        <h:column>
          <f:facet name="header" >
            <h:outputText value="Birth Date"/>
          </f:facet>  
          <h:outputText value="#{contact.birthDate}" >
            <f:convertDateTime type="date" dateStyle="short" pattern="MM/dd/yyyy" />
          </h:outputText>
        </h:column> 
  
        <h:column>
          <f:facet name="header" >
            <h:outputText value="Age"/>
          </f:facet>  
          <h:outputText value="#{contact.age}" />
       </h:column> 
  
       <h:column>
         <f:facet name="header" >
           <h:outputText value="Phone Numbers"/>
         </f:facet>  
         <h:outputText value="#{contact.allPhoneNumbers}" />
       </h:column> 
  
       <h:column>
         <f:facet name="header" >
           <h:outputText value="Actions"/>
         </f:facet>  
         <h:commandLink value="Delete" action="#{cacheControlBean.deleteContact(contact)}" 
                        onclick="if(confirm('Are you sure you want to delete Contact #{contact.firstName} #{contact.lastName}?'))return true; else return false;" />
         &nbsp;
         <h:commandLink value="Update"  action="#{cacheControlBean.updateContact(contact)}" />
       </h:column>

    </h:dataTable>
  </h:form>
</body>
</html>
</f:view>
