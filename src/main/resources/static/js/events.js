(function(){
    const autoSaveInputs = document.querySelectorAll('input.authorable');
    
    for (var i = 0; i < autoSaveInputs.length ; i++) {
        autoSaveInputs[i].addEventListener('change', (event) => {
            const formInput = document.getElementById(event.target.getAttribute('target'));
            formInput.value = event.target.value;
            formInput.parentElement.submit();
        });
    }
})()