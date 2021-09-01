function testUserId(userId){
	let returnMessage = "";
	let patt = new RegExp("^[a-zA-Z0-9]{6,10}$");

	if(userId == ""){
		returnMessage = "User Id is mandatory<br>";
	} else if(!patt.test(userId)){
		returnMessage += "User Id must be alphanumeric and should contain 6 - 10 characters<br>";
	}
	return returnMessage;
}

function testPassword(password){
	let returnMessage = "";
	let patt = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[%!@#&\(\)–\[\{\}\]:;',?/*~$^+=<>]).{8,20}$/;

	if(password == ""){
		returnMessage = "Password is mandatory<br>";
	} else if(!patt.test(password)){
		returnMessage = "Password must contain at least one number, one special character, one uppercase, one lowercase letter, one special char and should contain 8 - 16 characters<br>";
	}
	return returnMessage;
}

function testPetname(petnamePage) {
	let message = "";
	let patt = /[^a-zA-Z ]/g;
    if (petnamePage == "") {
        message += "Pet Name is mandatory<br>";
    }
    else {
        if (petnamePage.length < 3 || petnamePage.length > 10) {
            message += "Pet Name must be at least 3 - 10 characters long<br>";
        }
        if (patt.test(petnamePage)) {

			if($("#register").length){
            	message += "Pet Name must contain letters only<br>";
            } else {
            	message += "Pet name should be alphabets<br>";
			}
        }
    }
    return message;
}

function deleteEmployee(obj){
	let userId = $(obj).val();
	$("#deleteUserId").val(userId);
	$("#deleteForm").submit();
}

$(document).ready(function(){

	if($("#error").html()){
		$("#error").css("visibility", "visible");
	}

	if($("#message").html()){
		$("#message").css("visibility", "visible");
	}

	if($("#age")){
		$("#age").keypress(function(event){
			let patt = /[0-9]/;
			return patt.test(String.fromCharCode(event.which));
		});
	}

	if($("#login")){
		$("#login").click(function(){

			let message = "";
			let userIdPage = $("#username").val().trim();
			let passwordPage = $("#password").val().trim();

			message += testUserId(userIdPage);
			message += testPassword(passwordPage);

			if(message == "") {
				$("#loginForm").submit();
			} else {
				$("#error").html(message);
				$("#error").css("visibility", "visible");
				return false;
			}
		});
	}

	if($("#register")){
		$("#register").click(function(){

			let message = "";
			let userIdPage = $("#userId").val().trim();
			let passwordPage = $("#password").val().trim();
			let namePage = $("#name").val().trim();
			let petnamePage = $("#petname").val().trim();
			let agePage = $("#age").val().trim();

			message += testUserId(userIdPage);
			message += testPassword(passwordPage);

			let patt = /[^a-zA-Z ]/g;
			if(namePage == ""){
				message += "Name is mandatory<br>";
			} else {
				if(namePage.length < 3 || namePage.length > 20){
					message += "Name must be at least 3 - 20 characters long<br>";
				}
				if(namePage != "" && patt.test(namePage)){
					message += "Name must contain letters only<br>";
				}
			}

			message += testPetname(petnamePage);

			if(agePage == ""){
				message += "Age is mandatory<br>";
			} else if(agePage.valueOf() < 18 || agePage.valueOf() > 120){
				message += "Age should be greater than 18 and less than 120<br>";
			}

			if(message == "") {
				$("#registerForm").submit();
			} else {
				$("#error").html(message);
				$("#error").css("visibility", "visible");
				return false;
			}
		});
	}

		if($("#save")){
    		$("#save").click(function(){

    			let message = "";
    			let userIdPage = $("#userId").val().trim();
    			let passwordPage = $("#password").val().trim();
    			let namePage = $("#name").val().trim();
    			let petnamePage = $("#petname").val().trim();
    			let agePage = $("#age").val().trim();

    			message += testUserId(userIdPage);
    			message += testPassword(passwordPage);

    			let patt = /[^a-zA-Z ]/g;
    			if(namePage == ""){
    				message += "Name is mandatory<br>";
    			} else {
    				if(namePage.length < 3 || namePage.length > 20){
    					message += "Name must be at least 3 - 20 characters long<br>";
    				}
    				if(namePage != "" && patt.test(namePage)){
    					message += "Name must contain letters only<br>";
    				}
    			}

    			message += testPetname(petnamePage);

    			if(agePage == ""){
    				message += "Age is mandatory<br>";
    			} else if(agePage.valueOf() < 18 || agePage.valueOf() > 120){
    				message += "Age should be greater than 18 and less than 120<br>";
    			}

    			if(message == "") {
    				$("#registerForm").submit();
    			} else {
    				$("#error").html(message);
    				$("#error").css("visibility", "visible");
    				return false;
    			}
    		});
    	}

	if($("#logOutLink")){
		$("#logOutLink").click(function(){
			$("#logoutForm").submit();
		});
	}

	if($("#validate")){
		$("#validate").click(function(){

			let message = "";
			let userIdPage = $("#userId").val().trim();
			let petnamePage = $("#petname").val().trim();

			message += testUserId(userIdPage);
			message += testPetname(petnamePage);

			if(message == "") {
				$("#validateForm").submit();
			} else {
				$("#error").html(message);
				$("#error").css("visibility", "visible");
				return false;
			}
		});
	}

	if($("#reset")){
		$("#reset").click(function(){

			let message = "";
			let passwordPage = $("#password").val().trim();
			let confirmPasswordPage = $("#confirmPassword").val().trim();

			message += testPassword(passwordPage);

		    if (confirmPasswordPage == "") {
		        message += "Confirm Password is mandatory<br>";
		    }
		    else {
		        if (passwordPage != confirmPasswordPage) {
		            message += "Password and Confirm Password do not match<br>";
		        }
		    }

			if(message == "") {
				$("#resetForm").submit();
			} else {
				$("#error").html(message);
				$("#error").css("visibility", "visible");
				return false;
			}
		});
	}

	function convertToMMddyyyy(date) {
        let stringdate = date;
        let dd = stringdate.substring(0,2);
        let MM = stringdate.substring(3,5);
        let yyyy = stringdate.substring(6,10);
        return MM + "-" + dd + "-" + yyyy;
    }


	function testDateField(firstDate, lastDate) {
        let tempfirst = convertToMMddyyyy(firstDate);
        let templast = convertToMMddyyyy(lastDate);
        const date1 = new Date(tempfirst);
        const date2 = new Date(templast);

//        let patt = new RegExp("^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)(\\d{4})$");
        let patt = new RegExp("^\\d{2}-\\d{2}-\\d{4}$");
        let diffTime = date2 - date1;
        let diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
        console.log(diffDays + " days");

        if (firstDate === "" || lastDate === "") {
            returnmessage += "Date is mandatory<br>";

        }
        else if (!patt.test(tempfirst) && !patt.test(templast)) {
            returnmessage += "Date field must be of format dd/mm/yyyy<br>";
        }
        else if (diffDays < 0) {
            returnmessage += "End Date must be at least 1 day greater than Start Date<br>";
        }
        return returnmessage;
    }

    function testDateField(startDate, endDate){
        let returnMessage = "";
        let patt = new RegExp("^\d{2}-\d{2}-\d{4}$");

        date1 = startDate.split("-").reverse().join("-");
        date2 = endDate.split("-").reverse().join("-");
        var oneDay = 24 * 60 * 60 * 1000;
        var firstDate = new Date(date1);
        var secondDate = new Date(date2);
        difference = (Math.round((secondDate.getTime() - firstDate.getTime()) / (oneDay)) > 0);

        if(startDate == "" && endDate == ""){
            returnMessage = "Date is mandatory<br>";
        } else if(!patt.test(startDate) && !patt.test(endDate)){
            returnMessage += "Date field must be of format dd-mm-yyyy<br>";
        } else if(!difference) {
            returnMessage += "End Date must be at least 1 day greater than Start Date<br>"
        }
        return returnMessage;
    }

	      if($("#saveproject")) {
                $("#saveproject").click(function() {
                    let flag = true;
                    let message = "";

                    if($("#projectId").val() == "") {
                        message += "Project Id is Mandatory <br>" ;
                        flag = false;
                    }
                    else {
                        let patt = /[A-Za-z0-9]{6,10}/;
                        if(!patt.test($("#projectId").val())) {
                            message += "Project Id must be alphanumeric and should contain 6 - 10 character <br>";
                            flag = false;
                        }
                    }

                    if($("#projectName").val() == "") {
                        message += "Project name is Mandatory <br>" ;
                        flag = false;
                    }
                    else {
                        let patt = /[A-Za-z0-9]{6,10}/;
                        if(!patt.test($("#projectName").val())) {
                             message += "Project name must be alphanumeric and should contain 6 - 10 character <br>";
                            flag = false;
                        }
                    }

//                    message += testDateField(document.getElementById("startDate").value, document.getElementById("endDate").value);



                    if($("#startDate").val() == "") {
                        message += "Start date is Mandatory <br>" ;
                        flag = false;
                    }
                    else {
                        let patt = /^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$/;
                        if(!patt.test($("#startDate").val())) {
                            message += "Date should be dd-mm-yyyy";
                            flag = false;
                        }
                    }

                    if($("#endDate").val() == "") {
                        message += "End date is Mandatory <br>" ;
                        flag = false;
                    }
                    else {
                        let patt = /^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$/;
                        if(!patt.test($("#endDate").val())) {
                            message += "Date should be dd-mm-yyyy";
                            flag = false;
                        }
                    }
//
//                    if(message != ""){
//                    flag = false;
//                    }

                    if(flag) {
                        $("#projectDataForm").submit();
                    }
                    else {
                         $("#error").html(message);
                         return false;
                    }
                });
            }
});
