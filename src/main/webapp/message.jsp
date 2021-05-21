<!-- To display information message in Web page -->

<%
String errorMessage = request.getParameter("errorMessage");

if (errorMessage != null) {
	out.println("<p>" + errorMessage + "</p>");
}
String infoMessage = request.getParameter("infoMessage");
if (infoMessage != null) {
	out.println("<p>" + infoMessage + "<p>");
}
%>