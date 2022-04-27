(function(){
    const autoSaveInputs = document.querySelectorAll('input.authorable, textarea.authorable, select.authorable');
    const SaveComment = document.querySelectorAll('button.comment-case');
    const editIcon = document.querySelectorAll('i.icon-click');
    const asignarmeIcon = document.querySelectorAll('i.icon-click-asignarme');
    
    // input.authorable
    for (var i = 0; i < autoSaveInputs.length ; i++) {
        autoSaveInputs[i].addEventListener('change', (event) => {
            const formInput = document.getElementById(event.target.getAttribute('target'));
            formInput.value = event.target.nodeName  == 'SELECT' ?
                event.target.options[event.target.selectedIndex].value :
                event.target.value;
            formInput.parentElement.submit();
        });
    }
    
    // button.comment-case
    for (var i = 0; i < SaveComment.length ; i++) {
        SaveComment[i].addEventListener('click', (event) => {
            const textarea = document.querySelector('textarea.comment-case');
            if(textarea.value.replace(/\s/g, '').length > 0) {
                const formInput = document.getElementById(event.target.getAttribute('target'));
                formInput.value = textarea.value;
                formInput.parentElement.submit();
            }
        });
    }
    
    // i.icon-click
    for (var i = 0; i < editIcon.length ; i++) {
        editIcon[i].addEventListener('click', (event) => {
            const target = event.target.getAttribute('target');
            const input = document.querySelector('input[target='+target+']');
            input.classList.remove('d-none');
        });
    }
    
    // i.icon-click-asignarme
    for (var i = 0; i < asignarmeIcon.length ; i++) {
        asignarmeIcon[i].addEventListener('click', (event) => {
            const formInput = document.getElementById(event.target.getAttribute('target'));
            formInput.value = window.cimsys.utils.getCookie('user') ;
            formInput.parentElement.submit();
        });
    }
})()