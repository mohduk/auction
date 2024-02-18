function validationBidder(){
	
	const phoneRegex = /^\d{10}$/;
	
	const bidderName = document.BidderForm.b_name.value;
    const email = document.BidderForm.email.value;
    const pno = document.BidderForm.p_no.value;
	
	if(bidderName==""){
		document.getElementById("Error").innerHTML="* Enter Bidder Name";
		return false;
	}else if (email=="") {
        document.getElementById("Error").innerHTML = "* Enter Email Address";
        return false;
    }else if (pno=="") {
        document.getElementById("Error").innerHTML = "* Enter Phone Number";
        return false;
    }else if (!phoneRegex.test(pno)) {
        document.getElementById("Error").innerHTML = "* Enter a valid 10-digit Phone Number";
        return false;
    }
}

function ValidationSupplier(){
	
	const name=document.SupplierForm.name.value;
	const lname=document.SupplierForm.lname.value;
	const no=document.SupplierForm.number.value;
	const email=document.SupplierForm.email.value;
	
	const phoneRegex = /^\d{10}$/;
	
	if(name==""){
		document.getElementById("Error").innerHTML="* Enter Supplier Name";
		return false;
	}else if(lname==""){
		document.getElementById("Error").innerHTML="* Enter Supplier Last Name";
		return false;
	}else if (no=="") {
        document.getElementById("Error").innerHTML = "* Enter Phone Number";
        return false;
    }else if (!phoneRegex.test(no)) {
        document.getElementById("Error").innerHTML = "* Enter a valid 10-digit Phone Number";
        return false;
    }else if (email=="") {
        document.getElementById("Error").innerHTML = "* Enter Email Address";
        return false;
    }
}

function ValidationProduct(){
	
	const pname=document.ProductForm.p_name.value;
	const price=document.ProductForm.b_price.value;
	
	if(pname==""){
		document.getElementById("Error").innerHTML="* Enter Product Name";
		return false;
	}else if(price==""){
		document.getElementById("Error").innerHTML="* Enter Product Price";
		return false;
	}
}

function ValidationSeller(){
	
	const name=document.SellerForm.s_name.value;
	const lname=document.SellerForm.s_lname.value;
	const email=document.SellerForm.email.value;
	const pno=document.SellerForm.pno.value;
	const phoneRegex = /^\d{10}$/;
	
	if(name==""){
		document.getElementById("Error").innerHTML="* Enter Seller Name";
		return false;
	}else if(lname==""){
		document.getElementById("Error").innerHTML="* Enter Seller Last Name";
		return false;
	}else if (email=="") {
        document.getElementById("Error").innerHTML = "* Enter Email Address";
        return false;
    }else if (pno=="") {
        document.getElementById("Error").innerHTML = "* Enter Phone Number";
        return false;
    }else if (!phoneRegex.test(pno)) {
        document.getElementById("Error").innerHTML = "* Enter a valid 10-digit Phone Number";
        return false;
    }
}