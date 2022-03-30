(function(){
    const autoSaveInputs = document.querySelectorAll('.auto-save-inputs input');
    
    for (var i = 0; i < autoSaveInputs.length ; i++) {
        autoSaveInputs[i].addEventListener('change', (event) => {
            const formInput = document.getElementById(event.target.getAttribute('target'));
            formInput.value = event.target.value;
            formInput.parentElement.submit();
        });
    }
})()