/**
 * 
 * Function that validates the form

 * @returns {Boolean} if the form submitted is valid
 */
function emptyValidation() {
	
	var error = "Error(s): ";
	var valid = true;
	
	var namePattern = /^([a-zA-Z0-9]).{0,30}$/;
	if (!document.form.firstName.value.match(namePattern)) {
		error = error + "Name not provided,";

		valid = false;

	}
	if (!document.form.lastName.value.match(namePattern)) {
		error = error + "Last name not provided,";

		valid = false;

	}
	if (!checkEmail(document.form.email.value)) {
		error = error + "email address is not valid,";
		valid = false;

	}

	var usernamePattern = /^([a-zA-Z0-9]).{5,15}$/;
	if (!document.form.username.value.match(usernamePattern)) {
		error = error + "Username is not valid,";

		valid = false;

	}
	var passwordPattern = /^([a-zA-Z0-9]).{5,15}$/;
	if (document.form.password.value.match(passwordPattern)) {
		if (document.form.password.value != document.form.confirmPassword.value) {
			error = error + "passwords do not match,";
			valid = false;
		}

	} else {
		error = error + "password does not match the standards,";
		valid = false;

	}
	var numberPattern = /^([0-9]).{9,20}$/;
	if (!document.form.phoneNumber.value.match(numberPattern)) {
			error = error + "Phone number is invalid";
			valid = false;
	}
	
	if(!valid){
	alert(error);
	}
	return valid;

}
/**
 * 
 * @param inputvalue - email to be checked
 * @returns {Boolean} - returns true if email is in right format.
 */
function checkEmail(inputvalue) {
	var pattern =/^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+$/;
	
	if (pattern.test(inputvalue)) {
		return true;
	} else {
		return false;
	}
}
