document.getElementById('loginform').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('errorMessage');

    // reemplazar en el backend
    const validUsername = 'UMG';
    const validPassword = '1234';
    const usertype = 'admin';

    if (username === validUsername && password === validPassword) {
        if (usertype === 'adin') {
            window.location.href = 'admin.html';
        } else {
            window.location.href = 'marcaje.html';
        }
    } else {
        errorMessage.textContent = 'Nombre de usuario o contraseña incorrectos.';
        errorMessage.style.display = 'block';
    }
});

