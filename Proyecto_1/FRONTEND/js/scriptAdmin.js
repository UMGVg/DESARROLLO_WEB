document.addEventListener('DOMContentLoaded', () => {
    // Datos de ejemplo para mostrar en la tabla
    const records = [
        { id: 1, date: '01/09/2024', time: '08:30:45' },
        { id: 2, date: '02/09/2024', time: '09:15:32' },
        { id: 3, date: '03/09/2024', time: '07:45:28' },
        { id: 4, date: '04/09/2024', time: '10:05:12' },
        { id: 5, date: '05/09/2024', time: '11:20:00' },
        // Añade más registros de ejemplo aquí
    ];

    // Referencia al cuerpo de la tabla
    const tableBody = document.getElementById('recordsTable').getElementsByTagName('tbody')[0];

    // Función para llenar la tabla con los registros
    function populateTable() {
        records.forEach(record => {
            const row = document.createElement('tr');

            const cellId = document.createElement('td');
            cellId.textContent = record.id;
            row.appendChild(cellId);

            const cellDate = document.createElement('td');
            cellDate.textContent = record.date;
            row.appendChild(cellDate);

            const cellTime = document.createElement('td');
            cellTime.textContent = record.time;
            row.appendChild(cellTime);

            tableBody.appendChild(row);
        });
    }

    // Llamar a la función para llenar la tabla al cargar la página
    populateTable();
});

document.getElementById("logout-button").addEventListener("click", function() {
    window.location.href = "index.html";
});