<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding = "UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv = "Content-Type" content = "text/html; charset = UTF-8" />
        <title>success page</title>
    </head>
    <body>
        <h2>login was successful</h2>
        <p>
            name: ${requestScope.user.username}<br />
            password: ${requestScope.user.password}<br />
            age: ${requestScope.user.age}<br />
            phone: ${requestScope.user.phone}<br />
            email: ${requestScope.user.email}<br /> 
        </p>
        <h2>Description</h2>
        <p>${requestScope.user.description}</p>
    </body>
</html>