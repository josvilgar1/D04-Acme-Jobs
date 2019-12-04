<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.application.form.lable.referenceNumber" path="referenceNumber"/>
	<acme:form-moment code="employer.application.form.lable.creationMoment" path="creationMoment"/>
	<acme:form-textbox code="employer.application.form.lable.statement" path="statement"/>
	<acme:form-textbox code="employer.application.form.lable.skills" path="skills"/>
	<acme:form-textbox code="employer.application.form.lable.qualifications" path="qualifications"/>
  	
  	<acme:form-submit 
		method="get" 
		code="employer.application.form.button.job" 
		action="/employer/job/show?id=${job.id}"/>
  	<acme:form-return code="employer.application.form.button.return"/>
</acme:form>
