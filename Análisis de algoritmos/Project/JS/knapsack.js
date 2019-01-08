
var name_actual;
var map_images = new Map();
var matrix;
var array = [];
var li = 0, lj = 0;
var maxX, maxY;


function allowDrop(ev) {
	ev.preventDefault();
}

function drag(ev, name) {

	ev.dataTransfer.setData("text", ev.target.id);
	//document.getElementById("prueba").innerHTML = name;
	name_actual = name;
}

function drop(ev, name_div) {
	ev.preventDefault();
	var data = ev.dataTransfer.getData("text");
	ev.target.appendChild(document.getElementById(data));
	//console.log("Voy a guardar "+document.getElementById("prueba").innerHTML+" en el div: "+name_div);
	console.log("Voy a guardar " + name_actual + " en el div: " + name_div);
	map_images.set(parseInt(name_div), name_actual);
}

(function ($) {
	'use strict';

	$("#btnSend").click(function () {
		$("#tblItems > tbody").empty();
		var items = $("#inputNItems").val();
		var row = "";
		for (var i = 0; i < items; i++) {
			row += "<tr><td color='black'> Item#" + (i + 1) + " <br /><input type='text' class='form-control md-2 mr-sm-2' placeholder='Value' id='Value" + i + "'/><br/><input type='text' class='form-control md-2 mr-sm-2' placeholder='Size' id='Size" + i + "'/>  <br>  <div class='div_dragdrop' id='dragdrop" + i + "' ondrop='drop(event, " + i + ")' ondragover='allowDrop(event)'></div>  </td></tr>";
		}
		$("#tblItems > tbody").append(row);


		//$("#divprueba").append("<div id='div1' ondrop='drop(event)' ondragover='allowDrop(event)'></div>");


	});

	$("#Step").click(function(){
		step();
	});

	$("#btnSendItems").click(function () {

		for (var m = 0; m < $("#inputNItems").val(); m++) {
			console.log("id: " + m + " " + map_images.get(m));
		}


		var items = $("#inputNItems").val();
		array = []; //Estoy creando un arreglo de tuplas pa almacenar el valor y el peso
		for (var i = 0; i < items; i++) {
			array.push([parseInt(document.getElementById("Value" + i).value), parseInt(document.getElementById("Size" + i).value)]);
		}

		//Le agregamos el 1 a filas y columnas por los pivotes
		maxX = parseInt(items) + 1;
		maxY = parseInt($("#inputKMaxSize").val()) + 1;
		matrix = [];
		var ceros = new Map();
		var solution = new Map();
		var index_images = [];

		for (var i = 0; i < maxX; i++) {
			matrix[i] = new Array(maxY);
		}

		//Algoritmo
		for (var i = 0; i < maxX; i++) {
			for (var j = 0; j < maxY; j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
					ceros.set("" + i + "" + j, [i, j]);
				} else if (array[i - 1][1] <= j) {
					matrix[i][j] = Math.max((array[i - 1][0] + matrix[i - 1][j - array[i - 1][1]]), (matrix[i - 1][j]));
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}

		var j = maxY - 1;
		var count_aux = 0;
		for (var i = maxX - 1; i > 0; i--) {
			if (matrix[i][j] == matrix[i - 1][j])
				continue;
			else {
				solution.set("" + i + "" + j, [i, j]);
				index_images[count_aux++] = i - 1;
				j -= array[i - 1][1];
			}
		}


		for (var i = 0; i < index_images.length; i++) {
			if (map_images.get(index_images[i])) {
				console.log("Me quedo con el objeto " + map_images.get(index_images[i]));
			}
		}

		var header = $("#table > thead");
		var td_header = "";
		for (var j = -1; j < maxY; j++) { //Si no funciona lo de las imagenes dejar j=0 y borrar el if de abajo
			if (j == -1)
				td_header += '<th class="num_elements"></th>';
			else
				td_header += '<th class="num_elements" style="text-align:center">' + j + '</th>';
		}


		header.append(td_header);
		$("#table").append(header);

		var cont_aux = 0;

		$("#table > tbody").empty();
		var table = $("#table");
		for (var i = 0; i < maxX; i++) {
			var tr = $('<tr>');
			var td = "";
			for (var j = 0; j < maxY; j++) {

				if (solution.get("" + i + "" + j) && j != 0)
					td += '<td class="soluciones" style="background-color: rgba(63, 224, 60, 0.9);" title="Objeto tomado" id="id' + i + '-' + j + 'id">' + matrix[i][j] + '</td>';
				/*else if (ceros.get(""+i+""+j))
					td += '<td class="ceros">'+matrix[i][j]+'</td>'; 	*/

				else if (ceros.get("" + i + "" + j)) { //Si no funciona lo de las imagenes borrar este else if y dejar el de arriba
					if (j == 0 && i > 0) {
						td += '<td title="' + map_images.get(cont_aux) + '" style="background-color: rgba(29, 186, 255, 0.9);" class="an_img"> <img src=\"IMAGENES/' + map_images.get(cont_aux) + '.png\" width="70" height="60"> </td>';
						cont_aux++;
					} else if (j == 0)
						td += '<td></td>';

					td += '<td class="ceros" id="id' + i + '-' + j + 'id">' + matrix[i][j] + '</td>';

				}

				else {
					td += '<td id="id' + i + '-' + j + 'id">' + matrix[i][j] + '</td>';
				}
			}
			tr.append(td);
			table.append(tr);
		}
		$("#table").append(table);

		document.getElementById("articulos_sel").style.visibility = "visible";
		document.getElementById("titulo_tabla").style.visibility = "visible";
		
		var labels = $("#articulos > ul");
		var labels_li = "";

		for (var i = 0; i < index_images.length; i++) {
			if (map_images.get(index_images[i])) {
				labels_li += '<li type="square"> <img src=\"IMAGENES/' + map_images.get(index_images[i]) + '.png\" width="70" height="60" title="' + map_images.get(index_images[i]) + '"> </li> <br/>'
			}
		}
		labels.append(labels_li);
		
	});

	function step(){

		if(li == 0 || lj == 0){
			$("#line07").css({"background": "darkgrey"});
			$("#line08").css({"background-color": ""});
			$("#line09").css({"background-color": ""});
			$("#line10").css({"background-color": ""});
			$("#line11").css({"background-color": ""});
			changeElement(li, lj, li, lj);
		} else {	
			$("#line07").css({"background": ""});
			if(array[li - 1][1] <= lj){
				$("#line08").css({"background-color": "darkgrey"});
				$("#line09").css({"background-color": "darkgrey"});
				$("#line10").css({"background-color": ""});
				$("#line11").css({"background-color": ""});
				changeElement(li, lj, li, lj);
				//Math.max((array[i - 1][0] + matrix[i - 1][j - array[i - 1][1]]), (matrix[i - 1][j]));
				//changeElement();
				//changeElement(array_items[li-1][0] + matrix[li-1][lj - array_items[li - 1][1]]);
			} else {
				//changeElement(li, lj, li, lj);
				changeElement(li, lj, li-1, lj);
				$("#line10").css({"background-color": "darkgrey"});
				$("#line11").css({"background-color": "darkgrey"});
				$("#line08").css({"background-color": ""});
				$("#line09").css({"background-color": ""});
			}
		}
		changeElement(li, lj, li, lj);

		if(li >= maxX - 1 && lj >= maxY - 1){
			li = 0;
			lj = 0;
		} else if(lj >= maxY - 1){
			li++;
			lj = 0;
		} else {
			lj++;
		}
		//changeElement("id"+li+"-"+lj+"id", "id"+li+"-"+lj-1+"id");
	}

	function changeElement(pi, pj, qi, qj){
		var id1 = "id" + pi + "-" + pj + "id";
		var id2 = "id" + qi + "-" + qj + "id";
		$("table > tbody > tr").each( function(i, e){
			$(this).find("td").each(function(index, element){
				if($(this).attr('id') == id2){
					$(this).css({'background-color': 'green'});
				}
				else if($(this).attr('id') == id1){
					$(this).css({'background-color': 'green'});
				} else {
					$(this).css({'background-color': ''});
					if($(this).attr('class') == 'soluciones')
					$(this).css({'background-color': 'rgba(63, 224, 60, 0.9)'});
				}
				if($(this).attr('class') == 'an_img')
					$(this).css({'background-color': 'rgba(29, 186, 255, 0.9)'});
				
				
			});
		});
	}

	function iterateTable() {
		var parametros = [];
		var parame = [];
		$("#table > tbody > table > tr").each( function(i, e){
			var tr = [];
			$(this).find("td").each(function(index, element){
				var td = {};
				td["dato"+index] = $(this).html();
				tr.push(td);
			});
			parametros.push(tr);
		});
		console.log(parametros);
	}


})(jQuery);