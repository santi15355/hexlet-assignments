<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language = "java" %>
<!DOCTYPE html>
<html lang=\"ru\">
   <head>
      <meta charset=\"UTF-8\">
      <title>Example</title>
      <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
         rel=\"stylesheet\"
         integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
         crossorigin=\"anonymous\">
   </head>
   <body>
      <div class=\"container\">
         <p>Вы действительно хотите удалить ${user.get("firstName")} ${user.get("lastName")}</p>
         <br/>
         <form method="post" action="/users/delete?id=${user.get("id")}">
         <button type="submit" class="btn btn-danger">Удалить</button>
         </form>
      </div>
   </body>
</html>
<!-- END -->