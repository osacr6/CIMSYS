(function(){
    const autoSaveInputs = document.querySelectorAll('input.authorable');
    const SaveComment = document.querySelectorAll('button.comment-case');
    
    // input.authorable
    for (var i = 0; i < autoSaveInputs.length ; i++) {
        autoSaveInputs[i].addEventListener('change', (event) => {
            const formInput = document.getElementById(event.target.getAttribute('target'));
            formInput.value = event.target.value;
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
})()