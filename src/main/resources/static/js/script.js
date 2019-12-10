


function create(){
   
}

function update(){
    var element = event.target;
    var parent = element.parentNode;
    var idElement = parent.querySelectorAll('.Id');

    var url = window.location + "/"+idElement[0].innerHTML;
    document.location.href = url;
}
