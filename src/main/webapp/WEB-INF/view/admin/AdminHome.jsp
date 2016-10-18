
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:url var="home" value="/" scope="request" />
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}"/> --%>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, shrink-to-fit=no, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Aspire Bank</title>

    <!-- Bootstrap Core CSS -->
    <link href="/C55-Backend/assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/C55-Backend/assets/css/simple-sidebar.css" rel="stylesheet">
    
    <!-- jQuery -->
        <script src="/C55-Backend/assets/js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="/C55-Backend/assets/js/bootstrap.min.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">
   function doAjaxCall() {
	   
   var name='Pankaj';
   var lastName='Singh';
   $.ajax({
                   // type: "POST",
                    //dataType: "json",
                    url: "${home}admin/doAjax",
                    data: 'name='+name+'&lastname='+ lastName,//{myData:dataString},
                    //contentType: "application/json; charset=utf-8",
                    success: function(data){
                        alert('transacion successfull '+data);
                        
                    },
                    error: function(e){
                        console.log(e.message);
                    }
                });
             }
   </script>
   <script type="text/javascript">
    var intervalId = 0;
    intervalId = setInterval(doAjaxCall, 3000);
</script>
</head>   

<body>

<div id="wrapper">

         <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                       
                </li>
                <li>
                   <a href='<c:url value="/admin/RoleAddition"/>'> Create New Internal User</a>
                </li>
                <li>
                    <a href="/admin/RoleAddition.jsp">View All Internal User</a>
                </li>
                
                <li>
                    <a href="${home}admin/RoleAddition">Access Logs</a>
                </li>
               <li>
                    <a href="/C55-Backend/WEB-INF/view/admin/RoleAddition.jsp">PII</a>
                </li>
                <li>
                    <a href="RoleAddition">PII</a>
                </li>
                <li>
                    <a href="#">Logout</a>
                </li>
                
            </ul>
            <button  onclick='doAjaxCall()'></button>
        </div>
</div>
</body>
</html>