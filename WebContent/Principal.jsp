<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  </head>

  <body>
  	<ul id="slide-out" class="side-nav">
	    <li><div class="user-view">
	      <div class="background">
	        <img src="img/paisagem.jpg">
	      </div>
	      <a href="#!user"><img class="circle" src="img/iconPadrao.jpg"></a>
	      <a href="#!name"><span class="white-text name">${nome}</span></a>
	      <a href="#!email"><span class="white-text email">${usuario}</span></a>
	    </div></li>
	    <li><a href="#!"><i class="material-icons">cloud</i>First Link With Icon</a></li>
	    <li><a href="#!">Second Link</a></li>
	    <li><div class="divider"></div></li>
	    <li><a class="subheader">Subheader</a></li>
	    <li><a class="waves-effect" href="#!">Third Link With Waves</a></li>
	  </ul>
	  
  	<div class="navbar-fixed">
	    <nav>
	      <div class="nav-wrapper  teal darken-4">
	      	<a href="#" data-activates="slide-out" class="button-collapse show-on-large"><i class="material-icons">menu</i></a>
	        <a href="#!" class="brand-logo"><img class="circle" alt="" src="img/logo.png" height="60px"></a>
	      </div>
	    </nav>
	  </div>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="materialize/js/plugin.js"></script>
  </body>
</html>