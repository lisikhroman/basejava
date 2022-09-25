<%@ page import="ru.javawebinar.basejava.model.ContactType" %>
<%@ page import="ru.javawebinar.basejava.model.Resume" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/theme/light.css">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/resume-list-styles.css">
    <title>Список всех резюме</title>
</head>
<script type="text/javascript"
        src="/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=YQPP9VyT5wvsmHej82R_F5y7CrLMLsaTuSNP_Wz4GxxoC3um0hRo1oCYlTK-sKLtPENmAd-aa8wSd6KACVn8t7wVePAOt89mIWoI4bJDX-A"
        charset="UTF-8"></script>
</head>
<body>
<div class="themes">
    <div class="theme-title">Тема</div>
    <div class="theme-selector">
        <form action="" method="GET">
            <select name="theme" onchange="this.form.submit()">
                <option value="light" selected>Светлая</option>
                <option value="dark">Темная</option>
                <option value="purple">Фиолетовая</option>
            </select>
        </form>
    </div>
</div>

<jsp:include page="fragments/header.jsp"/>
<section>
    <a href="resume?action=add"><img src="img/add.png"></a>
    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>Имя</th>
            <th>Контакты</th>
            <th>Удалить</th>
            <th>Редактировать</th>
        </tr>
        <c:forEach items="${resumes}" var="resume">
            <jsp:useBean id="resume" type="ru.javawebinar.basejava.model.Resume"/>
            <tr>
                <td><a href="resume?uuid=${resume.uuid}&action=view">${resume.fullName}</a></td>
                <td><%=ContactType.EMAIL.toHtml(resume.getContact(ContactType.EMAIL))%>
                </td>
                <td><a href="resume?uuid=${resume.uuid}&action=delete"><img src="img/delete.png"></a></td>
                <td><a href="resume?uuid=${resume.uuid}&action=edit"><img src="img/pencil.png"></a></td>
            </tr>
            n
        </c:forEach>
    </table>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
