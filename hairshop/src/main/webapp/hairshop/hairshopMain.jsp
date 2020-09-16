<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤어살롱 메인페이지</title>
<link
	href='https://cdn.jsdelivr.net/npm/fullcalendar-scheduler@5.3.2/main.min.css'
	rel='stylesheet' />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar-scheduler@5.3.2/main.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
	
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			schedulerLicenseKey: 'CC-Attribution-NonCommercial-NoDerivatives',
			themeSystem : 'bootstrap',
			initialView : 'resourceTimeGridDay',
			   resources: [
				      { id: 'a', title: '김강산' },
				      { id: 'b', title: '김린아'},
				      { id: 'c', title: '김승연' },
				      { id: 'd', title: '이송현' },
				      { id: 'e', title: '이상민' }
				    ],
				    titleFormat: {
				        month: 'numeric',
				        year: 'numeric',
				        day: 'numeric',
				        weekday: 'short'
				      },
				      buttonText: {
				    	  today:    '오늘',
				    	  month:    'month',
				    	  week:     'week',
				    	  day:      'day',
				    	  list:     'list'
				    	},
				    	buttonIcons: {
				    		prev: 'left-single-arrow',
				    		  next: 'right-single-arrow',
				    		  prevYear: 'left-double-arrow',
				    		  nextYear: 'right-double-arrow'
				    	},
				    	headerToolbar:{
				    		start: 'title', // will normally be on the left. if RTL, will be on the right
				    		  center: '',
				    		  end: 'today prev,next' // will normally be on the right. if RTL, will be on the left
				    	}
				     
		});
		calendar.render();
		
		// Load the Visualization API and the corechart package.
	      google.charts.load('current', {'packages':['corechart']});

	      // Set a callback to run when the Google Visualization API is loaded.
	      google.charts.setOnLoadCallback(drawChart);

	      // Callback that creates and populates a data table,
	      // instantiates the pie chart, passes in the data and
	      // draws it.
	      function drawChart() {

	        // Create the data table.
	        var data = new google.visualization.DataTable();
	        data.addColumn('string', '부서');
	        data.addColumn('number', '사원수');
	        
	        var datatable = [];
	        $.ajax({
	        	async : false,
	        	url: "ajax/ChartData.do",
	        	dataType: "json",
	        	success : function(datas){
	        		for(i=0; i<datas.length; i++){
	        			var innertb = [datas[i].name, parseInt(datas[i].cnt)]; 
	        			datatable.push(innertb);
	        		}
	        	}
	        	
	        });
	        
	        data.addRows(datatable);

	        // Set chart options
	        var options = {'title':'매장 현황',
	                       'width':500,
	                       'height':500};

	        // Instantiate and draw our chart, passing in some options.
	        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
	        chart.draw(data, options);
	      }
		
		
		
		
		
	});
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm">
				<div class="btn-group btn-group-toggle" data-toggle="buttons">
				  <label class="btn btn-secondary active">
				    <input type="radio" name="options" id="option1" checked> 일
				  </label>
				  <label class="btn btn-secondary">
				    <input type="radio" name="options" id="option2"> 주
				  </label>
				  <label class="btn btn-secondary">
				    <input type="radio" name="options" id="option3"> 월
				  </label>
				</div>
			</div>
			<div class="col-sm">
				<div>주</div>
			</div><div class="col-sm">
				<div>일</div>
			</div>
			
		</div>
		<div class="row">	
			<div class="col-9">
				<div id='calendar'></div>
			</div>
			<div class="col-3">
				<div id="chart_div"></div>
				<div class="container-fluid">
				<div class="btn-group btn-group-toggle" data-toggle="buttons">
				  <label class="btn btn-secondary active">
				    <input type="radio" name="options" id="option1" checked> 일
				  </label>
				  <label class="btn btn-secondary">
				    <input type="radio" name="options" id="option2"> 주
				  </label>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>