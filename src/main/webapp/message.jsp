<!-- To display information message in Web page -->

<%
String errorMessage = request.getParameter("errorMessage");

if (errorMessage != null) {
	out.println("<p><strong>" + errorMessage + "</strong></p>");
}
errorMessage = null;

String infoMessage = request.getParameter("infoMessage");
if (infoMessage != null) {
	out.println("<p><strong>" + infoMessage + "</strong><p>");
}
infoMessage = null;
%>