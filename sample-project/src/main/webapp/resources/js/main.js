function editFunction(id){
	firstname = document.getElementById("name"+id).innerText.split(" ");
	firstname = firstname[0];
	lastname = document.getElementById("name"+id).innerText.split(" ");
	lastname = lastname[1];
	age = document.getElementById("age"+id).innerText;
	document.getElementById("emp"+id).innerHTML = "<td><input type=\"text\" name='firstName' id='firstName"+id+"' value='"+firstname+"' /> <input type=\"text\" name=\"lastName\" id='lastName"+id+"' value='"+lastname+"'  /></td><td><input type=\"text\" name=\"age\" id='age"+id+"' value='"+age+"'  /></td><td><input type=\"button\" onclick='myForm("+id+")' value=\"Save\" class=\"btn btn-success\"></td> <td><a href=\"empreg\" class=\"btn btn-danger\">Cancel</a></td>";
}

function submitForm(id){
	alert(id);
}

function myForm(id){
	tr = document.getElementById("emp"+id);
	firstname = document.getElementById("firstName"+id).value;
	lastname = document.getElementById("lastName"+id).value;
	age = document.getElementById("age"+id).value;
	
	var form = document.createElement("form");
	form.name = "employeeForm";
	form.method = "POST";
    form.action = "echo";   

    var springAttribute= '${employee}';
    alert(springAttribute);   
	

	fntd = document.createElement("input");  
	fntd.id = 'firstName'
	fntd.name = 'firstName'
	fntd.value = firstname;
	form.appendChild(fntd);
	
	lntd = document.createElement("input");  
	lntd.id = 'lastName';
	lntd.name = 'lastName';
	lntd.value = lastname;
	form.appendChild(lntd);
	
	atd = document.createElement("input");  
	atd.id = 'age';
	atd.name = 'age';
	atd.value = age;
	form.appendChild(atd);
	


	var data = {};
	data['id'] = id;
	data['firstName'] = $("#firstName"+id).val();
	data['lastName'] = $("#lastName"+id).val();
	data['age'] = $("#age"+id).val();
	employee = JSON.stringify(data);
	$.ajax({ 
	    url:"echo",    
	    data: $('form[name=employeeForm]').serialize(),
	    dataType: 'json',
	    success : function(res) {
	    	console.log("hey")
	    }
	});
}