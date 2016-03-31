function validateForm()
{
	var Myname=document.getElementById("custname");
	if (Myname.value=="" || Myname.value==null) 
	{ 
	alert("Please enter name!!!");
	Myname.focus();
	Myname.select();
	return false;
	} 
	var pos=Myname.value.search(/^[A-Za-z0-9 ]{3,20}$/);
	if(pos!=0)
	{
		alert("Please check the name you entered!!!");
		Myname.focus();
		Myname.select();
		 return false;
	}
	var Myphone=document.getElementById("phone");
	var pos=Myphone.value.search(/^(\d{3})(\d{3})(\d{4})$/);
	if (Myphone.value=="" || Myphone.value==null) 
	{ 
	alert("Please enter phone number!!!");
	Myphone.focus();
	Myphone.select();
	return false;
	} 
	if(pos!=0)
	{
		alert("Please check the phone number you entered!!!");
		Myphone.focus();
		Myphone.select();
		 return false;
	}
	var Mymail=document.getElementById("email");
	var pos=Mymail.value.search(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/);
	if (Mymail.value=="" || Mymail.value==null) 
	{ 
	alert("Please enter correct mail id!!!");
	Mymail.focus();
	Mymail.select();
	return false;
	} 
	if(pos!=0)
	{
		alert("Please check the mail you entered!!!");
		Mymail.focus();
		Mymail.select();
		 return false;
	}
	
	
        var pass1 = document.getElementById("password1");
        var pass2 = document.getElementById("password2");
       	if(pass1.value == pass2.value){
           
        }
	else{
		alert("Passwords did not matched");
		pass1.focus();
		pass1.select();
		 return false;
            }
	 return true;
}