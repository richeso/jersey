<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample Jersey Web Services</title>
 
<style type="text/css">
		body { font-size: 62.5%; }
		label, input { display:block; }
		input.text { margin-bottom:12px; width:95%; padding: .4em; }
		fieldset { padding:0; border:0; margin-top:25px; }
		h1 { font-size: 1.2em; margin: .6em 0; }
		div#jerseylist { width: 350px; margin: 20px 0; }
		div#jerseylist table { margin: 1em 0; border-collapse: collapse; width: 100%; }
		div#jerseylist table td, div#jerseylist table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
		.ui-dialog .ui-state-error { padding: .3em; }
		.validateTips { border: 1px solid transparent; padding: 0.3em; }
		
	</style>
	<script type="text/javascript">
	$(function() {
		// a workaround for a flaw in the demo system (http://dev.jqueryui.com/ticket/4375), ignore!
		$("#dialog").dialog("destroy");
		
		var name = $("#name"),
			password = $("#password"),
			allFields = $([]).add(name).add(password),
			tips = $(".validateTips");

		function updateTips(t) {
			tips
				.text(t)
				.addClass('ui-state-highlight');
			setTimeout(function() {
				tips.removeClass('ui-state-highlight', 1500);
			}, 500);
		}

		function checkLength(o,n,min,max) {

			if ( o.val().length > max || o.val().length < min ) {
				o.addClass('ui-state-error');
				updateTips("Length of " + n + " must be between "+min+" and "+max+".");
				return false;
			} else {
				return true;
			}

		}

		function checkRegexp(o,regexp,n) {

			if ( !( regexp.test( o.val() ) ) ) {
				o.addClass('ui-state-error');
				updateTips(n);
				return false;
			} else {
				return true;
			}

		}
		
		$("#dialog-form").dialog({
			autoOpen: false,
			//height: 300,
			width: 350,
			modal: true,
			buttons: {
				'Login To System': function() {
					var bValid = true;
					allFields.removeClass('ui-state-error');

					bValid = bValid && checkLength(name,"username",3,16);
					bValid = bValid && checkLength(password,"password",5,16);

					bValid = bValid && checkRegexp(name,/^[a-z]([0-9a-z_])+$/i,"Username may consist of a-z, 0-9, underscores, begin with a letter.");
					bValid = bValid && checkRegexp(password,/^([0-9a-zA-Z])+$/,"Password field only allow : a-z 0-9");
					
					if (bValid) {
						$('#users tbody').append('<tr>' +
							'<td>' + name.val() + '</td>' + 
							'<td>' + password.val() + '</td>' +
							'</tr>'); 
						$(this).dialog('close');
					}
				},
				Cancel: function() {
					$(this).dialog('close');
				}
			},
			close: function() {
				allFields.val('').removeClass('ui-state-error');
			}
		});
		
		
		
		$('#login')
			.button()
			.click(function() {
				$('#dialog-form').dialog('open');
			});

	});
	</script>
</head>
<body>

<div class="demo">

<div id="dialog-form" title="Login to System">
	<p class="validateTips">All form fields are required.</p>

	<form>
	<fieldset>
		<label for="name">Name</label>
		<input type="text" name="name" id="name" class="text ui-widget-content ui-corner-all" />
		<label for="password">Password</label>
		<input type="password" name="password" id="password" value="" class="text ui-widget-content ui-corner-all" />
	</fieldset>
	</form>
</div>


<div id="jerseylist" class="ui-widget">
	<div id="content">
		<div id="header"></div>			
		<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Menu</h1>
		<table>
        <tbody>
        <tr><td align="left"><a href="/jersey/jqueryui">Jquery UI</a></td><td>Jquery UI</td></tr>
        <tr><td align="left"><a href="/jersey/sample/contacts/list">Contact List</a></td><td>Contact List</td></tr>
        <tr><td align="left"><a href="/jersey/sample/contacts">Contacts</a></td><td>Contacts</td></tr>
	    <tr><td align="left"><a href="/jersey/pages/new_contact.html">Add a new Contact</a></td><td>Add new contact</td></tr>
	    <tr><td align="left"><a href="/jersey/hibernate/list">Jersey/Spring/Hibernate Example</a></td><td>Hibernate Word Administration</td></tr>
        <tr><td align="left"><a href="/jersey/bookstore">bookstore</a></td><td>bookstore</td></tr>
        <tr><td align="left"><a href="/jersey/Logout.jsp">Logout</a></td><td>Log off System</td></tr>
       	</tbody>
		</table>	
	</div>
	<div id="clearer"/>
</div>

<button id="login">Login to System</button>	
</body>
</html>