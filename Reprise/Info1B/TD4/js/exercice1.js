var random;
var dernier;

function alea(){
var min=-10; 
var max=10;  
random = Math.floor(Math.random() * (max - min)) + min; 
document.getElementById("name").value = random;

var tab = [2,4,5,8,10,16,20,25]
 dernier = tab[Math.floor(Math.random() * tab.length)];
document.getElementById("ledeuxieme").value = dernier;

}
function verifier(){

    var verif = parseInt(document.getElementById("somme").value);
    if((random+dernier) != verif)
        alert("cest pas vraie");
    else alert("cest bon");
    
}
function correction(){
    var som = random + dernier;
    document.getElementById("somme").value = som;
}





