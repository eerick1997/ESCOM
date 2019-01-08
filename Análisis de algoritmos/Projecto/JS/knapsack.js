(function($){
    'use strict';

    $("#btnSend").click(function(){
        $("#tblItems > tbody").empty();
        var items = $("#inputNItems").val();
        var row = "";
        for(var i = 0; i < items; i++){
            row += "<tr><td> Item#" + (i+1) + " <br /><input type='text' class='form-control md-2 mr-sm-2' placeholder='Value' id='Value"+i+"' /><br/><input type='text' class='form-control md-2 mr-sm-2' placeholder='Size' id='Size"+i+"'/></td></tr>";
        }
        $("#tblItems > tbody").append(row);
    });

    $("#btnSendItems").click(function(){
        var items= $("#inputNItems").val();
        var array= []; //Estoy creando un arreglo de tuplas pa almacenar el valor y el peso
        for (var i=0; i<items; i++){
            array.push([parseInt(document.getElementById("Value"+i).value), parseInt(document.getElementById("Size"+i).value)]);
        }
        //Le agregamos el 1 a filas y columnas por los pivotes
        var maxX = parseInt(items)+1;
        var S = parseInt($("#inputKMaxSize").val()) + 1;
        var matrix = [];

        for(var i=0; i< maxX; i++) {
            matrix[i] = new Array(S);
        }

        for(var i = 0; i < maxX; i ++){
            for(var j = 0; j < S; j++){
                if(i == 0 || j == 0){
                    matrix[i][j] = 0;
                } else if(array[i - 1][1] <= j){
                    matrix[i][j] = Math.max( (array[i - 1][0] + matrix[i - 1][j - array[i-1][1]]), (matrix[i-1][j]) );
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
        $("#table > tbody").empty();
        var table = $("#table");
        for(var i = 0; i < maxX; i++){
            var tr = $('<tr>');
            var td = "";
            for(var j = 0; j < S; j++){
                td += '<td>'+matrix[i][j]+'</td>'; 
            }
            tr.append(td);  
            table.append(tr);
        }
        $("#table").append(table);
    });
})(jQuery);