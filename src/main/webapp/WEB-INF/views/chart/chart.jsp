<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Google Chart API</title>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
	function ajaxData(){
		//console.log("ajaxData()");
		$.ajax({
			//url: "./chartData.json", 
			url: "./charDataRan.json",
			//dataType: "json", 
			type: "post", 
			//async: true, 
			success: function(list){
				google.charts.load('current', {'packages':['corechart']}); //api로딩 
			    google.charts.setOnLoadCallback(drawChart); //콜백메소드 등록 
			    
			    function drawChart() {
			    	var dataChart = [['글로벌 회사', '주가총액']];
			    	if(list.length != 0){
			    		$.each(list, function(i, item){
			    			dataChart.push([item.item, item.number]);
			    		});
			    	}else{
			    		dataChart.push(['서버에서 넘어온 데이터가 없어요', 1]);
			    	}
			    	
			    	var data = google.visualization.arrayToDataTable(dataChart);
			    	var view = new google.visualization.DataView(data);
			    	var options = {
			    		 title: "글로벌 IT 회사 주가 총액 비교", 
			    		 width: 400,  
			    		 height: 200 
			    	};
			    	
			    	var chart1 = new google.visualization.PieChart(document.getElementById('piechart'));
			    	var chart2 = new google.visualization.LineChart(document.getElementById('linechart'));
			    	var chart3 = new google.visualization.BarChart(document.getElementById('barchart'));
			    	var chart4 = new google.visualization.ColumnChart(document.getElementById('columnchart'));
		            chart1.draw(view, options);
		            chart2.draw(view, options);
		            chart3.draw(view, options);
		            chart4.draw(view, options);
			    }
			} 
		});
	}
	
	$(document).ready(function(){
		ajaxData();
	});
	
	setInterval(function(){ ajaxData(); }, 1000);
</script>
</head>
<body>
    <center>
        <h1>Google Chart</h1> 
        <input type="button" value="데이터호출" onclick="ajaxData()"/>
        &nbsp;&nbsp;
	    <a href="../">인덱스</a>
	    <br/><br/>
	   
		<div id="piechart"></div>
		<div id="linechart"></div>
		<div id="barchart"></div>
		<div id="columnchart"></div>
		
	</center>
</body>
</html>
