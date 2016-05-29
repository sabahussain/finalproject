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
<script type="text/javascript">
var cartApp = angular.module('cartApp', []);
cartApp.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}
]);

cartApp.controller("cartCtrl", function($scope, $http){

    $scope.refreshCart = function(){
       $http.get('/rest/cart/' + $scope.cartId).success(function (data){
           $scope.cart.cartItems = data;
       });
    };

    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(id){
        $http.put('/rest/cart/add/' + id).success(function (){
            alert('Product successfully added to the cart!');
        });
    };

    $scope.removeFromCart = function(id){
        $http.put('/rest/cart/remove/' + id).success(function(data){
           $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function(){
        var grandTotal = 0;

        for (var i = 0; i < $scope.cart.cartItems.length; i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    }
});

</script>
</head>
<body>

<div class="container-wrapper">
    <div class="container">
      
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>
                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
   

        <div class="container" ng-app="cartApp">

            <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">

                <div>
           <a href="<spring:url value="/order/${cartId}" />" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Check out</a>
                </div>

                <br/><br/><br/>

                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <tr ng-repeat = "item in cart.cartItems">
                        <td>{{item.product.name}}</td>
                        <td>{{item.product.price}}</td>
                        <td>{{item.quantity}}</td>
                        <td>{{item.totalPrice}}</td>
                        <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.id)"><span class="glyphicon glyphicon-remove"></span>remove</a></td>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Grand Total</th>
                        <th>{{calGrandTotal()}}</th>
                        <th></th>
                    </tr>
                </table>

               <button class="btn btn-default" name="_eventId_backtoproductdetail">Back</button>

                <input type="submit" value="Next" class="btn btn-default" name="_eventId_forwardtoaddress" />
            </div>
            </div></div>
            </div>
           
       </body>
    </html>




