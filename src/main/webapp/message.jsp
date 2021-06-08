<!-- To display information message in Web page -->

<%
String errorMessage = request.getParameter("errorMessage");

if (errorMessage != null) {
	out.println("<font color='red'><strong>" + errorMessage + "</strong></font>");
}
errorMessage = null;

String infoMessage = request.getParameter("infoMessage");
if (infoMessage != null) {
	out.println("<font color='green'><strong>" + infoMessage + "</strong></font>");
}
infoMessage = null;
%>