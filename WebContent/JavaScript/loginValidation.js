/**
 * 
 * Function that checks login page form

 * @returns {Boolean} if the username and password is entered.
 */
function loginValidation() {
	var message = "Please enter: ";
	var valid = true;
	
	if(document.form.username.value.length==0){
		
		message = message + "username (and) ";
			valid = false;
	}
	if(document.form.password.value.length==0){
		
		message = message + "password ";
			valid = false;
	}
	
	if(!valid){
		alert(message);
	}
	
	return valid;
	
	
}