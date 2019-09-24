var passwordConfirm = document.querySelector('#passwordConfirm');

passwordConfirm.addEventListener('keyup', function() {
    var password = document.querySelector('#password').value;
    if (password.length < 6 || password.length > 20) {
        document.querySelector('#password2').style.display="inline";
    }
    if (passwordConfirm.value === password) {
        document.querySelector('#passwordConfirm2').style.display = "none";
        document.getElementById('register').disabled=false;


    } else if (passwordConfirm.value !== password ) {
        document.querySelector('#passwordConfirm2').style.display = "inline";
        document.getElementById('register').disabled=true;
    }
});
