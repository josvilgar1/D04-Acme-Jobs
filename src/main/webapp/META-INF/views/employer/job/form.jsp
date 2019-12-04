<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="employer.job.form.label.title" path="title"/>
	<acme:form-moment code="employer.job.form.label.deadline" path="moment"/>
	<acme:form-money code="employer.job.form.label.salary" path="salary"/>
	<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="employer.job.form.label.description" path="description"/>
	<acme:form-checkbox code="employer.job.form.label.finalmode" path="finalMode"/>
	
  	<acme:form-submit 
		method="get" 
		code="employer.job.form.button.duty" 
		action="/employer/duty/list?id=${id}"/>
	<acme:form-submit 
		method="get" 
		code="employer.job.form.button.auditrecord" 
		action="/employer/auditrecord/list-by-job?id=${id}"/>
  	<acme:form-return code="employer.job.form.button.return"/>
</acme:form>
