<!DOCTYPE html>
<html>
	<head>
		<title>Error</title>
		<link rel="stylesheet" href="/webjars/bootstrap/3.1.0/css/bootstrap.min.css" />
	</head>
	<body>
		<div class="container">
			<div class="navbar">
				<div class="navbar-inner">
					<ul class="nav">
						<li><a href="/"> Home </a></li>
					</ul>
				</div>
			</div>
			<h1>Error Page</h1>
			<div id="created">${timestamp?datetime}</div>
			<div>
				There was an unexpected error (type=${error}, status=${status}).
			</div>
			<div>${message}</div>
			<div>
				Please contact the operator with the above information.
			</div>
		</div>
	</body>
</html>
