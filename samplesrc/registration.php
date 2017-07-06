<head>
	<script type="text/javascript" src="jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="jquery.pwdMeter.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){

                $("#pass123").pwdMeter();

            });
    </script>
	<style>
        .veryweak{
            color:#B40404;
        }
        .weak{
            color:#DF7401;
        }
        .medium{
            color:#FFFF00;
        }
        .strong{
            color:#9AFE2E;
        }
        .verystrong{
            color:#0B610B;
        }
    </style>
    </head>
<style type="text/css">
</style>
<div class="modal fade" id="m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
    	<div class="modal-content">
      		
	  	<div class="modal-header" style=" background-color:#FF0000;   color:#fff;">
        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel" ><span class="glyphicon glyphicon-pencil"style=" background-color:#FF0000; margin-left:180px; color:#fff;"></span>&nbsp;Register</h4>
      	</div>
     	

      <div class="modal-body">
	  		<div  id ="err1" style="color:red;"  class="form-alert">
			</div>
		<form action="#" method="post">

	
	
	
	<div class="form-group">
	<div class="input-group input-group-sm">
					<span class="input-group-addon"> 
						<span class="glyphicon glyphicon-user"></span></span>
							
    <input type="text" class="form-control" name="username"  id="username" placeholder="User name"/>
	</div>
</div>


<div class="form-group">
	<div class="input-group input-group-sm">
							
		<span class="input-group-addon">  
		 <span class="glyphicon glyphicon-envelope"></span></span>
						
	 <input type="email" class="form-control" name="email"  id="email12" placeholder="Email"/>
	</div>
	</div>
	
	
	<div class="form-group">
	<div class="input-group input-group-sm">
							
		<span class="input-group-addon">  
		 <span class="glyphicon glyphicon-lock"></span></span>
							
	 <input type="password" class="form-control" name="pass"  id="pass123" placeholder="Password"/>
	</div>
	<span id="pwdMeter" class="neutral"></span>
   </div>
   

<div class="form-group">
	<div class="input-group input-group-sm">
					<span class="input-group-addon"> 
						<span class="glyphicon glyphicon-user"></span></span>				
    <select class="form-control" name="usertype"  id="usertype" required>
		<option value="">Select User</option>
		<option value="1">Student</option>
		<option value="2">HOD</option>
	</select>
	</div>
</div>


<div class="controls controls-row">
	   <!--<form method="POST" >-->
	<div class="controls controls-group">      
	</div>
</div>

	  <div class="modal-footer">
	  <input type="submit" class="btn btn-success" id="save"  value="Register" name="regis" />
    </form>
	    <button type="button" class="btn btn-success" data-dismiss="modal">Cancel</button>
       </div>
    </div>
  </div>
</div>
