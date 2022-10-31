<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
   <head>
      <meta charset="UTF-8">
      <title>Example application</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
   </head>
   <style>
      table,
      th,
      td {
      border: 3px solid blue;
      }
   </style>
   <body>
      <div class="container">
         <table style="width:50%">
            <tr>
               <th>id</th>
               <th>full name</th>
            </tr>
            <c:forEach var="user" items="${users}">
               <tr>
                  <td>${user.get("id")}</td>
                  <td><a href='/users/show?id=${user.get("id")}'>${user.get("firstName")} ${user.get("lastName")}</a></td>
               </tr>
            </c:forEach>
         </table>
      </div>
   </body>
</html>
<!-- END -->