function validerFormulaire() {
	const formulaire = document.formulaireInscription;
	
	if (formulaire.nom.value.trim() === "" || formulaire.prenom.value.trim() === "" ||
	formulaire.age.value.trim() === "" || formulaire.addresse.value.trim() === "" ||
	formulaire.codepostal.value.trim() === "" || formulaire.tel.value.trim() === "" ||
	formulaire.ville.value.trim() === "" || (!formulaire.masculin.checked && !formulaire.feminin.checked)) {
  alert("Veuillez remplir tous les champs du formulaire, s'il vous plaît.");
  return false; 
}
  
	
	const regexNomPrenom = /^[A-Za-zÀ-ÿ]+$/;
	if (!regexNomPrenom.test(formulaire.nom.value.trim())) {
	  alert("Le nom doit contenir uniquement des lettres");
	  formulaire.nom.focus();
	  return false;
	}
  
	
	if (!regexNomPrenom.test(formulaire.prenom.value.trim())) {
	  alert("Le prénom doit contenir uniquement des lettres");
	  formulaire.prenom.focus();
	  return false;
	}

	// Vérification de l'âge
	if (formulaire.age.value.trim() === "") {
		alert("Saisissez votre âge");
		formulaire.age.focus();
		return false;
	}

  
	const courriel = formulaire.addresse.value.trim();
	const regexEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
	if (courriel === "" || !regexEmail.test(courriel)) {
	  alert("Saisissez une adresse courriel valide");
	  formulaire.addresse.focus();
	  return false;
	}

	const codePostal = formulaire.codepostal.value.trim();
	const regexCodePostal = /^\d{5}$/;  
	if (!regexCodePostal.test(codePostal)) {
	  alert("Le code postal doit contenir exactement 5 chiffres (aucune lettre autorisée).");
	  formulaire.codepostal.focus();
	  return false;
	}
  
  
	
	const regexTelephone = /^[0-9]{10}$/;
	if (!regexTelephone.test(formulaire.tel.value.trim())) {
	  alert("Le numéro de téléphone doit contenir exactement 10 chiffres (aucune lettre autorisée).");
	  formulaire.tel.focus();
	  return false;
	}
  
	
	if (formulaire.ville.value.trim() === "") {
	  alert("Saisissez votre ville");
	  formulaire.ville.focus();
	  return false;
	}
  
	
	if (!formulaire.masculin.checked && !formulaire.feminin.checked) {
	  alert("Faites votre choix pour le sexe");
	  return false;
	}
  
	
	alert("Formulaire soumis avec succès !");
	return true; 
  }
  