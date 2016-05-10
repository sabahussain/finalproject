<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"/>
<link href="${a}/bootstrap.min.css" rel="stylesheet"/>
 <script src="${b}/jquery-2.2.3.min.js">
 </script>
<script src="${b}/bootstrap.min.js">
</script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script>
angular.module('myApp', [])

.controller('ctrl', function($scope) {
 $scope.book = [
    {id: '1', name:'Diary of a Wimpy Kid', author: 'Jeff Kiney' ,description: '2016 release' ,price:'194', category:'Comic & Graphic Novels'},
    {id: '2', name: 'The Book of Tomorrow', author: 'Cecelia Arem' ,description: '2015 release' ,price:'229',category:'Literature & Fiction Books'},
    {id: '3', name: '7 secrets of SHIVA', author: 'Devdutt Pattanaik',description: '2016 release' ,price:'299',category:'Fantasy Books'},
    {id: '4', name: 'MADHUSHALA', author: 'Harivansh Rai Bachhan',description: '1980 release' ,price:'100',category:'Poetry'},
    
  ];
  
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Explore Products</title>
</head>

                   <body ng-app="myApp" style="background-color: #FFE4E1;">
                   <jsp:include page="header.jsp"/>
                     <div class="container"> 
                     
                         <div class="form-group form-group-sm">
                          <div class="col-sm-10">
                          <input type="text" class="form-control" placeholder="Search"  ng-model="searchBooks">
                           </div>
                           </div>
                           </div>
                         
                         <div  ng-controller="ctrl"  class="container" style="padding-top:60px">
                       
                         <table style="width:100%" border="1" class="table table-striped table-responsive">

                      <tr>
                      <th>ID</th>
                      <th>Name</th> 
                      <th>Author</th>
                      <th>Description</th>
                      <th>Price</th>
                      <th>Category</th>
                      <th>Click To Explore</th>
                       </tr>
                       <tbody>
                         <tr ng-repeat="x in book | orderBy:'id' | filter:searchBooks">
                         <td>{{ x.id }}</td>
                         <td>{{ x.name }}</td>
                       <td>{{ x.author}}</td>
                       <td>{{ x.description}}</td>
                       <td><i class="fa fa-inr"></i>{{ x.price}}</td>
                       <td>{{ x.category}}</td>
                       <td> <a href="productdetails"  class="btn btn-success btn-lg">
                         <span class="glyphicon glyphicon-plus-sign"></span>
                         </a>
                         </td>
                       <td><form action="productdetails" method="post">
                          <input type="hidden" name="id" value={{x.id}}/>
                         <input type="hidden" name="name" value={{x.name}}/>
                         <input type="hidden" name="author" value={{x.author}}/>
                         <input type="hidden" name="description" value={{x.description}}/>
                          <input type="hidden" name="price" value={{x.price}}/>
                           <input type="hidden" name="category" value={{x.category}}/>
                          </form>
                         </td>
                       
                       </tr>
                       </tbody>
                       </table>
                       </div>


</body>
</html>