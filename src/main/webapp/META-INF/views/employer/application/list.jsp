<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="employer.application.list.label.referenceNumber" path="referenceNumber" width="40%"/>
	<acme:list-column code="employer.application.list.label.statement" path="statement" width="30%"/>
	<acme:list-column code="employer.application.list.label.creationMoment" path="creationMoment" width="30%"/>
</acme:list>