
function choixsandwitch() {
	var d=document.forms["form1"];

	var i= d.menu1.selectedIndex;
switch(i){

    case 0: var t=new Array("","","","","","");break;
    case 1: var t=new Array("Pizza mexicain",
    	"pizza margaritta","pizza vegetarien",
    	"pizza Americain");break;
    case 2: var t=new Array("chawarma poulet",
    	"chawarma viande",
    	"chawarma mix (viande et poulet) ");break;
    case 3: var t=new Array("Hamb Mac",
    	"Hamb Tasty","Hamb-Fish","hamb-cheese");break;
	default :
	 var t=new Array("","","","","","");
	 break;

}
for (var i=0;i<t.length;i++) { 
    document.getElementById("select2").options[i].text=t[i];

} 
  

}

function choixboisson(){
	var d=document.forms["form1"];
	var j= d.menu4.selectedIndex;
switch(j){

    case 0: var tab=new Array("","","","","","");break;
    case 1: var tab=new Array("25CL",
    	"40CL","50CL");break;
	case 2: var tab=new Array("25CL",
			"40CL","50CL");break;
	case 3: var tab=new Array("25CL",
				"40CL","50CL");break;
	case 4: var tab=new Array("25CL",
					"40CL","50CL");break;
	case 5: var tab=new Array("25CL",
						"40CL","50CL");break;
	case 6: var tab=new Array("25CL",
							"40CL","50CL");break;
	default :
	 var tab=new Array("","","","","","");
	 break;

}
for (var j=0;j<tab.length;j++) { 
    document.getElementById("select3").options[j].text=tab[j];

} 
  

}

function test()
{
	var d=document.forms["form1"];
	var m1= d.menu1.selectedIndex;
	var m3= d.menu3.selectedIndex;
	var m4= d.menu4.selectedIndex;
	

	if(m1!=0  && m3 !=0 && m4!=0)
	{
		alert("Commande passée avec succès ")
		return true ;
	}
	else
	{
		alert("Completez votre menu s'il vous plaît");
		return false;
	}


}
