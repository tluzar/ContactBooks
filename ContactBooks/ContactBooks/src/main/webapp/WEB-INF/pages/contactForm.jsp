
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="tluzar">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Contact Information</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>    
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
    <div class="container myrow-container">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">
                    Contact Details
                </h3>
            </div>
            <div class="panel-body">
                <form:form id="contactRegisterForm" cssClass="form-horizontal" modelAttribute="contact" method="post" action="saveContact">
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="name" >Name</form:label> </div>
                        <div class="col-xs-6">
                            <form:hidden path="id" value="${contactObject.id}"/>
                            <form:input cssClass="form-control" path="name" value="${contactObject.name}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <form:label path="surname" cssClass="control-label col-xs-3">Surname</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="surname" value="${contactObject.surname}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"><form:label path="phone">Phone</form:label></div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="phone" value="${contactObject.phone}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                                <input type="submit" id="saveContact" class="btn btn-primary" value="Save" onclick="return submitContactForm();"/>
                            </div>
                            <div class="col-xs-4">
                            </div>
                        </div>
                    </div>
    
                </form:form>
            </div>
        </div>
    </div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	
		function submitContactForm() {				
			
		    // getting the contact form values
		    var name = $('#name').val().trim();
		    var surname = $('#surname').val();
		    var phone = $('#phone').val();
		    
		    if(name.length == 0) {
		        alert('Please enter name:');
		        $('#name').focus();
		        return false;
		    }
	
		    if(surname.length == 0) {
		        alert('Please enter surname:');
		        $('#surname').focus();
		        return false;
		    }
	
		    if(phone.length == 0) {
		        alert('Please enter phone:');
		        $('#phone').focus();
		        return false;
		    }
		    
		    return true;
		};	
	</script>

</body>
</html>