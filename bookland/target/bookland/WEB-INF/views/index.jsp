<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@page isELIgnored="false" %>
<html>
<head>
<c:url value="/resources/bootstrap/css" var="a" scope="application"></c:url>
<c:url value="/resources/bootstrap/js" var="b" scope="application"></c:url>
<c:url value="/resources/images" var="z" scope="application"></c:url>
<link href="${a}/bootstrap.min.css" rel="stylesheet"/>
 <script src="${b}/jquery-2.2.3.min.js">
 </script>
<script src="${b}/bootstrap.min.js">
</script>
<style>
body {
    background-color: #FFE4E1;
}
.navbar-default {
    background-color: #FFAEC9;
    border-color: #E7E7E7;
}
.navbar-default .navbar-nav > li > a {
    color: #777777;
}
.navbar-default .navbar-nav > .active > a, .navbar-default .navbar-nav > .active > a:hover, .navbar-default .navbar-nav > .active > a:focus {
    background-color: #FFE4C4;
    color: #555555;
}
div.img {
    margin: 50px;
    border: 1px solid #ccc;
    float: left;
    width: 180px;
    background-color: #FFB6C1;
    
}

div.img:hover {
    border: 1px solid #777;
}

div.img img {
    width: 100%;
    height: auto;
}

div.desc {
    padding: 15px;
    text-align: center;
}
.navbar-brand
{padding: 0px 0px;}

 $('.carousel').carousel({
   interval: 3000
  });
</style>
</head>
<body>
    <nav class="navbar navbar-default navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#"><img src="${z}/newlogo.png" alt="" width="180" height="50" ></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
         <li><a href="#">Contact</a></li>
        <li class="dropdown">
           <a class="dropdown-toggle" data-toggle="dropdown" href="#">Product<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="product">Comic & Graphic Novels</a></li>
            <li><a href="product">Literature & Fiction Books</a></li>
            <li><a href="product">Poetry</a></li>  
             <li><a href="product">Fantasy Books</a></li>                        
          </ul>
        </li>
        </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="register"><span class="glyphicon glyphicon-user"></span> Register</a></li>
        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="admin"><span class="glyphicon glyphicon-user"></span> Admin</a></li>
      </ul>
    </div>
  </div>
</nav>

 <div class="container" style="background color:#FFE4E1;">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="${z}/carousel2.jpg" alt="">
      <div class="carousel-caption">
      </div>
    </div>

    <div class="item">
      <img src="${z}/carousel1.jpg" alt="">
      <div class="carousel-caption">
      </div>
    </div>

    <div class="item">
      <img src="${z}/carousel3.jpg" alt="">
      <div class="carousel-caption">
      </div>
    </div>
    <div class="item">
      <img src="${z}/carousel4.jpg" alt="">
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
</div>
<div class="container" style="padding-top:30px">
<p style="font-size:100%;font-family:verdana;">
About Bookland, India's Ultimate Online Shopping Destination.Bookland's vision is to create India's most impactful digital commerce ecosystem that creates life-changing experiences for buyers and sellers. It's an India's largest online marketplace, with the widest assortment of 15 million+ products across 500+ diverse categories from thousands of regional, national, and international brands and retailers. With millions of users and 200,000 sellers, Bookland is the shopping destination for internet users across the country, delivering to 5000+ cities and towns in India.
Buy literature books, Novels , fiction books in India @ best prices in India. Large collection of Classics, Thrillers, Sci-Fi Fantancy books available at bookland.com
</p>
</div>

<div class="container">
<div class="img">
  <a target="_blank" href="product">
    <img src="${z}/comic.jpg" alt="" width="300" height="200">
  </a>
  <div class="desc">Comic & Graphic Novels</div>
</div>

<div class="img">
  <a target="_blank" href="product">
    <img src="${z}/fantasy.jpg" alt="" width="300" height="200">
  </a>
  <div class="desc">Fantasy Books</div>
</div>

<div class="img">
  <a target="_blank" href="product">
    <img src="${z}/Fiction.jpg" alt="" width="300" height="200">
  </a>
  <div class="desc">Literature & Fiction Books</div>
</div>

<div class="img">
  <a target="_blank" href="product">
    <img src="${z}/poetry.jpg" alt="" width="300" height="200">
  </a>
  <div class="desc">Poetry</div>
</div>
</div>

<div class="container">
   <footer>  
  <p align="center"><a href="#">TM & &#169; 2016, Created by Saba</a></p>  
    </footer>  
      </div>  

</body>
</html>
     
</body>
</html>
