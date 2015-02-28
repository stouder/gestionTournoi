<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html"
    xmlns:ui="http://java.sun.com/jsf/facelets">
<h:head>
    JSF 2 Login
</h:head>
<h:body>
    <p>Login to access secure pages:</p>
    <form method="post" action="j_security_check">
        <h:panelGrid columns="2">
            <h:outputLabel for="j_username" value="Username" />
            <input type="text" id="j_username" name="j_username" />
            <h:outputLabel for="j_password" value="Password" />
            <input type="password" id="j_password" name="j_password" />
            <input type="submit" name="submit" value="Login" />
        </h:panelGrid>
        <br />
    </form>
</h:body>
</html>