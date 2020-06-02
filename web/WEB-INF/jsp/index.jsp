<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>Monitorias-Inicio</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
<link href='css/immersive-slider.css' rel='stylesheet' type='text/css'>
<!-- pricing -->
<link rel="stylesheet" href="css/jquery.flipster.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/site.css">

<body>

<!-- Navigation -->

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
<!-- Slide Show -->
 <!--carrusel-->
 <br> <br>
 <div id="myCarousel" class="carousel slide" data-ride="carousel" style="background-color: greenyellow">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
	  <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        
      <div class="item active">
        <center><h1 style="color: white">Haz parte del grupo de monitores de la UCC</h1></center>
        <img src="images/p.jpg"  alt="Image">
        <div class="carousel-caption">
        </div>      
      </div>
	
	<div class="item">
        <center><h1 style="color:white">Inscribete por esta página</h1></center>
        <img src="images/s.jpg" alt="Image">
        <div class="carousel-caption">
        </div>      
      </div>

      <div class="item">
        <center><h1 style="color: white">Comparte tus conocimientos</h1></center>
        <img src="images/t.jpg" alt="Image">
        <div class="carousel-caption">
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <!--carrusel-->

</body>
</html>
