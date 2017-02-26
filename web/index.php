<?php
//START CONFIG------------------------
    $DB_HOSTNAME = "localhost";
    $DB_USERNAME = "root";
    $DB_PASSWORD = "";
    $DB_NAME = "stats";
    $TEAM_NAME = "";
//END CONFIG--------------------------
	$pdo = new PDO("mysql:host=$DB_HOSTNAME;dbname=$DB_NAME", $DB_USERNAME, $DB_PASSWORD);
	$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	$result = array();
	try {
   		$result = $pdo->query("SELECT teamNumber, autoInput, shooting, movement, gears, humanBalls, humanSpeed, pilotGears, climbing, win, overall  FROM stats_keeper");
    	$result = $result->fetchAll();
	} catch (Exception $e) {
    	$error = $e->getMessage();
	}
?>

<!DOCTYPE HTML>
<html>
	<head>
    	<title><?php echo htmlspecialchars($TEAM_NAME);?></title>
    	<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta http-equiv="X-UA-Compatible" content="ie=edge">
    	<link rel="stylesheet" type="text/css" href="https://bootswatch.com/darkly/bootstrap.min.css">
    	<link rel="stylesheet" type="text/css" href="style.css">
	</head>

	<body class="background-color">
    	<div class="container">
        	<div class="row">
           		<div class="col-lg-10 col-lg-push-1">
                	<?php
                		if (isset($error)) {
                    		echo "<div class='alert alert-danger'>$error</div>";
                		} else {
                	?>
                    	<table class="table table-bordered">
                        	<thead>
                            	<tr>
                                	<th>Team Number</th>
                                	<th>Auto Description</th>
                                    <th>Shooting Performance</th>
                                    <th>Movement Skills</th>
                                    <th>Gears Picked Up</th>
                                    <th>How Well Did the Human Player Handle Balls?</th>
                                    <th>How Fast Was Their Human?</th>
                                    <th>How Well Did the Pilot Handle Gears?</th>
                                    <th>Can They Climb?</th>
                                    <th>Did they win?</th>
                                    <th>Overall Score (X/10)</th>
                            	</tr>
                        	</thead>

                        	<tbody>
                            	<?php foreach ($result as $row): ?>
                            	<tr>
                            		<td>
                            			<?php echo htmlspecialchars( $row["teamNumber"], ENT_QUOTES, 'UTF-8'); ?>
                            		</td>
                                    <td>
                                        <?php echo htmlspecialchars($row["autoInput"], ENT_QUOTES, 'UTF-8'); ?>
                                    </td>
                                    <td>
                                        <?php echo $row["shooting"]; ?>
                                    </td>
                                    <td>
                                        <?php echo $row["movement"]; ?>
                                    </td>
                                    <td>
                                        <?php echo $row["gears"]; ?>
                                    </td>
                                    <td>
                                        <?php echo $row["humanBalls"]; ?>
                                    </td>
                                    <td>
                                        <?php echo $row["humanSpeed"]; ?>
                                    </td>
                                    <td>
                                        <?php echo $row["pilotGears"]; ?>
                                    </td>
                                    <td>
                                        <?php echo $row["climbing"]; ?>
                                    </td>
                                    <td>
                                        <?php echo $row["win"]; ?>
                                    </td>
                                    <td>
                                        <?php echo $row["overall"]; ?>
                                    </td>
                            	</tr>
                            	<?php endforeach; ?>
                        	</tbody>
                    	</table>

                    	<?php 
                    		} 
                    	?>
            	</div>
        	</div>
    	</div>
	</body>
    <footer>
        &copy; <?php echo date("Y") ?> by <a href="https://github.com/SubjectAlpha">Jake Starr </a>-<a href = "http://www.merps.org/robotics"> Team 5203</a>
    </footer>
</html>