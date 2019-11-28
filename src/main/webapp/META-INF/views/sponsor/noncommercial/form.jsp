<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="sponsor.noncommercial.form.label.picture" path="picture"/>
	<acme:form-textbox code="sponsor.noncommercial.form.label.slogan" path="slogan"/>
	<acme:form-textbox code="sponsor.noncommercial.form.label.url" path="url"/>
	<acme:form-integer code="sponsor.noncommercial.form.label.jingle" path="jingle"/>
	
  	<acme:form-return code="sponsor.noncommercial.form.button.return"/>
</acme:form>