<%@ page language = "java" contentType = "text/html; charset = UTF-8"
    pageEncoding = "UTF-8" isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv = "Content-Type" content = "text/html; charset = UTF-8">
<title>Download the page</title>
</head>
<body>
    <h4>Click the link to download</h4>
    <a href = "download?filename=${requestScope.file.originalFilename}">${requestScope.file.originalFilename}</a>
</body>
</html>