<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>Inscripción Monitorias</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Hosting City Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--// bootstrap-css -->
<!-- css -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!--// css -->
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<!-- font -->
<link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300' rel='stylesheet' type='text/css'>
<!-- //font -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/SmoothScroll.min.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
</head>
<body>
	<!-- header -->

<div class="header">
    <div class="container">
	<nav class="navbar navbar-default">
	<!-- Brand and toggle get grouped for better mobile display-->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
		</button>
		
                <div class="w3layouts-logo">
                    <h1><a href="helloworld.htm">Monitorias <span>UCC</span></a></h1>
		</div>
            </div>

        <!-- Collect the nav links, forms, and other content for toggling-->
            <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
		<nav>
                    <ul class="nav navbar-nav">
			<li class="active"><a href="helloworld.htm">Inicio</a></li>
			
			<li><a href="#" class="dropdown-toggle hvr-sweep-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Opciones<span class="caret"></span></a>
                            <ul class="dropdown-menu">
				<li><a class="hvr-sweep-to-bottom" href="personaCrear.htm">Registrar</a></li>
				<li><a class="hvr-sweep-to-bottom" href="personaConsultar.htm">Consultar</a></li>
				<li><a class="hvr-sweep-to-bottom" href="personaEditar.htm">Editar</a></li>
                                <li><a class="hvr-sweep-to-bottom" href="personaEliminar.htm">Eliminar</a></li>
                            </ul>
			</li>
			<li class="active"><a href="#" class="dropdown-toggle hvr-sweep-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Monitoria<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a class="hvr-sweep-to-bottom" href="monitoriaIngreso.htm">Inscripcion</a></li>
                                <li><a class="hvr-sweep-to-bottom" href="monitoriaIngreso.htm">Descuento</a></li>
                                <li><a class="hvr-sweep-to-bottom" href="monitoriaIngreso.htm">Contrato</a></li>
                            </ul>
                        </li>
                    </ul>
		</nav>
            </div>
	<!-- /.navbar-collapse--> 
		</nav>
    </div>
</div>
	<!-- //header -->
	<!-- about-heading -->
	<div class="about-heading">
		<h2>Inscribir <span>Monitorias</span></h2>
	</div>
	<!-- //about-heading -->
	<div class="registration">
		<div class="container">
			<div class="signin-form profile">
				<h3>:: Consultar ::</h3>
				
				<div class="login-form">
					<form action="monitoriaIngresoForm.htm" method="post">
                                            <input type="text" name="codEstudiante" placeholder="Codigo del Estudiante" required>
                                            <input type="text" name="codCurso" placeholder="Codigo del Curso" required>
                                            <input type="password" name="password" placeholder="Contraseña" required>
                                            <!-- <input type="text" name="nombre1" placeholder="Nombre 1" required> -->

                                            <input type="submit" value="CONSULTAR INFORMACIÓN">
					</form>
				</div>
				<p>${mensaje}</p>
			</div>
                        <br><br> 
                     <div class="table-responsive">   
                            <h3>:: Datos Estudiante ::</h3>
                            <table id="tablaResultado" class="table table-striped table-hover table-bordered" >
                                <thead>       
                                    <tr>
                                       <th>Codigo Est</th>
                                       <th>Nombre Est </th>
                                       <th>Codigo Curso</th> 
                                       <!--<th>Password</th>-->
                                    </tr>
                                </thead>                                        
                                <tbody>
                                <c:forEach var="p" items="${listaEstudiante}">                                           
                                    <tr>
                                        <td>${p.getCodEstudiante()}</td>
                                        <td>${p.getNomEstudiante()}</td>
                                        <td>${p.getCodCurso()}</td>
                                        
                                        
                                        <!--est.setCodEstudiante(rs.getString(1));
                est.setNomEstudiante(rs.getString(2));
                est.setCodCurso(rs.getString(3));
                est.setPassword(rs.getString(4));-->

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>  
                        
                        <div class="table-responsive">  
                            <h3>:: Datos Curso ::</h3>
                            <table id="tablaResultado" class="table table-striped table-hover table-bordered" >
                                <thead>       
                                    <tr>
                                       <th>Codigo Curso</th>
                                       <th>Nombre Curso </th>
                                       <th>Creditos Curso</th> 
                                    </tr>
                                </thead>                                        
                                <tbody>
                                <c:forEach var="p" items="${listaCurso}">                                           
                                    <tr>
                                        <td>${p.getCodCurso()}</td>
                                        <td>${p.getNomCurso()}</td>
                                        <td>${p.getCredCurso()}</td>
                                        
                                        <!--  cur.setCodCurso(rs.getString(1));
                                            cur.setNomCurso(rs.getString(2));
                                            cur.setCredCurso(rs.getString(3));-->

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div> 
                         <div class="table-responsive"> 
                                   <h3>:: Datos Monitoria ::</h3>
                            <table id="tablaResultado" class="table table-striped table-hover table-bordered" >
                                <thead>       
                                    <tr>
                                       <th>Codigo Monitoria</th>
                                       <th>Nombre Monitoria </th>
                                       <th>Nombre Materia</th> 
                                    </tr>
                                </thead>                                        
                                <tbody>
                                <c:forEach var="p" items="${listaMonitoria}">                                           
                                    <tr>
                                        <td>${p.getCodMonitoria()}</td>
                                        <td>${p.getNomMonitoria()}</td>
                                        <td>${p.getNomMateria()}</td>
                                        
                                        <!--mon.setCodCurso(rs.getString(1));
                                            mon.setNomMonitoria(rs.getString(2));
                                            mon.setNomMateria(rs.getString(3));-->

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <h3>::Ingrese el codigo de la monitoria::</h3>
                        <div class="login-form">
                            <form action="monitoriaIngresoForm.htm" method="post">
                                <input type="text" name="codMonitoria" placeholder="Codigo de la monitoria" required>
                                <input type="submit" value="CONSULTAR MONITOR">
                            </form>
                        </div>
                        <p>${mensaje}</p>
                         
                     <div class="table-responsive">   
                            <h3>:: Validación Monitoria ::</h3>
                            <table id="tablaResultado" class="table table-striped table-hover table-bordered" >
                                <thead>       
                                    <tr>
                                       <th>Codigo Monitoria</th>
                                       <th>Cod. Estudiante Asignado </th>
                                       
                                       <!--<th>Password</th>-->
                                    </tr>
                                </thead>                                        
                                <tbody>
                                <c:forEach var="p" items="${listaEstMonitoria}">                                           
                                    <tr>
                                        <td>${p.getCodMonitoria()}</td>
                                        <td>${p.getCodEstudiante()}</td>
                                        
                                        
                                        
                                        <!--esm.setCodMonitoria(rs.getString(1));
                                            esm.setCodEstudiante(rs.getString(2));-->

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>  
		</div>
	</div>
	<!-- footer -->
	<!-- //footer -->
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
	<!-- //here ends scrolling icon -->
</body>	
</html>
