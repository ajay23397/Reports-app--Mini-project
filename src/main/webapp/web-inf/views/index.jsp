<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
  <div class="container">
 <h3 class="pb-3 pt-3">Report Application</h3>

    <form:form action="search" modelAttribute="search" method="POST">
    <table>
   <tr>
   <td> Plan Name:</td>
   <td>
     <form:select path="planName">
       <form:option value=" ">-select-</form:option>
       <form:options items="${names}"/>
     </form:select>
    </td>
    <td>Plan Status:</td>
      <td> <form:select path="planStatus">
     <form:option value=" ">-select-</form:option>
     <form:options items="${status}"/>
     </form:select></td>
     
        <td> Gender:</td>
        <td>
        <form:select path="gender">
        <form:option value="">-select-</form:option>
        <form:option value="Male">-Male-</form:option>
        <form:option value="Female">-Female-</form:option>
        </form:select>
        </td>
     </tr>
      <tr>
       <td> Start Date: </td>
       
        <td><form:input path="StartDate"  type="date" data-date-format = "mm/dd/yyyy"/></td>
        <td> End  Date: </td>
        <td><form:input path="EndDate" type ="date" data-date-format = "mm/dd/yyyy"/></td>
      </tr>
      <tr>
      
      <td><input type="submit" value="search"  class= "btn btn-primary"/></td>
       </tr>
      
         
         
   </table>
     </form:form>
     
      <c:if test="${empty plans }">
            No records found
      </c:if>
     
     <hr/>
     
     <hr/>
     
     <table class= "table table-stripe">
     <thead>
            <tr>
             <th>Id</th>
              <th>Holder name</th>
               <th>Plan Name</th>
                <th>Plan Status</th>
                 <th>Start Date</th>
                  <th>End Date</th>
                   <th>benifitAmt</th>
             </tr>
     
     </thead>
     
     <tboday>
     <tr>
    <td colspan="7">
     <c:forEach items = "${plans}"  var ="plan"  varStatus ="index">  
     </td>
      </tr>
               <tr>
               <td>${index.count }</td>
               <td>${plan.citizenName }</td>
               <td>${plan.planName }</td>
               <td>${plan.planStatus }</td>
               <td>${plan.planStartDate }</td>
               <td>${plan.planEndDate }</td>
                  <td>${plan.benifitAmt }</td>
               
               </tr>
     
     </c:forEach>
     
     </tboday>
     
      </table>
     Export: <a href="excel">Excel</a> <a href="pdf">pdf</a>
     
     
     
     
      </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</body>
</html>