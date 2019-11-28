<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="sponsor.commercial.form.label.picture" path="picture"/>
	<acme:form-textbox code="sponsor.commercial.form.label.slogan" path="slogan"/>
	<acme:form-textbox code="sponsor.commercial.form.label.url" path="url"/>
	<acme:form-integer code="sponsor.commercial.form.label.creditCardMonth" path="creditCardMonth"/>
	<acme:form-integer code="sponsor.commercial.form.label.creditCardYear" path="creditCardYear"/>
	<acme:form-textbox code="sponsor.commercial.form.label.creditCardName" path="creditCardName"/>
	<acme:form-textbox code="sponsor.commercial.form.label.creditCardNumber" path="creditCardNumber"/>
	<acme:form-textbox code="sponsor.commercial.form.label.creditCardType" path="creditCardType"/>
	
  	<acme:form-return code="sponsor.commercial.form.button.return"/>
</acme:form>
