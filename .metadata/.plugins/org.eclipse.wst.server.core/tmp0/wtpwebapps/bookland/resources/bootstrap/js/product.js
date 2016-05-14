angular.module('myApp', [])

.controller('ctrl', function($scope) {
 $scope.book = [
    {id: '1', name:'Diary of a Wimpy Kid', author: 'Jeff Kiney' ,description: '2016 release' ,price:'194', category:'Comic & Graphic Novels'},
    {id: '2', name: 'The Book of Tomorrow', author: 'Cecelia Arem' ,description: '2015 release' ,price:'229',category:'Literature & Fiction Books'},
    {id: '3', name: '7 secrets of SHIVA', author: 'Devdutt Pattanaik',description: '2016 release' ,price:'299',category:'Fantasy Books'},
    {id: '4', name: 'MADHUSHALA', author: 'Harivansh Rai Bachhan',description: '1980 release' ,price:'100',category:'Poetry'},
    
  ];
  
});