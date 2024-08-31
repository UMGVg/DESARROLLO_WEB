
const express = require('express');
const sqlite3 = require('sqlite3').verbose();
const cors = require('cors');

const app = express();
const port = 3000;

// Permitir CORS para todas las solicitudes
app.use(cors());

// Middleware para analizar JSON
app.use(express.json());

// Configuración de la base de datos SQLite
const db = new sqlite3.Database(':memory:');

db.serialize(() => {
    db.run("CREATE TABLE IF NOT EXISTS times (id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, time TEXT)");
});

// Ruta para guardar la fecha y la hora en la base de datos
app.post('/save-date-time', (req, res) => {
    const { date, time } = req.body;

    if (!date || !time) {
        return res.status(400).json({ error: 'Se requiere la fecha y la hora' });
    }

    const stmt = db.prepare("INSERT INTO times (date, time) VALUES (?, ?)");
    stmt.run(date, time, function(err) {
        if (err) {
            return res.status(500).json({ error: err.message });
        }
        res.json({ message: 'Fecha y hora guardadas exitosamente', id: this.lastID });
    });
    stmt.finalize();
});

app.listen(port, () => {
    console.log(`Servidor corriendo en http://localhost:${port}`);
});
