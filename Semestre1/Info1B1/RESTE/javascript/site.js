function modifcoul() {
    var coul=document.forms["formu"].favcolor.value;
        alert(coul);
        document.body.style.backgroundColor=coul;
    
    }
function ladate() {
	var date= new Date();
	document.getElementById("date").innerHTML=date;
}