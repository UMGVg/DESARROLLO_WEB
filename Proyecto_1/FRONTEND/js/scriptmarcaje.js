function updateClock() {
    const now = new Date();
    
    // Obtener la fecha actual
    const day = String(now.getDate()).padStart(2, '0');
    const month = String(now.getMonth() + 1).padStart(2, '0'); // Los meses comienzan en 0
    const year = now.getFullYear();
    
    const currentDate = `${day}/${month}/${year}`;
    document.getElementById('date').textContent = currentDate;

    // Obtener la hora actual
    const hours = String(now.getHours()).padStart(2, '0');
    const minutes = String(now.getMinutes()).padStart(2, '0');
    const seconds = String(now.getSeconds()).padStart(2, '0');

    const currentTime = `${hours}:${minutes}:${seconds}`;
    document.getElementById('clock').textContent = currentTime;
}

function sendDateTimeToDatabase() {
    const currentDate = document.getElementById('date').textContent;
    const currentTime = document.getElementById('clock').textContent;
    
    fetch('http://localhost:3000/save-date-time', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ date: currentDate, time: currentTime })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Fecha y hora guardadas exitosamente:', data);
    })
    .catch(error => {
        console.error('Error al guardar la fecha y hora:', error);
    });
}

document.getElementById('saveButton').addEventListener('click', sendDateTimeToDatabase);

document.getElementById("logout-button").addEventListener("click", function() {
    window.location.href = "index.html";
});

setInterval(updateClock, 1000);

updateClock();