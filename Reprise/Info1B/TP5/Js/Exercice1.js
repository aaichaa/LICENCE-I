
function pause(){
    
    
    if(audio.paused){
        document.getElementById("audio").play();

    }else document.getElementById("audio").pause();

}
function augmenter(){
    
    document.getElementById("audio").volume += 0.1;
   
}
function diminuer(){
    document.getElementById("audio").volume -= 0.1;
}
function normal(){
    document.getElementById("audio").volume = 0.5;
}

