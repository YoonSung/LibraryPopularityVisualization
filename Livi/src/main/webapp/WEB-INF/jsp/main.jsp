<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/stylesheet/main.css">
<link rel="stylesheet" href="/resources/stylesheet/container.css">
<link rel="stylesheet" href="/resources/stylesheet/loading.css">
<title>Library Popularity Visualization</title>
<style>
</style>
</head>
<body>
	<div id="wrapper">
		<h1>Github Library Popularity :)</h1>
		<div>
			<form action="#">
				<input type="text" id="inputfield" /><input class="button"
					type="submit" value="Show" />
					<input class="button test" type="submit" value="Test" />
			</form>
		</div>

		<div id="result">
			<div id="status">
			
				<div class="rank" style="color: black; font-size: 0.9em; font-style: italic;">Rank</div>
				<div class="seperator"></div>
				<div>
					Star : <span class="star"></span>
				 / </div>

				<div>
					Fork : <span class="fork"></span>
				 / </div>

				<div>
					Total : <span class="total"></span>
				 </div>
				 <div class="seperator"></div>
				<div>
					Repository : <span class="repo"></span>
				 / </div>

				<div>
					LastUpdated : <span class="time"></span>
				 </div>
				<div class="seperator"></div>
				<div>
					{Discription} <br /> <span class="description"></span>
				</div>
			</div>
			<div id="container" class="container">
				<div id="main" role="main">
					<div id="vis"></div>
				</div>
			</div>
		</div>
	</div>

	<div id="loadArea">
		<div id="cover" class="cover">
			<h1>Data Loading...</h1>
			<div id="loading" class="ui-circle-loading">
				<ul class="animate">
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/lib/javascript/d3.js"></script>
<script type="text/javascript" src="/resources/javascript/container.js"></script>
<script type="text/javascript" src="/resources/javascript/main.js"></script>
</html>